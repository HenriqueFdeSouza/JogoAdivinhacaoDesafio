package com.github.henriquefdesouza.nivel;

import java.util.Scanner;

public class GameManager {
    private static final Scanner sc = new Scanner(System.in);

    public static int numeroDoUsuario;
    public static int numeroAleatorioGerado;

    public static int nivelEscolhidoPeloUsuario = sc.nextInt();


    public static int numeroEscolhidoPeloUsuario() {
        return numeroDoUsuario = sc.nextInt();
    }
}
