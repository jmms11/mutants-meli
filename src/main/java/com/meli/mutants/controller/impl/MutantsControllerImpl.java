package com.meli.mutants.controller.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import com.meli.mutants.service.impl.MutantsSrvImpl;

/**
 * @author JhonMauricio
 *
 */
@RestController
@RequestMapping("")
public class MutantsControllerImpl implements IMutantsController {
	
	
	@Autowired
	IMutantsSrv mutantsSrv;

	@Autowired
	IStatsSrv statsSrv;
	
	private static Log log = LogFactory.getLog(MutantsControllerImpl.class	);
	
	/**
	 * Expone servicio /mutant el cual valida si un sujeto es mutante o humano.
	 * 
	 * @param sequence 
	 * @return ResponseEntity
	 */
	@Override
	@PostMapping("/mutant")
	public ResponseEntity<String> isMutant(@RequestBody Sequence sequence) {
		log.info("Inicia validación de adn");
		return mutantsSrv.isMutant(sequence);
	}

	/**
	 * Expone servicio /stats el cual retorna las estadisticas de mutantes y humanos.
	 *
	 * @return ResponseEntity
	 */
	@Override
	@GetMapping("/stats")
	public ResponseEntity<Stats> getStats() {	
		log.info("Inicia consulta de estadisticas");
		return new ResponseEntity<Stats>(statsSrv.getStats(),HttpStatus.OK);
	}
	

}
