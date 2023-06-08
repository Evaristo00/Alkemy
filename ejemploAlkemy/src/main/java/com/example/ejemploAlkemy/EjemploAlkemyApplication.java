package com.example.ejemploAlkemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

public class EjemploAlkemyApplication {

    public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Bienvenido al Conversor de Temperatura");
//		while(true){
//			System.out.println("=====================================");
//			System.out.println("1. Celsius a Fahrenheit");
//			System.out.println("2. Fahrenheit a Celsius");
//			System.out.println("3. Salir");
//			System.out.print("Elige una opción (1,2 o 3): ");
//			int opcion = scanner.nextInt();
//
//			if (opcion == 1) {
//				System.out.print("Ingresa la temperatura en grados Celsius: ");
//				double celsius = scanner.nextDouble();
//				double fahrenheit = (celsius * 9/5) + 32;
//				System.out.println("La temperatura en grados Fahrenheit es: " + fahrenheit);
//			} else if (opcion == 2) {
//				System.out.print("Ingresa la temperatura en grados Fahrenheit: ");
//				double fahrenheit = scanner.nextDouble();
//				double celsius = (fahrenheit - 32) * 5 / 9;
//				System.out.println("La temperatura en grados Celsius es: " + celsius);
//			}
//			else if (opcion == 3) {
//					break;
//			} else {
//				System.out.println("Opción inválida. Por favor, elige 1 o 2.");
//			}
//		}
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingresa el operador a utilizar:");
        System.out.println("Operaciones basicas:");
        System.out.println("\t 1. Suma. \n\t 2.Resta.\n\t 3.Multiplicacion. \n\t 4.Division.");
        System.out.println("Operaciones avanzada:");
        System.out.println("\t 5. Potencia. \n\t 6.Raiz cuadrada.\n\t 7.Modulo.");
        System.out.println("Conversion de Temperatura");
        System.out.println("\t 8.Celsius a Fahrenheit. \n\t 9.Fahrenheit a Celsius.");
        int operador = scanner.nextInt();

//		if (operador == 1){
//			System.out.println("El resultado es " + (num1 + num2));
//		} else if (operador == 2) {
//			System.out.println("El resultado es " + (num1 - num2));
//		} else if (operador == 3) {
//			System.out.println("El resultado es " + (num1 * num2));
//		}else if (operador == 4) {
//			System.out.println("El resultado es " + (num1 / num2));
//		}

        System.out.println("Ingresa primer numero");
        double num1 = scanner.nextDouble(),num2 = 0;
        if (operador < 8){
            System.out.println("Ingresa segundo numero");
            num2 = scanner.nextDouble();
        }

        switch (operador) {
            case 1 -> {
                System.out.println("El resultado es " + (num2 + num1));
            }
            case 2 -> {
                System.out.println("El resultado es " + (num1 - num2));
            }
            case 3 -> {
                System.out.println("El resultado es " + (num1 * num2));
            }
            case 4 -> {
                System.out.println("El resultado es " + (num1 / num2));
            }
            case 5 -> {
                System.out.println("El resultado es " + Math.pow(num1,num2));
            }
            case 6 -> {
                System.out.println("El resultado es " + (Math.pow(num1, 1.0 / num2)));
            }
            case 7 -> {
                System.out.println("El resultado es " + (num1 % num2));
            }
            case 8 -> {
                System.out.println("El resultado es " + ((num1 * 9/5) + 32));
            }
            case 9 -> {
                System.out.println("El resultado es " + ((num1 - 32) * 5 / 9));
            }
        }

        // Declarar y crear un arreglo multidimensional de 3x3
//        int[][] matriz = new int[4][4];
//        Random random = new Random();
//
//        // Llenar la matriz con valores aleatorios del 1 al 10
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                matriz[i][j] = random.nextInt(100) + 1;
//            }
//        }
//        // Imprimir la matriz
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.print(matriz[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        int max = -1, min = 999;
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//               if(max < matriz[i][j]) max = matriz[i][j];
//               if(min > matriz[i][j]) min = matriz[i][j];
//            }
//        }
//        System.out.println("El maximo es: " + max + " El minimo es: " + min);
    }

}
