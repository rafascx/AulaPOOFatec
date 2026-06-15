package lista_03_laçosderepetição;

import java.util.Scanner;

// tabuada

public class exercicio05 {
	public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Digite um número: "); 
int numero = sc.nextInt(); 
for (int i = 1; i <= 10; i++) { 
            System.out.println(numero + " x " + i + " = " + (numero * i)); 
        } 
        sc.close(); 
    }
}
