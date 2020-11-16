/*
Exercícios de Fixação – Lista
 2. Considere a estrutura de lista que armazena valores inteiros. Implemente
uma função que receba um vetor de valores inteiros e construa uma lista
armazenado os elementos do vetor na lista. Assim, se for recebido o vetor
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

        int[] vetor = {3, 8, 1, 7, 2};
        int[] vetor1 = new int[5];
        System.out.printf("Vetor informado de: %d%s\n", vetor.length, " posições");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + ", ");
        }
        System.out.println("");

        Lista lista = new Lista(vetor1.length);

        lista.receberVetor(vetor);
        
        lista.mostrarLista();
        
        lista.alterarElemento(1, 2);
        
        lista.ordenarLista();
        
    }

}
