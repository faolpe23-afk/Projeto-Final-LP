/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WIN10
 */
import java.io.*;
import java.util.ArrayList;

public class ArquivoUtil {

    private static final String ARQ_USUARIOS = "usuarios.dat";
    private static final String ARQ_TRILHAS = "trilhas.dat";

    public static void salvarUsuarios(ArrayList<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQ_USUARIOS))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarTrilhas(ArrayList<Trilha> trilhas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQ_TRILHAS))) {
            oos.writeObject(trilhas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Usuario> carregarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQ_USUARIOS))) {
            return (ArrayList<Usuario>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Trilha> carregarTrilhas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQ_TRILHAS))) {
            return (ArrayList<Trilha>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}