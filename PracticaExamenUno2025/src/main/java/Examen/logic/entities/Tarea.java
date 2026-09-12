package Examen.logic.entities;

import Examen.data.adapters.LocalDateAdapter;
import Examen.logic.entities.enums.Estado;
import Examen.logic.entities.enums.Prioridad;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Tarea {
    @XmlID
    private String id;
    private String descripcion;
    private Estado estado;
    private Prioridad prioridad;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate fecha;
    @XmlIDREF
    private Usuario responsable;

    public Tarea() {}
    public Tarea(String id, String descripcion, Estado estado, Prioridad prioridad, LocalDate fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fecha = fecha;
    }
    public String getId() {
        return id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Estado getEstado() {
        return estado;
    }
    public Prioridad getPrioridad() {
        return prioridad;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public Usuario getResponsable() {
        return responsable;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
}
