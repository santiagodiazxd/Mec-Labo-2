/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aleatorios;

/**
 *
 * @author Estudiante
 */import java.util.Scanner;
import java.util.Random;
public class Aleatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           int[] tamaños = { 100, 500, 1000, 5000, 10000 };
        for (int tamaño : tamaños) {
            double[] arr = generarArregloAleatorio(tamaño);
            long startTime, endTime;

            // Ordenamiento burbuja
            startTime = System.nanoTime();
            burbuja(arr);
            endTime = System.nanoTime();
            System.out.printf("Burbuja para %d elementos: %d ns\n", tamaño, endTime - startTime);

            // Ordenamiento por inserción
            arr = generarArregloAleatorio(tamaño);
            startTime = System.nanoTime();
            insercion(arr);
            endTime = System.nanoTime();
            System.out.printf("Inserción para %d elementos: %d ns\n", tamaño, endTime - startTime);

            // Ordenamiento por selección
            arr = generarArregloAleatorio(tamaño);
            startTime = System.nanoTime();
            seleccion(arr);
            endTime = System.nanoTime();
            System.out.printf("Selección para %d elementos: %d ns\n", tamaño, endTime - startTime);

            // Ordenamiento por mezcla
            arr = generarArregloAleatorio(tamaño);
            startTime = System.nanoTime();
            mergeSort(arr, 0, arr.length - 1);
            endTime = System.nanoTime();
            System.out.printf("Mezcla para %d elementos: %d ns\n", tamaño, endTime - startTime);
        }
    }

    private static double[] generarArregloAleatorio(int tamaño) {
        double[] arr = new double[tamaño];
        Random random = new Random();
        for (int i = 0; i < tamaño; i++) {
            arr[i] = random.nextDouble();
        }
        return arr;
    }

    // Implementación del algoritmo de ordenamiento burbuja
    private static void burbuja(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambia arr[j] y arr[j+1]
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Implementación del algoritmo de ordenamiento por inserción
    private static void insercion(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Implementación del algoritmo de ordenamiento por selección
    private static void seleccion(double[] arr) {
        int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[min_idx]) {
                        min_idx = j;
                    }
                }
                // Intercambia el elemento mínimo con el primer elemento
                        double temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Implementación del algoritmo de ordenamiento por mezcla
    private static void mergeSort(double[] arr, int l, int r) {
        if (l < r) {
            // Encuentra el punto medio del arreglo
            int m = (l + r) / 2;
    
            // Ordena la primera y segunda mitad del arreglo
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
    
            // Une las dos mitades ordenadas
            merge(arr, l, m, r);
        }
    }

    // Función auxiliar para unir dos subarreglos del arreglo dado
    private static void merge(double[] arr, int l, int m, int r) {
        // Encuentra el tamaño de los subarreglos a unir
        int n1 = m - l + 1;
        int n2 = r - m;
    
        // Crea arreglos temporales para almacenar los valores de los subarreglos
        double[] L = new double[n1];
        double[] R = new double[n2];
    
        // Copia los datos a los arreglos temporales
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
    
        // Une los arreglos temporales en el arreglo original
        int i = 0, j = 0;
    
        // Índice inicial del subarreglo fusionado
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
    
        // Copia los elementos restantes de L[], si hay alguno
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
    
        // Copia los elementos restantes de R[], si hay alguno
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
}