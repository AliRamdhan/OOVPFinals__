/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry.manager;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Baskoro Adi
 */
public class Homepage extends javax.swing.JFrame {

    private Component mainPanel;

    /**
     * Creates new form Homepage
     */
    public Homepage() {
        initComponents();
        this.setLocationRelativeTo(null);
        labelAdmin.setText("Welcome To The Laund-Al, " + String.valueOf(adm.nameAdm));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAdmin = new javax.swing.JLabel();
        explain = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_Pelanggan = new javax.swing.JMenuItem();
        jMenuItem_Admin = new javax.swing.JMenuItem();
        menuCucian = new javax.swing.JMenu();
        jMenuItem_CucianMasuk = new javax.swing.JMenuItem();
        jMenuItem_Laporan = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelAdmin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAdmin.setText("dsaas");

        explain.setText("Click this");
        explain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explainActionPerformed(evt);
            }
        });

        jMenu1.setText("Auth");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem_Pelanggan.setText("Customer");
        jMenuItem_Pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_PelangganActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Pelanggan);

        jMenuItem_Admin.setText("Admin");
        jMenuItem_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AdminActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Admin);

        jMenuBar1.add(jMenu1);

        menuCucian.setText("Laundry");

        jMenuItem_CucianMasuk.setText("Transaksi");
        jMenuItem_CucianMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CucianMasukActionPerformed(evt);
            }
        });
        menuCucian.add(jMenuItem_CucianMasuk);

        jMenuItem_Laporan.setText("Report");
        jMenuItem_Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_LaporanActionPerformed(evt);
            }
        });
        menuCucian.add(jMenuItem_Laporan);

        jMenuBar1.add(menuCucian);

        jMenu2.setText("About");

        jMenuItem1.setText("Credit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(explain, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(explain)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem_PelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_PelangganActionPerformed
        // TODO add your handling code here:
        new Pelanggan().show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem_PelangganActionPerformed

    private void jMenuItem_CucianMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CucianMasukActionPerformed
        // TODO add your handling code here:
        new CucianMasuk().show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem_CucianMasukActionPerformed

    private void jMenuItem_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AdminActionPerformed
        // TODO add your handling code here:
        new Admin().show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem_AdminActionPerformed

    private void jMenuItem_LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_LaporanActionPerformed
        // TODO add your handling code here:
        new LaporanTransaksi().show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem_LaporanActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(this, "Farhan Ali Ramadhan" + "\n" + "001202200044" + "\n" + " Information Technology", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void explainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explainActionPerformed
        if (explain.isSelected()) {
            String text = "A laundry company offers cleaning services for various types of clothing and linens. ";
            String text2 = "They may provide wash-and-fold, dry cleaning, ironing, or alterations. ";
            String text3 = "Some companies offer pickup and delivery services.";
            JOptionPane.showMessageDialog(this.mainPanel, text + "\n" + text2 + "\n" + text3, "Laund-al", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_explainActionPerformed

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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox explain;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_Admin;
    private javax.swing.JMenuItem jMenuItem_CucianMasuk;
    private javax.swing.JMenuItem jMenuItem_Laporan;
    private javax.swing.JMenuItem jMenuItem_Pelanggan;
    private javax.swing.JLabel labelAdmin;
    private javax.swing.JMenu menuCucian;
    // End of variables declaration//GEN-END:variables
}
