package com.github.henriquefdesouza.nivel;

import java.util.Random;

public interface Nivel {

    int getLimiteMaximoGerado();

    void imprimirNivelCorrespondente();

    int getNivel();

    default void nivelEscolhido() {
        gerarNumeroAleatorio();
        gerarChancesUsuario();
    }

    default int gerarNumeroAleatorio() {
        Random random = new Random();
        int limiteMaximoGerado = getLimiteMaximoGerado();
        System.out.println("Número Gerado!");
        return GameManager.numeroAleatorioGerado = random.nextInt(limiteMaximoGerado);
    }

    default void gerarChancesUsuario() {
        imprimirNivelCorrespondente();

        for (int i = 0; i < getNivel(); i++) {
            System.out.print("Digite o " + (i + 1) + " Número: ");
            GameManager.numeroEscolhidoPeloUsuario();
            if (verificarNumeroUsuario()) {
                break;
            }
            if (GameManager.numeroDoUsuario > getLimiteMaximoGerado()) {
                System.out.println("Você perdeu uma chance pois digitou um número maior que o gerado!");
            }
        }
    }

    default boolean verificarNumeroUsuario() {
        return GameManager.numeroDoUsuario == GameManager.numeroAleatorioGerado;
    }

}
