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
import paneles.pnlReportes;

public class pnlRProduCaduc extends javax.swing.JPanel {

    ControlReportes re = new ControlReportes();
    public pnlRProduCaduc() throws SQLException {
        initComponents();
        re.LlenarTablaProductosProximosCaducar(tblProductosProximosCaducar, cbSucursalPPC.getSelectedIndex());
        re.RellenarComboSucursal("Sucursal", "Ciudad", cbSucursalPPC);
        autoResizeColumn(tblProductosProximosCaducar);
        re.actualizarFecha(lblProductosProximosCaducar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlcaducado = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductosProximosCaducar = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        lblProductosProximosCaducar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbSucursalPPC = new javax.swing.JComboBox<>();
        btnGenerarReportePPC = new metodos.MyButton();

        setMinimumSize(new java.awt.Dimension(1235, 720));
        setPreferredSize(new java.awt.Dimension(1235, 720));

        pnlcaducado.setMinimumSize(new java.awt.Dimension(1230, 720));
        pnlcaducado.setPreferredSize(new java.awt.Dimension(1230, 720));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductosProximosCaducar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblProductosProximosCaducar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductosProximosCaducar.setEnabled(false);
        jScrollPane2.setViewportView(tblProductosProximosCaducar);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1200, 490));

        jPanel18.setBackground(new java.awt.Color(99, 169, 229));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Fecha de Emisión:");

        lblProductosProximosCaducar.setBackground(new java.awt.Color(255, 255, 255));
        lblProductosProximosCaducar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblProductosProximosCaducar.setForeground(new java.awt.Color(255, 255, 255));
        lblProductosProximosCaducar.setText("jLabel26");

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Reporte de productos próximos a caducar");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Seleccionar Sucursal:");

        cbSucursalPPC.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbSucursalPPC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar todas las sucursales" }));
        cbSucursalPPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSucursalPPCActionPerformed(evt);
            }
        });

        btnGenerarReportePPC.setBackground(new java.awt.Color(19, 102, 217));
        btnGenerarReportePPC.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReportePPC.setText("Descargar");
        btnGenerarReportePPC.setBorderColor(new java.awt.Color(19, 102, 217));
        btnGenerarReportePPC.setColor(new java.awt.Color(19, 102, 217));
        btnGenerarReportePPC.setColorClick(new java.awt.Color(19, 102, 217));
        btnGenerarReportePPC.setColorOver(new java.awt.Color(66, 139, 225));
        btnGenerarReportePPC.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        btnGenerarReportePPC.setRadius(10);
        btnGenerarReportePPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReportePPCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProductosProximosCaducar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSucursalPPC, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReportePPC, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(lblProductosProximosCaducar))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbSucursalPPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(btnGenerarReportePPC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );

        jPanel3.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1200, 120));

        javax.swing.GroupLayout pnlcaducadoLayout = new javax.swing.GroupLayout(pnlcaducado);
        pnlcaducado.setLayout(pnlcaducadoLayout);
        pnlcaducadoLayout.setHorizontalGroup(
            pnlcaducadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcaducadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlcaducadoLayout.setVerticalGroup(
            pnlcaducadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcaducadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlcaducado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlcaducado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbSucursalPPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSucursalPPCActionPerformed
        try {
            re.LlenarTablaProductosProximosCaducar(tblProductosProximosCaducar, cbSucursalPPC.getSelectedIndex());
        } catch (SQLException ex) {
            Logger.getLogger(pnlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbSucursalPPCActionPerformed

    public String SucursalSelected(int sucursalID) {
        String sucursal = "";

        if (sucursalID == 0) {
            sucursal = "0";
        }

        if (sucursalID == 1) {
            sucursal = "'SC01'";
        }

        if (sucursalID == 2) {
            sucursal = "'SC02'";
        }

        if (sucursalID == 3) {
            sucursal = "'SC03'";
        }

        if (sucursalID == 4) {
            sucursal = "'SC04'";
        }

        if (sucursalID == 5) {
            sucursal = "'SC05'";
        }

        if (sucursalID == 6) {
            sucursal = "'SC06'";
        }

        return sucursal;
    }
    
    private void btnGenerarReportePPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReportePPCActionPerformed
        try {
            Conexion con = new Conexion();

            Connection conn = con.getConnect();

            JasperReport reporte = null;
            String path = "src\\Reportes\\ProductosProximosCaducar.jasper";

            Map parametro = new HashMap();

            String sucursal = SucursalSelected(cbSucursalPPC.getSelectedIndex());
            
            parametro.put("SucursalID", sucursal);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(view.DISPOSE_ON_CLOSE);

            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pnlRProduCaduc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarReportePPCActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private metodos.MyButton btnGenerarReportePPC;
    private javax.swing.JComboBox<String> cbSucursalPPC;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblProductosProximosCaducar;
    public javax.swing.JPanel pnlcaducado;
    private javax.swing.JTable tblProductosProximosCaducar;
    // End of variables declaration//GEN-END:variables
}
