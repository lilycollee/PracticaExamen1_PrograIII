package Examen.presentation.gestionProyectos;

import Examen.logic.entities.Proyecto;
import Examen.presentation.TableModel;

import java.util.List;

public class ProyectosTableModel extends TableModel<Proyecto> {
    public ProyectosTableModel(List<Proyecto> proyectos) {
        super(new int[]{0,1,2,3}, proyectos);
    }

    @Override
    protected void inicializarColumnasNombre() {
        columnNames = new String[]{"Código", "Descripción", "Encargado", "#Tareas"};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proyecto proyecto = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> proyecto.getCodigo();
            case 1 -> proyecto.getDescripcion();
            case 2 -> proyecto.getResponsable().getNombre();
            case 3 -> proyecto.getTareas();
            default -> null;
        };
    }
}
