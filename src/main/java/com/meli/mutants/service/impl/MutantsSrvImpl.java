package com.meli.mutants.service.impl;

import java.util.List;

import javax.print.DocFlavor.SERVICE_FORMATTED;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meli.mutants.dao.ISubjectDao;
import com.meli.mutants.service.IMutantsSrv;
import com.meli.mutants.service.dto.Sequence;
import com.meli.mutants.service.dto.Subject;
import com.meli.mutants.utils.MatrixUtils;

/**
 * @author JhonMauricio
 *
 */
@Service
public class MutantsSrvImpl implements IMutantsSrv {
	
	@Autowired
	ISubjectDao subjectDao;
	
	@Autowired
	MatrixUtils matrixUtils;
	
    private static Log log = LogFactory.getLog(MutantsSrvImpl.class	);

	
	
	/**
	 * Valida si el el sujeto es mutante o humano y lo guarda en bd
	 * 
	 * @param sequence
	 * @return ResponseEntity
	 */
	@Override
	public ResponseEntity<String> isMutant(Sequence sequence) {
		
		ResponseEntity<String> responseEntity= new ResponseEntity<>(HttpStatus.FORBIDDEN);
		List<String> dna = sequence.getDna();
		if(!validateSequence(dna))return new ResponseEntity<>("Secuencia Incompatible a (A,C,G,T)",HttpStatus.FORBIDDEN);
		
        char [][] matriz = matrixUtils.listToMatrix(dna);
        log.info("matriz correcta para validar"+matriz);
        
        
        Subject subject = new Subject();
        subject.setAdn(dna.toString());        
        if(matrixUtils.validateHorizontalSequence(matriz, 4) 
        		|| matrixUtils.validateVerticalSequence(matriz, 4) 
        		|| matrixUtils.validateDiagonalLeftToRight(matriz, 4) 
        		|| matrixUtils.validateDiagonalRightToLeft(matriz, 4)) {
        	subject.setType("MUTANT");
        	responseEntity = new ResponseEntity<>("El sujeto es mutante",HttpStatus.OK);
        }else {
        	subject.setType("HUMAN");
        	responseEntity = new ResponseEntity<>("El sujeto es humano",HttpStatus.FORBIDDEN);
        }
        log.info("Sujeto a insertar "+ subject.toString());
        try {
        	subjectDao.save(subject);
        	log.info("Insert correcto");
        } catch (DataIntegrityViolationException e) {
        	responseEntity = new ResponseEntity<>("El sujeto ya fue validado" ,HttpStatus.FORBIDDEN);
        }

        
        return responseEntity;
		
	}
	
	
	/**
	 * Valida que la secuencia de ADN tenga sus bases correctas
	 * 
	 * @param dna
	 * @return boolean 
	 */
	public boolean validateSequence(List<String> dna){
        for(int i =0; i < dna.size();i++){
            if(dna.get(i).matches(".*[^ACGT].*")){
            	return false;
            }
        }
    	return true; 
	}
	
	



	
}
