/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WIN10
 */
import java.util.ArrayList;

public class PersistenciaAdapter implements Persistencia {

    private PersistenciaJson json;

    public PersistenciaAdapter(PersistenciaJson json) {
        this.json = json;
    }

    @Override
    public void salvarUsuarios(ArrayList<Usuario> usuarios) {
        json.salvarUsuariosJson(usuarios);
    }

    @Override
    public void salvarTrilhas(ArrayList<Trilha> trilhas) {
        json.salvarTrilhasJson(trilhas);
    }
}
