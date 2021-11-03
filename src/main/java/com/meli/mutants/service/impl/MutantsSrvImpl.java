package com.meli.mutants.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	MatrixUtils matrixUtils;
	
	

	@Override
	public ResponseEntity<String> isMutant(Sequence sequence) {
		
		ResponseEntity<String> responseEntity= new ResponseEntity<>(HttpStatus.FORBIDDEN);
		List<String> dna = sequence.getDna();
		if(!validateSequence(dna))return new ResponseEntity<>("Secuencia Incompatible a (A,C,G,T)",HttpStatus.FORBIDDEN);
        char [][] matriz = matrixUtils.listToMatrix(dna);
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
        subjectDao.save(subject);
        
        
        return responseEntity;
		
	}
	
	
	/**
	 * @param dna
	 * @return
	 */
	public boolean validateSequence(List<String> dna){
        //Validar secuencia mutante correcta 
        for(int i =0; i < dna.size();i++){
            if(dna.get(i).matches(".*[^ACGT].*")){
            	return false;
            }
        }
    	return true; 
	}
	
	



	
}
