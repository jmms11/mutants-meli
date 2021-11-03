package com.meli.mutants.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.mutants.controller.IMutantsController;
import com.meli.mutants.service.IMutantsSrv;
import com.meli.mutants.service.IStatsSrv;
import com.meli.mutants.service.dto.Sequence;
import com.meli.mutants.service.dto.Stats;

@RestController
@RequestMapping("")
public class MutantsControllerImpl implements IMutantsController {
	
	
	@Autowired
	IMutantsSrv mutantsSrv;

	@Autowired
	IStatsSrv statsSrv;
	
	@Override
	@PostMapping("/mutant")
	public ResponseEntity<String> isMutant(@RequestBody Sequence sequence) {
		// Valida si un humano es mutante;
		return mutantsSrv.isMutant(sequence);
	}

	@Override
	@GetMapping("/stats")
	public ResponseEntity<Stats> getStats() {
		// Retorna las estadisticas de mutantes y no mutantes
		return new ResponseEntity<Stats>(statsSrv.getStats(),HttpStatus.OK);
	}
	

}
