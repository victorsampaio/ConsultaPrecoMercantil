
package movimentos;


import java.util.List;
import javax.swing.table.AbstractTableModel;

public class movimentosTabela extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    // lista de pessoas obtidas através da consulta ao banco
    private List<movimentos> movimento;

    // esse construtor precisa de uma lista de pessoas
    // ao invés do construtor poderia ter utilizado um setPessoas...
    public movimentosTabela(final List<movimentos> end) {
        this.movimento = end;
    }

    @Override
    public int getColumnCount() {
        return 5;  // a Table que utilizar este modelo só terá seis colunas
    }

    @Override
    public String getColumnName(final int column) {
        switch (column) {
            case 0:
                return "id_produto";
            case 1:
                return "nm_produto";
            case 2:
                return "preco";            
            case 3:
                return "nm_mercantil";
            case 4:
                return "obs";                   
            default:
                return "?"; // nunca vai cair aqui
        }
    }

    @Override
    public int getRowCount() {
        return movimento.size();
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        movimentos end = movimento.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return end.getId_prod();
            case 1:
                return end.getNm_prod();    
            case 2:
                return end.getPreco();            
            case 3:
                return end.getNm_merc();
            case 4:
                return end.getObs();     
            default:
                return null; // nunca vai cair aqui, pois só tem 11 colunas
        }
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return false;
    }

    public void setData(List<movimentos> end2) {

        //Esta classe altera os dados mostrados de acordo com a consulta!
        
        this.movimento.clear();
        this.movimento.addAll(end2);
        super.fireTableDataChanged();
    }
    
    
}
