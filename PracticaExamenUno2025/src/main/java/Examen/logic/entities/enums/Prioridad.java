package Examen.logic.entities.enums;

public enum Prioridad {
    ALTA ("Alta"), MEDIA ("Media"), BAJA ("Baja");
    private String prioridad;
    private Prioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    @Override
    public String toString() {
        return prioridad;
    }
}
