package com.dw.drone.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 앞자리 4 : 프론트 에러(url 오타, 파라미터 오타, GET인데 POST로 전송함)
 * 앞자리 5 : 백엔드 에러(99%오타, 1% null에러)
 * 404 : 잘못된 URL요청
 * 405 : http메소드 오류 GET인데 POST로 보냄
 * 401 : 권한없음
 */
/*
 * @Controller : 페이지 이동
 * @RestController : json 대이터를 보내고 받음
 */
@Controller
public class GlobalErrorController implements ErrorController {
	/*
	 * Http : 인터넷 프로토콜
	 * Servlet : 서버(==서비스(웹)을 제공)
	 * Request : 요청
	 */
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		String httpErrorCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
		
		if(httpErrorCode.equals("500")) {
			// *폴더이름/파일이름
			return "error/500";
		}
		if("404".equals(httpErrorCode)) {
			return "error/404";
		}
		return "error/error";
	}
}
