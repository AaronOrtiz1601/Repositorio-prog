package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mainApp.App;
import modelos.Serie;
import modelos.Temporada;

public class MisSeries extends JPanel {

  private static final long serialVersionUID = 1L;
  private JLabel lblPlataforma;
  private JLabel lblTemporada;

  /**
   * Create the panel.
   */
  public MisSeries(JLayeredPane pane) {
    setBackground(new Color(128, 128, 128));
    setLayout(new GridLayout(0, 2, 0, 30));
    
    JLabel lblNewLabel_1 = new JLabel("Serie");
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    add(lblNewLabel_1);
    
    JComboBox comboBox = new JComboBox(lista().toArray(new String[0]));
    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        

      String peliculaSeleccionada = comboBox.getSelectedItem().toString();
      for (Serie nuevaSerie : App.series) {
          if (peliculaSeleccionada.equals(nuevaSerie.getNombre())) {
              lblPlataforma.setText(nuevaSerie.getPlataforma());
              int numero = nuevaSerie.getLstTemporadas().get(nuevaSerie.getLstTemporadas().size()-1).getNumeroTemporada();
              String temporada = numero + "";
              lblTemporada.setText(temporada);
              

             
              break;
          }
      
      }
      }
    });
    add(comboBox);
    
    JLabel lblNewLabel_2 = new JLabel("Plataforma");
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_2.setForeground(new Color(255, 255, 255));
    add(lblNewLabel_2);
    
     lblPlataforma = new JLabel("");
    lblPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
    lblPlataforma.setForeground(new Color(255, 255, 255));
    add(lblPlataforma);
    
    JLabel lblNewLabel_4 = new JLabel("Numero de temporadas");
    lblNewLabel_4.setForeground(new Color(255, 255, 255));
    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
    add(lblNewLabel_4);
    
     lblTemporada = new JLabel("");
    lblTemporada.setForeground(new Color(255, 255, 255));
    lblTemporada.setHorizontalAlignment(SwingConstants.CENTER);
    add(lblTemporada);
    
    JLabel lblNewLabel_6 = new JLabel("");
    add(lblNewLabel_6);
    
    JButton btnNewButton = new JButton("Añadir a mis series");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        for (Serie nuevaSerie : App.series)
        {
          String serieSeleccionada = comboBox.getSelectedItem().toString();
          if (nuevaSerie.getNombre().equals(serieSeleccionada)) {
        Serie serie = new Serie(nuevaSerie.getNombre(),lblPlataforma.getText(),nuevaSerie.getLstTemporadas());
        List<Serie> series = Principal.getClienteActivo().getMisSeries();
        series.add(serie);
        Principal.getClienteActivo().setMisSeries(series);
        JOptionPane.showMessageDialog(null, "Serie añadida con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    });
    add(btnNewButton);

  }
  private static List<String> lista() {
    List<String> lista = new ArrayList<>();
    for (Serie nuevaSerie : App.series) {
        
            lista.add(nuevaSerie.getNombre());
        
    }
    return lista;
}

}
