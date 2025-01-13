package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import mainApp.App;
import models.Usuario;

public class login extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField textFieldUsuario;
  private JTextField textFieldContraseña;
  


  /**
   * Create the frame.
   */
  public login() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 662, 537);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    
    JLabel lblUsuario = new JLabel("Usuario");
    lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/resources/logo2.png")));
    
    textFieldUsuario = new JTextField();
    textFieldUsuario.setColumns(10);
    
    JLabel lblContrasea = new JLabel("Contraseña");
    lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    textFieldContraseña = new JTextField();
    textFieldContraseña.setColumns(10);
    
    JButton btnlogin = new JButton("Login");
    btnlogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textUsuario = textFieldUsuario.getText();
        String textContraseña = textFieldContraseña.getText();
        boolean avisador = false;

        for (int i = 0; i < App.usuarios.size(); i++) {
          if (App.usuarios.get(i).getUsuario().equals(textUsuario) && App.usuarios.get(i).getContraseña().equals(textContraseña)) {
            avisador = true;
          } 
        }
        if (avisador) {
          JOptionPane.showMessageDialog(null, "Bienvenido", "Credenciales correctas", JOptionPane.INFORMATION_MESSAGE);
        }else {
          JOptionPane.showMessageDialog(null, "Ups... Parece que algo ha salido mal, intentalo de nuevo o registrate si no lo habias hecho", "Credenciales incorrectas", JOptionPane.INFORMATION_MESSAGE);
        }
        
      }
    });
    
    JButton btnRegister = new JButton("Register");
    btnRegister.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Registro ventana2 = new Registro();
        ventana2.setVisible(true);
      }
    });
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(177)
          .addComponent(lblNewLabel)
          .addContainerGap(211, Short.MAX_VALUE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(260)
          .addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(278, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
          .addContainerGap(233, Short.MAX_VALUE)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
            .addComponent(textFieldContraseña, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
            .addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
          .addGap(267))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(94)
          .addComponent(btnlogin)
          .addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
          .addComponent(btnRegister)
          .addGap(126))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(26)
          .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(lblUsuario)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(textFieldContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addGap(38)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(btnlogin)
            .addComponent(btnRegister))
          .addContainerGap(95, Short.MAX_VALUE))
    );
    contentPane.setLayout(gl_contentPane);
  }
}
