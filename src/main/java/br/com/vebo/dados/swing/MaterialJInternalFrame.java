/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Material.java
 *
 * Created on 16/05/2009, 01:41:32
 */

package br.com.vebo.dados.swing;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.bo.MaterialBO;
import br.com.vebo.dados.mapeamento.Material;
import br.com.vebo.dados.swing.table.MaterialTableModel;
import br.com.vebo.util.DoubleUtil;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mohfus
 */
public class MaterialJInternalFrame extends javax.swing.JInternalFrame {

    /** Creates new form Material */
    public MaterialJInternalFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalJPanel = new javax.swing.JPanel();
        tabelaJScrolPane = new javax.swing.JScrollPane();
        materiaisJTable = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtValor = new javax.swing.JFormattedTextField();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaReferencia = new javax.swing.JTextArea();
        lblReferencia = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setTitle("Materiais");
        setName("materialJInternalFrame"); // NOI18N

        materiaisJTable.setModel(new br.com.vebo.dados.swing.table.MaterialTableModel());
        materiaisJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materiaisJTableMouseClicked(evt);
            }
        });
        tabelaJScrolPane.setViewportView(materiaisJTable);
        atualizaTabela();

        lblNome.setText("Nome");

        lblValor.setText("Valor");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValor.setVerifyInputWhenFocusTarget(false);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txaReferencia.setColumns(20);
        txaReferencia.setLineWrap(true);
        txaReferencia.setRows(5);
        jScrollPane1.setViewportView(txaReferencia);

        lblReferencia.setText("Refer�ncia");

        javax.swing.GroupLayout principalJPanelLayout = new javax.swing.GroupLayout(principalJPanel);
        principalJPanel.setLayout(principalJPanelLayout);
        principalJPanelLayout.setHorizontalGroup(
            principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(tabelaJScrolPane, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addGroup(principalJPanelLayout.createSequentialGroup()
                        .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalJPanelLayout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir))
                    .addComponent(lblReferencia))
                .addContainerGap())
        );
        principalJPanelLayout.setVerticalGroup(
            principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelaJScrolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblReferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo)
                    .addComponent(btnLimpar))
                .addContainerGap())
        );

        getContentPane().add(principalJPanel, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-467)/2, (screenSize.height-504)/2, 467, 504);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (validaForm()) {

            try {
                Material material = new MaterialBO().retrieve(idMaterial);
                material.setNome(txtNome.getText());
                material.setValor(new DoubleUtil().stringParaDouble(txtValor.getText()));
                material.setReferencia(txaReferencia.getText());
                HibernateUtil.beginTransaction();
                new MaterialBO().save(material);
                HibernateUtil.commitTransaction();
                JOptionPane.showMessageDialog(this, "Material alterado com sucesso", "Mensagem",  JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
            }

            limpaForm();
            atualizaTabela();
            
        }
}//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (validaForm()) {
            Material novoMaterial = new Material();
            novoMaterial.setNome(txtNome.getText());
            novoMaterial.setValor(new DoubleUtil().stringParaDouble(txtValor.getText()));
            novoMaterial.setReferencia(txaReferencia.getText());
            try {
                HibernateUtil.beginTransaction();
                new MaterialBO().save(novoMaterial);
                HibernateUtil.commitTransaction();
                JOptionPane.showMessageDialog(this, "Material inserido com sucesso", "Mensagem",  JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
            }

            limpaForm();
            atualizaTabela();
            
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o material selecionado?","Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int linhaSelecionada = materiaisJTable.getSelectedRow();
            try {
                Material material = new MaterialBO().retrieve((Long) materiaisJTable.getValueAt(linhaSelecionada, 0));
                HibernateUtil.beginTransaction();
                new MaterialBO().delete(material);
                HibernateUtil.commitTransaction();
                JOptionPane.showMessageDialog(this, "Material excluído com sucesso", "Mensagem",  JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
            }
            atualizaTabela();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void materiaisJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materiaisJTableMouseClicked
        if (evt.getClickCount() > 1) {
            try {
                Material material = new MaterialBO().retrieve((Long) materiaisJTable.getValueAt(materiaisJTable.getSelectedRow(), 0));
                idMaterial = material.getId();
                txtNome.setText(material.getNome());
                txtValor.setText(new DoubleUtil().doubleParaString(material.getValor()));
                txaReferencia.setText(material.getReferencia());
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_materiaisJTableMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaForm();
    }//GEN-LAST:event_btnLimparActionPerformed


    private boolean validaForm() {
        boolean retorno = true;
        StringBuffer mensagensErro = new StringBuffer();
        if (txtNome.getText().isEmpty()) {
            mensagensErro.append("O campo Nome é requerido.\n");
            retorno = false;
        }
        if (txtValor.getText().isEmpty()) {
            mensagensErro.append("O campo Valor é requerido.\n");
            retorno = false;
        }
        else if (new DoubleUtil().stringParaDouble(txtValor.getText()) == null){
            mensagensErro.append("O campo Valor é inválido. Exemplo: 35,50\n");
            retorno = false;
        }
        if (!retorno) {
            JOptionPane.showMessageDialog(this, mensagensErro.toString(), "Validação",  JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }

    private void limpaForm() {
        idMaterial = 0l;
        txtNome.setText("");
        txtValor.setText("");
        txaReferencia.setText("");
    }

    private void atualizaTabela() {

        MaterialTableModel tableModel = (MaterialTableModel) materiaisJTable.getModel();
        try {
            tableModel.setMateriais((List) new MaterialBO().findAll());
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
        }
        materiaisJTable.updateUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable materiaisJTable;
    private javax.swing.JPanel principalJPanel;
    private javax.swing.JScrollPane tabelaJScrolPane;
    private javax.swing.JTextArea txaReferencia;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
    private Long idMaterial = 0l;
}
