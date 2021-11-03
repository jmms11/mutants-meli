package com.meli.mutants.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.mutants.dao.ISubjectDao;
import com.meli.mutants.service.IStatsSrv;
import com.meli.mutants.service.dto.Stats;

/**
 * @author JhonMauricio
 *
 */
@Service
public class StatsSrvImpl implements IStatsSrv{
	
	@Autowired
	ISubjectDao subjectDao;
	
	/**
	 * Solocita el conteo de cada tipo de sujeto y genera las estadisticas
	 * 
	 * @return Stats
	 */
	@Override
	public Stats getStats() {
		Integer humans = (int) subjectDao.countByType("HUMAN");
		Integer mutants = (int) subjectDao.countByType("MUTANT");
		double ratio = humans==0? mutants: (mutants/humans);
		Stats stats = new Stats(humans,mutants,ratio);
		return stats;
	}
}
