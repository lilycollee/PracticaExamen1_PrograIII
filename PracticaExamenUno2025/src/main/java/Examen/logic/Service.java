package Examen.logic;

import Examen.data.Data;
import Examen.data.XmlPersister;
import Examen.logic.entities.Proyecto;
import Examen.logic.entities.Tarea;
import Examen.logic.entities.Usuario;

import java.util.List;

public class Service {
    private Data data;

    public Service() {
        data = XmlPersister.instance().load();
    }

    private void guardarCambios() {
        XmlPersister.instance().store(data);
    }

    //-Proyectos
    public void crearProyecto(Proyecto proyecto) {
        data.getProyectos().add(proyecto);
        XmlPersister.instance().store(data);
    }
    public List<Proyecto> getProyectos() {
        return data.getProyectos();
    }
    public List<Usuario> getUsuarios() {
        return data.getUsuarios();
    }

    //-Tareas
    public void crearTarea(Proyecto proyecto, Tarea tarea) throws Exception {
        Proyecto proyectoActual = data.getProyectos().stream().
                filter(p-> p.getCodigo().equals(proyecto.getCodigo())).
                findFirst().orElseThrow(()->new Exception("Proyecto no encontrado"));
        boolean existe = proyecto.getTareas().stream().anyMatch(t->t.getDescripcion().equals(tarea.getDescripcion()));
        if (existe) {
            throw new Exception("Proyecto ya existe");
        }
        proyectoActual.getTareas().add(tarea);
        XmlPersister.instance().store(data);
    }
}
