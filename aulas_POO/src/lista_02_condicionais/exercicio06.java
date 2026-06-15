package lista_02_condicionais;

import java.util.Scanner;

public class exercicio06 {

    // classificação por idade

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a idade: ");
        int idade = sc.nextInt();

        if (idade >= 0 && idade <= 12) {

            System.out.println("Crianca");

        } else if (idade <= 17) {

            System.out.println("Adolescente");

        } else if (idade <= 59) {

            System.out.println("Adulto");

        } else {

            System.out.println("Idoso");
        }

        sc.close();
    }
}