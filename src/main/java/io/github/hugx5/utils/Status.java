package io.github.hugx5.utils;

public enum Status {
    APROVADO("Aprovado"),
    REPROVADO("Reprovado"),
    PENDENTE("Pendente"),
    SELECIONADO("Selecionado");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
