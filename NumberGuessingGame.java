package Ngg;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Bem-vindo ao Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfTries = 0;
            int maxTries = 10;
            int guess;
            boolean win = false;
            int roundScore = 0;
            ArrayList<Integer> guessHistory = new ArrayList<>();

            System.out.println("Escolhi aleatoriamente um número entre 1 e 100.");
            System.out.println("Tente acertar em " + maxTries + " tentativas.");

            while (!win && numberOfTries < maxTries) {
                System.out.print("Insira seu palpite: ");
                guess = scanner.nextInt();
                guessHistory.add(guess);
                numberOfTries++;

                if (guess == numberToGuess) {
                    win = true;
                    if (numberOfTries <= 5) {
                        roundScore += 10; // 10 pontos se acertar em até 5 tentativas
                    } else {
                        roundScore += 5; // 5 pontos se acertar em mais de 5 tentativas
                    }
                } else if (guess < numberToGuess) {
                    System.out.println(">> É maior. Tente novamente");
                } else {
                    System.out.println(">> É menor. Tente novamente");
                }

                // Sistema de Dicas
                if (!win) {
                    if (numberToGuess % 2 == 0) {
                        System.out.println(">>Dica: O número é par."); 
                    } else {
                        System.out.println(">>Dica: O número é ímpar."); 
                    }

                    if (numberToGuess % 3 == 0) {
                        System.out.println("Dica: O número é multiplo de 3."); 
                    }
                }

                System.out.println(">> Seus palpites: " + guessHistory);
            }

            if (win) {
                System.out.println("Parabéns! Você acertou em " + numberOfTries + " tentativas.");
            } else {
                System.out.println("Ops! Você atingiu o limite de tentativas. O número era " + numberToGuess);
            }

            System.out.println("Você ganhou " + roundScore + " pontos nessa rodada.");
            totalScore += roundScore;
            System.out.println("Sua pontuação agora é: " + totalScore + " pontos.");

            System.out.print("Jogar novamente? (sim/não): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("sim")) {
                playAgain = false;
            }
        }

        System.out.println("Obrigada por jogar! Sua pontuação final é: " + totalScore + " pontos.");
        scanner.close();
    }
}
