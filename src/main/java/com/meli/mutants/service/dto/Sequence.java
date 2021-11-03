package com.meli.mutants.service.dto;

import java.util.List;

public class Sequence {
	
	private List<String> dna;
	
	public Sequence() {
		
	}

	public Sequence(List<String> dna) {
		super();
		this.dna = dna;
	}

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}

	@Override
	public String toString() {
		return "Sequence [dna=" + dna + "]";
	}
	
	

}
