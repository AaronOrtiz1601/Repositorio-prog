package views;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
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

public class EliminarCliente extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField textNombre; 
    private JTextField textApellidos; 
    private JPanel contentPanel;
    /**
     * Interfaz que se encarga de eliminar los clientes
     * @param layeredPane
     */
    public EliminarCliente(JLayeredPane layeredPane) {
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

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            textNombre.setText("");
            textApellidos.setText("");
          }
        });
        JButton okButton = new JButton("Eliminar Cliente");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textNombre.getText();
                String apellidos = textApellidos.getText();
                boolean clienteEncontrado = false;

                // Recorrer la lista de clientes
                for (Cliente cliente : MainApp.clientes) {
                    // Comprobar si el cliente tiene el mismo nombre y apellidos
                    if (cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellidos)) {
                   // Marca que se encontró el cliente  
                      clienteEncontrado = true; 
                        // Eliminar el cliente de la lista
                        MainApp.clientes.remove(cliente);
                     // Salimos del bucle ya que se ha encontrado y eliminado el cliente
                        break; 
                    }
                }

                // Mensaje si no se encontró el cliente
                if (!clienteEncontrado) {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese nombre y apellidos", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Establecer el GroupLayout
        GroupLayout groupLayout = new GroupLayout(contentPanel);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(120)
                    .addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
                        .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblApellidos)
                        .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre)))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(50)
                    .addComponent(okButton)
                    .addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                    .addComponent(cancelButton)
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(lblNombre)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(lblApellidos)
                    .addGap(18)
                    .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(36)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(okButton)
                        .addComponent(cancelButton))
                    .addContainerGap())
        );
        contentPanel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
    }
}
