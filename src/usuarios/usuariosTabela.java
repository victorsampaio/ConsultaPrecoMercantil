
package usuarios;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class usuariosTabela extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    // lista de pessoas obtidas através da consulta ao banco
    private List<usuarios> usuario;

    // esse construtor precisa de uma lista de pessoas
    // ao invés do construtor poderia ter utilizado um setPessoas...
    public usuariosTabela(final List<usuarios> end) {
        this.usuario = end;
    }

    @Override
    public int getColumnCount() {
        return 3;  // a Table que utilizar este modelo só terá três colunas
    }

    @Override
    public String getColumnName(final int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "nome";   
            case 2:
                return "login"; 
            default:
                return "?"; // nunca vai cair aqui
        }
    }

    @Override
    public int getRowCount() {
        return usuario.size();
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        usuarios end = usuario.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return end.getId();
            case 1: 
                return end.getNome();  
            case 2: 
                return end.getLogin();    
            default:
                return null; // nunca vai cair aqui, pois só tem 11 colunas
        }
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return false;
    }

    public void setData(List<usuarios> end2) {

        //Esta classe altera os dados mostrados de acordo com a consulta!
        
        this.usuario.clear();
        this.usuario.addAll(end2);
        super.fireTableDataChanged();
    }
    
    
}
