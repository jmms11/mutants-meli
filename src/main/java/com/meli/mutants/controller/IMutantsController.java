package com.meli.mutants.controller;

import org.springframework.http.ResponseEntity;

import com.meli.mutants.service.dto.Sequence;
import com.meli.mutants.service.dto.Stats;

/**
 * @author JhonMauricio
 *
 */
public interface IMutantsController {
	
	
	/**
	 * @param sequence
	 * @return ResponseEntity
	 */
	ResponseEntity<String> isMutant(Sequence sequence);
	
	
	/**
	 * @return ResponseEntity
	 */
	ResponseEntity<Stats> getStats();

}
