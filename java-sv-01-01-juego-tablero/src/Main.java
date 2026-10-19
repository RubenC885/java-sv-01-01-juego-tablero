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
            System.out.println("Tu jugador se encuentra en la casilla (0, 0)");
            System.out.println("Te puedes desplazar con las teclas W A S D");
            Scanner scan = new Scanner(System.in);
            System.out.print("Dime una letra: ");
            char movimiento;
        int temp = 1;
        int casilla = 0;
        for (int l = 0; l < temp;) {
            for (int p = 0; p < 1; p++) {
                do {
                    movimiento = scan.next().toUpperCase().charAt(0);
                    if (movimiento != 'D' & movimiento != 'S' & movimiento != 'A' & movimiento != 'W') {
                        System.out.println("No puedes ir en esa dirección");
                        System.out.print("Dime una letra: ");
                    }
                } while (movimiento != 'D' & movimiento != 'S' & movimiento != 'A' & movimiento != 'W');
                System.out.println("La letra elegida es: " + movimiento);
                matriz[filaY][colY] = '*';
                switch (movimiento) {
                    case 'A' -> {
                        colY--;
                        if (colY < 0) {
                            p--;
                            System.out.println("No puedes ir en esa dirección");
                            System.out.print("Dime una letra: ");
                            colY++;
                        }else if (matriz[filaY][colY] == 'M') {
                            casilla = 1;
                            vidas--;
                        } else if (matriz[filaY][colY] == 'P') {
                            casilla = 2;
                            vidas++;
                        } else if (matriz[filaY][colY] == 'F') {
                            casilla = 3;
                            l = 1;
                        }
                    }
                    case 'S' -> {
                        filaY++;
                        if (filaY >= matriz.length) {
                            p--;
                            System.out.println("No puedes ir en esa dirección");
                            System.out.print("Dime una letra: ");
                            filaY--;
                        }else if (matriz[filaY][colY] == 'M') {
                            casilla = 1;
                            vidas--;
                        } else if (matriz[filaY][colY] == 'P') {
                            casilla = 2;
                            vidas++;
                        } else if (matriz[filaY][colY] == 'F') {
                            casilla = 3;
                            l = 1;
                        }
                    }
                    case 'D' -> {
                        colY++;
                        if (colY >= matriz[p].length) {
                            p--;
                            System.out.println("No puedes ir en esa dirección");
                            System.out.print("Dime una letra: ");
                            colY--;
                        }else if (matriz[filaY][colY] == 'M') {
                            casilla = 1;
                            vidas--;
                        } else if (matriz[filaY][colY] == 'P') {
                            casilla = 2;
                            vidas++;
                        } else if (matriz[filaY][colY] == 'F') {
                            casilla = 3;
                            l = 1;
                        }
                    }
                    case 'W' -> {
                        filaY--;
                        if (filaY < 0) {
                            p--;
                            System.out.println("No puedes ir en esa dirección");
                            System.out.print("Dime una letra: ");
                            filaY++;
                        }else if (matriz[filaY][colY] == 'M') {
                            casilla = 1;
                            vidas--;
                        } else if (matriz[filaY][colY] == 'P') {
                            casilla = 2;
                            vidas++;
                        } else if (matriz[filaY][colY] == 'F') {
                            casilla = 3;
                            l = 1;
                        }
                    }
                }
            }
            matriz[filaY][colY] = yoda;
            switch (casilla) {
                case 1 -> System.out.println("¡Te has golpeado con un muro!");
                case 2 -> System.out.println("¡Has encontrado una poción!");
                case 3 -> System.out.println("!Has ganado!");
            }
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Vidas: " + vidas);
            if (vidas == 0) {
                temp = 1;
            }
        }
    }
    }