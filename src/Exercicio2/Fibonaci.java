package Exercicio2;

import java.util.Scanner;

public class Fibonaci {
    // Verificando se o numero pertece a sequencia
    public static boolean isFibonacci(int n) {
        if (n < 0) {
            return false;
        }

        // Os dois primeiros números da sequência
        int a = 0, b = 1;

        // Verifica se o número informado é 0 ou 1
        if (n == a || n == b) {
            return true;
        }

        // gerando a sequencia de Fibonacci até que b seja maior ou igual ao número informado
        int c = a + b;
        while (c <= n) {
            if (c == n) {
                return true;
            }
            a = b;
            b = c;
            c = a + b;
        }

        // Retorna false se o número não for encontrado na sequência
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int number = scanner.nextInt();

        if (isFibonacci(number)) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " não pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }
}
