package estabelecimentos;


import java.util.List;
import javax.swing.table.AbstractTableModel;


public class estabelecimentosTabela extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    // linsta de pessoas obtidas através da consulta ao banco
    private List<estabelecimentos> estabelecimento;

    // esse construtor precisa de uma lista de pessoas
    // ao invés do construtor poderia ter utilizado um setPessoas...
    public estabelecimentosTabela(final List<estabelecimentos> end) {
        this.estabelecimento = end;
    }

    @Override
    public int getColumnCount() {
        return 8;  // a Table que utilizar este modelo só terá três colunas
    }

    @Override
    public String getColumnName(final int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "nome";   
            case 2:
                return "cnpj";             
            case 3:
                return "rua";
            case 4:
                return "número";
            case 5:
                return "cep";
            case 6:
                return "telefone";  
            case 7:
                return "obs";     
            default:
                return "?"; // nunca vai cair aqui
        }
    }

    @Override
    public int getRowCount() {
        return estabelecimento.size();
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        estabelecimentos end = estabelecimento.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return end.getId();
            case 1: 
                return end.getNome();  
            case 2:
                return end.getCnpj(); 
            case 3:
                return end.getRua();
            case 4:
                return end.getNum();
            case 5:
                return end.getCep();
            case 6:
                return end.getTelefone();   
            case 7:
                return end.getObs();    
            default:
                return null; // nunca vai cair aqui, pois só tem 11 colunas
        }
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return false;
    }

    public void setData(List<estabelecimentos> end2) {

        //Esta classe altera os dados mostrados de acordo com a consulta!
        
        this.estabelecimento.clear();
        this.estabelecimento.addAll(end2);
        super.fireTableDataChanged();
    }
    
    
}
