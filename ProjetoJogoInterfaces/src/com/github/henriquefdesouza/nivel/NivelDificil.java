package com.github.henriquefdesouza.nivel;

import java.util.Random;
import java.util.Scanner;

public class NivelDificil implements Nivel {

    public static final int CHANCES_NIVEL_DIFICIL = 10;

    private int numeroAleatorioGerado;
    private int numeroEscolhidoPeloUsuario;

    public void setNumeroAleatorioGerado(int numeroAleatorioGerado) {
        this.numeroAleatorioGerado = numeroAleatorioGerado;
    }

    public int getNumeroEscolhidoPeloUsuario() {
        return numeroEscolhidoPeloUsuario;
    }

    public void setNumeroEscolhidoPeloUsuario(int numeroEscolhidoPeloUsuario) {
        this.numeroEscolhidoPeloUsuario = numeroEscolhidoPeloUsuario;
    }

    @Override
    public int getNumeroAleatorioGerado() {
        return numeroAleatorioGerado;
    }

    @Override
    public int getLimiteMaximoGerado() {
        int limiteMaximo = 30;
        return limiteMaximo;
    }

    @Override
    public int gerarNumeroAleatorio() {
        Random random = new Random();
        int limiteMaximoGerado = getLimiteMaximoGerado();
        setNumeroAleatorioGerado(random.nextInt(limiteMaximoGerado));
        System.out.println("Número Gerado!");
        return getNumeroAleatorioGerado();
    }

    @Override
    public void gerarChancesUsuario() {
        Scanner sc = new Scanner(System.in);
        imprimirNivelCorrespondente();

        for (int i = 0; i < CHANCES_NIVEL_DIFICIL; i++) {
            System.out.print("Digite o " + (i + 1) + " Número: ");
            setNumeroEscolhidoPeloUsuario(sc.nextInt());
            if (verificarNumeroUsuario()) {
                break;
            }
            if (getNumeroEscolhidoPeloUsuario() > getLimiteMaximoGerado()) {
                System.out.println("Você perdeu uma chance pois digitou um número maior que o gerado!");
            }
        }
    }

    public boolean verificarNumeroUsuario() {
        return getNumeroEscolhidoPeloUsuario() == getNumeroAleatorioGerado();
    }

    public void imprimirNivelCorrespondente() {
        System.out.println("Você está no nível Dificil. Daqui, você não passa!");
        System.out.printf("Você tem %d Chances Para Adivinhas o número Gerado!%n", CHANCES_NIVEL_DIFICIL);
    }
}
