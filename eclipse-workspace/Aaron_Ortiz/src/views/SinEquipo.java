package views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SinEquipo extends JPanel {
  private JLayeredPane layeredPane;

  private static final long serialVersionUID = 1L;

  /**
   * Create the panel.
   */
  public SinEquipo(JLayeredPane layeredPane) {
    setBounds(0, 0, 569, 319);
    setLayout(new BorderLayout(0, 0));
    
    JLabel lblNewLabel_5 = new JLabel("Actualmente no tienes equipo");
    lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
   add(lblNewLabel_5, BorderLayout.NORTH);
    
    JLabel lblNewLabel_6 = new JLabel("");
    lblNewLabel_6.setIcon(new ImageIcon(SesionJugador.class.getResource("/resources/ImgJugadorError.png")));
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
   add(lblNewLabel_6, BorderLayout.CENTER);
  }

}
