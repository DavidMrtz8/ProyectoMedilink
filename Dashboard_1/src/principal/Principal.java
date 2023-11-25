/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import metodos.CambiaPanel;
import paneles.pnlAgregarOrdenEntrada;

/**
 *
 * @author RojeruSan
 */
public class Principal extends javax.swing.JFrame {

    int x, y;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
        this.uno.setSelected(true);

        new CambiaPanel(pnlPrincipal, new paneles.pnlPaginaPrincipal());
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
        pnlMenu = new javax.swing.JPanel();
        uno = new rsbuttom.RSButtonMetro();
        tres = new rsbuttom.RSButtonMetro();
        dos = new rsbuttom.RSButtonMetro();
        seis = new rsbuttom.RSButtonMetro();
        cinco = new rsbuttom.RSButtonMetro();
        cuatro = new rsbuttom.RSButtonMetro();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlCentro = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(239, 238, 244)));

        uno.setBackground(java.awt.Color.white);
        uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/hogar.png"))); // NOI18N
        uno.setText("Panel Principal");
        uno.setColorHover(new java.awt.Color(110, 169, 229));
        uno.setColorNormal(new java.awt.Color(255, 255, 255));
        uno.setColorPressed(new java.awt.Color(51, 153, 255));
        uno.setColorTextNormal(new java.awt.Color(0, 0, 0));
        uno.setColorTextPressed(new java.awt.Color(110, 169, 229));
        uno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        uno.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        uno.setIconTextGap(25);
        uno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                unoMousePressed(evt);
            }
        });
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });

        tres.setBackground(java.awt.Color.white);
        tres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/estadisticas.png"))); // NOI18N
        tres.setText("Reportes");
        tres.setColorHover(new java.awt.Color(110, 169, 229));
        tres.setColorNormal(new java.awt.Color(255, 255, 255));
        tres.setColorPressed(new java.awt.Color(51, 153, 255));
        tres.setColorTextNormal(new java.awt.Color(0, 0, 0));
        tres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tres.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        tres.setIconTextGap(19);
        tres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tresMousePressed(evt);
            }
        });
        tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresActionPerformed(evt);
            }
        });

        dos.setBackground(java.awt.Color.white);
        dos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/carretilla.png"))); // NOI18N
        dos.setText("Inventario");
        dos.setColorHover(new java.awt.Color(110, 169, 229));
        dos.setColorNormal(new java.awt.Color(255, 255, 255));
        dos.setColorPressed(new java.awt.Color(51, 153, 255));
        dos.setColorTextNormal(new java.awt.Color(0, 0, 0));
        dos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dos.setIconTextGap(25);
        dos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dosMousePressed(evt);
            }
        });
        dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosActionPerformed(evt);
            }
        });

        seis.setBackground(java.awt.Color.white);
        seis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/log_out_icon_197724.png"))); // NOI18N
        seis.setText("Cerrar Sesion");
        seis.setColorHover(new java.awt.Color(110, 169, 229));
        seis.setColorNormal(new java.awt.Color(255, 255, 255));
        seis.setColorPressed(new java.awt.Color(51, 153, 255));
        seis.setColorTextNormal(new java.awt.Color(0, 0, 0));
        seis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seis.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        seis.setIconTextGap(19);
        seis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                seisMousePressed(evt);
            }
        });
        seis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seisActionPerformed(evt);
            }
        });

        cinco.setBackground(new java.awt.Color(255, 255, 255));
        cinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/entrega-de-pedidos.png"))); // NOI18N
        cinco.setText("Ordenes");
        cinco.setColorHover(new java.awt.Color(110, 169, 229));
        cinco.setColorNormal(new java.awt.Color(255, 255, 255));
        cinco.setColorPressed(new java.awt.Color(51, 153, 255));
        cinco.setColorTextNormal(new java.awt.Color(0, 0, 0));
        cinco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cinco.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cinco.setIconTextGap(19);
        cinco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cincoMousePressed(evt);
            }
        });
        cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cincoActionPerformed(evt);
            }
        });

        cuatro.setBackground(new java.awt.Color(255, 255, 255));
        cuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/usuario.png"))); // NOI18N
        cuatro.setText("Proveedores");
        cuatro.setColorHover(new java.awt.Color(110, 169, 229));
        cuatro.setColorNormal(new java.awt.Color(255, 255, 255));
        cuatro.setColorPressed(new java.awt.Color(51, 153, 255));
        cuatro.setColorTextNormal(new java.awt.Color(0, 0, 0));
        cuatro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cuatro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cuatro.setIconTextGap(19);
        cuatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cuatroMousePressed(evt);
            }
        });
        cuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatroActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesReportes/Logo.jpg"))); // NOI18N

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cinco, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(seis, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(108, 108, 108)
                .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cinco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(seis, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel1.add(pnlMenu);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        pnlCentro.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Juan Perez");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(52, 52, 52))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new javax.swing.BoxLayout(pnlPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(pnlPrincipal);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlCentro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlPaginaPrincipal());
        if (this.uno.isSelected()) {
            this.uno.setColorNormal(new Color(255, 255, 255));
            this.uno.setColorHover(new Color (110, 169, 229));
            this.uno.setColorPressed(new Color(51, 153, 255));

            this.dos.setColorNormal(new Color(255, 255, 255));
            this.dos.setColorHover(new Color(110, 169, 229));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(255, 255, 255));
            this.tres.setColorHover(new Color(110, 169, 229));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(255, 255, 255));
            this.cuatro.setColorHover(new Color(110, 169, 229));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(255, 255, 255));
            this.cinco.setColorHover(new Color(110, 169, 229));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(255, 255, 255));
            this.seis.setColorHover(new Color(110, 169, 229));
            this.seis.setColorPressed(new Color(204, 204, 204));
        } else {
            this.uno.setColorNormal(new Color(255, 255, 255));
            this.uno.setColorHover(new Color(110, 169, 229));
            this.uno.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_unoActionPerformed

    private void unoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unoMousePressed
        this.uno.setSelected(true);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
    }//GEN-LAST:event_unoMousePressed

    private void tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresActionPerformed
        try {
            new CambiaPanel(pnlPrincipal, new paneles.pnlMenuReportes());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.tres.isSelected()) {
            this.tres.setColorNormal(new Color(255, 255, 255));
            this.tres.setColorHover(new Color (110, 169, 229));
            this.tres.setColorPressed(new Color(51, 153, 255));

            this.uno.setColorNormal(new Color(255, 255, 255));
            this.uno.setColorHover(new Color(110, 169, 229));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(255, 255, 255));
            this.dos.setColorHover(new Color(110, 169, 229));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(255, 255, 255));
            this.cuatro.setColorHover(new Color(110, 169, 229));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(255, 255, 255));
            this.cinco.setColorHover(new Color(110, 169, 229));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(255, 255, 255));
            this.seis.setColorHover(new Color(110, 169, 229));
            this.seis.setColorPressed(new Color(204, 204, 204));
        } else {
            this.tres.setColorNormal(new Color(255, 255, 255));
            this.tres.setColorHover(new Color(110, 169, 229));
            this.tres.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_tresActionPerformed

    private void tresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tresMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(true);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
    }//GEN-LAST:event_tresMousePressed

    private void dosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dosMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(true);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
    }//GEN-LAST:event_dosMousePressed

    private void dosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosActionPerformed
        try {
            new CambiaPanel(pnlPrincipal, new paneles.pnlInventario());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.dos.isSelected()) {
            this.dos.setColorNormal(new Color(255, 255, 255));
            this.dos.setColorHover(new Color(110, 169, 229));
            this.dos.setColorPressed(new Color(51, 153, 255));

            this.uno.setColorNormal(new Color(255, 255, 255));
            this.uno.setColorHover(new Color(110, 169, 229));
            this.uno.setColorPressed(new Color(110, 169, 229));

            this.tres.setColorNormal(new Color(255, 255, 255));
            this.tres.setColorHover(new Color(110, 169, 229));
            this.tres.setColorPressed(new Color(110, 169, 229));

            this.cuatro.setColorNormal(new Color(255, 255, 255));
            this.cuatro.setColorHover(new Color(110, 169, 229));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(255, 255, 255));
            this.cinco.setColorHover(new Color(110, 169, 229));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(255, 255, 255));
            this.seis.setColorHover(new Color(110, 169, 229));
            this.seis.setColorPressed(new Color(204, 204, 204));
        } else {
            this.dos.setColorNormal(new Color(255, 255, 255));
            this.dos.setColorHover(new Color(110, 169, 229));
            this.dos.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_dosActionPerformed

    private void seisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seisActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(respuesta == JOptionPane.YES_OPTION){
            this.dispose();
            new Login().setVisible(true);
        }
//        new Login().setVisible(true);

//        new CambiaPanel(pnlPrincipal, new paneles.pnlAgregarOrdenSalida());
//        if (this.seis.isSelected()) {
//            this.uno.setColorNormal(new Color(239, 238, 244));
//            this.uno.setColorHover(new Color(204, 204, 204));
//            this.uno.setColorPressed(new Color(204, 204, 204));
//
//            this.dos.setColorNormal(new Color(239, 238, 244));
//            this.dos.setColorHover(new Color(204, 204, 204));
//            this.dos.setColorPressed(new Color(204, 204, 204));
//
//            this.tres.setColorNormal(new Color(239, 238, 244));
//            this.tres.setColorHover(new Color(204, 204, 204));
//            this.tres.setColorPressed(new Color(204, 204, 204));
//
//            this.cuatro.setColorNormal(new Color(255, 255, 255));
//            this.cuatro.setColorHover(new Color(110, 169, 229));
//            this.cuatro.setColorPressed(new Color(204, 204, 204));
//
//            this.cinco.setColorNormal(new Color(239, 238, 244));
//            this.cinco.setColorHover(new Color(204, 204, 204));
//            this.cinco.setColorPressed(new Color(204, 204, 204));
//
//            this.seis.setColorNormal(new Color(204, 204, 204));
//            this.seis.setColorHover(new Color(204, 204, 204));
//            this.seis.setColorPressed(new Color(204, 204, 204));
//        } else {
//            this.seis.setColorNormal(new Color(239, 238, 244));
//            this.seis.setColorHover(new Color(204, 204, 204));
//            this.seis.setColorPressed(new Color(204, 204, 204));
//        }
    }//GEN-LAST:event_seisActionPerformed

    private void seisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seisMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(true);
    }//GEN-LAST:event_seisMousePressed

    private void cincoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cincoMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(true);
        this.seis.setSelected(false);
    }//GEN-LAST:event_cincoMousePressed

    private void cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cincoActionPerformed
        try {
            new CambiaPanel(pnlPrincipal, new paneles.pnlOrdenes());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.cinco.isSelected()) {
            this.cinco.setColorNormal(new Color(255, 255, 255));
            this.cinco.setColorHover(new Color(110, 169, 229));
            this.cinco.setColorPressed(new Color(51, 153, 255));

            this.uno.setColorNormal(new Color(255, 255, 255));
            this.uno.setColorHover(new Color(110, 169, 229));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(255, 255, 255));
            this.dos.setColorHover(new Color(110, 169, 229));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(255, 255, 255));
            this.tres.setColorHover(new Color(110, 169, 229));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(255, 255, 255));
            this.cuatro.setColorHover(new Color(110, 169, 229));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(255, 255, 255));
            this.seis.setColorHover(new Color(110, 169, 229));
            this.seis.setColorPressed(new Color(204, 204, 204));
        } else {
            this.cinco.setColorNormal(new Color(255, 255, 255));
            this.cinco.setColorHover(new Color(110, 169, 229));
            this.cinco.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_cincoActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void cuatroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuatroMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(true);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
    }//GEN-LAST:event_cuatroMousePressed

    private void cuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatroActionPerformed
        try {
            new CambiaPanel(pnlPrincipal, new paneles.pnlProveedores());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.cuatro.isSelected()) {
            this.cuatro.setColorNormal(new Color(255, 255, 255));
            this.cuatro.setColorHover(new Color(110, 169, 229));
            this.cuatro.setColorPressed(new Color(51, 153, 255));

            this.uno.setColorNormal(new Color(255, 255, 255));
            this.uno.setColorHover(new Color(110, 169, 229));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(255, 255, 255));
            this.dos.setColorHover(new Color(110, 169, 229));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(255, 255, 255));
            this.tres.setColorHover(new Color(110, 169, 229));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(255, 255, 255));
            this.cinco.setColorHover(new Color(110, 169, 229));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(255, 255, 255));
            this.seis.setColorHover(new Color(110, 169, 229));
            this.seis.setColorPressed(new Color(204, 204, 204));
        } else {
            this.cuatro.setColorNormal(new Color(255, 255, 255));
            this.cuatro.setColorHover(new Color(110, 169, 229));
            this.cuatro.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_cuatroActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new Principal().setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro cinco;
    private rsbuttom.RSButtonMetro cuatro;
    private rsbuttom.RSButtonMetro dos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlMenu;
    public javax.swing.JPanel pnlPrincipal;
    private rsbuttom.RSButtonMetro seis;
    private rsbuttom.RSButtonMetro tres;
    private rsbuttom.RSButtonMetro uno;
    // End of variables declaration//GEN-END:variables
}
