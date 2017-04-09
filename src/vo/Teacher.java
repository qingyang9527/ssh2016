package vo;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private String tid;
	private String tname;
	private String pcourse;
	private String tpwd;
	private String departments;
	private String title;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String tid) {
		this.tid = tid;
	}

	/** full constructor */
	public Teacher(String tid, String tname, String pcourse, String tpwd,
			String departments, String title) {
		this.tid = tid;
		this.tname = tname;
		this.pcourse = pcourse;
		this.tpwd = tpwd;
		this.departments = departments;
		this.title = title;
	}

	// Property accessors

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPcourse() {
		return this.pcourse;
	}

	public void setPcourse(String pcourse) {
		this.pcourse = pcourse;
	}

	public String getTpwd() {
		return this.tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	public String getDepartments() {
		return this.departments;
	}

	public void setDepartments(String departments) {
		this.departments = departments;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}