package model.entity;

public enum Priority {
    URGENT(1),
    MEDIUM(2),
    NORMAL(3);

    private final int peso;

    Priority(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }
}
