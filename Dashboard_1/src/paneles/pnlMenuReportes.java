package paneles;

import paneles.pnlreportes.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import metodos.CambiaPanel;
import principal.Principal;

public class pnlMenuReportes extends javax.swing.JPanel {

    Principal p = new Principal();
    public pnlMenuReportes() throws SQLException {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenuR = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnRP = new metodos.MyButton();
        btnRPPC = new metodos.MyButton();
        btnRHPP = new metodos.MyButton();
        btnRSI = new metodos.MyButton();
        btnRDP = new metodos.MyButton();
        btnRPSE = new metodos.MyButton();
        btnREC = new metodos.MyButton();
        btnRNSM = new metodos.MyButton();

        setMinimumSize(new java.awt.Dimension(1230, 720));
        setPreferredSize(new java.awt.Dimension(1230, 720));

        pnlMenuR.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        pnlMenuR.setMinimumSize(new java.awt.Dimension(1230, 720));
        pnlMenuR.setPreferredSize(new java.awt.Dimension(1230, 720));

        jPanel17.setBackground(new java.awt.Color(99, 169, 229));
        jPanel17.setPreferredSize(new java.awt.Dimension(1217, 95));

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Menú Principal de Reportes");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jLabel13)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(28, 28, 28))
        );

        btnRP.setBackground(new java.awt.Color(99, 169, 229));
        btnRP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnRP.setForeground(new java.awt.Color(255, 255, 255));
        btnRP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_reports/proveedor1.png"))); // NOI18N
        btnRP.setText("   Reporte de proveedores");
        btnRP.setBorderColor(new java.awt.Color(0, 51, 153));
        btnRP.setColor(new java.awt.Color(99, 169, 229));
        btnRP.setColorClick(new java.awt.Color(99, 169, 229));
        btnRP.setColorOver(new java.awt.Color(66, 139, 225));
        btnRP.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 16)); // NOI18N
        btnRP.setRadius(10);
        btnRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRPActionPerformed(evt);
            }
        });

        btnRPPC.setBackground(new java.awt.Color(99, 169, 229));
        btnRPPC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnRPPC.setForeground(new java.awt.Color(255, 255, 255));
        btnRPPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_reports/caducado1.png"))); // NOI18N
        btnRPPC.setText("   Reporte de productos próximos a caducar");
        btnRPPC.setBorderColor(new java.awt.Color(0, 51, 153));
        btnRPPC.setColor(new java.awt.Color(99, 169, 229));
        btnRPPC.setColorClick(new java.awt.Color(99, 169, 229));
        btnRPPC.setColorOver(new java.awt.Color(66, 139, 225));
        btnRPPC.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 16)); // NOI18N
        btnRPPC.setRadius(10);
        btnRPPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRPPCActionPerformed(evt);
            }
        });

        btnRHPP.setBackground(new java.awt.Color(99, 169, 229));
        btnRHPP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnRHPP.setForeground(new java.awt.Color(255, 255, 255));
        btnRHPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_reports/precios1.png"))); // NOI18N
        btnRHPP.setText("   Reporte histórico de precios de productos");
        btnRHPP.setBorderColor(new java.awt.Color(0, 51, 153));
        btnRHPP.setColor(new java.awt.Color(99, 169, 229));
        btnRHPP.setColorClick(new java.awt.Color(99, 169, 229));
        btnRHPP.setColorOver(new java.awt.Color(66, 139, 225));
        btnRHPP.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 16)); // NOI18N
        btnRHPP.setRadius(10);
        btnRHPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRHPPActionPerformed(evt);
            }
        });

        btnRSI.setBackground(new java.awt.Color(99, 169, 229));
        btnRSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnRSI.setForeground(new java.awt.Color(255, 255, 255));
        btnRSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_reports/inventario1.png"))); // NOI18N
        btnRSI.setText("   Reporte de salida de inventario");
        btnRSI.setBorderColor(new java.awt.Color(0, 51, 153));
        btnRSI.setColor(new java.awt.Color(99, 169, 229));
        btnRSI.setColorClick(new java.awt.Color(99, 169, 229));
        btnRSI.setColorOver(new java.awt.Color(66, 139, 225));
        btnRSI.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 16)); // NOI18N
        btnRSI.setRadius(10);
        btnRSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRSIActionPerformed(evt);
            }
        });

        btnRDP.setBackground(new java.awt.Color(99, 169, 229));
        btnRDP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnRDP.setForeground(new java.awt.Color(255, 255, 255));
        btnRDP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_reports/devoluciones1.png"))); // NOI18N
        btnRDP.setText("   Reporte de devolución de productos");
        btnRDP.setBorderColor(new java.awt.Color(0, 51, 153));
        btnRDP.setColor(new java.awt.Color(99, 169, 229));
        btnRDP.setColorClick(new java.awt.Color(99, 169, 229));
        btnRDP.setColorOver(new java.awt.Color(66, 139, 225));
        btnRDP.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 16)); // NOI18N
        btnRDP.setRadius(10);
        btnRDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRDPActionPerformed(evt);
            }
        });

        btnRPSE.setBackground(new java.awt.Color(99, 169, 229));
        btnRPSE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnRPSE.setForeground(new java.awt.Color(255, 255, 255));
        btnRPSE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_reports/agotado1.png"))); // NOI18N
        btnRPSE.setText("   Reporte de productos sin existencia");
        btnRPSE.setBorderColor(new java.awt.Color(0, 51, 153));
        btnRPSE.setColor(new java.awt.Color(99, 169, 229));
        btnRPSE.setColorClick(new java.awt.Color(99, 169, 229));
        btnRPSE.setColorOver(new java.awt.Color(66, 139, 225));
        btnRPSE.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 16)); // NOI18N
        btnRPSE.setRadius(10);
        btnRPSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRPSEActionPerformed(evt);
            }
        });

        btnREC.setBackground(new java.awt.Color(99, 169, 229));
        btnREC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnREC.setForeground(new java.awt.Color(255, 255, 255));
        btnREC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_reports/categoria1.png"))); // NOI18N
        btnREC.setText("   Reporte de existencias por categoría");
        btnREC.setBorderColor(new java.awt.Color(0, 51, 153));
        btnREC.setColor(new java.awt.Color(99, 169, 229));
        btnREC.setColorClick(new java.awt.Color(99, 169, 229));
        btnREC.setColorOver(new java.awt.Color(66, 139, 225));
        btnREC.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 16)); // NOI18N
        btnREC.setRadius(10);
        btnREC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRECActionPerformed(evt);
            }
        });

        btnRNSM.setBackground(new java.awt.Color(99, 169, 229));
        btnRNSM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnRNSM.setForeground(new java.awt.Color(255, 255, 255));
        btnRNSM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_reports/minimo1.png"))); // NOI18N
        btnRNSM.setText("   Reporte de nivel de stock mínimo");
        btnRNSM.setBorderColor(new java.awt.Color(0, 51, 153));
        btnRNSM.setColor(new java.awt.Color(99, 169, 229));
        btnRNSM.setColorClick(new java.awt.Color(99, 169, 229));
        btnRNSM.setColorOver(new java.awt.Color(66, 139, 225));
        btnRNSM.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 16)); // NOI18N
        btnRNSM.setRadius(10);
        btnRNSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRNSMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuRLayout = new javax.swing.GroupLayout(pnlMenuR);
        pnlMenuR.setLayout(pnlMenuRLayout);
        pnlMenuRLayout.setHorizontalGroup(
            pnlMenuRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuRLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlMenuRLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(pnlMenuRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMenuRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRSI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRHPP, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRPPC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRP, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addGroup(pnlMenuRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMenuRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRPSE, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnREC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRNSM, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuRLayout.setVerticalGroup(
            pnlMenuRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuRLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(pnlMenuRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuRLayout.createSequentialGroup()
                        .addComponent(btnRP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnRPPC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnRHPP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnRSI, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuRLayout.createSequentialGroup()
                        .addComponent(btnRNSM, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnREC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnRPSE, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnRDP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenuR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenuR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRPActionPerformed
        try {
            pnlRProveedor prp = new pnlRProveedor();

            JFrame formFrame = new JFrame("Reporte de proveedores");
            formFrame.setSize(1280, 740);
            formFrame.setLocationRelativeTo(p); 

            JPanel formPanel = new JPanel();

            formFrame.add(prp.pnlProvee);
            formFrame.setResizable(false);
            formFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(pnlMenuReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRPActionPerformed

    private void btnRPPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRPPCActionPerformed
        // TODO add your handling code here:
                try {
            pnlRProduCaduc prpc = new pnlRProduCaduc();

            JFrame formFrame = new JFrame("Reporte de productos próximos a caducar");
            formFrame.setSize(1255, 730);
            formFrame.setLocationRelativeTo(p); 

            JPanel formPanel = new JPanel();

            formFrame.add(prpc.pnlcaducado);
            formFrame.setResizable(false);
            formFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(pnlMenuReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRPPCActionPerformed

    private void btnRHPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRHPPActionPerformed
        // TODO add your handling code here:
        try {
            pnlRHistoPrecioProdu prhpp = new pnlRHistoPrecioProdu();

            JFrame formFrame = new JFrame("Reporte histórico de precios de productos");
            formFrame.setSize(1260, 730);
            formFrame.setLocationRelativeTo(p); 

            JPanel formPanel = new JPanel();

            formFrame.add(prhpp.pnlhistorico);
            formFrame.setResizable(false);
            formFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(pnlMenuReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRHPPActionPerformed

    private void btnRSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRSIActionPerformed
        // TODO add your handling code here:
        try {
            pnlRSalidaInve prsi = new pnlRSalidaInve();

            JFrame formFrame = new JFrame("Reporte de salida de inventario");
            formFrame.setSize(1260, 730);
            formFrame.setLocationRelativeTo(p); 

            JPanel formPanel = new JPanel();

            formFrame.add(prsi.pnlsalidai);
            formFrame.setResizable(false);
            formFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(pnlMenuReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRSIActionPerformed

    private void btnRDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRDPActionPerformed
        // TODO add your handling code here:
        try {
            pnlRDevoluProdu prdp = new pnlRDevoluProdu();

            JFrame formFrame = new JFrame("Reporte de devolución de productos");
            formFrame.setSize(1400, 700);
            formFrame.setLocationRelativeTo(p); 

            JPanel formPanel = new JPanel();

            formFrame.add(prdp.pnldevolu);
            formFrame.setResizable(false);
            formFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(pnlMenuReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRDPActionPerformed

    private void btnRPSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRPSEActionPerformed
        // TODO add your handling code here:
        try {
            pnlRProduSinExis prpse = new pnlRProduSinExis();

            JFrame formFrame = new JFrame("Reporte de nivel de stock mínimo");
            formFrame.setSize(1260, 690);
            formFrame.setLocationRelativeTo(p); 

            JPanel formPanel = new JPanel();

            formFrame.add(prpse.pnlprodusinexis);
            formFrame.setResizable(false);
            formFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(pnlMenuReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRPSEActionPerformed

    private void btnRECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRECActionPerformed
        // TODO add your handling code here:
        try {
            pnlRExisCategoria prec = new pnlRExisCategoria();

            JFrame formFrame = new JFrame("Reporte de productos sin existencia");
            formFrame.setSize(1260, 710);
            formFrame.setLocationRelativeTo(p); 

            JPanel formPanel = new JPanel();

            formFrame.add(prec.pnlexist);
            formFrame.setResizable(false);
            formFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(pnlMenuReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRECActionPerformed

    private void btnRNSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRNSMActionPerformed
        // TODO add your handling code here:
        try {
            pnlRNivelStockMin prnsm = new pnlRNivelStockMin();

            JFrame formFrame = new JFrame("Reporte de nivel de stock mínimo");
            formFrame.setSize(1260, 770);
            formFrame.setLocationRelativeTo(p); 

            JPanel formPanel = new JPanel();

            formFrame.add(prnsm.pnlstockmin);
            formFrame.setResizable(false);
            formFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(pnlMenuReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRNSMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private metodos.MyButton btnRDP;
    private metodos.MyButton btnREC;
    private metodos.MyButton btnRHPP;
    private metodos.MyButton btnRNSM;
    private metodos.MyButton btnRP;
    private metodos.MyButton btnRPPC;
    private metodos.MyButton btnRPSE;
    private metodos.MyButton btnRSI;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel pnlMenuR;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(pnlMenuReportes aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setExtendedState(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
