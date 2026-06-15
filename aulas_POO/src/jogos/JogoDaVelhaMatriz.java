package jogos;

import java.util.Scanner;

public class JogoDaVelhaMatriz {
    private static final int N = 3;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] tab = new char[N][N];
        limpar(tab);
        char jogador = 'X';

        System.out.println("=== Jogo da Velha (matriz) ===");
        imprimeGuia();

        while (true) {
            imprime(tab);
            int[] pos = lerJogadaValida(tab, jogador); // [linha, coluna]
            tab[pos[0]][pos[1]] = jogador;

            if (venceu(tab, jogador)) {
                imprime(tab);
                System.out.println("Jogador " + jogador + " venceu!");
                break;
            }

            if (empate(tab)) {
                imprime(tab);
                System.out.println("Empate!");
                break;
            }

            // Alterna o jogador: se for 'X' vira 'O', senão vira 'X'
            jogador = (jogador == 'X') ? 'O' : 'X';
        }
        sc.close();
    }

    // ===== Utilidades =====
    private static void limpar(char[][] t) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                t[i][j] = ' ';
            }
        }
    }

    private static void imprimeGuia() {
        System.out.println("Informe LINHA COLUNA (1 a 3). Ex.: \"2 3\" coloca na linha 2, coluna 3.");
        System.out.println();
    }

    private static void imprime(char[][] t) {
        for (int i = 0; i < N; i++) {
            System.out.print(" ");
            for (int j = 0; j < N; j++) {
                System.out.print(t[i][j]);
                if (j < N - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < N - 1) System.out.println("---+---+---");
        }
        System.out.println();
    }

    private static int[] lerJogadaValida(char[][] t, char jogador) {
        while (true) {
            System.out.print("Jogador " + jogador + " (linha coluna 1-3): ");
            
            if (!sc.hasNextInt()) { 
                sc.next(); 
                System.out.println("Linha inválida."); 
                continue; 
            }
            int lin = sc.nextInt();

            if (!sc.hasNextInt()) { 
                sc.next(); 
                System.out.println("Coluna inválida."); 
                continue; 
            }
            int col = sc.nextInt();

            if (lin < 1 || lin > 3 || col < 1 || col > 3) {
                System.out.println("Fora do intervalo. Tente novamente.");
                continue;
            }

            // Conversão de 1-3 (usuário) para 0-2 (índice da matriz)
            int i = lin - 1;
            int j = col - 1;

            if (t[i][j] != ' ') {
                System.out.println("Posição ocupada. Escolha outra.");
                continue;
            }

            return new int[]{i, j};
        }
    }

    private static boolean venceu(char[][] t, char p) {
        // Verificar linhas
        for (int i = 0; i < N; i++) {
            boolean ok = true;
            for (int j = 0; j < N; j++) {
                if (t[i][j] != p) { 
                    ok = false; 
                    break; 
                }
            }
            if (ok) return true;
        }

        // Verificar colunas
        for (int j = 0; j < N; j++) {
            boolean ok = true;
            for (int i = 0; i < N; i++) {
                if (t[i][j] != p) { 
                    ok = false; 
                    break; 
                }
            }
            if (ok) return true;
        }

        // Verificar diagonal principal
        boolean okDP = true;
        for (int k = 0; k < N; k++) {
            if (t[k][k] != p) { 
                okDP = false; 
                break; 
            }
        }
        if (okDP) return true;

        // Verificar diagonal secundária
        boolean okDS = true;
        for (int k = 0; k < N; k++) {
            if (t[k][N - 1 - k] != p) { 
                okDS = false; 
                break; 
            }
        }
        return okDS;
    }

    private static boolean empate(char[][] t) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (t[i][j] == ' ') { 
                    return false; 
                }
            }
        }
        return true;
    }
}