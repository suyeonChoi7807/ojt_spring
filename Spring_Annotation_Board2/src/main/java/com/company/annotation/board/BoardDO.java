package com.company.annotation.board;

import java.sql.Date;

public class BoardDO {
	private int seq;			//�Խñ۹�ȣ
	private String title;		//����
	private String writer;		//�ۼ���
	private String content;		//�Խñ۳���
	private Date regdate;		//�ۼ�����
	private int cnt;			//��ȸ��
	
	//getter, setter �޼ҵ�
	public int getSeq() {return seq;}
	public void setSeq(int seq) {this.seq = seq;}
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public String getWriter() {return writer;}
	public void setWriter(String writer) {this.writer = writer;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public Date getRegdate() {return regdate;}
	public void setRegdate(Date regdate) {this.regdate = regdate;}
	
	public int getCnt() {return cnt;}
	public void setCnt(int cnt) {this.cnt = cnt;}
}

