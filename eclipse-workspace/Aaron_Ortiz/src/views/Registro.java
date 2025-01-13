package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import MainApp.App;
import models.Entrenador;
import models.Jugador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField textNombre;
  private JTextField textApellido;
  private JTextField textEmail;
  private JTextField textContraseña;
  private JTextField textRepiteContraseña;
  private JRadioButton rdbtnNewRadioButton;
  private JRadioButton rdbtnNewRadioButton1;
  private JDateChooser datechooser;

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
    setBounds(100, 100, 526, 572);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBackground(new Color(0, 128, 255));
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.NORTH);
    
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(new ImageIcon(Registro.class.getResource("/resources/Logo.png")));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    JPanel panel = new JPanel();
    
    JButton btnNewButton = new JButton("Registrar");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       if( rdbtnNewRadioButton.isSelected() && rdbtnNewRadioButton1.isSelected()) {
         JOptionPane.showMessageDialog(null, "No puedes ser entrenador y jugador a la vez", "UPS", JOptionPane.ERROR_MESSAGE);
       }else if (rdbtnNewRadioButton.isSelected()){
       // Validamos las contraseñas
       if (textContraseña.getText().equals(textRepiteContraseña.getText())) {
         // Validamos que los campos no estén vacíos
         if (textNombre.getText().isEmpty() || textApellido.getText().isEmpty() || 
             textEmail.getText().isEmpty() || textContraseña.getText().isEmpty() || 
             textRepiteContraseña.getText().isEmpty() || datechooser.getDate() == null) {
             JOptionPane.showMessageDialog(null, "Rellena Todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
         }else {
            Entrenador nuevoEntrenador = new Entrenador(textNombre.getText(),textApellido.getText(),datechooser.getDate(),textEmail.getText(),textContraseña.getText());
            App.entrenadores.add(nuevoEntrenador);
            JOptionPane.showMessageDialog(null, "Entrenador registrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
         }
      }else {
        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
      }
      }else if (rdbtnNewRadioButton1.isSelected()) {
        // Validamos las contraseñas
        if (textContraseña.getText().equals(textRepiteContraseña.getText())) {
          // Validamos que los campos no estén vacíos
          if (textNombre.getText().isEmpty() || textApellido.getText().isEmpty() || 
              textEmail.getText().isEmpty() || textContraseña.getText().isEmpty() || 
              textRepiteContraseña.getText().isEmpty() || datechooser.getDate() == null) {
              JOptionPane.showMessageDialog(null, "Rellena Todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
          }else {
             Jugador nuevoJugador = new Jugador(textNombre.getText(),textApellido.getText(),datechooser.getDate(),textEmail.getText(),textContraseña.getText());
             App.jugadores.add(nuevoJugador);
             JOptionPane.showMessageDialog(null, "Jugador registrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
             dispose();
          }
          }else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
          }
      }else {
        JOptionPane.showMessageDialog(null, "Rellena Todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
      }
       }});
    
    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
    gl_contentPanel.setHorizontalGroup(
      gl_contentPanel.createParallelGroup(Alignment.TRAILING)
        .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addContainerGap(78, Short.MAX_VALUE)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_contentPanel.createSequentialGroup()
              .addComponent(btnNewButton)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(btnCancelar))
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
          .addGap(51))
    );
    gl_contentPanel.setVerticalGroup(
      gl_contentPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addComponent(lblNewLabel)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(panel, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(btnCancelar)
            .addComponent(btnNewButton)))
    );
    
    JLabel lblNewLabel_1 = new JLabel("Nombre");
    
    textNombre = new JTextField();
    textNombre.setColumns(10);
    
    JLabel lblNewLabel_1_1 = new JLabel("Apellido");
    
    JLabel lblNewLabel_1_1_1 = new JLabel("Fecha de nacimiento");
    
    JLabel lblNewLabel_1_1_1_1 = new JLabel("email");
    
    JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Contraseña");
    
    JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Confirmar Contraseña");
    
    JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Perfil");
    
    textApellido = new JTextField();
    textApellido.setColumns(10);
    
    textEmail = new JTextField();
    textEmail.setColumns(10);
    
    textContraseña = new JTextField();
    textContraseña.setColumns(10);
    
    textRepiteContraseña = new JTextField();
    textRepiteContraseña.setColumns(10);
    
     rdbtnNewRadioButton = new JRadioButton("Entrenador/a");
    
     rdbtnNewRadioButton1 = new JRadioButton("Jugador/a");
    
     datechooser = new JDateChooser();
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
          .addGap(43)
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            .addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
            .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
              .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNewLabel_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
              .addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
                .addComponent(rdbtnNewRadioButton1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                .addComponent(textApellido, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addComponent(textNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addComponent(textContraseña, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addComponent(textRepiteContraseña, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addComponent(rdbtnNewRadioButton)
                .addComponent(textEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addComponent(datechooser, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
          .addGap(48))
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGap(30)
          .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_1))
          .addGap(18)
          .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
            .addComponent(lblNewLabel_1_1)
            .addComponent(textApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(26)
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            .addComponent(lblNewLabel_1_1_1)
            .addComponent(datechooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(26)
          .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_1_1_1_1)
            .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(35)
          .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_1_1_1_1_1)
            .addComponent(textContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(31)
          .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
            .addComponent(textRepiteContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_1_1_1_1_1_1))
          .addGap(33)
          .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
            .addComponent(lblNewLabel_1_1_1_1_1_1_1)
            .addComponent(rdbtnNewRadioButton1))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(rdbtnNewRadioButton)
          .addContainerGap(8, Short.MAX_VALUE))
    );
    panel.setLayout(gl_panel);
    contentPanel.setLayout(gl_contentPanel);
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }
  }
}
