package com.github.henriquefdesouza.usuario;

import java.util.Objects;
import java.util.Scanner;

public class Usuario {
    Scanner sc = new Scanner(System.in);

    private String nickName;

    public Usuario() {
        System.out.print("Digite seu nick: ");
        setNickName(sc.nextLine());
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        Objects.requireNonNull(nickName, "Nome de Usuario não pode ser null");
        if (nickName.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio!");
        }
        this.nickName = nickName;
    }


}
