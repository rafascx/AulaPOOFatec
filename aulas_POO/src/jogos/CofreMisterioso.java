package jogos;

import java.util.Random;
import java.util.Scanner;

public class CofreMisterioso {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rng = new Random();
        boolean continuar = true;
        int pontos = 0;

        System.out.println("Bem-vindo ao Cofre Misterioso!");

        while (continuar) {
            int max = escolherDificuldade(in);
            int secreto = 1 + rng.nextInt(max);
            int errosNaRodada = 0;
            boolean acertou = false;

            System.out.println("\nUm novo cofre foi gerado! Intervalo: 1 a " + max);

            for (int tent = 5; tent > 0; tent--) {
                int palpite = lerInteiro(in, "Tentativa " + (6 - tent) + "/5. Seu palpite: ");

                if (palpite == secreto) {
                    System.out.println("Acertou! Cofre aberto. Código: " + secreto);
                    acertou = true;
                    break;
                } else if (palpite < secreto) {
                    System.out.println("O código é MAIOR. Restam " + (tent - 1) + " tentativa(s).");
                    errosNaRodada++;
                } else {
                    System.out.println("O código é MENOR. Restam " + (tent - 1) + " tentativa(s).");
                    errosNaRodada++;
                }
            }

            if (!acertou) {
                System.out.println("X Tentativas esgotadas. O código era: " + secreto);
            }

            int ganho = Math.max(0, 10 - (2 * errosNaRodada));
            if (acertou) {
                pontos += ganho;
                System.out.println("Pontuação desta rodada: +" + ganho + " (erros: " + errosNaRodada + ")");
            } else {
                System.out.println("Pontuação desta rodada: +0");
            }
            System.out.println("Pontuação acumulada: " + pontos);

            char resp;
            do {
                System.out.print("Deseja jogar novamente? (s/n): ");
                String s = in.next().trim().toLowerCase();
                resp = s.isEmpty() ? 'n' : s.charAt(0);
            } while (resp != 's' && resp != 'n');

            continuar = (resp == 's');
            System.out.println(continuar ? "\nReiniciando..." : "\nFim de jogo. Pontuação final: " + pontos);
        }

        in.close();
    }

    static int escolherDificuldade(Scanner in) {
        int opcao;
        do {
            System.out.println();
            System.out.println("Escolha a dificuldade:");
            System.out.println("1 - Fácil (1 a 20)");
            System.out.println("2 - Médio (1 a 50)");
            System.out.println("3 - Difícil (1 a 100)");
            System.out.print("Opção: ");

            while (!in.hasNextInt()) {
                System.out.print("Entrada inválida. Digite 1, 2 ou 3: ");
                in.next();
            }
            opcao = in.nextInt();
        } while (opcao < 1 || opcao > 3);

        if (opcao == 1) return 20;
        if (opcao == 2) return 50;
        return 100;
    }

    static int lerInteiro(Scanner in, String prompt) {
        System.out.print(prompt);
        while (!in.hasNextInt()) {
            System.out.print("Valor inválido. Digite um número inteiro: ");
            in.next();
        }
        return in.nextInt();
    }
}