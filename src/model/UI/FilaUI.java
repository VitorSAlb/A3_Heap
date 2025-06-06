package model.UI;

import model.entity.Document;
import model.entity.Priority;
import model.infra.HeapFilaImpressao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FilaUI {
    private final HeapFilaImpressao fila;
    private final Scanner sc;

    public FilaUI() {
        this.fila = new HeapFilaImpressao();
        this.sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Menu da Fila de Impressão ===");
            System.out.println("[1] - Inserir nova impressão");
            System.out.println("[2] - Visualizar fila em ordem de prioridade");
            System.out.println("[3] - Mandar imprimir (remover da fila)");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("→ Entrada inválida. Digite um número de 1 a 4.");
                continue;
            }

            switch (opcao) {
                case 1:
                    inserirImpressao();
                    break;
                case 2:
                    visualizarFila();
                    break;
                case 3:
                    mandarImprimir();
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    sc.close();
                    return;
                default:
                    System.out.println("→ Opção inválida. Digite um número de 1 a 4.");
            }
        }
    }

    private void inserirImpressao() {
        System.out.print("Digite o nome do documento: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("→ Nome inválido. Tente novamente.");
            return;
        }

        System.out.println("Escolha a prioridade:");
        System.out.println("  [1] - URGENT");
        System.out.println("  [2] - MEDIUM");
        System.out.println("  [3] - NORMAL");
        System.out.print("Digite: ");

        int p;
        try {
            p = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("→ Entrada inválida. Volte ao menu e tente novamente.");
            return;
        }

        Priority prioridade;
        switch (p) {
            case 1:
                prioridade = Priority.URGENT;
                break;
            case 2:
                prioridade = Priority.MEDIUM;
                break;
            case 3:
                prioridade = Priority.NORMAL;
                break;
            default:
                System.out.println("→ Prioridade inválida. Retornando ao menu.");
                return;
        }

        Document doc = new Document(nome, prioridade);
        fila.add(doc);
        System.out.printf("→ Documento \"%s\" (prioridade = %s) inserido na fila.%n", nome, prioridade);
    }

    private void visualizarFila() {
        if (fila.isEmpty()) {
            System.out.println("→ A fila está vazia.");
        } else {
            System.out.println("\n---- Fila em ordem de prioridade ----");
            fila.printHeap();
        }
    }

    private void mandarImprimir() {
        if (fila.isEmpty()) {
            System.out.println("→ Não há documentos na fila para imprimir.");
        } else {
            Document impresso = fila.remove();
            System.out.printf("→ Documento \"%s\" [prioridade = %s] foi IMPRESSO!%n",
                    impresso.getName(), impresso.getPriority());
        }
    }
}
