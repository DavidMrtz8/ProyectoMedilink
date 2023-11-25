package paneles.pnlreportes;

import Controlador.ControlReportes;
import Modelo.Conexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import metodos.CambiaPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;

public class pnlRExisCategoria extends javax.swing.JPanel {

    ControlReportes re = new ControlReportes();
    public pnlRExisCategoria() throws SQLException {
        initComponents();
        re.LlenarTablaExistenciaPorCategoria(tblExistenciaPorCategoria, cbSucursalEC.getSelectedIndex());
        re.RellenarComboSucursal("Sucursal", "Ciudad", cbSucursalEC);
        re.RellenarComboSucursal("Sucursal", "Ciudad", cbSucursalGEC);
        re.actualizarFecha(lblExistenciaCategoria);
        
        graficoEC();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlexist = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblExistenciaPorCategoria = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        lblExistenciaCategoria = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbSucursalEC = new javax.swing.JComboBox<>();
        btnGenerarSalidaI3 = new metodos.MyButton();
        jPanel15 = new javax.swing.JPanel();
        pnlGraficoEC = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnGenerarGraficoEC = new metodos.MyButton();
        cbSucursalGEC = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1235, 720));
        setPreferredSize(new java.awt.Dimension(1235, 720));

        pnlexist.setMinimumSize(new java.awt.Dimension(1230, 720));
        pnlexist.setPreferredSize(new java.awt.Dimension(1230, 720));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblExistenciaPorCategoria.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblExistenciaPorCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExistenciaPorCategoria.setEnabled(false);
        jScrollPane4.setViewportView(tblExistenciaPorCategoria);

        jPanel14.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 159, 1180, 440));

        jPanel22.setBackground(new java.awt.Color(99, 169, 229));

        lblExistenciaCategoria.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblExistenciaCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblExistenciaCategoria.setText("jLabel26");

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Fecha de Emisión:");

        jLabel21.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Reporte de existencia por categoría");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Seleccionar Sucursal:");

        cbSucursalEC.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbSucursalEC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar todas las Sucursales" }));
        cbSucursalEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSucursalECActionPerformed(evt);
            }
        });

        btnGenerarSalidaI3.setBackground(new java.awt.Color(19, 102, 217));
        btnGenerarSalidaI3.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarSalidaI3.setText("Descargar");
        btnGenerarSalidaI3.setBorderColor(new java.awt.Color(19, 102, 217));
        btnGenerarSalidaI3.setColor(new java.awt.Color(19, 102, 217));
        btnGenerarSalidaI3.setColorClick(new java.awt.Color(19, 102, 217));
        btnGenerarSalidaI3.setColorOver(new java.awt.Color(66, 139, 225));
        btnGenerarSalidaI3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        btnGenerarSalidaI3.setRadius(10);
        btnGenerarSalidaI3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarSalidaI3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblExistenciaCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSucursalEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarSalidaI3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSucursalEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnGenerarSalidaI3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblExistenciaCategoria))
                .addGap(16, 16, 16))
        );

        jPanel14.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1180, 140));

        jTabbedPane4.addTab("Reportes tipo tabla", jPanel14);

        javax.swing.GroupLayout pnlGraficoECLayout = new javax.swing.GroupLayout(pnlGraficoEC);
        pnlGraficoEC.setLayout(pnlGraficoECLayout);
        pnlGraficoECLayout.setHorizontalGroup(
            pnlGraficoECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1169, Short.MAX_VALUE)
        );
        pnlGraficoECLayout.setVerticalGroup(
            pnlGraficoECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        jLabel5.setText("Seleccionar Sucursal:");

        btnGenerarGraficoEC.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarGraficoEC.setText("Generar");
        btnGenerarGraficoEC.setBorderColor(new java.awt.Color(102, 160, 255));
        btnGenerarGraficoEC.setColor(new java.awt.Color(102, 160, 255));
        btnGenerarGraficoEC.setColorClick(new java.awt.Color(19, 102, 217));
        btnGenerarGraficoEC.setColorOver(new java.awt.Color(183, 207, 255));
        btnGenerarGraficoEC.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        btnGenerarGraficoEC.setRadius(10);
        btnGenerarGraficoEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarGraficoECActionPerformed(evt);
            }
        });

        cbSucursalGEC.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        cbSucursalGEC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar todas las sucursales" }));
        cbSucursalGEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSucursalGECActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(99, 169, 229));
        jLabel22.setText("Existencia por categoría");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSucursalGEC, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerarGraficoEC, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addComponent(pnlGraficoEC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSucursalGEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(btnGenerarGraficoEC, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlGraficoEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Grafica", jPanel15);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlexistLayout = new javax.swing.GroupLayout(pnlexist);
        pnlexist.setLayout(pnlexistLayout);
        pnlexistLayout.setHorizontalGroup(
            pnlexistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlexistLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlexistLayout.setVerticalGroup(
            pnlexistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlexistLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlexist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlexist, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbSucursalECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSucursalECActionPerformed
        try {
            re.LlenarTablaExistenciaPorCategoria(tblExistenciaPorCategoria, cbSucursalEC.getSelectedIndex());
            graficoEC();
        } catch (SQLException ex) {
            Logger.getLogger(pnlRExisCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbSucursalECActionPerformed

    public String SucursalSelected (int sucursalID){
        String sucursal = "";
        
        if(sucursalID == 0){
            sucursal = "0";
        }
        
        if(sucursalID == 1){
            sucursal = "'SC01'";
        }
        
        if(sucursalID == 2){
            sucursal = "'SC02'";
        }
        
        if(sucursalID == 3){
            sucursal = "'SC03'";
        }
        
        if(sucursalID == 4){
            sucursal = "'SC04'";
        }
        
        if(sucursalID == 5){
            sucursal = "'SC05'";
        }
        
        if(sucursalID == 6){
            sucursal = "'SC06'";
        }
        
        return sucursal;
    }
    
    public String SucursalSeleccionada(int sucursalID){
        String sucursal = "";
        
        if(sucursalID == 0){
            sucursal = "0";
        }
        
        if(sucursalID == 1){
            sucursal = "SC01";
        }
        
        if(sucursalID == 2){
            sucursal = "SC02";
        }
        
        if(sucursalID == 3){
            sucursal = "SC03";
        }
        
        if(sucursalID == 4){
            sucursal = "SC04";
        }
        
        if(sucursalID == 5){
            sucursal = "SC05";
        }
        
        if(sucursalID == 6){
            sucursal = "SC06";
        }
        
        return sucursal;
    }
    
    private void btnGenerarSalidaI3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarSalidaI3ActionPerformed
        try {
            Conexion con = new Conexion();

            Connection conn = con.getConnect();

            JasperReport reporte = null;
            String path = "src\\Reportes\\rExistenciasPorCategoria.jasper";

            Map parametro = new HashMap();

            String sucursal = SucursalSelected(cbSucursalEC.getSelectedIndex());
            
            parametro.put("SucursalID", sucursal);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(view.DISPOSE_ON_CLOSE);

            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pnlRExisCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarSalidaI3ActionPerformed

    private void btnGenerarGraficoECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarGraficoECActionPerformed
        
    }//GEN-LAST:event_btnGenerarGraficoECActionPerformed

    private void cbSucursalGECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSucursalGECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSucursalGECActionPerformed

    private void graficoEC(){
        try {
            String sucursal = SucursalSeleccionada(cbSucursalGEC.getSelectedIndex());

            ControlReportes grafico = new ControlReportes();
            
            CategoryDataset dataset = grafico.getDataset(sucursal);
            JFreeChart chart = grafico.createChart(dataset);

            CategoryPlot plot = chart.getCategoryPlot();
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(1160, 520));
            
            pnlGraficoEC.setLayout(new BorderLayout());
            pnlGraficoEC.add(chartPanel, BorderLayout.NORTH);
            
            btnGenerarGraficoEC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String newSucursal = SucursalSeleccionada(cbSucursalGEC.getSelectedIndex());
                        //int newSucursalID = cbSucursalGEC.getSelectedIndex(); // Coloca aquí el nuevo número de sucursal deseado

                        CategoryDataset newDataset = grafico.getDataset(newSucursal);

                        JFreeChart newChart = grafico.createChart(newDataset);
                        chartPanel.setChart(newChart); // Actualiza el gráfico en el ChartPanel

                        CategoryPlot plot = newChart.getCategoryPlot();
                        CategoryAxis domainAxis = plot.getDomainAxis();
                        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
                        domainAxis.setCategoryMargin(0.35);

                        chartPanel.repaint();
                    } catch (SQLException ex) {
                        Logger.getLogger(pnlRExisCategoria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private metodos.MyButton btnGenerarGraficoEC;
    private metodos.MyButton btnGenerarSalidaI3;
    private javax.swing.JComboBox<String> cbSucursalEC;
    private javax.swing.JComboBox<String> cbSucursalGEC;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel lblExistenciaCategoria;
    private javax.swing.JPanel pnlGraficoEC;
    public javax.swing.JPanel pnlexist;
    private javax.swing.JTable tblExistenciaPorCategoria;
    // End of variables declaration//GEN-END:variables
}
