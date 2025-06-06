package model.infra;

import model.entity.Document;

public class HeapFilaImpressao {
    private No root;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(Document doc) {
        No node = new No(doc);
        size++;

        if (root == null) {
            root = node;
        } else {
            No pai = findPai(size);
            if (size % 2 == 0) {
                pai.setLeft(node);
            } else {
                pai.setRight(node);
            }
            correctUp(node);
        }
    }

    public Document remove() {
        if (root == null) return null;

        Document removed = root.getDocument();

        if (size == 1) {
            root = null;
            size--;
            return removed;
        }

        No last = findNode(size);

        root.setDocument(last.getDocument());

        No paiDoLast = last.getParent();
        if (paiDoLast.getLeft() == last) {
            paiDoLast.setLeft(null);
        } else {
            paiDoLast.setRight(null);
        }

        size--;
        correctDown(root);
        return removed;
    }

    private No findPai(int position) {
        String bin = Integer.toBinaryString(position);
        No atual = root;
        for (int i = 1; i < bin.length() - 1; i++) {
            if (atual == null) return null;
            if (bin.charAt(i) == '0') {
                atual = atual.getLeft();
            } else {
                atual = atual.getRight();
            }
        }
        return atual;
    }

    private No findNode(int position) {
        String bin = Integer.toBinaryString(position);
        No atual = root;
        for (int i = 1; i < bin.length(); i++) {
            if (atual == null) return null;
            if (bin.charAt(i) == '0') {
                atual = atual.getLeft();
            } else {
                atual = atual.getRight();
            }
        }
        return atual;
    }

    /**
     *  Compara com o pai se for menor ele troca de lugar
     */
    private void correctUp(No node) {
        while (node.getParent() != null &&
                node.getPriorityOrdinal() < node.getParent().getPriorityOrdinal()) {
            change(node, node.getParent());
            node = node.getParent();
        }
    }

    /**
     *  Compara com os nodes de baixo e se o tamanho for menor ele puxa pra cima, faz a troca
     */
    private void correctDown(No node) {
        while (node != null) {
            No menor = node;

            if (node.getLeft() != null &&
                    node.getLeft().getPriorityOrdinal() < menor.getPriorityOrdinal()) {
                menor = node.getLeft();
            }
            if (node.getRight() != null &&
                    node.getRight().getPriorityOrdinal() < menor.getPriorityOrdinal()) {
                menor = node.getRight();
            }

            if (menor != node) {
                change(node, menor);
                node = menor;
            } else {
                break;
            }
        }
    }

    private void change(No a, No b) {
        Document temp = a.getDocument();
        a.setDocument(b.getDocument());
        b.setDocument(temp);
    }


    /**
     *  checa se teve algum no que nn foi printado se teve algum no que nn foi printado ele retorna null
     */
    private No findMinNaoImprimido(No node) {
        if (node == null) return null;

        No melhorEsq = findMinNaoImprimido(node.getLeft());
        No melhorDir = findMinNaoImprimido(node.getRight());

        No candidato = node.isPrinted() ? null : node;

        return menorPeso(menorPeso(candidato, melhorEsq), melhorDir);
    }

    private No menorPeso(No a, No b) {
        if (a == null) return b;
        if (b == null) return a;
        return (a.getPriorityOrdinal() <= b.getPriorityOrdinal()) ? a : b;
    }

    private void resetPrintedFlags(No node) {
        if (node == null) return;
        node.setPrinted(false);
        resetPrintedFlags(node.getLeft());
        resetPrintedFlags(node.getRight());
    }

    /**
     *    Botei pra imprimir todos os elementos, para nn poder ter a verificação se o elemento ja foi printado ele marca o node,
     *    basicamente to fazendo o metodo de remoção mas ao inves de remover eu marco ele
     */
    public void printHeap() {
        if (root == null) {
            System.out.println("Fila vazia.");
            return;
        }

        int n = size;

        System.out.println("---- Documentos na ordem de remoção:");
        for (int i = 1; i <= n; i++) {
            No prox = findMinNaoImprimido(root);
            if (prox == null) break;

            Document d = prox.getDocument();
            System.out.printf(
                    "%dº - [ Documento = \"%s\" - Prioridade = \"%s\" ]%n",
                    i, d.getName(), d.getPriority()
            );
            prox.setPrinted(true);
        }
        resetPrintedFlags(root);
    }
}
