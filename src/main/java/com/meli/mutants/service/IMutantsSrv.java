package com.meli.mutants.service;


import org.springframework.http.ResponseEntity;

import com.meli.mutants.service.dto.Sequence;

/**
 * @author JhonMauricio
 *
 */
public interface IMutantsSrv {
	
	
	/**
	 * @param sequence
	 * @return ResponseEntity
	 */
	ResponseEntity<String> isMutant(Sequence sequence);


}
