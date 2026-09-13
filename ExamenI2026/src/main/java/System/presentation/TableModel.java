package System.presentation;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public abstract class TableModel<T> extends AbstractTableModel {
    protected List<T> data;
    protected int[] columns;
    protected String[] columnNames;

    public TableModel(int[] columns, List<T> data) {
        this.columns = columns;
        this.data = data;
        inicializarColumnasNombre();
    }
    protected abstract void inicializarColumnasNombre();
    public void setData(List<T> data) {
        this.data = data;
        fireTableDataChanged();
    }
    public T getFila(int fila) {
        return data.get(fila);
    }

    @Override
    public int getRowCount() {
        return data == null ? null : data.size();
    }
    @Override
    public int getColumnCount() {
        return columns.length;
    }
    @Override
    public String getColumnName(int column) {
        return columnNames[columns[column]];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }

    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);
}
