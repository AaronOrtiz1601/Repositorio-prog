package views;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import MainApp.App;
import models.Equipo;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConEquipoEntrenador extends JPanel {

  private static final long serialVersionUID = 1L;
  private JLabel lblNombre;
  private JLabel lblAnyo;
  private JLabel lblEntrenador;
  private JLabel lblHorario;
  private JLabel lblGenero;
  

  /**
   * Create the panel.
   */
  public ConEquipoEntrenador(JLayeredPane layeredPane) {
   
    setLayout(new BorderLayout(0, 0));
    
    JLabel lblNewLabel = new JLabel("Mi equipo");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    add(lblNewLabel, BorderLayout.NORTH);
    
    JPanel panel = new JPanel();
    add(panel, BorderLayout.CENTER);
    panel.setLayout(new GridLayout(6, 2, 0, 0));
    
    JLabel lblNewLabel_8 = new JLabel("Nombre");
    lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_8);
    
    lblNombre = new JLabel("New label");
    lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNombre);
    
    JLabel lblNewLabel_6 = new JLabel("Año");
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_6);
    
     lblAnyo = new JLabel("");
    lblAnyo.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblAnyo);
    
    JLabel lblNewLabel_3 = new JLabel("Genero");
    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_3);
    
     lblGenero = new JLabel("");
    lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblGenero);
    
    JLabel lblNewLabel_2 = new JLabel("Horario");
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_2);
    
     lblHorario = new JLabel("");
    lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblHorario);
    
    JLabel lblNewLabel_10 = new JLabel("Entrenador");
    lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel_10);
    
     lblEntrenador = new JLabel("");
    lblEntrenador.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblEntrenador);
    
    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setIcon(new ImageIcon(ConEquipoEntrenador.class.getResource("/resources/Izquierda.png")));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblNewLabel_1);
    
    JLabel lblNewLabel_4 = new JLabel("");
    lblNewLabel_4.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
      }
    });
    lblNewLabel_4.setIcon(new ImageIcon(ConEquipoEntrenador.class.getResource("/resources/Derecha.png")));
    panel.add(lblNewLabel_4);
    valores();
  }
  private  void valores() {
    
    for (Equipo nuevoEquipo : App.equipos) {
      if (nuevoEquipo.getNombre().equals(Principal.getEntrenadorActivo().getEquipo())){
        lblNombre.setText(nuevoEquipo.getNombre());
        lblAnyo.setText(nuevoEquipo.getAnyo());
        lblEntrenador.setText(nuevoEquipo.getEntrenador());
        lblGenero.setText(nuevoEquipo.getGenero());
        lblHorario.setText(nuevoEquipo.getHoraEntrenamiento());
      }
    }
  }

}
