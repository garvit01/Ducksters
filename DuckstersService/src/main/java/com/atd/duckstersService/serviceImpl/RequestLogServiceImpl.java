package com.atd.duckstersService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.entity.common.RequestLog;
import com.atd.duckstersService.repository.RequestLogRepo;
import com.atd.duckstersService.service.RequestLogService;

@Service
public class RequestLogServiceImpl implements RequestLogService {

	private RequestLogRepo requestRepo;

	@Autowired
	public RequestLogServiceImpl(RequestLogRepo requestRepo) {
		super();
		this.requestRepo = requestRepo;
	}

	@Override
	public RequestLog save(RequestLog request) {
		return requestRepo.save(request);
	}

}
