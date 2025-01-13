package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mainApp.App;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaClientes extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textNombre;
    private JTextField textApellido;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            BajaClientes dialog = new BajaClientes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public BajaClientes() {
        setModal(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(199, 31, 90, 13);
        contentPanel.add(lblNewLabel);
        
        textNombre = new JTextField();
        textNombre.setBounds(177, 54, 96, 19);
        contentPanel.add(textNombre);
        textNombre.setColumns(10);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblApellido.setBounds(199, 83, 90, 13);
        contentPanel.add(lblApellido);
        
        textApellido = new JTextField();
        textApellido.setColumns(10);
        textApellido.setBounds(177, 102, 96, 19);
        contentPanel.add(textApellido);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton okButton = new JButton("Dar de baja");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textNombre.getText();
                String apellido = textApellido.getText();
             // Bandera para verificar si el cliente existe
                boolean clienteEncontrado = false; 

                for (int i = 0; i < App.clientes.size(); i++) {
                    if (nombre.equals(App.clientes.get(i).getNombre()) && apellido.equals(App.clientes.get(i).getApellido())) {
                        // Cliente encontrado, preguntar si quiere eliminarlo
                        int confirmacion = JOptionPane.showConfirmDialog(null, "Cliente encontrado. ¿Seguro que quieres darlo de baja?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (confirmacion == JOptionPane.YES_OPTION) {
                            // Si el usuario confirma, eliminar el cliente
                            App.clientes.remove(i);
                            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // Si el usuario cancela, informa que la operación ha sido cancelada
                            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Cancelación", JOptionPane.INFORMATION_MESSAGE);
                        }
                     // Marcamos que el cliente fue encontrado
                        clienteEncontrado = true; 
                        dispose(); 
                    }
                }

                // Si después de todo el bucle no se encontró el cliente
                if (!clienteEncontrado) {
                    JOptionPane.showMessageDialog(null, "No existe ningún cliente con ese nombre y apellido.", "Ups...", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }
}
