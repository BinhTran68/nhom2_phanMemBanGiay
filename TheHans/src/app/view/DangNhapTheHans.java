/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.view;

import app.model.NhanVien;
import app.service.NhanVienService;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author admin
 */
public class DangNhapTheHans extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private NhanVienService nhanVienService = new NhanVienService();

    public DangNhapTheHans() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void login() {

        String sdt = txtEmail.getText().trim();

        String matKhau = txtMatKhau.getText().trim();
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");
            return;
        }
        if (matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu");
            return;
        }

        NhanVien nhanVien = nhanVienService.dangNhap(sdt, matKhau);
        if (nhanVien != null) {
            if (nhanVien.isTrangThaiXoa() != true) {
                JOptionPane.showMessageDialog(this, "Bạn không có quyển đăng nhập");
                return;
            }
            MainApplicationView1 applicationView = new MainApplicationView1(nhanVien);
            applicationView.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Tên tài khoản hoặc mật khẩu không đúng");
            return;
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

        panelGradiente1 = new swing.PanelGradiente();
        panelBorder1 = new swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        btnDangNhap = new swing.MyButton();
        jPanel1 = new javax.swing.JPanel();
        txtMatKhau = new swing.MyPasswordField();
        txtEmail = new swing.MyTextField1();
        cbShowPass = new javax.swing.JCheckBox();
        btnThoat = new swing.MyButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 0));
        panelGradiente1.setColorSecundario(new java.awt.Color(0, 102, 0));
        panelGradiente1.setPreferredSize(new java.awt.Dimension(700, 450));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(400, 450));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Wellcome  Back");
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(30, 20, 250, 60);

        btnDangNhap.setBackground(new java.awt.Color(51, 102, 0));
        btnDangNhap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.setColor(new java.awt.Color(51, 102, 0));
        btnDangNhap.setColorOver(new java.awt.Color(0, 204, 0));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        panelBorder1.add(btnDangNhap);
        btnDangNhap.setBounds(30, 270, 110, 40);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMatKhau.setBackground(new java.awt.Color(51, 102, 0));
        txtMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        txtMatKhau.setHint("Mật Khẩu");
        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyPressed(evt);
            }
        });

        txtEmail.setBackground(new java.awt.Color(51, 102, 0));
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setHint("SĐT");
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        cbShowPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbShowPass.setForeground(new java.awt.Color(51, 102, 0));
        cbShowPass.setText("Hiển Thị Mật Khẩu");
        cbShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbShowPass))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbShowPass)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelBorder1.add(jPanel1);
        jPanel1.setBounds(0, 100, 310, 150);

        btnThoat.setBackground(new java.awt.Color(51, 102, 0));
        btnThoat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.setColor(new java.awt.Color(51, 102, 0));
        btnThoat.setColorOver(new java.awt.Color(0, 204, 0));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        panelBorder1.add(btnThoat);
        btnThoat.setBounds(180, 270, 110, 40);

        panelGradiente1.add(panelBorder1);
        panelBorder1.setBounds(350, 40, 310, 380);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icon/thehans.png"))); // NOI18N
        panelGradiente1.add(jLabel1);
        jLabel1.setBounds(-50, 90, 480, 280);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    private void cbShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowPassActionPerformed
        if (cbShowPass.isSelected()) {
            txtMatKhau.setEchoChar((char) 0); //password = JPasswordField
        } else {
            txtMatKhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cbShowPassActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMatKhau.requestFocus();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtMatKhauKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_txtMatKhauKeyPressed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);

    }//GEN-LAST:event_btnThoatActionPerformed

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangNhapTheHans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapTheHans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapTheHans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapTheHans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapTheHans().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnDangNhap;
    private swing.MyButton btnThoat;
    private javax.swing.JCheckBox cbShowPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private swing.PanelBorder panelBorder1;
    private swing.PanelGradiente panelGradiente1;
    private swing.MyTextField1 txtEmail;
    private swing.MyPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}
