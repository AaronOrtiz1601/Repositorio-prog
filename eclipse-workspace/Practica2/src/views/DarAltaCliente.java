package views;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import mainApp.MainApp;
import models.Cliente;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import java.util.Calendar;

public class DarAltaCliente extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField textNombre; 
    private JTextField textApellidos; 
    private JPanel contentPanel; 
    private JDateChooser dateChooser; 
    /**
     * Interfaz que se encarga del alta de clientes
     * @param layeredPane
     */
    public DarAltaCliente(JLayeredPane layeredPane) {
        setBackground(new Color(0, 128, 192));
        contentPanel = new JPanel(); 
        contentPanel.setBackground(new Color(0, 128, 192));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPanel);

        JLabel lblNombre = new JLabel("Nombre");
        textNombre = new JTextField();
        textNombre.setColumns(10);

        JLabel lblApellidos = new JLabel("Apellidos");
        textApellidos = new JTextField();
        textApellidos.setColumns(10);

        JLabel lblEdad = new JLabel("Fecha de Nacimiento");

        String[] provincias = {"Málaga", "Granada", "Huelva", "Córdoba", "Jaén", "Almería", "Cádiz", "Sevilla"};
        JComboBox<String> comboBox = new JComboBox<>(provincias);
        
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textNombre.setText("");
                textApellidos.setText("");
                comboBox.setSelectedIndex(0); 
                dateChooser.setDate(null); 
            }
        });

        JButton okButton = new JButton("Dar de alta");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textNombre.getText().trim();
                String apellidos = textApellidos.getText().trim();
                String provincia = (String) comboBox.getSelectedItem(); // Obtener la provincia seleccionada
                boolean clienteEncontrado = false;

                // Comprobar que todos los campos están completos
                if (nombre.isEmpty() || apellidos.isEmpty() || dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Calcular la edad a partir de la fecha de nacimiento seleccionada
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateChooser.getDate());
                int edad = Calendar.getInstance().get(Calendar.YEAR) - calendar.get(Calendar.YEAR);

                // Comprobar si la fecha de nacimiento es posterior a la fecha actual
                if (calendar.get(Calendar.MONTH) > Calendar.getInstance().get(Calendar.MONTH) ||
                        (calendar.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH) &&
                        calendar.get(Calendar.DAY_OF_MONTH) > Calendar.getInstance().get(Calendar.DAY_OF_MONTH))) {
               // Reducir la edad si aún no ha cumplido años este año
                    edad--; 
                }

                // Recorrer la lista de clientes
                for (Cliente cliente : MainApp.clientes) {
                    // Comprobar si el cliente tiene el mismo nombre y apellidos
                    if (cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellidos)) {
                      // Marca que se encontró el cliente
                        clienteEncontrado = true; 
                     // Salimos del bucle ya que se ha encontrado el cliente
                        break; 
                    }
                }

                // Mensaje si se encontró o no el cliente
                if (clienteEncontrado) {
                    JOptionPane.showMessageDialog(null, "El cliente ya existe", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Crear y agregar el nuevo cliente a la lista
                    Cliente nuevoCliente = new Cliente(nombre, apellidos, edad, provincia);
                    MainApp.clientes.add(nuevoCliente);

                    // Mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Cliente dado de alta correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
                textNombre.setText("");
                textApellidos.setText("");
                comboBox.setSelectedIndex(0); 
                dateChooser.setDate(null); 
            }
        });
     // Inicializar JDateChooser

        dateChooser = new JDateChooser(); 

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
                    .addComponent(lblNombre)
                    .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos)
                    .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad)
                    .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(ComponentPlacement.UNRELATED) 
                        .addComponent(cancelButton)))
                .addGap(50) 
        );

        groupLayout.setVerticalGroup(
            groupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(lblApellidos)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(lblEdad)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
