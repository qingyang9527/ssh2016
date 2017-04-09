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
	// Struts2��Map���͵�session
	private Map<String, Object> session;
	// ���տͻ��˴�������֤��
	private String securityCode;

	// �û���д�û���������ͣ���֤���¼
	public String login() throws Exception {

		// �жϴ���������֤������������֤���Ƿ�һ��
		String serverCode = (String) session.get("SESSION_SECURITY_CODE");
		if (!serverCode.equals(securityCode)) {
			return ERROR;
		} else {
			String role = request.getParameter("role");
			if ("ѧ��".equals(role)) {
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
			if ("����Ա".equals(role)) {
				User u = userService.validateUser(user.getUsername(),
						user.getPassword());
				if (u != null) {
					session.put("loginUsername", user.getUsername());
					// ��session�б����¼�ɹ����û���
					// session.setAttribute("loginUsername",
					// user.getUsername());
					return "login_success";
				} else {
					return "login_failure";
				}
			}
			if ("��ʦ".equals(role)) {
				Teacher t = teacherService.validateUser(user.getUsername(),
						user.getPassword());
				if (t != null) {
					session.put("teacherInfo", user.getUsername());
					session.put("teacherName", t.getTname());
					// ��session�б����¼�ɹ����û���
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

	// �û�ע��
	public String loginout() throws Exception {
		// if(session.getAttribute("loginUsername")!=null)
		{
			// session.removeAttribute("loginUsername");
		}
		return "loginOut_success";
	}

	// �û�ע�ᣨ���ӹ���Ա��
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
