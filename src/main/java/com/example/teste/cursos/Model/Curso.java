package com.example.teste.cursos.Model;

import org.springframework.stereotype.Component;

@Component
public class Curso {

    private int codigo;
    private String nome;
    private String descricao;
    private int duracao;


    // Construtor

    // Esse serve pra criar um novo curso
    public Curso(int codigo,String nome, String descricao, int duracao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    // Construtor vazio para o json preencher
    public Curso() {
    }


    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    // Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
