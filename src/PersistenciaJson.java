/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WIN10
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaJson {

    public void salvarUsuariosJson(ArrayList<Usuario> usuarios) {
        try (FileWriter writer = new FileWriter("usuarios.json")) {
            writer.write("Usuarios salvos em JSON (simulado)");
            System.out.println("Usuarios salvos em JSON.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar JSON.");
        }
    }

    public void salvarTrilhasJson(ArrayList<Trilha> trilhas) {
        try (FileWriter writer = new FileWriter("trilhas.json")) {
            writer.write("Trilhas salvas em JSON (simulado)");
            System.out.println("Trilhas salvas em JSON.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar JSON.");
        }
    }
}
