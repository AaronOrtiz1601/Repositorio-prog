package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainApp.App;
import models.Clase;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Dialogo que se encarga de registrar nuevas clases
 */
public class Clases extends JDialog {

  private static final long serialVersionUID = 1L;
  private JTextField textNombre;
  private JTextField textProfesor;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      Clases dialog = new Clases();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public Clases() {
    setBounds(100, 100, 421, 379);
    getContentPane().setLayout(new BorderLayout());
    
    JLabel lblNewLabel = new JLabel("Nueva Clase");
    lblNewLabel.setOpaque(true);
    lblNewLabel.setForeground(new Color(255, 255, 255));
    lblNewLabel.setBackground(new Color(0, 128, 192));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
    getContentPane().add(lblNewLabel, BorderLayout.NORTH);
    
    JPanel panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);
    panel.setLayout(new GridLayout(5, 2, 0, 50));
    
    JLabel lblNewLabel_8 = new JLabel("Nombre");
    lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
    panel.add(lblNewLabel_8);
    
    textNombre = new JTextField();
    panel.add(textNombre);
    textNombre.setColumns(10);
    
    JLabel lblNewLabel_6 = new JLabel("Profesor");
    lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_6);
    
    textProfesor = new JTextField();
    panel.add(textProfesor);
    textProfesor.setColumns(10);
    
    JLabel lblNewLabel_3 = new JLabel("Turno");
    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_3);
    
    JPanel panel_1 = new JPanel();
    panel.add(panel_1);
    panel_1.setLayout(new GridLayout(1, 1, 0, 0));
    
    JRadioButton rdbtnMañana = new JRadioButton("Mañana");
    panel_1.add(rdbtnMañana);
    
    JRadioButton rdbtnTarde = new JRadioButton("Tarde");
    panel_1.add(rdbtnTarde);
    
    JLabel lblNewLabel_5 = new JLabel("");
    panel.add(lblNewLabel_5);
    
    JButton btnNewButton = new JButton("Enviar");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (rdbtnMañana.isSelected() && rdbtnTarde.isSelected()) {
          JOptionPane.showMessageDialog(null, "Solo puede se puede marcar un checkBox", "Ups...", JOptionPane.ERROR_MESSAGE);
          
        }else {
          Clase nuevaClase = null;
          if (rdbtnMañana.isSelected()) {
            
          
           nuevaClase = new Clase(textNombre.getText(),textProfesor.getText(),"Mañana");
          } else if (rdbtnTarde.isSelected()) {
             nuevaClase = new Clase(textNombre.getText(),textProfesor.getText(),"Tarde");
          }
          boolean avisador = true;
          //Comprobamos que la clase ya exista, y si esta no existe la creamos
          for (Clase clase : App.clases) {
            if (nuevaClase.getProfesor().equals(clase.getProfesor())&& nuevaClase.getNombre().equals(clase.getNombre())&& nuevaClase.getTiempo().equals(clase.getTiempo())) {
              avisador = false;
              JOptionPane.showMessageDialog(null, "Esta clase ya existe", "Ups...", JOptionPane.ERROR_MESSAGE);
            }
          }
          if (avisador) {
            App.clases.add(nuevaClase);
            JOptionPane.showMessageDialog(null, "Clase añadida", "Exito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
          }
        }
      }
    });
    panel.add(btnNewButton);
  }

}
