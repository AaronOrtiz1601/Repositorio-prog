package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mainApp.App;
import modelos.Usuario;

public class Principal extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField textField;
  private JTextField textField_1;
  private static Usuario clienteActivo; 

  public static Usuario getClienteActivo() {
      return clienteActivo;
  }



  /**
   * Create the frame.
   */
  public Principal() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 543, 421);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(0, 0, 0));
    contentPane.add(panel, BorderLayout.NORTH);
    panel.setLayout(new GridLayout(1, 2, 0, 0));
    
    JLabel lblNewLabel = new JLabel("Seriefly");
    lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/resources/logo.png")));
    lblNewLabel.setForeground(new Color(255, 0, 0));
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 41));
    panel.add(lblNewLabel);
    
    JPanel panel_1 = new JPanel();
    panel.add(panel_1);
    panel_1.setLayout(new BorderLayout(0, 0));
    
    JLabel lblNewLabel_1 = new JLabel("Inicio de sesión");
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
    panel_1.add(lblNewLabel_1, BorderLayout.NORTH);
    
    JPanel panel_2 = new JPanel();
    panel_1.add(panel_2, BorderLayout.CENTER);
    panel_2.setLayout(new GridLayout(3, 2, 0, 0));
    
    JLabel lblNewLabel_5 = new JLabel("Usuario");
    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
    panel_2.add(lblNewLabel_5);
    
    textField = new JTextField();
    panel_2.add(textField);
    textField.setColumns(10);
    
    JLabel lblNewLabel_6 = new JLabel("Contraseña");
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
    panel_2.add(lblNewLabel_6);
    
    JLabel lblNewLabel_3 = new JLabel("¿No tienes cuenta?");
    lblNewLabel_3.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Registro ventana = new Registro();
        ventana.setVisible(true);
      }
    });
    
    textField_1 = new JTextField();
    textField_1.setColumns(10);
    panel_2.add(textField_1);
    lblNewLabel_3.setForeground(new Color(0, 0, 255));
    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
    panel_2.add(lblNewLabel_3);
    
    JButton btnNewButton = new JButton("Inicio de sesión");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String usuario = textField.getText();
        String contrasena = textField_1.getText();
        boolean avisador = false;

        // Recorre la lista de clientes
        for (int i = 0; i < App.usuarios.size(); i++) {
            if (usuario.equals(App.usuarios.get(i).getEmail()) && contrasena.equals(App.usuarios.get(i).getPass())) {
                avisador = true;
                clienteActivo = App.usuarios.get(i);
                Home ventana = new Home();
                ventana.setVisible(true);
                dispose();
                break; 
            }
        }

     

        // Si no se encuentra coincidencia, mostrar el mensaje de error
        if (!avisador) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Ups...", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    btnNewButton.setBackground(new Color(255, 128, 0));
    panel_2.add(btnNewButton);
    
    JLabel lblNewLabel_2 = new JLabel("");
    lblNewLabel_2.setOpaque(true);
    lblNewLabel_2.setBackground(new Color(128, 128, 128));
    lblNewLabel_2.setIcon(new ImageIcon(Principal.class.getResource("/resources/imgLogin.png")));
    contentPane.add(lblNewLabel_2, BorderLayout.CENTER);
  }

}
