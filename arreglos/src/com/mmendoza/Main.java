package com.mmendoza;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/*anotaciones sobre arreglos*/

public class Main {
	public static void main(String[] args) {
		/*
		 * Declaracion de un array 
		 * 
		 * int [] numeros;
		 * 
		 * instanciacion
		 * 
		 * int [] numeros = new int[3];
		 * 
		 * 
		 * Producto[] productos = new Producto[3]; ---> guardar referencias de objetos 
		 * 
		 * ----
		 * 
		 * int[] numeros = {1,2,3} instanciacion del arreglo con valores
		 * 
		 * */
		
		int [] numeros = {1,2,3,4,5,6,7,8,9,10};
		
		String[] nombres = new String[4]; 
		nombres[0] = "Leonardo";
		nombres[1] = "Juan";
		nombres[2] = "Sol";
		nombres[3] = "Arturo";
		
		//iterarArregloConFor(nombres);
		//iterarArregloConForEach(nombres);
		//ordenarConMetodoSort(nombres);
		imprimirDeFormaInversa(numeros);
	}
	
	private static void imprimirDeFormaInversa(int[]arreglo) {
		for(int i = 0 ; i < arreglo.length ; i++) /*descente*/
			System.out.println(" " + arreglo[arreglo.length - 1 - i]);
	}
	
	private static void ordenarConMetodoSort(String[] arreglo) {
		Arrays.sort(arreglo); //Ordena el arreglo de manera lexicografica
		for(String nombre:arreglo)
			System.out.println(nombre);
	}	

	private static void iterarArregloConForEach(String[] arreglo) {
		for(String nombre:arreglo)
			System.out.println(nombre);
	}
	private static void iterarArregloConFor(String[]arreglo) {
		for(int i = 0 ; i < arreglo.length ; i++) 
			System.out.println(arreglo[i]);
	}
}
