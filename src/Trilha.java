/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WIN10
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Trilha implements Serializable {
    private static final long serialVersionUID = 1L;

    String nome;
    ArrayList<Ponto> pontos;
    LocalDate dataCadastro;
    LocalDate ultimaAtualizacao;

    transient ArrayList<Observer> observers = new ArrayList<>();

    public Trilha(String nome) {
        this.nome = nome;
        this.pontos = new ArrayList<>();
        this.dataCadastro = LocalDate.now();
        this.ultimaAtualizacao = LocalDate.now();
    }

    public void adicionarObserver(Observer o) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(o);
    }

    public void notificar() {
        if (observers != null) {
            for (Observer o : observers) {
                o.atualizar("A trilha '" + nome + "' foi atualizada!");
            }
        }
    }

    public void adicionarPonto(Ponto ponto) {
        pontos.add(ponto);
        ultimaAtualizacao = LocalDate.now();
        notificar();
    }

    @Override
    public String toString() {
        return "Trilha: " + nome + " | Pontos: " + pontos.size();
    }
}
