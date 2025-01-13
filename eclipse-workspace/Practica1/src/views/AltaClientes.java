package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner; // Asegúrate de importar esta clase
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel; // Asegúrate de importar esta clase
import javax.swing.border.EmptyBorder;

import mainApp.App;
import models.Clientes;

public class AltaClientes extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textNombre;
    private JTextField textApellidos;
    private JSpinner spinnerEdad; 

    public AltaClientes() {
        setModal(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        JLabel lblNombre = new JLabel("Nombre");
        textNombre = new JTextField();
        textNombre.setColumns(10);
        
        JLabel lblApellidos = new JLabel("Apellidos");
        textApellidos = new JTextField();
        textApellidos.setColumns(10);

        JLabel lblEdad = new JLabel("Edad");
        // Configuración del JSpinner para la edad
        spinnerEdad = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1)); 

        String[] provincias = {"Málaga", "Granada", "Huelva", "Córdoba", "Jaén", "Almería", "Cádiz", "Sevilla"};
        JComboBox<String> comboBox = new JComboBox<>(provincias);

        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
            gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPanel.createSequentialGroup()
                    .addGap(32)
                    .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNombre)
                        .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEdad)
                        .addComponent(spinnerEdad, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)) // Cambiado aquí
                    .addGap(50)
                    .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblApellidos)
                        .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(32, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
            gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPanel.createSequentialGroup()
                    .addGap(23)
                    .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNombre)
                        .addComponent(lblApellidos))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblEdad)
                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(spinnerEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) // Cambiado aquí
                    .addContainerGap(101, Short.MAX_VALUE))
        );
        contentPanel.setLayout(gl_contentPanel);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        /**
         * Metodo para dar de alta
         */
        JButton okButton = new JButton("Dar de alta");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean avisador = false;
                
                // Comprobar si el cliente ya existe
                for (int i = 0; i < App.clientes.size(); i++) {
                    if (App.clientes.get(i).getNombre().equals(textNombre.getText()) && 
                        App.clientes.get(i).getApellido().equals(textApellidos.getText())) {
                        avisador = true;
                    } 
                }
                //Comprobamos si los campos estan vacios
                if (textNombre.getText().equals("") || textApellidos.getText().equals("")) {
                    avisador = true;
                }
                
                // Si no existe, agregar el cliente
                if (!avisador) { 
                    // Cambia el método de obtención de edad a un valor entero
                    int edad = (Integer) spinnerEdad.getValue(); 
                    Clientes cliente = new Clientes(textNombre.getText(), textApellidos.getText(), String.valueOf(edad), (String) comboBox.getSelectedItem());
                    App.clientes.add(cliente); // Agregar cliente a la lista
                    JOptionPane.showMessageDialog(null, "Cliente agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Ups...Algo ha salido mal, vuelve a intentarlo", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                dispose();
            }
        });

        buttonPane.add(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana sin hacer nada
            }
        });
        buttonPane.add(cancelButton);
    }
}
