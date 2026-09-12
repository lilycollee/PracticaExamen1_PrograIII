package Examen.presentation.gestionProyectos;

import Examen.logic.Service;
import Examen.presentation.gestionProyectos.tareas.EditorTareas;

public class Controller {
    Gestion gestionView;
    Model model;
    EditorTareas editorTareasView;
    Service service;

    public Controller(Gestion gestionView,  Model model, Service service) {
        this.gestionView = gestionView;
        this.model = model;
        this.service = service;

        gestionView.setController(this);
        gestionView.setModel(this.model);

        gestionView.addCargarButtonListener(e -> cargar());
        gestionView.addCrearButtonListener(e-> crear());

        editorTareasView.addOkButtonListener(e -> cambiarEyP());
        editorTareasView.addCancelButtonListener(e -> cancelar());
    }

    public void cargar(){

    }
    public void crear(){}
    public void cambiarEyP(){}
    public void cancelar(){}
}
