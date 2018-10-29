package skhu.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import skhu.dto.Admin;
import skhu.mapper.AdminMapper;

@Controller
@RequestMapping("admin/login")
public class AdminLoginController {
	@Autowired AdminMapper adminMapper;

	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(Admin admin, HttpSession session) {
		System.out.println("test");
		Admin login = adminMapper.login(admin.getLoginId(), admin.getPassword());
		System.out.println("test");
		if(login != null) {
			System.out.println("test");
			session.removeAttribute("userInfo");
			session.setAttribute("adminInfo", login);
			session.setMaxInactiveInterval(5400);
			System.out.println("test");
			return "redirect:../menu/main";
		}

		else {
			System.out.println("test");
			return "admin/login/login";
		}
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(HttpSession session) {
		if(session.getAttribute("adminInfo") != null)
			return "redirect:../menu/main";

		return "admin/login/login";
	}

	@RequestMapping(value="logout", method=RequestMethod.POST)
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:login";
	}
}
