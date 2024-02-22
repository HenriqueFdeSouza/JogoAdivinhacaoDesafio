package com.github.henriquefdesouza.jogo;

import com.github.henriquefdesouza.excecoes.NivelInvalidoException;
import com.github.henriquefdesouza.nivel.*;
import com.github.henriquefdesouza.usuario.Usuario;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Jogo {

    public static final int QUANTIDADE_DE_NIVEIS = 3;
    private Usuario usuario;

    private List<Nivel> listaDeNiveis() {
        return Arrays.asList(new NivelFacil(), new NivelMedio(), new NivelDificil());
    }

    public void startGame() {
        usuario = new Usuario();
        mostrarNiveisParaUsuario();
    }

    private void escolherNivelDoJogo(Nivel nivel) {
        nivel.nivelEscolhido();
        System.out.println(mensagemFimDoJogo(nivel));
    }

    private void mostrarNiveisParaUsuario() {
        try {
            System.out.printf("Seja bem-vindo %s, está preparado para falhar miseravelmente?%n", usuario.getNickName());
            System.out.println("1 - Fácil");
            System.out.println("2 - Médio");
            System.out.println("3 - Dificil");
            System.out.print("Escolha o nível que deseja perder (1/2/3): ");
            verificarNivelEscolhido(GameManager.nivelEscolhidoPeloUsuario);
            escolherNivelDoJogo(listaDeNiveis().get(GameManager.nivelEscolhidoPeloUsuario - 1));
        } catch (NivelInvalidoException e) {
            System.out.printf("Erro Nivel: %s Há apenas %d níveis disponíveis.%n", e.getMessage(), listaDeNiveis().size());
            mostrarNiveisParaUsuario();
        } catch (InputMismatchException e) {
            System.out.println("Digite um Número não uma Letra!");
            mostrarNiveisParaUsuario();
        } catch (NullPointerException e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    private void verificarNivelEscolhido(int nivelEscolhidoPeloUsuario) {
        if (nivelEscolhidoPeloUsuario > QUANTIDADE_DE_NIVEIS) {
            throw new NivelInvalidoException("O nível escolhido não é válido.");
        }
    }

    private String mensagemFimDoJogo(Nivel nivel) {
        return nivel.verificarNumeroUsuario() ? mensagemVitoria() : mensagemDerrota();
    }

    private String mensagemVitoria() {
        return String.format("Congratulations! Você conseguiu adivinhar! Mas não se ache muito, " +
                "quero ver você vencer no próximo Nível!" + "%nO número gerado foi o %d%n", GameManager.numeroAleatorioGerado);
    }

    private String mensagemDerrota() {
        return String.format("Game Over, esse jogo não é para você!" +
                "%nO número gerado foi %d%n", GameManager.numeroAleatorioGerado);
    }
}
