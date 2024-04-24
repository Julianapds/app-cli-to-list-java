import java.util.ArrayList;
import java.util.Scanner;

class Contato {
    private String nome;
    private String telefone;
    private boolean concluido;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.concluido = false; // Por padrão, a tarefa não está concluída
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}

public class Agenda {
    private static ArrayList<Contato> contatos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Listar contatos");
            System.out.println("2. Adicionar contato");
            System.out.println("3. Atualizar contato");
            System.out.println("4. Excluir contato");
            System.out.println("5. Atualizar status da tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    listarContatos();
                    break;
                case "2":
                    adicionarContato();
                    break;
                case "3":
                    atualizarContato();
                    break;
                case "4":
                    excluirContato();
                    break;
                case "5":
                    atualizarStatus();
                    break;
                case "0":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            System.out.println("\n==== Contatos ====");
            for (int i = 0; i < contatos.size(); i++) {
                Contato contato = contatos.get(i);
                String status = contato.isConcluido() ? "Concluído" : "Não concluído";
                System.out.println((i + 1) + ". Nome: " + contato.getNome() + " - Telefone: " + contato.getTelefone() + " - Status: " + status);
            }
        }
    }

    private static void adicionarContato() {
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o telefone do contato: ");
        String telefone = scanner.nextLine();
        contatos.add(new Contato(nome, telefone));
        System.out.println("Contato adicionado com sucesso.");
    }

    private static void atualizarContato() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            listarContatos();
            System.out.print("Digite o número do contato que deseja atualizar: ");
            int indice = Integer.parseInt(scanner.nextLine());
            if (indice >= 1 && indice <= contatos.size()) {
                System.out.print("Digite o novo nome do contato: ");
                String novoNome = scanner.nextLine();
                System.out.print("Digite o novo telefone do contato: ");
                String novoTelefone = scanner.nextLine();
                Contato contato = contatos.get(indice - 1);
                contato.setNome(novoNome);
                contato.setTelefone(novoTelefone);
                System.out.println("Contato atualizado com sucesso.");
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }

    private static void excluirContato() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            listarContatos();
            System.out.print("Digite o número do contato que deseja excluir: ");
            int indice = Integer.parseInt(scanner.nextLine());
            if (indice >= 1 && indice <= contatos.size()) {
                contatos.remove(indice - 1);
                System.out.println("Contato excluído com sucesso.");
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }

    private static void atualizarStatus() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            listarContatos();
            System.out.print("Digite o número do contato cujo status deseja atualizar: ");
            int indice = Integer.parseInt(scanner.nextLine());
            if (indice >= 1 && indice <= contatos.size()) {
                Contato contato = contatos.get(indice - 1);
                boolean statusAtual = contato.isConcluido();
                contato.setConcluido(!statusAtual);
                String novoStatus = contato.isConcluido() ? "Concluido" : "Não concluído";
                System.out.println("Status atualizado para: " + novoStatus);
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }
}
