<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test</h1>

<div>
    <div>
        작성자<input type="text" name="replyer" id="newReplyWriter">
    </div>

    <div>
        댓글내용<input type="text" name="replytext" id="newReplyText">
    </div>
    <button id="replyAddBtn">댓글 추가</button>

</div>
<style>
    #modDiv{
        width:300px;
        height: 100px;
        background-color: #b3d4fc;
        position: absolute;
        top: 50%;
        left: 50%;
        margin-top: -50px;
        margin-left: -50px;
        z-index: 1000;
    }
</style>

<div name="modDiv" id="modDiv" style="display: none;">
    <div class="modal-title"></div>
    <div>
        <input type="text" name = "replytext" id="replytext">
    </div>
    <div>
        <button type="button" id="replyModBtn">수정</button>
        <button type="button" id="replyDelBtn">삭제</button>
        <button type="button" id="CloseBtn">닫기</button>

    </div>
</div>

<ul id="replies"> </ul>
<ul class="pagination"></ul>

	<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		var bno = 49;
		getPageList(1);
	
	function getAllList(){
		
		 
		$.getJSON("/replies/all/" + bno, function(data) {
			console.log(data.length);
			var str="";
			$(data).each(
					function() {
						str += "<li data-rno= " + this.rno + " class='replyLi'>"
								+ this.rno +":"+ this.replytext + "<button>수정</button></li>";
					});
			$("#replies").html(str); 
		});
	       $("#replies").on("click",".replyLi button",function () {
	            var reply = $(this).parent();
	            var rno = reply.attr("data-rno");
	            var replytext = reply.text();
	            
	            $(".modal-title").html(rno);
	            $("#replytext").val(replytext);
	            $("#modDiv").show("slow");
	        })
	}
	
	  $("#replyDelBtn").on("click", function () {

	        var rno = $(".modal-title").html();
	        var replytext = $("#replytext").val();
	        console.log(replytext);

	        $.ajax({
	            type:'delete',
	            url:'/replies/'+rno,
	            headers :{
	                "Content-Type" : "application/json",
	                "X-HTTP-Method-Override" : "DELETE"
	            },
	            dataType:'text',
	            success:function (result) {
	                if(result == 'SUCCESS'){
	                    alert("삭제되었습니다.");
	                    $("#modDiv").hide("slow");
	                    getAllList();
	                }
	            }
	        });
	    });
	  
	  $("#replyModBtn").on("click", function () {

	        var rno = $(".modal-title").html();
	        var replytext = $("#replytext").val();
	        
	        console.log(rno + " : "+ replytext);

	        $.ajax({
	            type:'put',
	            url:'/replies/'+rno,
	            headers :{
	                "Content-Type" : "application/json",
	                "X-HTTP-Method-Override" : "PUT"
	            },
	            data:JSON.stringify({replytext :replytext}),
	            dataType:'text',
	            success:function (result) {
	            	console.log("---"+result);
	                if(result == 'SUCCESS'){
	                    console.log("수정되었습니다.");
	                    $("#modDiv").hide("slow");
	                    getAllList();
	                    getPageList(replyPage);
	                }
	            }
	        });
	    });
	    
    $("#replyAddBtn").on("click",function () {
        var replyer = $("#newReplyWriter").val();
        var replytext =$("#newReplyText").val();

  		
  		console.log(replyer +replytext );
  		
        $.ajax({
            type:'post',
            url:'/replies',
            headers :{
                "Content-Type" : "application/json",
                "X-HTTP-Method-Override" : "POST"
            },
            dataType:'text',
            data : JSON.stringify({
                bno : bno,
                replyer : replyer,
                replytext : replytext
            }),
            success:function (result) {
                if(result == 'SUCCESS'){
                   
                    getAllList();
                }
            }
        });
    });
    
    function getPageList(page) {
        $.getJSON("/replies/"+bno+"/"+page, function(data){
        	console.log("--------");
        	console.log(data.list.length);
            
            var str = "";
            
            $(data.list).each(function () {
                str+= "<li data-rno= "+this.rno+" calss='replyLi'>" 
                    +this.rno + " : "+ this.replytext + "<button>수정</button></li>";
            });
            $("#replies").html(str);
            
            printPaging(data.pageMaker);
        });
    }
    
    function printPaging(pageMaker) {
        var str ="";

        if(pageMaker.prev){
            str += "<li><a href='"+(pageMaker.stratPage-1)+"'> << </a></li>";
        }
        for(var i=pageMaker.stratPage, len=pageMaker.endPage; i<=len; i++){
            var strClass=pageMaker.cri.page == i?'class=active':'';
            str += "<li"+strClass+"><a href="+i+">"+i+"</a></li>";
        }
        if(pageMaker.next){
            str += "<li><a href='"+(pageMaker.endPage+1)+"'> >> </a></li>";
        }
        $(".pagination").html(str);
    }
    
    var replyPage=2;

    $(".pagination").on("click", "li a", function (event) {
        event.preventDefault();
        replyPage = $(this).attr("href");
        getPageList(replyPage);
    })
    
	</script>

</body>
</html>