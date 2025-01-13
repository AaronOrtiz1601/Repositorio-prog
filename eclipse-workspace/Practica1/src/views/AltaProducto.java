package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mainApp.App;
import models.Productos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaProducto extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textNombreProducto;
    private JTextField textPrecio;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AltaProducto dialog = new AltaProducto();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AltaProducto() {
        setModal(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNombreProducto = new JLabel("Nombre del producto");
        lblNombreProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNombreProducto.setBounds(145, 25, 130, 13);
        contentPanel.add(lblNombreProducto);

        textNombreProducto = new JTextField();
        textNombreProducto.setBounds(155, 48, 96, 19);
        contentPanel.add(textNombreProducto);
        textNombreProducto.setColumns(10);

        JLabel lblPrecioUnitario = new JLabel("Precio Unitario");
        lblPrecioUnitario.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPrecioUnitario.setBounds(145, 77, 130, 13);
        contentPanel.add(lblPrecioUnitario);

        textPrecio = new JTextField();
        textPrecio.setColumns(10);
        textPrecio.setBounds(155, 100, 96, 19);
        contentPanel.add(textPrecio);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Es perecedero?");
        chckbxNewCheckBox.setBounds(145, 142, 117, 21);
        contentPanel.add(chckbxNewCheckBox);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Dar de alta");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nombreProducto = textNombreProducto.getText().trim();
                        String precioTexto = textPrecio.getText().trim();
                        boolean indicador = false;

                        // Comprobaciones de validación
                        if (nombreProducto.isEmpty() || precioTexto.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Por favor, ingresa el nombre del producto.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                  
                       

                        // Validar que el precio es un número positivo
                        double precio;
                       
                            precio = Double.parseDouble(precioTexto);
                            if (precio < 0) {
                              JOptionPane.showMessageDialog(null, "El precio debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE); 
                              indicador = true;
                               
                            }
                        

                        // Verificar si el producto ya existe
                        for (int i = 0; i < App.productos.size(); i++) {
                            if (App.productos.get(i).getNombre().equalsIgnoreCase(nombreProducto)) {
                                JOptionPane.showMessageDialog(null, "Ese producto ya existe.", "Ups", JOptionPane.INFORMATION_MESSAGE);
                                indicador = true;
                                
                            }
                        }

                        // Crear un nuevo objeto Producto y agregarlo a la lista
                        boolean esPerecedero = chckbxNewCheckBox.isSelected();
                        Productos nuevoProducto = new Productos(nombreProducto, precio, esPerecedero);
                     // Agregar el producto a la lista
                        if (!indicador) {
                        App.productos.add(nuevoProducto); 

                        // Mensaje de éxito
                        JOptionPane.showMessageDialog(null, "Producto agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                     // Cierra el diálogo
                        dispose(); 
                        }
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancelar");
                cancelButton.setActionCommand("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                      //Cerramos la ventana cancelando las operaciones
                        dispose();
                    }
                });
                buttonPane.add(cancelButton);
            }
        }
    }
}
