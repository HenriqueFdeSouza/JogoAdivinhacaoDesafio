package com.github.henriquefdesouza.nivel;

public class NivelMedio implements Nivel {

    private final int CHANCES_NIVEL_MEDIO = 8;

    @Override
    public int getNivel() {
        return CHANCES_NIVEL_MEDIO;
    }

    @Override
    public int getLimiteMaximoGerado() {
        return 20;
    }

    public void imprimirNivelCorrespondente() {
        System.out.println("Você está no nível médio. Daqui, você não passa!");
        System.out.printf("Você tem %d Chances Para Adivinhas o número Gerado!%n", CHANCES_NIVEL_MEDIO);
    }


}
