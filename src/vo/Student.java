package vo;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String studentId;
	private String sname;
	private String spwd;
	private String ssex;
	private String specialities;
	private String college;
	private String semail;
	private String sphone;
	private String address;
	private String steacher;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String studentId, String sname, String spwd, String ssex,
			String specialities, String college, String semail, String sphone,
			String address, String steacher) {
		this.studentId = studentId;
		this.sname = sname;
		this.spwd = spwd;
		this.ssex = ssex;
		this.specialities = specialities;
		this.college = college;
		this.semail = semail;
		this.sphone = sphone;
		this.address = address;
		this.steacher = steacher;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpwd() {
		return this.spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSpecialities() {
		return this.specialities;
	}

	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getSemail() {
		return this.semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSphone() {
		return this.sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSteacher() {
		return this.steacher;
	}

	public void setSteacher(String steacher) {
		this.steacher = steacher;
	}

}