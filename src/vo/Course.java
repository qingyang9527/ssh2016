package vo;

import java.sql.Timestamp;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer cnum;
	private String cname;
	private String publisher;
	private String upload;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String cname, String publisher, String upload, Timestamp date) {
		this.cname = cname;
		this.publisher = publisher;
		this.upload = upload;
		this.date = date;
	}

	// Property accessors

	public Integer getCnum() {
		return this.cnum;
	}

	public void setCnum(Integer cnum) {
		this.cnum = cnum;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getUpload() {
		return this.upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}