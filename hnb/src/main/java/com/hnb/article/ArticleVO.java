package com.hnb.article;

import org.springframework.stereotype.Component;

@Component
public class ArticleVO {
	private int rcdNo; //글번호
	private int grpNo; //글 그룹 번호
	private String usrName; // 작성자 이름
	private String usrMail; // 작성자 이메일
	private String usrSubject; // 글 제목
	private String usrPass; // 글의 비번
	private String usrContent; // 글내용
	private String usrFileNmae; // 업로드 되는 파일 이름
	private int usrFileSize; //업로드 되는 파일 크키
	private String usrDate; //작성일
	private int usrRefer; // 글 참조 횟수
	private int rcdLevel; // 글 레벨
	private int rcdOrder; //글 그룹에서 글 의 출력순서
	
	
	public ArticleVO() {
		
	}
	
	public int getRcdNo() {
		return rcdNo;
	}
	public int getGrpNo() {
		return grpNo;
	}
	public String getUsrName() {
		return usrName;
	}
	public String getUsrMail() {
		return usrMail;
	}
	public String getUsrSubject() {
		return usrSubject;
	}
	public String getUsrPass() {
		return usrPass;
	}
	public String getUsrContent() {
		return usrContent;
	}
	public String getUsrFileNmae() {
		return usrFileNmae;
	}
	public int getUsrFileSize() {
		return usrFileSize;
	}
	public String getUsrDate() {
		return usrDate;
	}
	public int getUsrRefer() {
		return usrRefer;
	}
	public int getRcdLevel() {
		return rcdLevel;
	}
	public int getRcdOrder() {
		return rcdOrder;
	}
	public void setRcdNo(int rcdNo) {
		this.rcdNo = rcdNo;
	}
	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public void setUsrMail(String usrMail) {
		this.usrMail = usrMail;
	}
	public void setUsrSubject(String usrSubject) {
		this.usrSubject = usrSubject;
	}
	public void setUsrPass(String usrPass) {
		this.usrPass = usrPass;
	}
	public void setUsrContent(String usrContent) {
		this.usrContent = usrContent;
	}
	public void setUsrFileNmae(String usrFileNmae) {
		this.usrFileNmae = usrFileNmae;
	}
	public void setUsrFileSize(int usrFileSize) {
		this.usrFileSize = usrFileSize;
	}
	public void setUsrDate(String usrDate) {
		this.usrDate = usrDate;
	}
	public void setUsrRefer(int usrRefer) {
		this.usrRefer = usrRefer;
	}
	public void setRcdLevel(int rcdLevel) {
		this.rcdLevel = rcdLevel;
	}
	public void setRcdOrder(int rcdOrder) {
		this.rcdOrder = rcdOrder;
	}

	@Override
	public String toString() {
		return "게시판 [글번호=" + rcdNo 
				+ ", grpNo=" + grpNo 
				+ ", usrName=" + usrName 
				+ ", usrMail=" + usrMail
				+ ", usrSubject=" + usrSubject 
				+ ", usrPass=" + usrPass 
				+ ", usrContent=" + usrContent
				+ ", usrFileNmae=" + usrFileNmae 
				+ ", usrFileSize=" + usrFileSize 
				+ ", usrDate=" + usrDate
				+ ", usrRefer=" + usrRefer 
				+ ", rcdLevel=" + rcdLevel 
				+ ", rcdOrder=" + rcdOrder + "]";
	}
	
}
