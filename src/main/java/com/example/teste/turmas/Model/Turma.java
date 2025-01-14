package com.example.teste.turmas.Model;

import java.time.LocalDate;

public class Turma {
    private int codigo;
    private LocalDate inicio; // Inicio do curso
    private LocalDate fim; // Fim do curso
    private String local; // Local do curso
    private int cursoID; // ID do curso, que sera a referencia da tablea curso

    // Construtor vazio
    public Turma() {
    }

    // Construtor completo
    public Turma(int codigo, LocalDate inicio, LocalDate fim, String local, int cursoId) {
        this.codigo = codigo;
        this.cursoID = cursoId;
        this.local = local;
        this.fim = fim;
        this.inicio = inicio;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public String getLocal() {
        return local;
    }

    public int getCursoID() {
        return cursoID;
    }

    // Setters


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }
}
