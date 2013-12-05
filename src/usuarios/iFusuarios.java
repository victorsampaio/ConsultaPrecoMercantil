
package usuarios;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


public class iFusuarios extends javax.swing.JInternalFrame {

    /** Creates new form iFusuarios */
    public iFusuarios() {
        initComponents();
        telaInicial();        
    }
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTnome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTsenha = new javax.swing.JTextField();
        jTpesquisa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTlogin = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        jBnovo = new javax.swing.JButton();
        jBsalvar = new javax.swing.JButton();
        jBalterar = new javax.swing.JButton();
        jBremover = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Usuários");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID");

        jLabel2.setText("Nome:");

        jLabel4.setText("Senha (Máximo 8 caracteres):");

        jTpesquisa.setFont(new java.awt.Font("Tahoma", 2, 11));
        jTpesquisa.setForeground(new java.awt.Color(153, 153, 153));
        jTpesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTpesquisaMouseClicked(evt);
            }
        });
        jTpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTpesquisaKeyReleased(evt);
            }
        });

        jLabel5.setText("Pesquisa");

        jLabel3.setText("Login:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTnome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jTpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addComponent(jTsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(551, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTlogin, jTpesquisa, jTsenha});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTabela);

        jBnovo.setText("Novo");
        jBnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnovoActionPerformed(evt);
            }
        });

        jBsalvar.setText("Salvar");
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
            }
        });

        jBalterar.setText("Alterar");
        jBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBalterarActionPerformed(evt);
            }
        });

        jBremover.setText("Remover");
        jBremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBremoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jBnovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBsalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBalterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBremover)
                        .addGap(139, 139, 139)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBalterar, jBnovo, jBremover, jBsalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBnovo)
                    .addComponent(jBsalvar)
                    .addComponent(jBalterar)
                    .addComponent(jBremover))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTpesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTpesquisaKeyReleased
        // TODO add your handling code here:
        String ler = jTpesquisa.getText();
        String sql = "select * from tbusuarios where nome like '"+ler+"%'";
        buscaDados(sql);
    }//GEN-LAST:event_jTpesquisaKeyReleased

    private void jTpesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTpesquisaMouseClicked
        // TODO add your handling code here:
        telaInicial();
        jTpesquisa.setText("");
        jTpesquisa.requestFocus();
        jTpesquisa.setForeground(Color.black);        
        String sql = "select * from tbusuarios";
        buscaDados(sql);
    }//GEN-LAST:event_jTpesquisaMouseClicked

    private void jBnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnovoActionPerformed
        // TODO add your handling code here:
        novo();
    }//GEN-LAST:event_jBnovoActionPerformed

    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed
        // TODO add your handling code here:
        if (jTnome.getText().equals("") || jTlogin.getText().equals("") 
                || jTsenha.getText().equals("")){           
           JOptionPane.showMessageDialog(null, "Campo obrigatório vazio!");
        } else if (!"".equals(jTlogin.getText())){
            usuarios usu = new usuarios();
            usu.setLogin(jTlogin.getText());
            usuariosDAO dao = new usuariosDAO();
            try {
                dao.verificar(usu);
                if (!"".equals(usu.getNome())){
                  JOptionPane.showMessageDialog(null,"Login já pertence a outro usuário!");
                  jTnome.setText("");
                  jTnome.requestFocus();
                }else{                   
                    usu.setNome(jTnome.getText());
                    usu.setLogin(jTlogin.getText());
                    usu.setSenha(jTsenha.getText());  
                try {
                    dao.adicionar(usu);
                }catch (SQLException ex) {
                    Logger.getLogger(iFusuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
                    telaInicial();
                }
            } catch (SQLException ex) {
                Logger.getLogger(iFusuarios.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBalterarActionPerformed
        // TODO add your handling code here:
        if (jTid.getText().equals("")|| jTnome.getText().equals("")||
           jTlogin.getText().equals("")|| jTsenha.getText().equals("")){           
           JOptionPane.showMessageDialog(null, "Campo Obrigatório Vazio");
        } else {
            usuarios usu = new usuarios();
            usu.setId(Integer.parseInt(jTid.getText())); 
            usu.setNome(jTnome.getText());
            usu.setLogin(jTlogin.getText());
            usu.setSenha(jTsenha.getText());
            usuariosDAO dao = new usuariosDAO();
          try {
                dao.alterar(usu);                
          } catch (SQLException ex) {
                Logger.getLogger(iFusuarios.class.getName()).log(Level.SEVERE, null, ex);
          }            
            telaInicial();
          }
    }//GEN-LAST:event_jBalterarActionPerformed

    private void jBremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBremoverActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this,"Deseja realmente excluir esse Usuário?",
                "Confirmação",JOptionPane.YES_NO_OPTION);
        if(resp==JOptionPane.YES_NO_OPTION){
                 
           usuarios usu = new usuarios();
            
           usu.setId(Integer.parseInt(jTid.getText()));                

           usuariosDAO dao = new usuariosDAO();
         
        try {
            dao.remover(usu);            
        } catch (SQLException ex) {
            Logger.getLogger(iFusuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaInicial();
        }
    }//GEN-LAST:event_jBremoverActionPerformed

    private void telaInicial(){
        jTid.setEnabled(false);
        jTid.setEditable(false);
        jTnome.setEnabled(false);
        jTlogin.setEnabled(false);
        jTsenha.setEnabled(false);
        jBnovo.setEnabled(true);
        jBsalvar.setEnabled(false);
        jBalterar.setEnabled(false);
        jBremover.setEnabled(false);
        jTid.setText("");
        jTnome.setText("");
        jTlogin.setText("");
        jTsenha.setText("");
        jTpesquisa.setText("Digite o nome");
        jTpesquisa.setForeground(Color.DARK_GRAY);
        String sql = "select * from tbusuarios";
        buscaDados(sql);
}
    
    private void novo(){
        jTnome.setEnabled(true);
        jTlogin.setEnabled(true);
        jTsenha.setEnabled(true);
        jBnovo.setEnabled(false);
        jBsalvar.setEnabled(true);
        jBalterar.setEnabled(false);
        jBremover.setEnabled(false);
        jTid.setText("");
        jTnome.setText("");
        jTlogin.setText("");
        jTsenha.setText("");
        jTpesquisa.setText("Digite o nome");
        jTpesquisa.setForeground(Color.DARK_GRAY);
        jTnome.requestFocus();
}
    
    private void selecao(){
        jTnome.setEnabled(true);
        jTlogin.setEnabled(true);
        jTsenha.setEnabled(true);
        jBnovo.setEnabled(true);
        jBsalvar.setEnabled(false);
        jBalterar.setEnabled(true);
        jBremover.setEnabled(true);
        jTpesquisa.setText("Digite o nome");
        jTpesquisa.setForeground(Color.DARK_GRAY);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBalterar;
    private javax.swing.JButton jBnovo;
    private javax.swing.JButton jBremover;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    private javax.swing.JTextField jTid;
    private javax.swing.JTextField jTlogin;
    private javax.swing.JTextField jTnome;
    private javax.swing.JTextField jTpesquisa;
    private javax.swing.JTextField jTsenha;
    // End of variables declaration//GEN-END:variables

    private usuariosTabela cmt;
    
    public TableModel modeloTabela(String sql){
        usuariosDAO c = new usuariosDAO();
        cmt = new usuariosTabela(c.getLista(sql));
        
        return cmt;
    }
    private void buscaDados(String sql) {
        jTabela.setModel(modeloTabela(sql));
        jTabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // evento de clik na tabela
            if (e.getClickCount() > 0) {
                    
                    
                    //carrega dentro da veriavel linha o numero da lina que foi selecionado
                    int linha = jTabela.getSelectedRow();//linha que foi selecionada
                    
                    
                    //pega coluna selecionada e mostra no campo operação
                  jTid.setText(jTabela.getValueAt(linha, 0).toString());
                  jTnome.setText(jTabela.getValueAt(linha, 1).toString());
                  jTlogin.setText(jTabela.getValueAt(linha, 2).toString());
                  jTsenha.setText("");
                  selecao();
                  
                   //para alterações não permitir modificar chave primaria
                    
                 } 
            }
        });
    }
}