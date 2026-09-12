package Examen.logic.entities;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Proyecto {
    @XmlID
    private String codigo;
    private String descripcion;
    @XmlIDREF
    private Usuario responsable;

    @XmlElementWrapper(name = "tareas")
    @XmlElement(name = "tarea")
    private List<Tarea> tareas;

    public Proyecto(){}
    public Proyecto(String descripcion, Usuario responsable){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.tareas = new ArrayList<Tarea>();
    }

    public String getCodigo() {
        return codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Usuario getResponsable() {
        return responsable;
    }
    public List<Tarea> getTareas() {
        return tareas;
    }

    public void agregarTarea(Tarea tarea){
        this.tareas.add(tarea);
    }
}
