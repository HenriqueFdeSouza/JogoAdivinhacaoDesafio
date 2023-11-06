package com.github.henriquefdesouza.nivel;

import java.util.Random;
import java.util.Scanner;

public class NivelFacil implements Nivel {

    public static final int CHANCES_NIVEL_FACIL = 6;

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
        int limiteMaximo = 10;
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
        System.out.printf("Você tem %d Chances Para Adivinhas o número Gerado!%n", CHANCES_NIVEL_FACIL);


        for (int i = 0; i < CHANCES_NIVEL_FACIL; i++) {
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

    @Override
    public boolean verificarNumeroUsuario() {
        return getNumeroEscolhidoPeloUsuario() == getNumeroAleatorioGerado();
    }


}
