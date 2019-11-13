package main;

import java.util.Vector;

public class main {

	public static void main(String[] args) {
		// Ejercicio alineamiento de secuencias
		String[] secuencia1 = {"A","C","C","C","G","A"};
		String[] secuencia2 = {"T","C","C","T","A"};
		
		// 1 coincide, -1 no coincide, -2 gap
		
		alineamientoSecuencia(secuencia1, secuencia2);
	}

	public static void alineamientoSecuencia(String[] secuencia1, String[] secuencia2) {
		int x = secuencia1.length;
		int y = secuencia2.length;
		
		// damos el tamaño de la matriz
		int matriz[][] = new int [x+1][y+1];
		
		
		matriz[0][0] = 0;
		for (int i = 1; i<x; i++) {
			for (int j = 1; j<y; j++) {
				
				// si las letras coinciden
				if (secuencia1[i].compareTo(secuencia2[j]) == 0) {
					matriz[i][j] = 1;
				} 
				// si las letras no coinciden y no hay espacios
				else if (secuencia1[i].compareTo(secuencia2[j]) != 0 && secuencia2[j] != " ") {
					matriz[i][j] = -1;
				}
				// si hay espacios
				else 
					matriz[i][j] = -2;
				}
			}
		}
		
		
		
	}


}
