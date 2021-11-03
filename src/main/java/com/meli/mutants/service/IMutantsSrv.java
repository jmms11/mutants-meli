package com.meli.mutants.service;


import org.springframework.http.ResponseEntity;

import com.meli.mutants.service.dto.Sequence;

public interface IMutantsSrv {
	
	
	/**
	 * @param dna
	 */
	ResponseEntity<String> isMutant(Sequence sequence);


}
