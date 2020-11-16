/*
 Exercícios de Fixação – Lista
2. Considere a estrutura de lista que armazena valores inteiros. Implemente
uma função que receba um vetor de valores inteiros e construa uma lista
armazenado os elementos do vetor na lista. Assim, se for recebido o vetor
v= {3, 8, 1, 7, 2}, a função deve retornar uma lista cujo primeiro elemento
seja a informação 3, o segundo a informação 8, e assim por diante. Se o
vetor tiver zero elementos, a função deve retornar uma lista vazia.
 */
package br.rogerio.model;

/**
 *
 * @author roger
 */
public class Lista {

    private final int MAXTAM;
    private int[] array;
    private int ultimo;

    public Lista(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho deve ser maior de zero!\n");
        }
        MAXTAM = tamanho;
        array = new int[MAXTAM];
        ultimo = -1;
    }

    public boolean isEmpty() {
        return ultimo == -1;
    }

    public boolean isFull() {
        return ultimo + 1 == MAXTAM;
    }

    public int size() {
        return ultimo + 1;
    }

    public void inserirNoInicio(int elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        ultimo++;
        for (int i = ultimo; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = elemento;
    }

    public void ordenarLista() {
        int atual;
        int i;
        int j;
        for (i = 1; i < ultimo + 1; i++) {
            atual = array[i];
            j = i - 1;
            while (j >= 0 && atual < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = atual;
        }
        mostrarLista();
    }

    public void inserirDeFormaOrdenada(int elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        ultimo++;
        int i = ultimo;
        while ((i > 0) && (elemento < array[i - 1])) {
            array[i] = array[i - 1];
            i--;
        }
        array[i] = elemento;
    }

    public void mostrarLista() {
        if (isEmpty()) {
            System.out.println("A lista está vazia!\n");
        } else {
            System.out.println("*****  Elementos da lista  *****");
            for (int i = 0; i <= ultimo; i++) {
                System.out.printf("%d, ", array[i]);
            }
            System.out.println("");
        }
    }

    public void inserirNoFim(int elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        ultimo++;
        array[ultimo] = elemento;
    }

    public void inserirNaPosicaoInformada(int posicao, int elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        if (posicao > ultimo + 1 || posicao < 0) {
            throw new RuntimeException("Posição inválida!\n");
        }
        ultimo++;
        for (int i = ultimo; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = elemento;
    }

    public void removerNoInicio() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        for (int i = 0; i < MAXTAM; i++) {
            array[i] = array[i + 1];
        }
        ultimo--;
    }

    public void removerNoFim() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        ultimo--;
    }

    public void removerElementoNaPosicaoInformada(int posicao) {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        if (posicao < 0 || posicao > ultimo) {
            throw new RuntimeException("Posição inválida!\n");
        }
        for (int i = posicao; i < ultimo; i++) {
            array[i] = array[i + 1];
        }
        ultimo--;
    }

    public int buscarPosicaoDoElemento(int elemento) {
        for (int i = 0; i <= ultimo; i++) {
            if (array[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public boolean removerElemento(int elemento) {
        int pos = buscarPosicaoDoElemento(elemento);
        if (pos == -1) {
            return false;
        }
        removerElementoNaPosicaoInformada(pos);
        return true;
    }

    public int getElementoNoInicio() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        return array[0];
    }

    public int getElementoNoFim() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        return array[ultimo];
    }

    public int getElementoNaPosicaoInformata(int posicao) {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        if (posicao > ultimo || posicao < 0) {
            throw new RuntimeException("Posição inválida!\n");
        }
        return array[posicao];
    }

    public void destroy() {
        ultimo = -1;
    }

    public boolean alterarElemento(int elemento, int novoElemento) {

        for (int i = 0; i < size(); i++) {
            if (elemento == array[i]) {
                array[i] = novoElemento;
                return true;
            }
        }
        
        return false;
    }

    public void receberVetor(int[] vetor) {

        if (isFull()) {
            System.out.println("A lista está cheia!\n");
        }

        if (vetor.length > 0) {
            for (int i = 0; i < vetor.length; i++) {
                if (vetor[i] > 0) {
                    inserirNoFim(vetor[i]);
                } else {
                    System.out.println("O vetor informado está vazio\nVerifique!");
                    break;
                }
            }
        }
    }
}
