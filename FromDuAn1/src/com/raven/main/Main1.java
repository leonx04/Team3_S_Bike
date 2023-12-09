/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.main;

import com.raven.component.Header_BanHang;
import com.raven.component.Header_HoaDon;
import com.raven.component.Header_KhachHang;
import com.raven.component.Header_KhuyenMai;
import com.raven.component.Header_NhanVien;
import com.raven.component.Header_SanPham;
import com.raven.component.Header_Thongke;
import com.raven.event.EventMenuSelected;
import com.raven.swing.XImage;
import com.raven.view.Bill_Jpanel;
import com.raven.view.From_KhuyenMai;
import com.raven.view.JPanel_SanPham;
import java.awt.Color;
import javax.swing.JComponent;

/**
 *
 * @author RAVEN
 */
public class Main1 extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main1() {
        initComponents();
        this.setIconImage(XImage.getAppIcon());
        setBackground(new Color(0, 0, 0, 0));
        
        menu.initMoving(Main1.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
//                System.out.println(""+index);
                if (index == 1) {

                } else if (index == 3) {
                    setFrom2(new Header_BanHang() );
                } else if (index == 9) {
                    setFrom2(new Header_HoaDon() );
                    setFrom(new Bill_Jpanel());
                } else if (index == 11) {
                    setFrom2(new Header_SanPham() );
                    setFrom(new JPanel_SanPham());
                } else if (index == 13) {
                    setFrom2(new Header_KhachHang() );
                } else if (index == 15) {
                    setFrom2(new Header_Thongke() );
                } else if (index == 17) {
                    setFrom2(new Header_NhanVien());
                } else if (index == 19) {
                    setFrom2(new Header_KhuyenMai());
                    setFrom(new From_KhuyenMai());
                }
            }

        });
    }

    private void setFrom(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
        public void setFrom2(JComponent com){
        panel_header.removeAll();
        panel_header.add(com);
       panel_header.repaint();
        panel_header.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        menu = new com.raven.component.Menu();
        mainPanel = new javax.swing.JPanel();
        panel_header = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(249, 249, 249));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelBorder1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainPanel.setLayout(new java.awt.BorderLayout());
        panelBorder1.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 50, 1320, 800));

        panel_header.setOpaque(false);
        panel_header.setLayout(new java.awt.BorderLayout());
        panelBorder1.add(panel_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 1320, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private com.raven.component.Menu menu;
    private com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JPanel panel_header;
    // End of variables declaration//GEN-END:variables
}
