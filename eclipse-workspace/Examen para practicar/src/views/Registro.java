package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import MainApp.App;
import models.Usuario;

public class Registro extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldNombre;
    private JTextField textFieldApellidos;
    private JTextField textFieldTelefono;
    private JTextField textFieldEmail;
    private JTextField textFieldContraseña;
    private JTextField textFieldConfirmarContraseña;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            Registro dialog = new Registro();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public Registro() {
        setModal(true);
        setBounds(100, 100, 486, 392);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(128, 255, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 20));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 64, 128));
        contentPanel.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("Registro Cliente");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        contentPanel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(0, 2, 0, 10));

        JLabel lblNewLabel_15 = new JLabel("Nombre");
        lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_15);

        textFieldNombre = new JTextField();
        panel_1.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lblNewLabel_13 = new JLabel("Apellidos");
        lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_13);

        textFieldApellidos = new JTextField();
        textFieldApellidos.setColumns(10);
        panel_1.add(textFieldApellidos);

        JLabel lblNewLabel_11 = new JLabel("Telefono");
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_11);

        textFieldTelefono = new JTextField();
        textFieldTelefono.setColumns(10);
        panel_1.add(textFieldTelefono);

        JLabel lblNewLabel_9 = new JLabel("Email");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_9);

        textFieldEmail = new JTextField();
        textFieldEmail.setColumns(10);
        panel_1.add(textFieldEmail);

        JLabel lblNewLabel_7 = new JLabel("Contraseña");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_7);

        textFieldContraseña = new JTextField();
        textFieldContraseña.setColumns(10);
        panel_1.add(textFieldContraseña);

        JLabel lblNewLabel_5 = new JLabel("Confirmar Contraseña");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_5);

        textFieldConfirmarContraseña = new JTextField();
        textFieldConfirmarContraseña.setColumns(10);
        panel_1.add(textFieldConfirmarContraseña);

        JLabel lblNewLabel_3 = new JLabel("Método de contacto");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_3);

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        panel_2.setLayout(new GridLayout(2, 1, 0, 0));

        // Crear RadioButtons
        JRadioButton rdbtnTelefono = new JRadioButton("Teléfono");
        JRadioButton rdbtnEmail = new JRadioButton("Email");

        // Agruparlos en un ButtonGroup
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnTelefono);
        group.add(rdbtnEmail);

        // Añadir RadioButtons al panel
        panel_2.add(rdbtnTelefono);
        panel_2.add(rdbtnEmail);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(128, 255, 255));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Registrar");
        okButton.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            // Validamos las contraseñas
            if (textFieldContraseña.getText().equals(textFieldConfirmarContraseña.getText())) {
              // Validamos que los campos no estén vacíos
              if (textFieldNombre.getText().isEmpty() || textFieldApellidos.getText().isEmpty() || 
                  textFieldEmail.getText().isEmpty() ||textFieldTelefono.getText().isEmpty() || textFieldContraseña.getText().isEmpty() || 
                  textFieldConfirmarContraseña.getText().isEmpty() || group.getSelection() == null) {
                  JOptionPane.showMessageDialog(null, "Rellena Todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
              }else {
                Usuario usuario = new Usuario (textFieldNombre.getText(),textFieldApellidos.getText(), textFieldEmail.getText(),textFieldContraseña.getText(),textFieldTelefono.getText(),group.getSelection().toString());
                boolean aviso = false;
                for (Usuario nuevoUsuario : App.clientes) {
                  if(nuevoUsuario.getEmail().equals(usuario.getEmail())) {
                    aviso = true;
                  }
                }
                if (aviso) {
                  JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese email", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                  JOptionPane.showMessageDialog(null, "Usuario creado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                  App.clientes.add(usuario);
                  dispose();
                }
              }
          }else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
          }}
          });

        buttonPane.add(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int response = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que quieres cancelar?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION
                );

                if (response == JOptionPane.YES_OPTION) {
                    // Vaciar todos los campos
                    textFieldNombre.setText("");
                    textFieldApellidos.setText("");
                    textFieldTelefono.setText("");
                    textFieldEmail.setText("");
                    textFieldContraseña.setText("");
                    textFieldConfirmarContraseña.setText("");
                    group.clearSelection();
                }
            }
        });
        buttonPane.add(cancelButton);
    }
}
