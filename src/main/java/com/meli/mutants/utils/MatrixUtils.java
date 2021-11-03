package com.meli.mutants.utils;

import java.util.List;

/**
 * @author JhonMauricio
 *
 */
public class MatrixUtils {
	
	
	
	/**
	 * Comvierte una lista 2d a una matriz
	 * 
	 * @param list 
	 * @return matrix
	 */
	public char[][] listToMatrix(List<String> list){
		char [][] matrix = new char[list.size()][list.get(0).length()];
        for(int i = 0; i < list.size(); i++){
            char[] bases = list.get(i).toCharArray();
            for(int j = 0; j < list.get(i).length(); j++){
            	matrix[i][j] = bases[j];
            }
        }
        return matrix;
	}
	
	
	/**
	 * 
	 * 
	 * @param dna
	 * @param sequenceSize
	 * @return
	 */
	public boolean validateHorizontalSequence(char[][] dna, int sequenceSize){
        //Validar secuencia horizontal
		int counter = 1;
        for(int i = 0; i < dna.length; i++){
            for(int j = 0; j < dna.length; j++){
                if(j+1<dna.length && dna[i][j]== dna[i][j+1]){
                	counter++;
                }else{
                	counter=1;
                }
                if(counter == sequenceSize){
                	return true;
                }
            }
        }
		return false;
	}
	
	/**
	 * 
	 * 
	 * @param dna
	 * @param sequenceSize
	 * @return
	 */
	public boolean validateVerticalSequence(char[][] dna, int sequenceSize){
        //Validar secuencia vertical
		int counter = 1;
        for(int j = 0; j<dna.length; j++){
            for(int i = 0; i < dna.length; i++){
                if(i+1 < dna.length && dna[i][j] == dna[i+1][j]){
                	counter++;
                }else {
                	counter=1;
                }
                if(counter == sequenceSize){
                	return true;
                }
            }
        }
		return false;
	}
	
	/**
	 * 
	 * 
	 * @param dna
	 * @param sequenceSize
	 * @return
	 */
	public boolean validateDiagonalLeftToRight(char[][] dna, int sequenceSize) {
		int counter = 1;
        int height = dna.length, width = dna[0].length;

        for (int k = 1 - width; k <= height - 1; k ++) {
            for (int i = Math.max(0, k), j = -Math.min(0, k);
                i < height && j < width;
                i ++, j ++
            ) {
            	if(i+1 < height && j+1 < width && dna[i][j] == dna[i+1][j+1]) {
            		counter++;
            	}else{
            		counter=1;
            	}
            	System.out.print(dna[i][j]+" ");
                if(counter == sequenceSize){
                	return true;
                }
            }
            System.out.println();

        }
        return false;
	}
	
    
	/**
	 * 
	 * 
	 * @param dna
	 * @param sequenceSize
	 * @return
	 */
	public boolean validateDiagonalRightToLeft(char[][] dna, int sequenceSize) {
		char[][] mirrorDna = mirrorMatrix(dna);
        return validateDiagonalLeftToRight(mirrorDna, sequenceSize);
	}
	
	
	
    /**
     * Genera el espejo de una matriz.
     * 
     * @param origin
     * @return mirrorMatrix
     */
    public char[][] mirrorMatrix(char[][] origin){
        int size = origin.length;
        char[][] mirrorMatrix = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = size-1,k = 0; j >= 0 && k < size; j--,k++){
                mirrorMatrix[i][k] = origin[i][j];
            }
        }
        return mirrorMatrix;
    }

}
