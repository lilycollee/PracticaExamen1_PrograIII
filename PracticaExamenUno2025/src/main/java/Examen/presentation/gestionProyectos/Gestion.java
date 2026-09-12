package Examen.presentation.gestionProyectos;

import Examen.logic.entities.Proyecto;
import Examen.logic.entities.Usuario;
import Examen.presentation.gestionProyectos.tareas.EditorTareas;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Gestion extends JPanel implements PropertyChangeListener {
    private JPanel panelPrincipal;
    private EditorTareas editorTareas;
    private Controller controller;
    private Model model;

    private JTable tablaProyectos;
    private JButton crearButton;
    private JTextField descripcionProyecto;
    private JComboBox encargados;
    private JButton cargarButton;
    private JTextField descripcionTarea;
    private DatePicker datePicker1;
    private JComboBox prioridad;
    private JComboBox estado;
    private JComboBox responsables;
    private JTable tablaTareas;

    private ProyectosTableModel proyectosTableModel;
    private TareasTableModel tareasTableModel;

    public void cargarUsuarios(List<Usuario> listaUsuarios){
        DefaultComboBoxModel encargadosModel = new DefaultComboBoxModel();
        DefaultComboBoxModel responsablesModel = new DefaultComboBoxModel();

        for(Usuario usuario : listaUsuarios){
            encargadosModel.addElement(usuario);
            responsablesModel.addElement(usuario);
        }
        encargados.setModel(encargadosModel);
        responsables.setModel(responsablesModel);
        encargadosModel.setSelectedItem(-1);
        responsablesModel.setSelectedItem(-1);
    }

    public Gestion(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;

        proyectosTableModel = new ProyectosTableModel(new ArrayList<>());
        tareasTableModel = new TareasTableModel(new Proyecto());

        tablaProyectos.setModel(proyectosTableModel);
        tablaTareas.setModel(tareasTableModel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.PROYECTOS -> proyectosTableModel.setData(model.getListaProyectos());
            case Model.TAREAS ->  tareasTableModel.setData(model.getListaTareas());
        }
    }

    public void addCrearButtonListener(ActionListener actionListener){
        crearButton.addActionListener(actionListener);
    }
    public void addCargarButtonListener(ActionListener actionListener){
        cargarButton.addActionListener(actionListener);
    }
    public void seleccionarProyecto(ListSelectionListener listSelectionListener){
        tablaProyectos.getSelectionModel().addListSelectionListener(listSelectionListener);
    }
    public void seleccionarTarea(ListSelectionListener listSelectionListener){
        tablaTareas.getSelectionModel().addListSelectionListener(listSelectionListener);
    }

    public void setModel(Model model) {
        this.model = model;
        editorTareas.setModel(model);
        model.addPropertyChangeListener(this);
    }
    public void setController(Controller controller) {
        this.controller = controller;
        editorTareas.setController(controller);
    }

}
