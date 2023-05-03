/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Baskoro Adi
 */
public class LaporanTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form LaporanTransaksi
     */
    DefaultTableModel model;
    Connection conn = Koneksi.getConnection();

    public LaporanTransaksi() {

        initComponents();
        setTitle("Laporan Transaksi");
        setLocationRelativeTo(null);
        model = new DefaultTableModel(new String[]{
            "ID Pelanggan", "ID Cucian", "Nama", "No HP", "Alamat",
            "JK", "Berat (kg)", "Penerimaan Barang", "Harga", "Status Bayar",
            "Status Transaksi", "Selesai"
        }, 0);
        TableData.setModel(model);
        jDateChooser.setDateFormatString("dd/MM/yyyy");
        tampil();

    }

    private void sortDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        jDateChooser.setDateFormatString("dd/MM/yyyy");
        String date = sdf.format(jDateChooser.getDate());
        String select = "SELECT * FROM cucian JOIN pelanggan ON cucian.id_pelanggan = pelanggan.id_pelanggan WHERE tanggal_masuk LIKE ?";

        model.setColumnCount(0);
        model.addColumn("ID Pelanggan");
        model.addColumn("ID Cucian");
        model.addColumn("Nama");
        model.addColumn("No HP");
        model.addColumn("Alamat");
        model.addColumn("JK");
        model.addColumn("Berat (kg)");
        model.addColumn("Penerimaan Barang");
        model.addColumn("Harga");
        model.addColumn("Status Bayar");
        model.addColumn("Status Transaksi");
        model.addColumn("Selesai");

        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setString(1, date + "%");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Object[] o = new Object[12];
                o[0] = result.getString("id_pelanggan");
                o[1] = result.getString("id_cucian");
                o[2] = result.getString("nama_pelanggan");
                o[3] = result.getString("nomer_hp");
                o[4] = result.getString("alamat_pelanggan");
                o[5] = result.getString("jenis_kelamin");
                o[6] = result.getInt("berat");
                o[7] = result.getString("tanggal_keluar");
                o[8] = result.getInt("harga");
                o[9] = result.getString("statuspembayaran");
                o[10] = result.getString("statustransaksi");
                o[11] = result.getString("tanggal_keluar");

                model.addRow(o);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void search() {

        model.setRowCount(0);

        String sql = "SELECT * FROM cucian JOIN pelanggan ON cucian.id_pelanggan = pelanggan.id_pelanggan WHERE nama_pelanggan LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtSearch.getText() + "%");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Object[] o = new Object[12];
                o[0] = result.getString("id_pelanggan");
                o[1] = result.getString("id_cucian");
                o[2] = result.getString("nama_pelanggan");
                o[3] = result.getString("nomer_hp");
                o[4] = result.getString("alamat_pelanggan");
                o[5] = result.getString("jenis_kelamin");
                o[6] = result.getInt("berat");
                o[7] = result.getString("tanggal_masuk");
                o[8] = result.getInt("harga");
                o[9] = result.getString("statuspembayaran");
                o[10] = result.getString("statustransaksi");
                o[11] = result.getString("tanggal_keluar");

                model.addRow(o);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void tampil() {

        try {
            model.setRowCount(0); // clears the table
            String query = "SELECT * FROM cucian JOIN pelanggan WHERE cucian.id_pelanggan = pelanggan.id_pelanggan";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            if (!result.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "Data Kosong!", "Notification", JOptionPane.WARNING_MESSAGE);
            } else {
                while (result.next()) {
                    Object[] o = {
                        result.getString("id_pelanggan"),
                        result.getString("id_cucian"),
                        result.getString("nama_pelanggan"),
                        result.getString("nomer_hp"),
                        result.getString("alamat_pelanggan"),
                        result.getString("jenis_kelamin"),
                        result.getInt("berat"),
                        result.getString("tanggal_masuk"),
                        result.getInt("harga"),
                        result.getString("statuspembayaran"),
                        result.getString("statustransaksi"),
                        result.getString("tanggal_keluar")
                    };
                    model.addRow(o);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        btnSbd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableData = new javax.swing.JTable();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_Pelanggan = new javax.swing.JMenuItem();
        jMenuItem_Admin = new javax.swing.JMenuItem();
        menuCucian = new javax.swing.JMenu();
        jMenuItem_CucianMasuk = new javax.swing.JMenuItem();
        jMenuItem_Laporan = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnSbd.setText("Find");
        btnSbd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSbdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date :");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        TableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TableData);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Laporan Transaksi");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBack))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSbd))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSbd)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnPrint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Auth");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem_Pelanggan.setText("Pelanggan");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if (txtSearch.getText().isEmpty()) {
            tampil();
        } else {
            search();
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSbdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSbdActionPerformed
        // TODO add your handling code here:
        if (jDateChooser.getDate().equals("")) {
            tampil();
        } else {
            sortDate();
        }
    }//GEN-LAST:event_btnSbdActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageFormat header = new MessageFormat("Data Transaksi");
                MessageFormat footer = new MessageFormat("Page{0,number,integer}");
                try {
                    TableData.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                } catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new Homepage().show();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jMenuItem_PelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_PelangganActionPerformed
        // TODO add your handling code here:
        new Pelanggan().show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem_PelangganActionPerformed

    private void jMenuItem_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AdminActionPerformed
        // TODO add your handling code here:
        new Admin().show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem_AdminActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem_CucianMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CucianMasukActionPerformed
        // TODO add your handling code here:
        new CucianMasuk().show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem_CucianMasukActionPerformed

    private void jMenuItem_LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_LaporanActionPerformed
        // TODO add your handling code here:
        new LaporanTransaksi().show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem_LaporanActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(this, "Farhan Ali Ramadhan" + "\n" + "001202200044" + "\n" + " Information Technology", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableData;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSbd;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_Admin;
    private javax.swing.JMenuItem jMenuItem_CucianMasuk;
    private javax.swing.JMenuItem jMenuItem_Laporan;
    private javax.swing.JMenuItem jMenuItem_Pelanggan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuCucian;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
