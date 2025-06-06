package model.infra;

import model.entity.Document;

public class No {
    private Document document;
    private No left;
    private No right;
    private No parent;

    private boolean printed = false;

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
        if (left != null) {
            left.setParent(this);
        }
    }

    public No getRight() {
        return right;
    }

    public void setRight(No right) {
        this.right = right;
        if (right != null) {
            right.setParent(this);
        }
    }

    public No getParent() {
        return parent;
    }

    public void setParent(No parent) {
        this.parent = parent;
    }

    public int getPriorityOrdinal() {
        return document.getPriority().getPeso();
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }
}
