package Examen.logic.entities.enums;

public enum Estado {
    ABIERTA("Abierta"),
    EN_PROGRESO ("En-progreso"),
    EN_REVISION ("En-revision"),
    RESUELTA ("Resuelta");

    private String estado;
    private Estado(String estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return estado;
    }
}
