package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import mainApp.MainApp; // Asegúrate de que puedes acceder a App.productos
import models.Producto;

public class ListarProductos extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField textFieldNombre, textFieldPrecio, textFieldPerecedero;

    /**
     * Create the panel.
     * @param layeredPane 
     */
    public ListarProductos(JLayeredPane layeredPane) {
        setLayout(new BorderLayout());

        // Crear el modelo de la tabla
        String[] columnNames = {"Nombre", "Precio", "Perecedero"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setBackground(new Color(0, 128, 192));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para los filtros
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayout(3, 2));

        // Campos de texto para los filtros
        filterPanel.add(new JLabel("Nombre:"));
        textFieldNombre = new JTextField();
        filterPanel.add(textFieldNombre);

        filterPanel.add(new JLabel("Precio:"));
        textFieldPrecio = new JTextField();
        filterPanel.add(textFieldPrecio);

        filterPanel.add(new JLabel("Perecedero (true/false):"));
        textFieldPerecedero = new JTextField();
        filterPanel.add(textFieldPerecedero);

        add(filterPanel, BorderLayout.NORTH);

        // Actualizar la tabla con los productos
        actualizarTabla();

        // Añadir listeners a los campos de texto para filtrar la tabla
        textFieldNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrarTabla();
            }
        });
        
        textFieldPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrarTabla();
            }
        });

        textFieldPerecedero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrarTabla();
            }
        });
    }

    private void actualizarTabla() {
        // Limpiar el modelo de la tabla antes de agregar nuevos datos
        tableModel.setRowCount(0);

        // Iterar sobre los productos y agregar los datos al modelo
        for (Producto producto : MainApp.productos) {
            String[] rowData = {
                producto.getNombre(),
                String.valueOf(producto.getPrecio()),
                String.valueOf(producto.isPerecedero())
            };
            tableModel.addRow(rowData);
        }
    }

    private void filtrarTabla() {
        String nombreFilter = textFieldNombre.getText().toLowerCase();
        String precioFilter = textFieldPrecio.getText();
        String perecederoFilter = textFieldPerecedero.getText().toLowerCase();

        // Limpiar el modelo de la tabla
        tableModel.setRowCount(0);

        // Iterar sobre los productos y agregar los que coincidan con los filtros
        for (Producto producto : MainApp.productos) {
            boolean matches = true;

            if (!nombreFilter.isEmpty() && !producto.getNombre().toLowerCase().contains(nombreFilter)) {
                matches = false;
            }
            if (!precioFilter.isEmpty()) {
                try {
                    double precio = Double.parseDouble(precioFilter);
                    if (producto.getPrecio() != precio) {
                        matches = false;
                    }
                } catch (NumberFormatException ex) {
                    matches = false;
                }
            }
            if (!perecederoFilter.isEmpty() && !String.valueOf(producto.isPerecedero()).equalsIgnoreCase(perecederoFilter)) {
                matches = false;
            }

            if (matches) {
                String[] rowData = {
                    producto.getNombre(),
                    String.valueOf(producto.getPrecio()),
                    String.valueOf(producto.isPerecedero())
                };
                tableModel.addRow(rowData);
            }
        }
    }
}
