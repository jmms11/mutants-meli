package com.meli.mutants.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.mutants.dao.ISubjectDao;
import com.meli.mutants.service.IStatsSrv;
import com.meli.mutants.service.dto.Stats;

@Service
public class StatsSrvImpl implements IStatsSrv{
	
	@Autowired
	ISubjectDao subjectDao;
	
	
	@Override
	public Stats getStats() {
		int humans = (int) subjectDao.countByType("HUMAN");
		int mutants = (int) subjectDao.countByType("MUTANT");
		Stats stats = new Stats(humans,mutants,0.4);
		return stats;
	}
}
