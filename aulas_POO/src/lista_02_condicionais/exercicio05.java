package lista_02_condicionais;

import java.util.Scanner; 

public class exercicio05 { 
	// numero dentro do intervalo
	
		public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Digite um número: "); 
        int numero = sc.nextInt(); 
        if (numero >= 10 && numero <= 50) { 
            System.out.println("Está entre 10 e 50"); 
        } 
        else { 
            System.out.println("Está fora do intervalo"); 
        } 
        sc.close(); 
    } 
} 
