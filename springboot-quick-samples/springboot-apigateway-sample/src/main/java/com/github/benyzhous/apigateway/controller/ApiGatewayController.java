
package com.github.benyzhous.apigateway.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.benyzhous.apigateway.vo.JsonBodyVO;
import com.github.benyzhous.commons.quick.servlet.Params;

/**
 * ProjectName: springboot-apigateway-sample <br/>
 * ClassName: ApiGatewayController <br/>
 * Date: 2017年2月16日 下午10:45:13 <br/>
 * 
 * @author benyzhous@gmail.com
 */
@RestController
public class ApiGatewayController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping(value="get")
	public String get(HttpServletRequest request) {
		logger.info("\r\n------------------------------request params------------------------------\r\n", Params.requestToMap(request));

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			logger.info("{} = {}", headerName, request.getHeader(headerName));
		}

		return "ApiGatewayController in Action";
	}
	
	@PostMapping(value = "/post")
	public String list(HttpServletRequest request, @RequestBody JsonBodyVO jsonBodyVO) {
		logger.info("\r\n------------------------------request params------------------------------\r\n", Params.requestToMap(request));
		System.err.println(jsonBodyVO.toString());
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			logger.info("{} = {}", headerName, request.getHeader(headerName));
		}

		return "ApiGatewayController in Action";
	}
}
