package views;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import MainApp.App;
import models.Entrenador;
import models.Jugador;

public class Principal extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane; 
  private static Jugador jugadorActivo;  
  private static Entrenador entrenadorActivo; 

  public static Jugador getJugadorActivo() {
      return jugadorActivo;
  }
  public static Entrenador getEntrenadorActivo() {
    return entrenadorActivo;
}

  /**
   * Launch the application.
   */
 

  /**
   * Create the frame.
   */
  public Principal() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 579, 394);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(0, 128, 255));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/resources/Logo.png")));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    contentPane.add(lblNewLabel, BorderLayout.NORTH);
    
    JPanel panel = new JPanel();
    contentPane.add(panel, BorderLayout.CENTER);
    panel.setLayout(new GridLayout(3, 2, 0, 60));
    
    JLabel lblNewLabel_8 = new JLabel("Email");
    lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_8);
    
    JTextArea textEmail = new JTextArea();
    panel.add(textEmail);
    
    JLabel lblNewLabel_6 = new JLabel("Contraseña");
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_6);
    
    JPasswordField Textpassword = new JPasswordField();
    panel.add(Textpassword);
    
    JLabel lblNewLabel_4 = new JLabel("¿No tienes cuenta?");
    lblNewLabel_4.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Registro ventana = new Registro();
        ventana.setVisible(true);
      }
    });
    lblNewLabel_4.setForeground(new Color(0, 128, 255));
    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_4);
    
    JButton btnNewButton = new JButton("Login");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String usuario = textEmail.getText();
        String contraseña = new String(Textpassword.getPassword());
        boolean accesoConcedido = false;
        
        
        for (int i = 0; i < App.jugadores.size(); i++) {
            if (usuario.equals(App.jugadores.get(i).getEmail()) && contraseña.equals(App.jugadores.get(i).getContraseña())) {
              jugadorActivo = App.jugadores.get(i);
              JOptionPane.showMessageDialog(null, "Hola de nuevo " + usuario, "Bienvenido de nuevo", JOptionPane.INFORMATION_MESSAGE);
              SesionJugador ventana = new SesionJugador();
                ventana.setVisible(true);
                dispose();
                accesoConcedido = true;
                break;
            }
        }
        
        
        if (!accesoConcedido) {
            for (int i = 0; i < App.entrenadores.size(); i++) {
                if (usuario.equals(App.entrenadores.get(i).getEmail()) && contraseña.equals(App.entrenadores.get(i).getContraseña())) {
                   entrenadorActivo = App.entrenadores.get(i); 
                  JOptionPane.showMessageDialog(null, "Hola de nuevo " + usuario, "Bienvenido de nuevo", JOptionPane.INFORMATION_MESSAGE);
                    accesoConcedido = true;
                    SesionEntrenador ventana = new SesionEntrenador();
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
    panel.add(btnNewButton);
    
    JLabel lblNewLabel_1 = new JLabel("                          ");
    contentPane.add(lblNewLabel_1, BorderLayout.WEST);
    
    JLabel lblNewLabel_2 = new JLabel("                         ");
    contentPane.add(lblNewLabel_2, BorderLayout.EAST);
  }

}
