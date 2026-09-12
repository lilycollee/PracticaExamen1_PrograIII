package Examen.data;

import Examen.logic.entities.Proyecto;
import Examen.logic.entities.Tarea;
import Examen.logic.entities.Usuario;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    @XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
    private List<Usuario> usuarios;

    @XmlElementWrapper(name = "proyectos")
    @XmlElement(name = "proyecto")
    private List<Proyecto> proyectos;

    @XmlElementWrapper(name = "tareas")
    @XmlElement(name = "tarea")
    private List<Tarea> tareas;

    public Data() {
        usuarios = new ArrayList<>();
        proyectos = new ArrayList<>();
        tareas = new ArrayList<>();
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public List<Proyecto> getProyectos() {
        return proyectos;
    }
    public List<Tarea> getTareas() {
        return tareas;
    }
}
