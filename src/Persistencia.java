/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author WIN10
 */
import java.util.ArrayList;

public interface Persistencia {

    void salvarUsuarios(ArrayList<Usuario> usuarios);

    void salvarTrilhas(ArrayList<Trilha> trilhas);
}