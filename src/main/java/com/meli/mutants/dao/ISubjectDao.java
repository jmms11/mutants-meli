package com.meli.mutants.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.mutants.service.dto.Subject;

/**
 * @author JhonMauricio
 *
 */
public interface ISubjectDao extends JpaRepository<Subject, Integer> {
	
    /**
     * @param type
     * @return
     */
    long countByType(String type);

}
