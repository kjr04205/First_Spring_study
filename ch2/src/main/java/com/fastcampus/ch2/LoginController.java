package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception{
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		// 1. id�� pwd�� Ȯ��
		if(!loginCheck(id, pwd)) {
			
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.","utf-8");
			//��ġ���� ������, loginForm���� �̵�	
			return "redirect:/login/login?msg="+msg;
		}
		
		// 2. id�� pwd�� ��ġ�ϸ�,
		
		if(rememberId) {
			// ��Ű�� ����
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		}else {
			// ��Ű�� ����
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); // ��Ű ����
			response.addCookie(cookie);
		}
		// 1. ��Ű�� ����
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		// TODO Auto-generated method stub
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
