package lista_02_condicionais;

import java.util.Scanner;

public class exercício02 {

	public static void main(String[] args) {
		// par ou ímpar
		Scanner sc = new Scanner(System.in); 
        System.out.print("Digite um número inteiro: "); 
int numero = sc.nextInt(); 
if (numero % 2 == 0) { 
            System.out.println("Par"); 
        } 
else { 
            System.out.println("Ímpar"); 
        } 
        sc.close();

	}

}
