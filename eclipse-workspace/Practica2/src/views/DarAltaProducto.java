package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import mainApp.MainApp;
import models.Producto;

public class DarAltaProducto extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField textNombreProducto; 
    private JTextField textPrecio; 
    private JCheckBox chckbxPerecedero; 
    private JPanel contentPanel;
    
    /**
     * Interfaz que se encarga del alta de los productos
     * @param layeredPane
     */
    public DarAltaProducto(JLayeredPane layeredPane) {
        setBackground(new Color(0, 128, 192));
        contentPanel = new JPanel(); 
        contentPanel.setBackground(new Color(0, 128, 192));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPanel);

        JLabel lblNombreProducto = new JLabel("Nombre del producto");
        textNombreProducto = new JTextField();
        textNombreProducto.setColumns(10);

        JLabel lblPrecioUnitario = new JLabel("Precio Unitario");
        textPrecio = new JTextField();
        textPrecio.setColumns(10);

        chckbxPerecedero = new JCheckBox("Es perecedero?");

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textNombreProducto.setText("");
                textPrecio.setText("");
                chckbxPerecedero.setSelected(false);
            }
        });

        JButton okButton = new JButton("Dar de alta");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreProducto = textNombreProducto.getText().trim();
                String precioTexto = textPrecio.getText().trim();
                boolean indicador = false;

                // Comprobaciones de validación
                if (nombreProducto.isEmpty() || precioTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa el nombre del producto.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el precio es un número positivo
                double precio;
                try {
                    precio = Double.parseDouble(precioTexto);
                    if (precio < 0) {
                        JOptionPane.showMessageDialog(null, "El precio debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar si el producto ya existe
                for (Producto producto : MainApp.productos) {
                    if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                        JOptionPane.showMessageDialog(null, "Ese producto ya existe.", "Ups", JOptionPane.INFORMATION_MESSAGE);
                        indicador = true;
                        break;
                    }
                }

                // Crear un nuevo objeto Producto y agregarlo a la lista
                if (!indicador) {
                    boolean esPerecedero = chckbxPerecedero.isSelected();
                    Producto nuevoProducto = new Producto(nombreProducto, precio, esPerecedero);
                    MainApp.productos.add(nuevoProducto);

                    // Mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Establecer el GroupLayout
        GroupLayout groupLayout = new GroupLayout(contentPanel);
        contentPanel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true); 

        // Configurar el GroupLayout
        groupLayout.setHorizontalGroup(
            groupLayout.createSequentialGroup()
                .addGap(50) 
                .addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
                    .addComponent(lblNombreProducto)
                    .addComponent(textNombreProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioUnitario)
                    .addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(chckbxPerecedero)
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(ComponentPlacement.UNRELATED) 
                        .addComponent(cancelButton)))
                .addGap(50) 
        );

        groupLayout.setVerticalGroup(
            groupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreProducto)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(textNombreProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(lblPrecioUnitario)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(chckbxPerecedero)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
