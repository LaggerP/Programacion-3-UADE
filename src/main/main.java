package main;

import java.util.Vector;

public class main {

	public static void main (String[] args) {
		// Ejercicio alineamiento de secuencias
		String[] secuencia1 = {"A","C","C","C","G"};
		String[] secuencia2 = {"T","C","C","T"," ","A"};
		crearSecuencia(secuencia1, secuencia2);

	}

	public static void crearSecuencia(String[] secuencia1, String[] secuencia2) {
		int x = secuencia1.length;
		int y = secuencia2.length;

		// damos el tamaño de la matriz
		int matriz[][] = new int [x][y];

		for (int i = 0; i<x; i++) {
			for (int j = 0; j<y; j++) {
				// 1 si las letras coinciden
				if (secuencia1[i].compareTo(secuencia2[j]) == 0) {
					matriz[i][j] = 1;
				}
				// -1 si las letras no coinciden y no hay espacios
				else if (secuencia1[i].compareTo(secuencia2[j]) != 0 && secuencia2[j] != " ") {
					matriz[i][j] = -1;
				}
				// -2 si hay espacios
				else
					matriz[i][j] = -2;
			}
		}


	for (int i = 0; i<x; i++) {
		System.out.print("|");
		for (int j = 0; j < y; j++) {
			System.out.print(" ");
			System.out.print(matriz[i][j]);


		}
		System.out.println("\t");
	}
	// buscarMejorAlineamiento(matriz);
}

// este metodo realiza la busqueda del mejor alineamiento.
private static void buscarMejorAlineamiento(int[][] matriz) {

}
}
