package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SesionJugador extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  JLayeredPane layeredPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SesionJugador frame = new SesionJugador();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public SesionJugador() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 657, 506);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(0, 128, 255));
    contentPane.add(panel, BorderLayout.SOUTH);
    
    JLabel lblNewLabel = new JLabel("New label");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblNewLabel.setForeground(new Color(0, 128, 255));
    panel.add(lblNewLabel);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(0, 128, 255));
    contentPane.add(panel_1, BorderLayout.NORTH);
    
    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setIcon(new ImageIcon(SesionJugador.class.getResource("/resources/Logo.png")));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(lblNewLabel_1);
    
    JPanel panel_2 = new JPanel();
    contentPane.add(panel_2, BorderLayout.WEST);
    panel_2.setLayout(new GridLayout(3, 1, 0, 0));
    
    JLabel lblNewLabel_2 = new JLabel("");
    lblNewLabel_2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if(Principal.getJugadorActivo().getEquipo() == "")
        {
          cambiarPanel(new SinEquipo(layeredPane));
        }else {
          cambiarPanel(new ConEquipo(layeredPane));
        }
        
        
      }
    });
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_2.setBackground(new Color(128, 255, 255));
    lblNewLabel_2.setOpaque(true);
    lblNewLabel_2.setIcon(new ImageIcon(SesionJugador.class.getResource("/resources/Home.png")));
    panel_2.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("");
    lblNewLabel_3.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarPanel(new Equipos(layeredPane));
      }
      
    });
    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_3.setIcon(new ImageIcon(SesionJugador.class.getResource("/resources/Equipo.png")));
    lblNewLabel_3.setBackground(new Color(128, 255, 255));
    panel_2.add(lblNewLabel_3);
    lblNewLabel_3.setOpaque(true);
    
    JLabel lblNewLabel_4 = new JLabel("");
    lblNewLabel_4.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Principal ventana = new Principal();
        ventana.setVisible(true);
        dispose();
      }
    });
    lblNewLabel_4.setIcon(new ImageIcon(SesionJugador.class.getResource("/resources/Logout.png")));
    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_4.setBackground(new Color(128, 255, 255));
    lblNewLabel_4.setOpaque(true);
    panel_2.add(lblNewLabel_4);
    
     layeredPane = new JLayeredPane();
    contentPane.add(layeredPane, BorderLayout.CENTER);
    
    JPanel panel_3 = new JPanel();
    panel_3.setBounds(0, 0, 569, 319);
    panelInicio(layeredPane);
    panel_3.setLayout(new BorderLayout(0, 0));
    
    JLabel lblNewLabel_5 = new JLabel("Actualmente no tienes equipo");
    lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
    panel_3.add(lblNewLabel_5, BorderLayout.NORTH);
    
    JLabel lblNewLabel_6 = new JLabel("");
    lblNewLabel_6.setIcon(new ImageIcon(SesionJugador.class.getResource("/resources/ImgJugadorError.png")));
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
    panel_3.add(lblNewLabel_6, BorderLayout.CENTER);
  }
  private static void panelInicio(JLayeredPane layeredPane) {
    if(Principal.getJugadorActivo().getEquipo()== "") {
      SinEquipo panel = new SinEquipo(layeredPane);
      layeredPane.add(panel);
    }
  }
 
  private void cambiarPanel(JPanel newPanel) {
    // Limpiar contenido anterior
    layeredPane.removeAll();
    // Ajustar tamaño
    newPanel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
    // Añadir nuevo panel
    layeredPane.add(newPanel);
    // Repaint para reflejar el cambio
    layeredPane.repaint();
    // Revalidar para que el nuevo panel se muestre
    layeredPane.revalidate();
  }
}
