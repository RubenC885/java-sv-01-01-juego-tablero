import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] matriz = new char[10][10];

        int vidas = 10;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = '*';
            }
        }
        char yoda = 'Y';
        int filaY = 0;
        int colY = 0;
        matriz[filaY][colY] = yoda;
        System.out.println("Tu jugador se encuentra en la casilla (0, 0)");
        System.out.println("Te puedes desplazar con las teclas W A S D");
        Scanner scan = new Scanner(System.in);
        System.out.print("Dime una letra: ");
        char movimiento;
        do {
            movimiento = scan.next().toUpperCase().charAt(0);
            if (movimiento != 'D') {
                System.out.println("No puedes ir en esa dirección");
                System.out.print("Dime una letra: ");
            }
        } while (movimiento != 'D');
            matriz[filaY][colY] = '*';
            colY++;
            matriz[filaY][colY] = yoda;
        System.out.println("La letra elegida es: " + movimiento);

        char fin = 'F';
        matriz[9][9] = fin;
        Random dice = new Random();
        char muro = 'M';
        char pocima = 'P';
        int filaR;
        int colR;
        do {
            filaR = dice.nextInt(10);
            colR = dice.nextInt(10);
        } while (matriz[filaR][colR] != '*');
        matriz[filaR][colR] = muro;
        for (int i = 0; i < 5; i++) {
            do {
                filaR = dice.nextInt(10);
                colR = dice.nextInt(10);
            } while (matriz[filaR][colR] != '*');
            matriz[filaR][colR] = pocima;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}