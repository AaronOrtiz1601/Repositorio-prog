package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import mainApp.App;
import models.Usuario;

public class Registro extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField textFieldUsuario;
  private JTextField textFieldContraseña;
  private JTextField textFieldContraseña2;

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
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    JLabel lblNewLabel = new JLabel("Bienvenido al registro");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
    JLabel lblUsuario = new JLabel("Usuario");
    lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
    textFieldUsuario = new JTextField();
    textFieldUsuario.setColumns(10);
    JLabel lblContrasea = new JLabel("Contraseña");
    lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
    textFieldContraseña = new JTextField();
    textFieldContraseña.setColumns(10);
    
    JLabel lblRepiteLaContrasea = new JLabel("Repite la contraseña");
    lblRepiteLaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    textFieldContraseña2 = new JTextField();
    textFieldContraseña2.setColumns(10);
    
    JButton btnNewButton = new JButton("Registrarse");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textUsuario = textFieldUsuario.getText();
        String textContraseña = textFieldContraseña.getText();
        String textContraseña2 = textFieldContraseña2.getText();
        if (textContraseña.equals(textContraseña2)) {
          Usuario us = new Usuario(textUsuario,textContraseña);
         App.usuarios.add(us);
         JOptionPane.showMessageDialog(null, "Usuario creado", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
         
        }else {
          JOptionPane.showMessageDialog(null, "Algo salio mal, vuelve a intentarlo", "Ups...", JOptionPane.INFORMATION_MESSAGE);
          textFieldUsuario.setText("");
          textFieldContraseña.setText("");
          textFieldContraseña2.setText("");
        }
      }
    });
    GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
    gl_contentPanel.setHorizontalGroup(
      gl_contentPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addGap(95)
          .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(68, Short.MAX_VALUE))
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addContainerGap(180, Short.MAX_VALUE)
          .addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
          .addGap(155))
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addGap(162)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
            .addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
            .addComponent(textFieldContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(168, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
          .addContainerGap(140, Short.MAX_VALUE)
          .addComponent(lblRepiteLaContrasea, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
          .addGap(127))
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addGap(163)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
            .addComponent(btnNewButton)
            .addComponent(textFieldContraseña2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(167, Short.MAX_VALUE))
    );
    gl_contentPanel.setVerticalGroup(
      gl_contentPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addComponent(lblNewLabel)
          .addGap(18)
          .addComponent(lblUsuario)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(textFieldContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblRepiteLaContrasea, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(textFieldContraseña2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnNewButton)
          .addContainerGap(27, Short.MAX_VALUE))
    );
    contentPanel.setLayout(gl_contentPanel);
  }

}
