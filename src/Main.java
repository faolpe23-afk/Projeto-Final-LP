
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WIN10
 */

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static BaseDados bd = BaseDados.getInstance();
    static Usuario usuarioLogado = null;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if (bd.getUsuarios().isEmpty()) {
            bd.getUsuarios().add(new Usuario(
                    "admin", "123", "Rua A",
                    LocalDate.of(1990, 1, 1)
            ));
            bd.salvarTudo();
        }

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Login");
            System.out.println("2 - Criar trilha");
            System.out.println("3 - Listar trilhas");
            System.out.println("4 - Adicionar trilha aos favoritos");
            System.out.println("5 - Salvar em JSON (Adapter)");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    login(sc);
                    break;
                case 2:
                    criarTrilha(sc);
                    break;
                case 3:
                    listarTrilhas();
                    break;
                case 4:
                    adicionarFavorito(sc);
                    break;
                case 5:
                    salvarJson();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        bd.salvarTudo();
        sc.close();
    }

    static void login(Scanner sc) {
        System.out.print("Seu Nome: ");
        String nome = sc.nextLine();
        System.out.print("Sua 1"
                + "Senha: ");
        String senha = sc.nextLine();

        for (Usuario u : bd.getUsuarios()) {
            if (u.nome.equals(nome) && u.senha.equals(senha)) {
                usuarioLogado = u;
                System.out.println("Login realizado!");
                return;
            }
        }

        System.out.println("Usuario ou senha invalidos.");
    }

    static void criarTrilha(Scanner sc) {

        if (usuarioLogado == null) {
            System.out.println("Faca login primeiro.");
            return;
        }

        System.out.print("Nome da trilha: ");
        Trilha trilha = new Trilha(sc.nextLine());

        System.out.print("Quantidade de pontos: ");
        int qtd = sc.nextInt();

        for (int i = 0; i < qtd; i++) {
            System.out.print("Log: ");
            int log = sc.nextInt();
            System.out.print("Lat: ");
            int lat = sc.nextInt();

            trilha.adicionarPonto(new Ponto(log, lat));
        }

        bd.getTrilhas().add(trilha);
        bd.salvarTudo();

        System.out.println("Trilha salva com sucesso!");
    }

    static void listarTrilhas() {
        for (int i = 0; i < bd.getTrilhas().size(); i++) {
            System.out.println(i + " - " + bd.getTrilhas().get(i));
        }
    }

    static void adicionarFavorito(Scanner sc) {

        if (usuarioLogado == null) {
            System.out.println("Faca login primeiro.");
            return;
        }

        listarTrilhas();

        System.out.print("Escolha a trilha: ");
        int idx = sc.nextInt();

        if (idx >= 0 && idx < bd.getTrilhas().size()) {
            usuarioLogado.adicionarFavorita(bd.getTrilhas().get(idx));
            bd.salvarTudo();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    static void salvarJson() {
        PersistenciaJson json = new PersistenciaJson();
        Persistencia adapter = new PersistenciaAdapter(json);

        adapter.salvarUsuarios(bd.getUsuarios());
        adapter.salvarTrilhas(bd.getTrilhas());
    }
}
