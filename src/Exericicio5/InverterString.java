package Exericicio5;

import java.util.Scanner;

public class InverterString {

    public static void main(String[] args) {
        // Opção 1: String previamente definida no código
        String original = "Exemplo";

        // Opção 2: String informada pelo usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para inverter: ");
        original = scanner.nextLine();

        // Invertendo a string manualmente
        String invertida = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            invertida += original.charAt(i);
        }

        // Exibir a string invertida
        System.out.println("String original: " + original);
        System.out.println("String invertida: " + invertida);
    }
}