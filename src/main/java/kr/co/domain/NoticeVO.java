package kr.co.domain;



import lombok.Data;

@Data
public class NoticeVO {

	private int seq_bno;
	private String notice_title;
	private String notice_content;
	private String notice_writer;
	private String notice_date;
	public int getSeq_bno() {
		return seq_bno;
	}
	public void setSeq_bno(int seq_bno) {
		this.seq_bno = seq_bno;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_writer() {
		return notice_writer;
	}
	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	
	
}
