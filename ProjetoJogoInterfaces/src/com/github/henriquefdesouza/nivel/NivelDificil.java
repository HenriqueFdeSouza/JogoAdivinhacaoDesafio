package com.github.henriquefdesouza.nivel;

public class NivelDificil implements Nivel {

    private final int CHANCES_NIVEL_DIFICIL = 10;

    public int getNivel() {
        return CHANCES_NIVEL_DIFICIL;
    }

    @Override
    public int getLimiteMaximoGerado() {
        return 30;
    }

    @Override
    public void imprimirNivelCorrespondente() {
        System.out.println("Você está no nível Dificil. Daqui, você não passa!");
        System.out.printf("Você tem %d Chances Para Adivinhas o número Gerado!%n", CHANCES_NIVEL_DIFICIL);
    }
}
