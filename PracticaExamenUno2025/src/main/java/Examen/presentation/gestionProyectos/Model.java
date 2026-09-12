package Examen.presentation.gestionProyectos;

import Examen.logic.entities.Proyecto;
import Examen.logic.entities.Tarea;
import Examen.presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model extends AbstractModel {
    Proyecto current_proyecto;
    Tarea current_tarea;
    List<Proyecto> listaProyectos;
    List<Tarea> listaTareas;

    public final static String CURRENT_PROYECTO = "current_Proyecto";
    public final static String CURRENT_TAREA = "current_Tarea";
    public final static String PROYECTOS =  "proyectos";
    public final static String TAREAS = "tareas";

    Model() {
        current_proyecto = new Proyecto();
        current_tarea = new Tarea();
        listaProyectos = new ArrayList<>();
        listaTareas = new ArrayList<>();
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl){
        super.addPropertyChangeListener(pcl);
        firePropertyChange(CURRENT_PROYECTO);
        firePropertyChange(CURRENT_TAREA);
        firePropertyChange(PROYECTOS);
        firePropertyChange(TAREAS);
    }

    public Proyecto getCurrent_proyecto(){
        return current_proyecto;
    }
    public void setCurrent_proyecto(Proyecto current_proyecto){
        this.current_proyecto = current_proyecto;
        firePropertyChange(CURRENT_PROYECTO);
    }
    public Tarea getCurrent_tarea(){
        return current_tarea;
    }
    public void setCurrent_tarea(Tarea current_tarea){
        this.current_tarea = current_tarea;
        firePropertyChange(CURRENT_TAREA);
    }
    public List<Proyecto> getListaProyectos(){
        return listaProyectos;
    }
    public void setListaProyectos(List<Proyecto> listaProyectos){
        this.listaProyectos = listaProyectos;
        firePropertyChange(PROYECTOS);
    }
    public List<Tarea> getListaTareas(){
        return listaTareas;
    }
    public void setListaTareas(List<Tarea> listaTareas){
        this.listaTareas = listaTareas;
        firePropertyChange(TAREAS);
    }
}
