/*
Exercícios de Fixação – Lista
 2. Considere a estrutura de lista que armazena valores inteiros. Implemente
uma função que receba um vetor de valores inteiros e construa uma lista
armazenando os elementos do vetor na lista. Assim, se for recebido o vetor
v= {3, 8, 1, 7, 2}, a função deve retornar uma lista cujo primeiro elemento
seja a informação 3, o segundo a informação 8, e assim por diante. Se o
vetor tiver zero elementos, a função deve retornar uma lista vazia.
 */
package br.rogerio.app;

import br.rogerio.model.Lista;

/**
 *
 * @author roger
 */
public class ListaApp {

    public static void main(String[] args) {

//        int[] vetor = {3, 8, 1, 7, 2};
        int[] vetor = new int [0];
        System.out.printf("Vetor informado de: %d%s\n", vetor.length, " posições");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + ", ");
        }
        System.out.println("");

        try {
            receberVetor(vetor);
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
    }

    private static void receberVetor(int[] vetor) {

        if (vetor.length <= 0) {
            System.out.println("A lista está vazia!");
        }
        Lista lista = new Lista(vetor.length);

        for (int i = 0; i < vetor.length; i++) {
            lista.inserirNoFim(vetor[i]);
        }
        lista.mostrarLista();
    }
}
