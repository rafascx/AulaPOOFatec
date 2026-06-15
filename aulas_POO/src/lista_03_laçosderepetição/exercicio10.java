package lista_03_laçosderepetição;

import java.util.Scanner;

// soma até digitar zero

public class exercicio10 {
	public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 

        int soma = 0; 
        int numero; 

        do { 
            System.out.print("Digite um número ou 0 para sair: "); 
            numero = sc.nextInt(); 
            soma += numero; 
        } 
        while (numero != 0); 

        System.out.println("Soma total: " + soma);
        
        sc.close();
	}
}
