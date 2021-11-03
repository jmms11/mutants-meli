package com.meli.mutants.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.mutants.service.dto.Subject;

/**
 * @author JhonMauricio
 *
 */
public interface ISubjectDao extends JpaRepository<Subject, Integer> {
	
    /**
     * @param type subject
     * @return long type subject
     */
    long countByType(String type);

}
