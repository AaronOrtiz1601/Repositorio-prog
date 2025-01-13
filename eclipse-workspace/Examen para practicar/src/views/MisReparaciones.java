package views;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import models.Citas;

public class MisReparaciones extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            MisReparaciones dialog = new MisReparaciones();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public MisReparaciones() {
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        // Etiqueta superior
        JLabel lblNewLabel = new JLabel("Mis reparaciones");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(lblNewLabel, BorderLayout.NORTH);

        // Modelo de tabla con las columnas especificadas
        String[] columnNames = {
            "Matrícula del coche", 
            "Fecha de la cita", 
            "Estado de la reparación", 
            "Importe (€)", 
            "Observaciones"
        };
         tableModel = new DefaultTableModel(columnNames, 0);

        // Crear la tabla y asignarle el modelo
        table = new JTable(tableModel);

        // Hacer que las columnas sean ordenables
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        // Añadir la tabla dentro de un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Botón en la parte inferior
        JButton btnNewButton = new JButton("Nuevo");
        contentPanel.add(btnNewButton, BorderLayout.SOUTH);
        rellenarTabla();
    }
    private void rellenarTabla() {
      
      for (Citas nuevaCita : Principal.getClienteActivo().getMisCitas()) {
        tableModel.addRow(new Object[]{nuevaCita.getMatricula(), nuevaCita.getFecha(), nuevaCita.getEstado(), nuevaCita.getImporte(),nuevaCita.getObervaciones()});
      }
    }
}
