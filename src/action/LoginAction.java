package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import service.IStudentService;
import service.ITeacherService;
import service.IUserService;
import vo.Student;
import vo.Teacher;
import vo.User;

import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class LoginAction extends SuperAction implements ModelDriven<User>,
		SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student = new Student();
	private User user = new User();
	private Teacher teacher = new Teacher();
	private IUserService userService;
	private IStudentService studentService;
	private ITeacherService teacherService;
	// Struts2中Map类型的session
	private Map<String, Object> session;
	// 接收客户端传来的验证码
	private String securityCode;

	// 用户填写用户名，密码和，验证码登录
	public String login() throws Exception {

		// 判断传过来的验证码和你输入的验证码是否一致
		String serverCode = (String) session.get("SESSION_SECURITY_CODE");
		if (!serverCode.equals(securityCode)) {
			return ERROR;
		} else {
			String role = request.getParameter("role");
			if ("学生".equals(role)) {
				Student s = studentService.validateStu(user.getUsername(),
						user.getPassword());
				Student s2 = studentService.findStudentByStudentId(user
						.getUsername());
				if (s != null) {
					session.put("studentInfo", user.getUsername());
					session.put("studentName", s2.getSname());
					return "studentlogin_success";
				} else {
					return "studentlogin_failure";
				}
			}
			if ("管理员".equals(role)) {
				User u = userService.validateUser(user.getUsername(),
						user.getPassword());
				if (u != null) {
					session.put("loginUsername", user.getUsername());
					// 在session中保存登录成功的用户名
					// session.setAttribute("loginUsername",
					// user.getUsername());
					return "login_success";
				} else {
					return "login_failure";
				}
			}
			if ("教师".equals(role)) {
				Teacher t = teacherService.validateUser(user.getUsername(),
						user.getPassword());
				if (t != null) {
					session.put("teacherInfo", user.getUsername());
					session.put("teacherName", t.getTname());
					// 在session中保存登录成功的用户名
					// session.setAttribute("loginUsername",
					// user.getUsername());
					return "teacherlogin_success";
				} else {
					return "teacherlogin_failure";
				}
			}
		}
		return null;
	}

	// 用户注销
	public String loginout() throws Exception {
		// if(session.getAttribute("loginUsername")!=null)
		{
			// session.removeAttribute("loginUsername");
		}
		return "loginOut_success";
	}

	// 用户注册（增加管理员）
	public String saveUser() {
		userService.saveUser(user);
		return "saveAdmin_success";
	}

	public User getModel() {
		return user;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public ITeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}

}
