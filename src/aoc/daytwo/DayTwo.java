package aoc.daytwo;

import aoc.inputfile.InputReader;
import java.util.Scanner;

public class DayTwo {

    public static void main(String[] args) {
        InputReader reader = new InputReader("inputday2.txt");
        System.out.println(String.format("Part one result %d", partOne(reader.getFileContent())));
        System.out.println(String.format("Part two result %d", partTwo(reader.getFileContent())));
    }
    /* --- Part One --- */
    /**
     * Metodo per verificare se e' stata ottenuta una vittoria
     * @param op - mossa dell'avversario
     * @param my - mossa effetuata seguendo la guida
     * @return 0 se persa, 1, 2 o 3 se vinta, secondo la scala di punteggi del gioco
     */
    private static int isWin(char op, char my) {

        if (op == 'A'/* rock */ && my == 'Y' /* paper */) {
            return Points.PAPER.ordinal() + 1;
        }

        if (op == 'B' /* paper */ && my == 'Z' /* scissor */) {
            return Points.SCISSOR.ordinal() + 1;
        }

        if (op == 'C' /* scissor */ && my == 'X' /* rock */) {
            return Points.ROCK.ordinal() + 1;
        }

        return 0;
    }

    /**
     * Metodo per verificare se e' stato ottenuto un pareggio
     * @param op - mossa avversario
     * @param my - mossa effettuata seguendo la guida
     * @return 0 in caso di errore, 1, 2 o 3, secondo la scala di punteggi del gioco
     */
    private static int isDraw(char op, char my) {
        if (op == 'A' && my == 'X') { // Rock 1
            return Points.ROCK.ordinal() + 1;
        }

        if (op == 'B' && my == 'Y') { // Paper 2
            return Points.PAPER.ordinal() + 1;
        }

        if (op == 'C' && my == 'Z') { // Scissor 3
            return Points.SCISSOR.ordinal() + 1;
        }

        return 0;
    }

    /**
     * Determina il punteggio della perdita in base alla mossa
     * effettuata seguendo la guida.
     * @param my - mossa eseguita secondo la guida
     * @return il punteggio della mossa.
     */
    private static int isLoss(char my) {
        if (my == 'X') {
            return Points.ROCK.ordinal() + 1;
        }
        if (my == 'Y') {
            return Points.PAPER.ordinal() + 1;
        }
        if (my == 'Z') {
            return Points.SCISSOR.ordinal() + 1;
        }

        return 0;
    }

    /**
     * Analizza l'input ed elabora il punteggio di tutte le partite
     * svolte seguendo la guida degli Elfi.
     * @param inputStr Input sotto forma di stringa.
     * @return Il punteggio finale sommato di tutte le partite.
     */
    private static int partOne(String inputStr) {
        int score = 0;
        int tmp;
        Scanner scanner = new Scanner(inputStr);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if ((tmp = isWin(line.charAt(0), line.charAt(2))) > 0) {
                score = score + 6 + tmp;
            } else if ((tmp = isDraw(line.charAt(0), line.charAt(2))) > 0) {
                score = score + 3 + tmp;
            } else { // isLoss
                score = score + isLoss(line.charAt(2));
            }
        }
        scanner.close();
        return score;
    }
    /* --- Part Two --- */

    /**
     * Determina il punteggio di ogni partita in base alle
     * mosse eseguite seguendo la guida degli Elfi
     * @param move - La mossa proposta dall'avversario
     * @param result - Come deve risultare la partita secondo la guida
     * @return 0 in caso di errore, il punteggio della partita altrimenti.
     */
    private static int determineMoves(char move, char result) {
        if (move == 'A') {  // Rock
            switch (result) {
                case 'X': // Loss
                    return Points.SCISSOR.ordinal() + 1;
                case 'Y': // Draw
                    return 3 + Points.ROCK.ordinal() + 1;
                case 'Z': // Win
                    return 6 + Points.PAPER.ordinal() + 1;
            }
        }
        if (move == 'B') {  // Paper
            switch (result) {
                case 'X': // Loss
                    return Points.ROCK.ordinal() + 1;
                case 'Y': // Draw
                    return 3 + Points.PAPER.ordinal() + 1;
                case 'Z': // Win
                    return 6 + Points.SCISSOR.ordinal() + 1;
            }
        }
        if (move == 'C') { // Scissor
            switch (result) {
                case 'X': // Loss
                    return Points.PAPER.ordinal() + 1;
                case 'Y': // Draw
                    return 3 + Points.SCISSOR.ordinal() + 1;
                case 'Z': // Win
                    return 6 + Points.ROCK.ordinal() + 1;
            }
        }

        return 0;
    }

    private static int partTwo(String inputStr) {
        int score = 0;
        int tmp;
        Scanner scanner = new Scanner(inputStr);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if ((tmp = determineMoves(line.charAt(0), line.charAt(2))) > 0) {
                score = score + tmp;
            }
        }
        scanner.close();
        return score;
    }
}
