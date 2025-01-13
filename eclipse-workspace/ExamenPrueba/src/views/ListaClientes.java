package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import MainApp.App;
import models.Cliente;
/**
 * Dialogo que se encarga de listar los clientes que ya hay regitrados
 */
public class ListaClientes extends JDialog {
  //Atributos privados de la clase
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel tableModel; 
    private JTextField textFieldApellidos;
    private TableRowSorter<DefaultTableModel> sorter;

    public static void main(String[] args) {
        try {
            ListaClientes dialog = new ListaClientes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListaClientes() {
        setModal(true);
        setBounds(100, 100, 615, 386);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // Crear el modelo de la tabla
        String[] columnNames = {"Nombre", "Apellidos", "Fecha de Nacimiento", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0); 

        // Crear la tabla y envolverla en un JScrollPane
        table = new JTable(tableModel); 
        //para ordenar
        sorter = new TableRowSorter<>((DefaultTableModel)table.getModel());
        table.setRowSorter(sorter);
        JScrollPane scrollPane = new JScrollPane(table); 
        scrollPane.setBounds(10, 47, 581, 231); 
        contentPanel.add(scrollPane); 

        JLabel lblNewLabel = new JLabel("Listar Clientes");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setBackground(new Color(173, 216, 230));
        lblNewLabel.setForeground(new Color(0, 64, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 10, 581, 38);
        contentPanel.add(lblNewLabel);

        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtrarTabla();
            }
        });
        btnFiltrar.setBounds(364, 318, 85, 21);
        contentPanel.add(btnFiltrar);

        textFieldApellidos = new JTextField();
        textFieldApellidos.setBounds(258, 319, 96, 19);
        contentPanel.add(textFieldApellidos);
        textFieldApellidos.setColumns(10);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblApellido.setBounds(185, 322, 63, 13);
        contentPanel.add(lblApellido);

        // Actualiza la tabla con los datos de los clientes
        actualizarTabla();
    }

    private void actualizarTabla() {
        // Limpiar el modelo de la tabla antes de agregar nuevos datos
        tableModel.setRowCount(0); // Limpia el modelo antes de agregar filas

        // Iterar sobre los clientes y agregar los datos al modelo
        for (Cliente cliente : App.clientes) {
            String[] rowData = {
                cliente.getNombre(),
                cliente.getApellidos(),
                String.valueOf(cliente.getFechaNacimiento()), 
                cliente.getEmail()
            };
            tableModel.addRow(rowData); 
        }
    }

    private void filtrarTabla() {
        String apellidosFilter = textFieldApellidos.getText().toLowerCase();

        // Limpiar el modelo de la tabla
        tableModel.setRowCount(0);

        // Iterar sobre los clientes y agregar los que coincidan con los filtros
        for (Cliente cliente : App.clientes) {
            boolean matches = true;

            if (!apellidosFilter.isEmpty() && !cliente.getApellidos().toLowerCase().contains(apellidosFilter)) {
                matches = false;
            }

            if (matches) {
                String[] rowData = {
                    cliente.getNombre(),
                    cliente.getApellidos(),
                    String.valueOf(cliente.getFechaNacimiento()),
                    cliente.getEmail()
                };
                tableModel.addRow(rowData);
            }
        }
    }
}
