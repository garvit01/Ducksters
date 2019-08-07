package com.atd.duckstersService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atd.duckstersService.service.RequestLogService;

@RestController
@RequestMapping("/api/log")
public class RequestLogController {

	private RequestLogService requestLogService;

	@Autowired
	public RequestLogController(RequestLogService requestLogService) {
		super();
		this.requestLogService = requestLogService;
	}
	

}
