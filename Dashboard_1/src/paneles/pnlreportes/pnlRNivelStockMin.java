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
import principal.Principal;

public class pnlRNivelStockMin extends javax.swing.JPanel {

    ControlReportes re = new ControlReportes();
    Principal pr = new Principal();
    public pnlRNivelStockMin() throws SQLException {
        initComponents();
        re.LlenarTablaStockMinimo(stockMinimo, cbSucursal.getSelectedIndex());
        re.RellenarComboSucursal("Sucursal", "Ciudad", cbSucursal);
        re.RellenarComboSucursal("Sucursal", "Ciudad", cbSucursalGSM);
        autoResizeColumn(stockMinimo);
        re.actualizarFecha(lblStockMinimo);
        
        graficoStockMinimo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlstockmin = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockMinimo = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lblStockMinimo = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbSucursal = new javax.swing.JComboBox<>();
        btnGenerarSalidaI2 = new metodos.MyButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        pnlStockMinimo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbSucursalGSM = new javax.swing.JComboBox<>();
        btnGenerarGraficoSM = new metodos.MyButton();
        jLabel20 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1235, 740));
        setPreferredSize(new java.awt.Dimension(1235, 740));

        pnlstockmin.setMinimumSize(new java.awt.Dimension(1230, 720));
        pnlstockmin.setPreferredSize(new java.awt.Dimension(1230, 720));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(1196, 590));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stockMinimo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        stockMinimo.setModel(new javax.swing.table.DefaultTableModel(
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
        stockMinimo.setEnabled(false);
        jScrollPane1.setViewportView(stockMinimo);

        jPanel11.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 1180, 450));

        jPanel21.setBackground(new java.awt.Color(99, 169, 229));

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Fecha de Emisión:");

        lblStockMinimo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblStockMinimo.setForeground(new java.awt.Color(255, 255, 255));
        lblStockMinimo.setText("jLabel26");

        jLabel19.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Reporte de nivel de stock mínimo");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Seleccionar Sucursal:");

        cbSucursal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cbSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar todas las sucursales" }));
        cbSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSucursalActionPerformed(evt);
            }
        });

        btnGenerarSalidaI2.setBackground(new java.awt.Color(19, 102, 217));
        btnGenerarSalidaI2.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarSalidaI2.setText("Descargar");
        btnGenerarSalidaI2.setBorderColor(new java.awt.Color(19, 102, 217));
        btnGenerarSalidaI2.setColor(new java.awt.Color(19, 102, 217));
        btnGenerarSalidaI2.setColorClick(new java.awt.Color(19, 102, 217));
        btnGenerarSalidaI2.setColorOver(new java.awt.Color(66, 139, 225));
        btnGenerarSalidaI2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        btnGenerarSalidaI2.setRadius(10);
        btnGenerarSalidaI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarSalidaI2ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesReportes/Logo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel19)
                        .addGap(158, 158, 158)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStockMinimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerarSalidaI2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(jLabel3)
                .addGap(48, 48, 48))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblStockMinimo))
                .addGap(15, 15, 15))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnGenerarSalidaI2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1190, 150));

        jTabbedPane3.addTab("Reporte Tipo Tabla", jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(1196, 630));

        javax.swing.GroupLayout pnlStockMinimoLayout = new javax.swing.GroupLayout(pnlStockMinimo);
        pnlStockMinimo.setLayout(pnlStockMinimoLayout);
        pnlStockMinimoLayout.setHorizontalGroup(
            pnlStockMinimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlStockMinimoLayout.setVerticalGroup(
            pnlStockMinimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        jLabel4.setText("Seleccionar Sucursal:");

        cbSucursalGSM.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        cbSucursalGSM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar todas las sucursales" }));
        cbSucursalGSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSucursalGSMActionPerformed(evt);
            }
        });

        btnGenerarGraficoSM.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarGraficoSM.setText("Mostrar Gráfica");
        btnGenerarGraficoSM.setBorderColor(new java.awt.Color(102, 160, 255));
        btnGenerarGraficoSM.setColor(new java.awt.Color(102, 160, 255));
        btnGenerarGraficoSM.setColorClick(new java.awt.Color(19, 102, 217));
        btnGenerarGraficoSM.setColorOver(new java.awt.Color(183, 207, 255));
        btnGenerarGraficoSM.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        btnGenerarGraficoSM.setRadius(10);
        btnGenerarGraficoSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarGraficoSMActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(99, 169, 229));
        jLabel20.setText("Nivel de stock mínimo");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(pnlStockMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSucursalGSM, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnGenerarGraficoSM, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSucursalGSM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnGenerarGraficoSM, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Grafica", jPanel12);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlstockminLayout = new javax.swing.GroupLayout(pnlstockmin);
        pnlstockmin.setLayout(pnlstockminLayout);
        pnlstockminLayout.setHorizontalGroup(
            pnlstockminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlstockminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnlstockminLayout.setVerticalGroup(
            pnlstockminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlstockminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlstockmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlstockmin, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSucursalActionPerformed
        try {
            re.LlenarTablaStockMinimo(stockMinimo, cbSucursal.getSelectedIndex());
            graficoStockMinimo();
        } catch (SQLException ex) {
            Logger.getLogger(pnlRNivelStockMin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbSucursalActionPerformed

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
        
        public String SucursalSeleccionada(int sucursalID) {
        String sucursal = "";

        if (sucursalID == 0) {
            sucursal = "0";
        }

        if (sucursalID == 1) {
            sucursal = "SC01";
        }

        if (sucursalID == 2) {
            sucursal = "SC02";
        }

        if (sucursalID == 3) {
            sucursal = "SC03";
        }

        if (sucursalID == 4) {
            sucursal = "SC04";
        }

        if (sucursalID == 5) {
            sucursal = "SC05";
        }

        if (sucursalID == 6) {
            sucursal = "SC06";
        }

        return sucursal;
    }
    
    private void btnGenerarSalidaI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarSalidaI2ActionPerformed
        try {
            Conexion con = new Conexion();

            Connection conn = con.getConnect();

            JasperReport reporte = null;
            String path = "src\\Reportes\\rStockMinimo.jasper";

            Map parametro = new HashMap();

            String sucursal = SucursalSelected(cbSucursal.getSelectedIndex());
            
            parametro.put("sucursal", sucursal);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(view.DISPOSE_ON_CLOSE);

            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pnlRNivelStockMin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarSalidaI2ActionPerformed

    private void cbSucursalGSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSucursalGSMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSucursalGSMActionPerformed

    private void btnGenerarGraficoSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarGraficoSMActionPerformed
        graficoStockMinimo();
    }//GEN-LAST:event_btnGenerarGraficoSMActionPerformed

    private void autoResizeColumn(JTable jTable1) {
        JTableHeader header = jTable1.getTableHeader();
        int rowCount = jTable1.getRowCount();

        final Enumeration columns = jTable1.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) jTable1.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(jTable1, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();

            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) jTable1.getCellRenderer(row, col).getTableCellRendererComponent(jTable1,
                        jTable1.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // this line is very important
            column.setWidth(width + jTable1.getIntercellSpacing().width);
        }
    }
    
    private void graficoStockMinimo() {
        String sucursalSM = SucursalSeleccionada(cbSucursalGSM.getSelectedIndex()); // Coloca aquí el número de sucursal deseado

        try {
            ControlReportes grafico = new ControlReportes();
            CategoryDataset dataset = grafico.getDatasetStockMinimo(sucursalSM);
            JFreeChart chart = grafico.createChartStockMinimo(dataset);

            // Rotar las etiquetas del eje x
            CategoryPlot plot = chart.getCategoryPlot();
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);   

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(1160, 590));

            pnlStockMinimo.setLayout(new BorderLayout());
            pnlStockMinimo.add(chartPanel, BorderLayout.NORTH);

            btnGenerarGraficoSM.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String newSucursalID = SucursalSeleccionada(cbSucursalGSM.getSelectedIndex()); // Coloca aquí el nuevo número de sucursal deseado

                        CategoryDataset newDataset = grafico.getDatasetStockMinimo(newSucursalID);

                        JFreeChart newChart = grafico.createChartStockMinimo(newDataset);
                        chartPanel.setChart(newChart); // Actualiza el gráfico en el ChartPanel

                        CategoryPlot plot = newChart.getCategoryPlot();
                        CategoryAxis domainAxis = plot.getDomainAxis();
                        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
                        domainAxis.setCategoryMargin(0.35);

                        chartPanel.repaint();
                    } catch (SQLException ex) {
                        Logger.getLogger(pnlRNivelStockMin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private metodos.MyButton btnGenerarGraficoSM;
    private metodos.MyButton btnGenerarSalidaI2;
    private javax.swing.JComboBox<String> cbSucursal;
    private javax.swing.JComboBox<String> cbSucursalGSM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblStockMinimo;
    private javax.swing.JPanel pnlStockMinimo;
    public javax.swing.JPanel pnlstockmin;
    public javax.swing.JTable stockMinimo;
    // End of variables declaration//GEN-END:variables
}
