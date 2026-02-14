/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WIN10
 */
import java.util.ArrayList;

public class BaseDados {

    private static BaseDados instance;

    private ArrayList<Usuario> usuarios;
    private ArrayList<Trilha> trilhas;

    private BaseDados() {
        usuarios = ArquivoUtil.carregarUsuarios();
        trilhas = ArquivoUtil.carregarTrilhas();
    }

    public static BaseDados getInstance() {
        if (instance == null) {
            instance = new BaseDados();
        }
        return instance;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Trilha> getTrilhas() {
        return trilhas;
    }

    public void salvarTudo() {
        ArquivoUtil.salvarUsuarios(usuarios);
        ArquivoUtil.salvarTrilhas(trilhas);
    }
}