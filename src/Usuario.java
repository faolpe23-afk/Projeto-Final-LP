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

public class Usuario implements Serializable, Observer {
    private static final long serialVersionUID = 1L;

    String nome;
    String senha;
    String endereco;
    LocalDate dataNascimento;
    ArrayList<Trilha> trilhasFavoritas;

    public Usuario(String nome, String senha, String endereco, LocalDate dataNascimento) {
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.trilhasFavoritas = new ArrayList<>();
    }

    public void adicionarFavorita(Trilha trilha) {
        if (!trilhasFavoritas.contains(trilha)) {
            trilhasFavoritas.add(trilha);
            trilha.adicionarObserver(this);
            System.out.println("Trilha adicionada aos favoritos!");
        }
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Notificação para " + nome + ": " + mensagem);
    }
}
