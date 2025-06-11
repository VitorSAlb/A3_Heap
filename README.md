# 🧮 Fila de Impressão com Prioridade (Heap)

Este projeto é uma simulação de uma **fila de impressão** que utiliza a estrutura de dados **Heap (min-heap)** para garantir que documentos com maior prioridade sejam processados primeiro.

## 🚀 Objetivo

Gerenciar uma fila de documentos com três níveis de prioridade:
- `URGENT` (mais prioritário)
- `MEDIUM`
- `NORMAL` (menos prioritário)

## ⚙️ Estrutura da Fila

A fila foi implementada com um **Min-Heap dinâmico** baseado em **árvore binária completa com nós**, sem uso de estruturas prontas como `ArrayList` ou `PriorityQueue`.

Cada documento possui:
- Um nome
- Uma prioridade (`enum Priority` com peso interno)

## 📚 Principais funções de um Heap

- **add(document)**  
  Insere um novo documento no heap, mantendo a estrutura completa da árvore e a ordenação por prioridade (heapify-up).

- **remove()**  
  Remove e retorna o documento de maior prioridade (a raiz), substituindo-o pelo último nó e reorganizando com heapify-down.

- **printHeap()**  
  Imprime o heap, garantindo a ordem correta de prioridade sem alterar o heap original.

## 📎 Organização

- `Document.java` — Define os documentos com nome e prioridade.
- `Priority.java` — Enum de prioridades com peso (urgente = 1).
- `No.java` — Nó de árvore com ponteiros e valor.
- `HeapFilaImpressao.java` — Implementa o heap com base em ponteiros.

## 🤝 Colaboradores

- **Vitor Santana e Albuquerque** — 1272215370  
- **Wadson Daniel Lima Silva** — 1272216683  
- **Lucas Lopes Pereira Pedroza** — 1272215973  
- **Henrique Moura Taruffe** — 1272227092  
- **Lucas Pires Lima** — 1272215898

---
