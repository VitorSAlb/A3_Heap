package model.infra;

import model.entity.Document;

public class No {
    private Document document;
    private No left;
    private No right;
    private No parent;

    public No() {
    }

    public No(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public No getLeft() {
        return left;
    }

    public void setLeft(No left) {
        this.left = left;
    }

    public No getRight() {
        return right;
    }

    public void setRight(No right) {
        this.right = right;
    }

    public No getParent() {
        return parent;
    }

    public void setParent(No parent) {
        this.parent = parent;
    }

    public int getPriorityOrdinal() {
        return document.getPriority().ordinal();
    }
}
