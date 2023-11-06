package com.github.henriquefdesouza.jogo;

import com.github.henriquefdesouza.nivel.*;
import com.github.henriquefdesouza.usuario.Usuario;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Jogo {

    private Usuario usuario;
    private Nivel nivel;
    ArrayList<Nivel> niveis = new ArrayList<>();


    public Jogo(Usuario usuario) {
        setUsuario(usuario);
    }

    public Jogo(Usuario usuario, Nivel nivel) {
        setUsuario(usuario);
        setNivel(nivel);
    }

    public void setUsuario(Usuario usuario) {
        Objects.requireNonNull(usuario, "Usuario não pode ser null.");
        this.usuario = usuario;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        if (nivel == null) {
            throw new NivelInvalidoException("Nivel não pode estar null.");
        }
        this.nivel = nivel;
    }

    boolean temNivel() {
        return getNivel() != null;
    }


    public void startGame() {
        try {
            if (temNivel()) {
                System.out.printf("Seja bem-vindo %s, está preparado para falhar miseravelmente?%n", usuario.getNickName());
                escolherNivelDoJogo(getNivel());
            } else {
                listaDeNiveis();
                mostrarNiveisParaUsuario();
            }
        } catch (NivelInvalidoException e) {
            System.out.printf("Erro Nivel: %s, so existem %d Niveis%n", e.getMessage(), niveis.size());
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
        Scanner sc = new Scanner(System.in);
        System.out.printf("Seja bem-vindo %s, está preparado para falhar miseravelmente?%n", usuario.getNickName());
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Dificil");
        System.out.print("Escolha o nível que deseja perder (1/2/3): ");
        int nivelEscolhidoPeloUsuario = sc.nextInt();
        verificarNivelEscolhido(nivelEscolhidoPeloUsuario, usuario);
        escolherNivelDoJogo(niveis.get(nivelEscolhidoPeloUsuario - 1));
    }

    private void verificarNivelEscolhido(int nivelEscolhidoPeloUsuario, Usuario usuario) {
        if (nivelEscolhidoPeloUsuario > 3) {
            throw new NivelInvalidoException("Nível escolhido não existe. Escolha novamente.");
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
