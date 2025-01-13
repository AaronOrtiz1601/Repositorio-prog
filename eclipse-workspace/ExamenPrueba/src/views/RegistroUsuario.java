package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import MainApp.App;
import models.Administracion; // Asegúrate de tener este modelo
import models.Cliente;
/**
 * Dialogo que se encarga del resgistro del usuario
 */
public class RegistroUsuario extends JDialog {

    //Atributos privados de la clase
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textEmail;
    private JTextField textContraseña;
    private JTextField textRepiteContraseña;
    private JComboBox<String> comboBox;

    public static void main(String[] args) {
        try {
            RegistroUsuario dialog = new RegistroUsuario();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistroUsuario() {
        setModal(true);
        setBounds(100, 100, 451, 567);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("Registro de usuario");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setBackground(new Color(0, 128, 192));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblNombre = new JLabel("Nombre");
        textNombre = new JTextField();
        textNombre.setColumns(10);

        JLabel lblApellidos = new JLabel("Apellidos");
        textApellido = new JTextField();
        textApellido.setColumns(10);

        JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento");
        JDateChooser dateChooser = new JDateChooser();

        JLabel lblPerfil = new JLabel("Perfil");
        String[] opciones = {"Cliente", "Administración"};
        comboBox = new JComboBox<>(opciones);

        JLabel lblEmail = new JLabel("Email");
        textEmail = new JTextField();
        textEmail.setColumns(10);

        JLabel lblContraseña = new JLabel("Contraseña");
        textContraseña = new JTextField();
        textContraseña.setColumns(10);

        JLabel lblRepiteContraseña = new JLabel("Repite contraseña");
        textRepiteContraseña = new JTextField();
        textRepiteContraseña.setColumns(10);

        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
            gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addGroup(gl_contentPanel.createSequentialGroup()
                    .addGap(49)
                    .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNombre)
                        .addComponent(lblApellidos)
                        .addComponent(lblFechaNacimiento)
                        .addComponent(lblPerfil)
                        .addComponent(lblEmail)
                        .addComponent(lblContraseña)
                        .addComponent(lblRepiteContraseña))
                    .addGap(56)
                    .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(textContraseña, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textApellido, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textRepiteContraseña, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(117))
        );
        gl_contentPanel.setVerticalGroup(
            gl_contentPanel.createSequentialGroup()
                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(18)
                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27)
                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(textApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(26)
                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(44)
                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblPerfil)
                    .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(33)
                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(52)
                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblContraseña)
                    .addComponent(textContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(61)
                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblRepiteContraseña)
                    .addComponent(textRepiteContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(70)
        );

        contentPanel.setLayout(gl_contentPanel);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Enviar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificamos si el tipo de usuario es Cliente o Administración
                if (comboBox.getSelectedIndex() == 0) { 
                    // Validamos las contraseñas
                    if (textContraseña.getText().equals(textRepiteContraseña.getText())) {
                        // Validamos que los campos no estén vacíos
                        if (textNombre.getText().isEmpty() || textApellido.getText().isEmpty() || 
                            textEmail.getText().isEmpty() || textContraseña.getText().isEmpty() || 
                            textRepiteContraseña.getText().isEmpty() || dateChooser.getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Rellena Todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Creamos el nuevo cliente
                            Cliente cliente = new Cliente(textNombre.getText(), textApellido.getText(), dateChooser.getDate(), textEmail.getText(), textContraseña.getText());
                            boolean indicador = true;

                            // Verificamos si el cliente ya existe
                            for (Cliente nuevoCliente : App.clientes) {
                                if (nuevoCliente.getNombre().equals(cliente.getNombre()) && 
                                    nuevoCliente.getApellidos().equals(cliente.getApellidos())) {
                                    JOptionPane.showMessageDialog(null, "Ha habido un error, ese cliente ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                                    indicador = false;
                                    break; 
                                }
                            }

                            if (indicador) {
                                App.clientes.add(cliente);
                                JOptionPane.showMessageDialog(null, "Cliente añadido con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                dispose(); 
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (comboBox.getSelectedIndex() == 1) { 
                    // Validamos las contraseñas
                    if (textContraseña.getText().equals(textRepiteContraseña.getText())) {
                        // Validamos que los campos no estén vacíos
                        if (textNombre.getText().isEmpty() || textApellido.getText().isEmpty() || 
                            textEmail.getText().isEmpty() || textContraseña.getText().isEmpty() || 
                            textRepiteContraseña.getText().isEmpty() || dateChooser.getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Rellena Todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Creamos el nuevo administrador
                            Administracion admin = new Administracion(textNombre.getText(), textApellido.getText(), dateChooser.getDate(), textEmail.getText(), textContraseña.getText());
                            boolean indicador = true;

                            // Verificamos si el administrador ya existe
                            for (Administracion nuevoAdmin : App.admins) {
                                if (nuevoAdmin.getNombre().equals(admin.getNombre()) && 
                                    nuevoAdmin.getApellidos().equals(admin.getApellidos())) {
                                    JOptionPane.showMessageDialog(null, "Ha habido un error, ese administrador ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                                    indicador = false;
                                    break; 
                                }
                            }

                            if (indicador) {
                                App.admins.add(admin);
                                JOptionPane.showMessageDialog(null, "Administrador añadido con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                dispose(); 
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(cancelButton);
    }
}
