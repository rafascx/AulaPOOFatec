package lista_02_condicionais;

import java.util.Scanner;

public class exercicio10 {
	// desconto em compra
	public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Digite o valor da compra: "); 
double valor = sc.nextDouble(); 
double valorFinal; 
if (valor >= 100) { 
            valorFinal = valor * 0.9; 
        } 
else { 
            valorFinal = valor; 
        } 
        System.out.println("Valor final: R$ " + valorFinal); 
        sc.close(); 
    }
}
