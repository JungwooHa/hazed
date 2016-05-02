package org.zerock.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount,stratPage,endPage;
	private boolean prev, next;
	
	private int displayPageNum = 10;
	
	private Criteria cri;
	
	public String makeQuery(int page)throws Exception{
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page).queryParam("perPageNum", cri.getPerPageNum())
				.build();
		return uriComponents.toUriString();
		
	
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		clacData();
	}

	private void clacData() {
		// TODO Auto-generated method stub
		endPage = (int)(Math.ceil(cri.getPage()/ (double)displayPageNum) * displayPageNum);
		
		stratPage = (endPage - displayPageNum) +1;
		
		int tempEndPage = (int)(Math.ceil(totalCount/(double)(cri.getPerPageNum())));
		
		if(endPage > tempEndPage){
			endPage = tempEndPage;
		}
		prev = stratPage ==1?false:true;
		
		next = endPage * cri.getPerPageNum() >= totalCount ?false:true;
	}

	public int getStratPage() {
		return stratPage;
	}

	public void setStratPage(int stratPage) {
		this.stratPage = stratPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", stratPage=" + stratPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	
	 
}
