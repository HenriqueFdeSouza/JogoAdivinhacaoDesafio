package com.github.henriquefdesouza.jogo;

import com.github.henriquefdesouza.excecoes.NivelInvalidoException;
import com.github.henriquefdesouza.nivel.*;
import com.github.henriquefdesouza.usuario.Usuario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Jogo {

    public static final int QUANTIDADE_DE_NIVEIS = 3;
    private Usuario usuario;
    private Nivel nivel;
    ArrayList<Nivel> niveis = new ArrayList<>();


    public Jogo(Usuario usuario) {
        try {
            setUsuario(usuario);
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public Jogo(Usuario usuario, Nivel nivel) {
        try {
            setUsuario(usuario);
            setNivel(nivel);
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public void setUsuario(Usuario usuario) {
        Objects.requireNonNull(usuario, "Erro Usuario não pode ser Null.");
        this.usuario = usuario;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    boolean temNivel() {
        return getNivel() != null;
    }


    public void startGame() {
        if (temNivel()) {
            System.out.printf("Seja bem-vindo %s, está preparado para falhar miseravelmente?%n", usuario.getNickName());
            escolherNivelDoJogo(getNivel());
        } else {
            listaDeNiveis();
            mostrarNiveisParaUsuario();
        }
    }

    private void escolherNivelDoJogo(Nivel nivel) {
        nivel.gerarNumeroAleatorio();
        nivel.gerarChancesUsuario();
        mensagemFimDoJogo(nivel);
    }

    private void listaDeNiveis() {
        niveis.add(new NivelFacil());
        niveis.add(new NivelMedio());
        niveis.add(new NivelDificil());
    }

    private void mostrarNiveisParaUsuario() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Seja bem-vindo %s, está preparado para falhar miseravelmente?%n", usuario.getNickName());
            System.out.println("1 - Fácil");
            System.out.println("2 - Médio");
            System.out.println("3 - Dificil");
            System.out.print("Escolha o nível que deseja perder (1/2/3): ");
            int nivelEscolhidoPeloUsuario = sc.nextInt();
            verificarNivelEscolhido(nivelEscolhidoPeloUsuario);
            escolherNivelDoJogo(niveis.get(nivelEscolhidoPeloUsuario - 1));
        } catch (NivelInvalidoException e) {
            System.out.printf("Erro Nivel: %s Há apenas %d níveis disponíveis.%n", e.getMessage(), niveis.size());
            mostrarNiveisParaUsuario();
        } catch (InputMismatchException e) {
            System.out.println("Digite um Número não uma Letra!");
            mostrarNiveisParaUsuario();
        } catch (NullPointerException e) {
        }
    }

    private void verificarNivelEscolhido(int nivelEscolhidoPeloUsuario) {
        if (nivelEscolhidoPeloUsuario > QUANTIDADE_DE_NIVEIS) {
            throw new NivelInvalidoException("O nível escolhido não é válido.");
        }
    }

    private void mensagemFimDoJogo(Nivel nivel) {
        if (nivel.verificarNumeroUsuario()) {
            mensagemVitoria(nivel);

        } else {
            mensagemDerrota(nivel);
        }
    }

    private void mensagemVitoria(Nivel nivel) {
        System.out.printf("Congratulations! Você conseguiu adivinhar! Mas não se ache muito, " +
                "quero ver você vencer no próximo Nível!" + "%nO número gerado foi %d%n", nivel.getNumeroAleatorioGerado());
    }

    private void mensagemDerrota(Nivel nivel) {
        System.out.printf("Game Over, esse jogo não é para você!" +
                "%nO número gerado foi %d%n", nivel.getNumeroAleatorioGerado());
    }


}
