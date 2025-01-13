package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import mainApp.MainApp; // Asegúrate de que puedes acceder a App.clientes
import models.Cliente;

public class ListarClientes extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField textFieldNombre, textFieldApellidos, textFieldEdad, textFieldProvincia;

    /**
     * Create the panel.
     * @param layeredPane 
     */
    public ListarClientes(JLayeredPane layeredPane) {
        setLayout(new BorderLayout());

        // Crear el modelo de la tabla
        String[] columnNames = {"Nombre", "Apellidos", "Edad", "Provincia"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setBackground(new Color(0, 128, 192));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para los filtros
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayout(4, 2));

        // Campos de texto para los filtros
        JLabel label = new JLabel("Nombre:");
        label.setBackground(new Color(0, 128, 192));
        filterPanel.add(label);
        textFieldNombre = new JTextField();
        filterPanel.add(textFieldNombre);

        filterPanel.add(new JLabel("Apellidos:"));
        textFieldApellidos = new JTextField();
        filterPanel.add(textFieldApellidos);

        filterPanel.add(new JLabel("Edad:"));
        textFieldEdad = new JTextField();
        filterPanel.add(textFieldEdad);

        filterPanel.add(new JLabel("Provincia:"));
        textFieldProvincia = new JTextField();
        filterPanel.add(textFieldProvincia);

        add(filterPanel, BorderLayout.NORTH);

        // Actualizar la tabla con los clientes
        actualizarTabla();

        // Añadir listeners a los campos de texto para filtrar la tabla
        textFieldNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrarTabla();
            }
        });
        
        textFieldApellidos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrarTabla();
            }
        });

        textFieldEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrarTabla();
            }
        });

        textFieldProvincia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrarTabla();
            }
        });
    }

    private void actualizarTabla() {
        // Limpiar el modelo de la tabla antes de agregar nuevos datos
        tableModel.setRowCount(0);

        // Iterar sobre los clientes y agregar los datos al modelo
        for (Cliente cliente : MainApp.clientes) {
            String[] rowData = {
                cliente.getNombre(),
                cliente.getApellido(),
                String.valueOf(cliente.getEdad()),
                cliente.getProvincia()
            };
            tableModel.addRow(rowData);
        }
    }

    private void filtrarTabla() {
        String nombreFilter = textFieldNombre.getText().toLowerCase();
        String apellidosFilter = textFieldApellidos.getText().toLowerCase();
        String edadFilter = textFieldEdad.getText();
        String provinciaFilter = textFieldProvincia.getText().toLowerCase();

        // Limpiar el modelo de la tabla
        tableModel.setRowCount(0);

        // Iterar sobre los clientes y agregar los que coincidan con los filtros
        for (Cliente cliente : MainApp.clientes) {
            boolean matches = true;

            if (!nombreFilter.isEmpty() && !cliente.getNombre().toLowerCase().contains(nombreFilter)) {
                matches = false;
            }
            if (!apellidosFilter.isEmpty() && !cliente.getApellido().toLowerCase().contains(apellidosFilter)) {
                matches = false;
            }
            if (!edadFilter.isEmpty() && cliente.getEdad() != Integer.parseInt(edadFilter)) {
                matches = false;
            }
            if (!provinciaFilter.isEmpty() && !cliente.getProvincia().toLowerCase().contains(provinciaFilter)) {
                matches = false;
            }

            if (matches) {
                String[] rowData = {
                    cliente.getNombre(),
                    cliente.getApellido(),
                    String.valueOf(cliente.getEdad()),
                    cliente.getProvincia()
                };
                tableModel.addRow(rowData);
            }
        }
    }
}
