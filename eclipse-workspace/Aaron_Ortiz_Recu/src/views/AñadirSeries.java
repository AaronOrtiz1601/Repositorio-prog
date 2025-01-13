package views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AñadirSeries extends JPanel {

  private static final long serialVersionUID = 1L;

  /**
   * Create the panel.
   */
  public AñadirSeries(JLayeredPane pane) {
    setBackground(new Color(128, 128, 128));
    setLayout(new GridLayout(1, 0, 0, 0));
    
    JLabel lblNewLabel_1 = new JLabel("Nueva temporada");
    lblNewLabel_1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Nuevatemporada ventana = new Nuevatemporada();
        ventana.setVisible(true);
      }
    });
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    add(lblNewLabel_1);
    
    JLabel lblNewLabel = new JLabel("Nueva Serie");
    lblNewLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        AñadirSerie ventana = new AñadirSerie();
        ventana.setVisible(true);
      }
    });
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblNewLabel.setForeground(new Color(255, 255, 255));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(lblNewLabel);

  }

}
