package com.example.carpooling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Grafo {
    private Map<Integer, List<int[]>> grafo;

    public Grafo() {
        this.grafo = new HashMap<>();
    }

    public void agregarArista(int origen, int destino, int peso) {
        List<int[]> vecinos = grafo.getOrDefault(origen, new ArrayList<>());
        vecinos.add(new int[]{destino, peso});
        grafo.put(origen, vecinos);
    }

    public void generarGrafo(int numeroDeNodos) {
        Random random = new Random();

        for (int i = 1; i <= numeroDeNodos; i++) {
            for (int j = i + 1; j <= numeroDeNodos; j++) {
                int peso = random.nextInt(10) + 1; // Generar un peso aleatorio de 1 a 10
                agregarArista(i, j, peso);
                agregarArista(j, i, peso); // Para hacer el grafo no dirigido
            }
        }
    }

    public void imprimirGrafo() {
        System.out.println("Conexiones del Grafo:");
        for (int nodo : grafo.keySet()) {
            System.out.print(nodo + " -> ");
            for (int[] vecino : grafo.get(nodo)) {
                System.out.print("(" + vecino[0] + ", peso " + vecino[1] + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grafo grafoAleatorio = new Grafo();
        grafoAleatorio.generarGrafo(30);
        grafoAleatorio.imprimirGrafo();
    }
}

