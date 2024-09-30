package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import parteInterna.Usuario;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class parteGrafica {

  private JFrame frame;
  private JTextArea textAreaUsername;
  public static final String JDBC_URL = "jdbc:sqlite:";
  public static final String DATABASE_PATH = "db/Users.db";
  private static final String SQL = "select User, Password from Users where User = ? and Password = ? ; ";
  private JPasswordField passwordField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          parteGrafica window = new parteGrafica();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public parteGrafica() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setBackground(new Color(0, 64, 128));
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel username = new JLabel("Username:");
    username.setForeground(new Color(128, 128, 192));
    username.setFont(new Font("Tahoma", Font.BOLD, 13));
    
     textAreaUsername = new JTextArea();
    
    JLabel password = new JLabel("Password:");
    password.setForeground(new Color(128, 128, 192));
    password.setFont(new Font("Tahoma", Font.BOLD, 13));
    
    JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
    chckbxNewCheckBox.setForeground(new Color(128, 128, 192));
    chckbxNewCheckBox.setBackground(new Color(0, 64, 128));
    
    JButton btnNewButtonLogin = new JButton("Login");
    btnNewButtonLogin.setBackground(new Color(128, 128, 192));
    /**
     * Metodo que se activa al pulsar el boton login
     */
    btnNewButtonLogin.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        /**
         * LLamada al metodo privado
         */
       eventoLogin();
        
      }
    });
    
    JButton btnNewButtonLimpiar = new JButton("Clean");
    btnNewButtonLimpiar.setBackground(new Color(128, 128, 192));
    /**
     * Metodo que se activa al pulsar el boton clean
     */
    btnNewButtonLimpiar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //Cuando pulsas el botón este metodo pone en blanco los cuadros de texto
        passwordField.setText("");
        textAreaUsername.setText("");
      }
    });
    
    passwordField = new JPasswordField();
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(btnNewButtonLogin, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
              .addGap(58)
              .addComponent(btnNewButtonLimpiar))
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap(164, Short.MAX_VALUE)
              .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(password, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED))
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(username, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(textAreaUsername, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                .addComponent(chckbxNewCheckBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
          .addContainerGap(185, GroupLayout.PREFERRED_SIZE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(49)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(username, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
            .addComponent(textAreaUsername, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(password, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addComponent(chckbxNewCheckBox)
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(btnNewButtonLimpiar)
            .addComponent(btnNewButtonLogin))
          .addContainerGap(52, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
  /**
   * Metodo privado que compara los datos introducidos con los que ya existen en la tabla
   */
  private void eventoLogin() {
    Usuario usuario1 = new Usuario(textAreaUsername.getText(), passwordField.getText());

    // Conecta con la base de datos
    try {
        // Cargar el driver SQLite
        Class.forName("org.sqlite.JDBC");
        
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH);
             PreparedStatement stmt = conn.prepareStatement(SQL); 
             Scanner sc = new Scanner(System.in)) {

            //Sacamos los datos del usuario que se ha introducido en la interfaz para introducirlos en la comparación

            stmt.setString(1, usuario1.getNombreUsuario());
            stmt.setString(2, usuario1.getContrasenya());

            ResultSet rs = stmt.executeQuery();
            
            //Si ha salido algun resultado damos la bienbenida
            if (rs.next()) { 
                JOptionPane.showMessageDialog(frame, "Bienvenido " + rs.getString(1));
            } else {
              //Si no hay resultados , damos un mensaje de que no hay datos para ese usuario
              JOptionPane.showMessageDialog(frame, "Tu en la base de datos no me sales... ");
                
            }

        } catch (SQLException e) {
            System.out.printf("Error: Ocurrió error %s%n", e.getMessage());
        } 
    } catch (ClassNotFoundException e) {
        System.out.println("Driver no encontrado. Asegúrate de que el conector JDBC esté en el classpath.");
    }
}
}
