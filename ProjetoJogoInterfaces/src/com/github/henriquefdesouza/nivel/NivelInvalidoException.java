package com.github.henriquefdesouza.nivel;

public class NivelInvalidoException extends RuntimeException {

    private int quantidadeDeNiveis;

    public NivelInvalidoException(String message, int quantidadeDeNiveis) {
        super(message);
        this.quantidadeDeNiveis = quantidadeDeNiveis;
    }

    public NivelInvalidoException(String message) {
        super(message);
    }

    public int getQuantidadeDeNiveis() {
        return quantidadeDeNiveis;
    }
}
