package com.mmendoza;

import java.util.Arrays;

public class MetodoBurbuja {
	public static void main(String[] args) {
		/*
		 * Se pueden comparar si el tipo de dato implementa la interfaz Comparable
		 * 
		 * */
		Integer[] numeros = {10,9,8,7,6,5};
		
		for(Integer n : numeros){
			System.out.println(n);
		}
		
		System.out.println("#################");
		
		burbuja(numeros);
		
		for(Integer n : numeros){
			System.out.println(n);
		}
	}
		
	/*metodo burbuja optimizado*/
	private static void burbuja(Integer[] arreglo) {
		for(int i = 0 ; i < arreglo.length - 1 ; i ++) {
			for(int j = 0 ; j < arreglo.length - 1 - i; j++) {
				if(arreglo[j+1].compareTo(arreglo[j]) < 0) {
					Integer aux = arreglo[j];
					arreglo[j] = arreglo[j+1];
					arreglo[j+1] = aux;
				}
			}
		}
	}
}
