package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import MainApp.App;
import models.Cliente;
/**
 * Clase que se encarga del inicio de sesion y del registro
 */
public class Principal extends JFrame {
  
    private JTextField textUsuario;
    private JPasswordField textContraseña;
    private static Cliente clienteActivo; 

    public static Cliente getClienteActivo() {
        return clienteActivo;
    }
    public Principal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        getContentPane().setBackground(new Color(173, 216, 222));
        setBounds(100, 100, 885, 501);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lblNewLabel = new JLabel("GYM PICASSO");
        lblNewLabel.setOpaque(true); 
        lblNewLabel.setBackground(new Color(173, 216, 230)); 
        lblNewLabel.setForeground(new Color(0, 64, 128));
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/resources/logoApp.png")));
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblNewLabel_1 = new JLabel("Bienvenido a la aplicación Gym Picasso");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setBackground(new Color(0, 128, 192));
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/resources/imgLogin.png")));
        
        JLabel lblNewLabel_3 = new JLabel("Usuario");
        
        textUsuario = new JTextField();
        textUsuario.setColumns(10);
        
        JLabel lblNewLabel_3_1 = new JLabel("Contraseña");
        
        textContraseña = new JPasswordField();
        textContraseña.setColumns(10);
        
        JButton btnNewButton = new JButton("Iniciar Sesión");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textUsuario.getText();
                String contraseña = new String(textContraseña.getPassword());
                boolean accesoConcedido = false;
                
                // Verificar en clientes
                for (int i = 0; i < App.clientes.size(); i++) {
                    if (usuario.equals(App.clientes.get(i).getNombre()) && contraseña.equals(App.clientes.get(i).getContraseña())) {
                      clienteActivo = App.clientes.get(i);
                      JOptionPane.showMessageDialog(null, "Hola de nuevo " + usuario, "Bienvenido de nuevo", JOptionPane.INFORMATION_MESSAGE);
                        SesionCliente ventana = new SesionCliente();
                        ventana.setVisible(true);
                        dispose();
                        accesoConcedido = true;
                        break;
                    }
                }
                
                // Verificar en administradores si no fue encontrado en clientes
                if (!accesoConcedido) {
                    for (int i = 0; i < App.admins.size(); i++) {
                        if (usuario.equals(App.admins.get(i).getNombre()) && contraseña.equals(App.admins.get(i).getContraseña())) {
                            JOptionPane.showMessageDialog(null, "Hola de nuevo " + usuario, "Bienvenido de nuevo", JOptionPane.INFORMATION_MESSAGE);
                            accesoConcedido = true;
                            SesionAdmin ventana = new SesionAdmin();
                            ventana.setVisible(true);
                            dispose();
                           
                        }
                    }
                }
                
                // Mensaje de error si las credenciales son incorrectas
                if (!accesoConcedido) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión fallido, revisa tus credenciales y vuelve a intentarlo", "Ups...", JOptionPane.INFORMATION_MESSAGE);
                } 
            }
        });
        btnNewButton.setBackground(new Color(0, 128, 192));
        
        JButton btnPulsaParaRegistrarte = new JButton("Pulsa para registrarte");
        btnPulsaParaRegistrarte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistroUsuario ventana = new RegistroUsuario();
                ventana.setVisible(true);
            }
        });
        btnPulsaParaRegistrarte.setBackground(new Color(0, 128, 192));

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
                            .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(88)
                                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
                                            .addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(groupLayout.createSequentialGroup()
                                            .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                            .addGap(38)))
                                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(textContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(136))
                                .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(129)
                            .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(btnNewButton)
                                .addComponent(btnPulsaParaRegistrarte, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNewLabel_3)
                                .addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNewLabel_3_1)
                                .addComponent(textContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(67)
                            .addComponent(btnNewButton)
                            .addGap(18)
                            .addComponent(btnPulsaParaRegistrarte)
                            .addContainerGap())
                        .addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)))
        );
        getContentPane().setLayout(groupLayout);
    }

 
}
