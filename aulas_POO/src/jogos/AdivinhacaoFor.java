package jogos;

import java.util.Scanner;

public class AdivinhacaoFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        boolean acertou = false;

        System.out.println("Jogo da Adivinhação (FOR)!");
        System.out.println("Tente adivinhar o número entre 1 e 100 (10 tentativas).");

        for (int i = 1; i <= 10; i++) {
            System.out.print("Tentativa " + i + ": ");
            int palpite = sc.nextInt();

            if (palpite == numeroSecreto) {
                System.out.println("Acertou em " + i + " tentativas!");
                acertou = true;
                break;
            } else if (palpite > numeroSecreto) {
                System.out.println("O número secreto é menor!");
            } else {
                System.out.println("O número secreto é maior!");
            }
        }

        if (!acertou) {
            System.out.println("Suas tentativas acabaram. O número era: " + numeroSecreto);
        }

        sc.close();
    }
}
