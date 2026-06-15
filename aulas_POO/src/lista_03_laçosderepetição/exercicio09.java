package lista_03_laçosderepetição;

import java.util.Scanner;

// fatorial

public class exercicio09 {
	public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite um número inteiro positivo: "); 
        int numero = sc.nextInt(); 

        int fatorial = 1; 

        for (int i = numero; i >= 1; i--) { 
            fatorial *= i; 
        } 
        System.out.println(numero + "! = " + fatorial); 
        sc.close(); 
    }
}
