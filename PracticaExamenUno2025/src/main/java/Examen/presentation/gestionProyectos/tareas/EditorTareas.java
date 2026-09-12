package Examen.presentation.gestionProyectos.tareas;

import Examen.logic.entities.enums.Estado;
import Examen.logic.entities.enums.Prioridad;
import Examen.presentation.gestionProyectos.Controller;
import Examen.presentation.gestionProyectos.Model;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditorTareas extends JDialog implements PropertyChangeListener {
    private JComboBox prioridad;
    private JComboBox estado;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel panel;

    Controller controller;
    Model model;

    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void setModel(Model model){
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public EditorTareas(){
        setContentPane(panel);
        setModal(true);
        getRootPane().setDefaultButton(okButton);
        setLocationRelativeTo(null);
        setTitle("Edicion de prioridad y estatus");
        setSize(350,200);

        prioridad.setModel(new DefaultComboBoxModel<>(Prioridad.values()));
        estado.setModel(new DefaultComboBoxModel<>(Estado.values()));

    }

    public void addOkButtonListener(ActionListener actionListener){
        okButton.addActionListener(actionListener);
    }
    public void addCancelButtonListener(ActionListener actionListener){
        cancelButton.addActionListener(actionListener);
    }

    public Prioridad getPrioridad() {
        return (Prioridad)prioridad.getSelectedItem();
    }
    public Estado getEstado() {
        return (Estado)estado.getSelectedItem();
    }

    public void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()){
            case Model.CURRENT_PROYECTO:
                prioridad.setSelectedIndex(model.getCurrent_tarea().getPrioridad().ordinal());
                estado.setSelectedIndex(model.getCurrent_tarea().getEstado().ordinal());
                prioridad.setBackground(null);
                estado.setBackground(null);
                break;
        }
        this.panel.revalidate();

    }
}
