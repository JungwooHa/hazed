package org.zerock.domain;

import java.util.Date;

public class ChildVO {

	private Integer cno;
	private String userid;
	private Integer clevel;
	private Integer age;
	private Integer deep;
	private String cname;
	private String imgpath;
	private String school;
	private Date regdate;
	private Date updatedate;
	@Override
	public String toString() {
		return "ChildVO [cno=" + cno + ", userid=" + userid + ", clevel=" + clevel + ", age=" + age + ", deep=" + deep
				+ ", cname=" + cname + ", imgpath=" + imgpath + ", school=" + school + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + "]";
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Integer getClevel() {
		return clevel;
	}
	public void setClevel(Integer clevel) {
		this.clevel = clevel;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDeep() {
		return deep;
	}
	public void setDeep(Integer deep) {
		this.deep = deep;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	
	
}
