package Examen.presentation;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public abstract class AbstractModel {
    private PropertyChangeSupport propertyChangeSupport;
    public AbstractModel() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    protected void firePropertyChange(String propertyName) {
        propertyChangeSupport.firePropertyChange(propertyName, null, null);
    }
}
