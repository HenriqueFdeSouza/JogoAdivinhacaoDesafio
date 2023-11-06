package com.github.henriquefdesouza.nivel;

import java.util.Random;
import java.util.Scanner;

public interface Nivel {

    int gerarNumeroAleatorio();

    void gerarChancesUsuario();

    int getLimiteMaximoGerado();

    boolean verificarNumeroUsuario();

    int getNumeroAleatorioGerado();

}
