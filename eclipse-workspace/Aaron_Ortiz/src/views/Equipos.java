package views;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import MainApp.App;
import models.Equipo;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Equipos extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTextField textAnyo;
  private JTextField textGenero;
  private JTextField textEntrenador;
  private JTextField textHora;
  private JTextField textNumeroJugadores;
  private JComboBox comboBox;

  /**
   * Create the panel.
   */
  public Equipos(JLayeredPane layeredPane) {
    setLayout(new BorderLayout(0, 0));
    
    JLabel lblNewLabel = new JLabel("Inscripcion a equipo");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(lblNewLabel, BorderLayout.NORTH);
    
    JPanel panel = new JPanel();
    add(panel, BorderLayout.CENTER);
    panel.setLayout(new GridLayout(7, 2, 0, 20));
    
    JLabel lblNewLabel_9 = new JLabel("Equipo");
    lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_9);
    
     comboBox = new JComboBox(lista().toArray());
    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String nuevoEquipoNombre = comboBox.getSelectedItem().toString();
        for (Equipo nuevoEquipo : App.equipos) {
          if (nuevoEquipo.getNombre().equals(nuevoEquipoNombre)) {
            textAnyo.setText(nuevoEquipo.getAnyo());
            textEntrenador.setText(nuevoEquipo.getEntrenador());
            textGenero.setText(nuevoEquipo.getGenero());
            textHora.setText(nuevoEquipo.getHoraEntrenamiento());
            textNumeroJugadores.setText(nuevoEquipo.getNumeroDeJugadores());
            break;
          }
        }
        
      }
    });
    panel.add(comboBox);
    
    JLabel lblNewLabel_7 = new JLabel("Año");
    lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_7);
    
    textAnyo = new JTextField();
    textAnyo.setEditable(false);
    textAnyo.setEnabled(false);
    panel.add(textAnyo);
    textAnyo.setColumns(10);
    
    JLabel lblNewLabel_6 = new JLabel("Genero");
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_6);
    
    textGenero = new JTextField();
    textGenero.setEditable(false);
    textGenero.setEnabled(false);
    panel.add(textGenero);
    textGenero.setColumns(10);
    
    JLabel lblNewLabel_4 = new JLabel("Entrenador");
    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_4);
    
    textEntrenador = new JTextField();
    textEntrenador.setEditable(false);
    textEntrenador.setEnabled(false);
    panel.add(textEntrenador);
    textEntrenador.setColumns(10);
    
    JLabel lblNewLabel_2 = new JLabel("Hora de entrenamiento");
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_2);
    
    textHora = new JTextField();
    textHora.setEditable(false);
    textHora.setEnabled(false);
    panel.add(textHora);
    textHora.setColumns(10);
    
    JLabel lblNewLabel_10 = new JLabel("Numero de jugadores");
    lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_10);
    
    textNumeroJugadores = new JTextField();
    textNumeroJugadores.setEditable(false);
    textNumeroJugadores.setEnabled(false);
    panel.add(textNumeroJugadores);
    textNumeroJugadores.setColumns(10);
    
    JPanel panel_1 = new JPanel();
    add(panel_1, BorderLayout.SOUTH);
    
    JButton btnNewButton = new JButton("Inscribirse");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(Principal.getJugadorActivo().getEquipo().equals(comboBox.getSelectedItem().toString())) {
          JOptionPane.showMessageDialog(null, "No puedes unirte a un equipo al que ya perteneces", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
        Principal.getJugadorActivo().setEquipo(comboBox.getSelectedItem().toString());
        JOptionPane.showMessageDialog(null, "Bienvenido a " + comboBox.getSelectedItem().toString() +".", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
        }
      }
    });
    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
    gl_panel_1.setHorizontalGroup(
      gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
          .addContainerGap(377, Short.MAX_VALUE)
          .addComponent(btnNewButton)
          .addContainerGap())
    );
    gl_panel_1.setVerticalGroup(
      gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnNewButton))
    );
    panel_1.setLayout(gl_panel_1);

  }
  private static List <String> lista(){
    List<String> lista = new ArrayList<String>();
    for (Equipo nuevoEquipo: App.equipos) {
      lista.add(nuevoEquipo.getNombre());
    }
    return lista;
    
  }
 
}
