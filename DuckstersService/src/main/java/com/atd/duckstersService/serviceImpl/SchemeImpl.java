package com.atd.duckstersService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.model.common.Scheme;
import com.atd.duckstersService.repository.SchemeRepo;
import com.atd.duckstersService.service.SchemeService;

@Service
public class SchemeImpl implements SchemeService {

	private SchemeRepo schemeRepo;

	public SchemeImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public SchemeImpl(SchemeRepo schemeRepo) {
		this.schemeRepo = schemeRepo;
	}

	@Override
	public Scheme addSchemes(Scheme scheme) {
		return schemeRepo.save(scheme);
	}

}
