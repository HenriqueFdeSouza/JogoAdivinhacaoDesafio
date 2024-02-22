package com.github.henriquefdesouza.nivel;

public class NivelFacil implements Nivel {

    private final int CHANCES_NIVEL_FACIL = 6;

    @Override
    public int getNivel() {
        return CHANCES_NIVEL_FACIL;
    }

    @Override
    public int getLimiteMaximoGerado() {
        return 10;
    }

    @Override
    public void imprimirNivelCorrespondente() {
        System.out.println("Você está no nível facil. Ja vi que você é noob!");
        System.out.printf("Você tem %d Chances Para Adivinhas o número Gerado!%n", CHANCES_NIVEL_FACIL);
    }


}
