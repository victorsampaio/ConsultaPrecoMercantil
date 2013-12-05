
package clientes;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class clientesTabela extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    // linsta de pessoas obtidas através da consulta ao banco
    private List<clientes> cliente;

    // esse construtor precisa de uma lista de pessoas
    // ao invés do construtor poderia ter utilizado um setPessoas...
    public clientesTabela(final List<clientes> end) {
        this.cliente = end;
    }

    @Override
    public int getColumnCount() {
        return 9;  // a Table que utilizar este modelo só terá três colunas
    }

    @Override
    public String getColumnName(final int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "nome";   
            case 2:
                return "cpf"; 
            case 3:
                return "dt nascimento";
            case 4:
                return "renda";
            case 5:
                return "rua";
            case 6:
                return "número";
            case 7:
                return "cep";
            case 8:
                return "telefone";    
            default:
                return "?"; // nunca vai cair aqui
        }
    }

    @Override
    public int getRowCount() {
        return cliente.size();
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        clientes end = cliente.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = sdf.format(end.getDataNasc());
        switch (columnIndex) {
            case 0:
                return end.getId();
            case 1: 
                return end.getNome();  
            case 2:
                return end.getCpf(); 
            case 3:
                return strDate;
            case 4:
                return end.getRenda();
            case 5:
                return end.getRua();
            case 6:
                return end.getNum();
            case 7:
                return end.getCep();
            case 8:
                return end.getTel();    
            default:
                return null; // nunca vai cair aqui, pois só tem 11 colunas
        }
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return false;
    }

    public void setData(List<clientes> end2) {

        //Esta classe altera os dados mostrados de acordo com a consulta!
        
        this.cliente.clear();
        this.cliente.addAll(end2);
        super.fireTableDataChanged();
    }
    
    
}
