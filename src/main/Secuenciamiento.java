package main;

public class Secuenciamiento {

	public static void main(String[] args) {
		// Datos
		String[] secuencia1 = {"A", "C", "C", "C", "G", "A"};
		String[] secuencia2 = {"T", "C", "C", "T", "A"};
		crearSecuencia(secuencia1, secuencia2);
	}
	
	private static void crearSecuencia (String[] secuencia1, String[] secuencia2) {
		
		// El +1 es para incluir un 0 en la esquina superior izquierda de la matriz
		int fila = secuencia1.length + 1;
		int columna = secuencia2.length + 1;
		
		//Scores
		int paridad = 1;
		int disparidad = -1;
		int gap = -2;
		
		//Soluciones finales
		String alineamientoA = "";
		String alineamientoB = "";
		
		//Creamos y damos el tamaño de la matriz principal en donde se realizaran los calculos
		int matriz[][] = new int [fila][columna];
		//Creamos y damos el tamaño de la matriz scores en donde se almacenaran los scores
		int scores[][] = new int [fila][columna];
		
		//Agregamos los gaps en los contornos superior e izquierdo de la matriz principal
		for (int i = 0; i < fila; i++) {
			matriz [i][0] = gap * i;
		}
		for (int i = 0; i < columna; i++) {
			matriz [0][i] = gap * i;
		}
		
		//Llenamos la matriz scores con los scores
		for (int i = 0; i < secuencia1.length; i++) {
			for (int j = 0; j < secuencia2.length; j++) {
				//Si son iguales el score es 1
				if (secuencia1[i].compareTo(secuencia2[j]) == 0){
					scores [i+1][j+1] = paridad;
				}
				//Si son distintos el score es -1
				else{
					scores[i+1][j+1] = disparidad;
				}
			}
		}
		
		//Existen tres casos en donde elegir el mayor score
		for (int i = 1; i < fila; i++) {
			for (int j = 1; j < columna; j++) {
				//Valor de la diagonal + valor de score
				int c1 = matriz [i-1][j-1] + scores [i][j];
				//Valor de la celda de arriba + gap
				int c2 = matriz [i-1][j] + gap;
				//Valor de la celda de la izquierda + gap
				int c3 = matriz [i][j-1] + gap;
				
				//La diagonal tiene prioridad
				int mayor = c1;
				//Buscamos el mayor de los tres casos
				if (c2 > mayor){
					mayor = c2;
				}
				else if (c3 > mayor){
					mayor = c3;
				}
				matriz [i][j] = mayor;
			}
		}
		
		//Ya tenemos la solucion optima en la ultima casilla de la matriz principal
		//Ahora hay que hallar el camino que nos dio la solucion
		
		int i = fila - 1;
		int j = columna - 1;
		int s = matriz [secuencia1.length][secuencia2.length];

		while (i > 0 && j > 0) {
			//Si el resultado optimo es igual a su diagonal
			//se agregan los elementos al principio de sus 
			//respectivas cadenas (solucion final) y nos ubicamos en la diagonal
			if (matriz[i][j] == matriz [i-1][j-1] + scores [i][j]) {
				alineamientoA = secuencia1 [i -1] + alineamientoA;
				alineamientoB = secuencia2 [j -1] + alineamientoB;
				i--;
				j--;
				
			}
			
			//Si el resultado optimo es igual a su izquierda 
			//se agrega un gap en el alineamiento A, el elemento en
			//el alineamiento B y nos ubicamos a la izquierda
			else if (matriz [i][j] == matriz [i][j-1] + gap) {
				alineamientoA = "-" + alineamientoA;
				alineamientoB = secuencia2 [j -1] + alineamientoB;
				j--;
				
			}
			
			//Si el resultado optimo es igual al valor de su casilla superior
			//se agrega el elemento en el alineamiento B, un gap en el
			//alineamiento A y nos ubicamos arriba
			else if (matriz[i][j] == matriz [i-1][j] + gap) {
				alineamientoA = secuencia1 [i -1] + alineamientoA;
				alineamientoB = "-" + alineamientoB;
				i--;
			}
		}
		
		//Si la secuencia 1 tiene mas elementos que la secuencia 2
		while (i > 0 && j == 0) {
			alineamientoA = secuencia1 [i-1] + alineamientoA;
			alineamientoB = "-" + alineamientoB;
			i--;
		}
		
		//Si la secuencia 2 tiene mas elementos que la secuencia 1
		while (j > 0 && i == 0) {
			alineamientoA = "-" + alineamientoA;
			alineamientoB = secuencia2 [j -1] + alineamientoB;
			j--;
		}
		
		//Impresion de la solucion optima + score
		System.out.println ("Alineamiento A: " + alineamientoA);
		System.out.println ("Alineamiento B: " + alineamientoB);
		System.out.println ("Score: " + s);
	}
}

