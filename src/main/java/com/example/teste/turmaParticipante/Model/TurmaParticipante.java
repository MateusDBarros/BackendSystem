package com.example.teste.turmaParticipante.Model;

public class TurmaParticipante {
    private int codigo;
    private int turmaID; // ID da turma, referencia da tabela turma
    private int funcionarioID; // ID do funcionario, tambem fazendo referencia a sua tabela (funcionario)

    // Construtor vazio
    public TurmaParticipante() {
    }

    // Construtor completo
    public TurmaParticipante(int codigo, int turmaID, int funcionarioID) {
        this.codigo = codigo;
        this.turmaID = turmaID;
        this.funcionarioID = funcionarioID;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public int getTurmaID() {
        return turmaID;
    }

    public int getFuncionarioID() {
        return funcionarioID;
    }

    // Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTurmaID(int turmaID) {
        this.turmaID = turmaID;
    }

    public void setFuncionarioID(int funcionarioID) {
        this.funcionarioID = funcionarioID;
    }
}
