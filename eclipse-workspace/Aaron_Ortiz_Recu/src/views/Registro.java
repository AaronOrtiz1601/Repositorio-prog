package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mainApp.App;
import modelos.Usuario;

public class Registro extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField textFieldNombre;
  private JTextField textFieldApellidos;
  private JTextField textFieldEmail;
  private JTextField textFieldContraseña;
  private JTextField textFieldConfirmaContraseña;

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
    setBounds(100, 100, 403, 596);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JLabel lblNewLabel = new JLabel("Registro de Usuario");
      lblNewLabel.setOpaque(true);
      lblNewLabel.setBackground(new Color(0, 0, 0));
      lblNewLabel.setForeground(new Color(255, 128, 0));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
      contentPanel.add(lblNewLabel, BorderLayout.NORTH);
    }
    {
      JPanel panel = new JPanel();
      panel.setBackground(new Color(128, 128, 128));
      contentPanel.add(panel, BorderLayout.CENTER);
      panel.setLayout(new GridLayout(7, 2, 0, 60));
      {
        JLabel lblNewLabel_6 = new JLabel("");
        panel.add(lblNewLabel_6);
      }
      {
        JLabel lblNewLabel_1 = new JLabel("");
        panel.add(lblNewLabel_1);
      }
      {
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setForeground(new Color(255, 255, 255));
        panel.add(lblNombre);
      }
      {
        textFieldNombre = new JTextField();
        panel.add(textFieldNombre);
        textFieldNombre.setColumns(10);
      }
      {
        JLabel lblNewLabel_2 = new JLabel("Apellidos");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_2);
      }
      {
        textFieldApellidos = new JTextField();
        panel.add(textFieldApellidos);
        textFieldApellidos.setColumns(10);
      }
      {
        JLabel lblNewLabel_3 = new JLabel("Email");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_3);
      }
      {
        textFieldEmail = new JTextField();
        panel.add(textFieldEmail);
        textFieldEmail.setColumns(10);
      }
      {
        JLabel lblNewLabel_4 = new JLabel("Contraseña");
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_4);
      }
      {
        textFieldContraseña = new JTextField();
        panel.add(textFieldContraseña);
        textFieldContraseña.setColumns(10);
      }
      {
        JLabel lblNewLabel_5 = new JLabel("Confirmar Contraseña");
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_5);
      }
      {
        textFieldConfirmaContraseña = new JTextField();
        panel.add(textFieldConfirmaContraseña);
        textFieldConfirmaContraseña.setColumns(10);
      }
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setBackground(new Color(0, 0, 0));
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("Registro");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            
         // Validamos las contraseñas
            if (textFieldContraseña.getText().equals(textFieldConfirmaContraseña.getText())) {
              // Validamos que los campos no estén vacíos
              if (textFieldNombre.getText().isEmpty() || textFieldApellidos.getText().isEmpty() || 
                  textFieldEmail.getText().isEmpty() || textFieldContraseña.getText().isEmpty() || 
                  textFieldConfirmaContraseña.getText().isEmpty() ) {
                  JOptionPane.showMessageDialog(null, "Rellena Todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
              }else {
                Usuario usuario = new Usuario (textFieldNombre.getText(),textFieldApellidos.getText(), textFieldEmail.getText(),textFieldContraseña.getText());
                boolean aviso = false;
                for (Usuario nuevoUsuario : App.usuarios) {
                  if(nuevoUsuario.getEmail().equals(usuario.getEmail())) {
                    aviso = true;
                  }
                }
                if (aviso) {
                  JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese email", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                  JOptionPane.showMessageDialog(null, "Usuario creado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                  App.usuarios.add(usuario);
                  dispose();
                }
              }
          }else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
          }
          }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
      {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            dispose();
          }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

}
