/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

/**
 *
 * @author mardio
 */
public class TelaPrincipalVIEW extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalVIEW
     */
    public TelaPrincipalVIEW() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBackgroud = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmProduto = new javax.swing.JMenuItem();
        jmEntradaProduto = new javax.swing.JMenuItem();
        jmSaidaProduto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpBackgroud.setBackground(new java.awt.Color(255, 255, 255));
        jpBackgroud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logo.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jpBackgroud.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 7, 548, 330));

        jMenu1.setText("Cadastro");

        jmProduto.setText("Produto");
        jmProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jmProduto);

        jmEntradaProduto.setText("Entrada de Produto");
        jmEntradaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEntradaProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jmEntradaProduto);

        jmSaidaProduto.setText("Saída de Produto");
        jmSaidaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSaidaProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jmSaidaProduto);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpBackgroud, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackgroud, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProdutoActionPerformed
FrmProdutoVIEW objFrmProdutoVIEW = new FrmProdutoVIEW();
objFrmProdutoVIEW.setVisible(true);
    }//GEN-LAST:event_jmProdutoActionPerformed

    private void jmEntradaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEntradaProdutoActionPerformed
FrmEntradaProdutoVIEW objFrmEntradaProdutoVIEW =new FrmEntradaProdutoVIEW();
objFrmEntradaProdutoVIEW.setVisible(true);
    }//GEN-LAST:event_jmEntradaProdutoActionPerformed

    private void jmSaidaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSaidaProdutoActionPerformed
FrmSaidaProdutoVIEW objFrmSaidaProdutoVIEW = new FrmSaidaProdutoVIEW();
objFrmSaidaProdutoVIEW.setVisible(true);
    }//GEN-LAST:event_jmSaidaProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmEntradaProduto;
    private javax.swing.JMenuItem jmProduto;
    private javax.swing.JMenuItem jmSaidaProduto;
    private javax.swing.JPanel jpBackgroud;
    // End of variables declaration//GEN-END:variables
}