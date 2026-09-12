package Examen.presentation.gestionProyectos;

import Examen.logic.entities.Proyecto;
import Examen.logic.entities.Tarea;
import Examen.presentation.TableModel;

import java.util.ArrayList;
import java.util.List;

public class TareasTableModel extends TableModel<Tarea> {
    TareasTableModel(Proyecto proyecto) {
        List<Tarea> tareas = proyecto.getTareas();
        super(new int[] {0,1,2,3,4,5}, tareas);
    }
    @Override
    protected void inicializarColumnasNombre() {
        columnNames = new String[] {"Numero", "Descripcion", "Vence", "Prioridad", "Estado", "Asignado a"};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tarea tarea = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> tarea.getId();
            case 1 -> tarea.getDescripcion();
            case 2 -> tarea.getFecha();
            case 3 -> tarea.getPrioridad();
            case 4 -> tarea.getEstado();
            case 5 -> tarea.getResponsable().getNombre();
            default -> "";
        };
    }
}
