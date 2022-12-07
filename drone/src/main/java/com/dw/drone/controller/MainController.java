package com.dw.drone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dw.drone.service.MainService;

/*
 * 프론트를 이클립스에서 관리하면 Controller ex) JSP
 * 프론트가 분리되어 있으면 RestController ex) React, Angular ...
 */
//페이지 호출할 때는 Rest (X) Controller (O)
@Controller
public class MainController {

	@Autowired
	private MainService mainService;
	
	@GetMapping("/home")
	public String loadHomePage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		/*
		 * return 타입은 String
		 * html 페이지 이름을 리턴
		 */
		HttpSession session= request.getSession();
		if(session.getAttribute("korea")==null) {
			//세션에 데이터가 없을 때
			//1.로그인 없이 바로 /home 경로로 들어올때 
			//2.세션 만료일 때 
			//tip 세션 처리는 interceptor에서 전역으로 처리하자
			response.sendRedirect("/");
		}else {
		
		
		boolean sessionData = (boolean)session.getAttribute("korea");
		if(!sessionData) {
			response.sendRedirect("/");
		}
		}
		return "index";
	}
	
	@GetMapping("/")
	public String loadIndexPage() {
		return "login";
	}
	
	@GetMapping("/drone/detail/{uuid}")
	public String loadDetailPage(@PathVariable int uuid, ModelMap map) {
		//ModelMap은 주소로 넘어오는 @PathVariable or @RequestParam 데이터를 View(HTML)에 전달한다.
		map.addAttribute("droneUUID", uuid);
		return "detail";
	}
	
	
	@PostMapping("/valid-recaptcha")
	public @ResponseBody Boolean validRecaptcha(HttpServletRequest request, HttpSession session){
		String recaptchaResponse = request.getParameter("g-recaptcha-response");
		boolean isRecaptcha = mainService.verifyRecaptcha(recaptchaResponse);
		if(isRecaptcha) {
			//session에 데이터 추가
			//세션은 메모리 데이터를 저장하는 거임
			session.setAttribute("korea", true);
		}else {
			session.setAttribute("korea", false);
		}
		
		return isRecaptcha;
	}
	
	@GetMapping("/join")
	public String callJoinPage() {
		return "join";
	}
}