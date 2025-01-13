package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaEmpleado extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;


  

  /**
   * Create the frame.
   */
  public PantallaEmpleado() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 616, 444);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    JLabel lblNewLabel = new JLabel("Talleres Picasso");
   lblNewLabel.setOpaque(true);
    lblNewLabel.setBackground(new Color(128, 255, 255));
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNewLabel.setForeground(new Color(0, 64, 128));
    lblNewLabel.setIcon(new ImageIcon(PantallaEmpleado.class.getResource("/resources/cocheAzul.png")));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    contentPane.add(lblNewLabel, BorderLayout.NORTH);
    
    JPanel panel = new JPanel();
    contentPane.add(panel, BorderLayout.CENTER);
    panel.setLayout(new BorderLayout(0, 0));
    
    JLabel lblNewLabel_1 = new JLabel("Bienvenido/a " + Principal.getClienteActivo().getNombre() + " " + Principal.getClienteActivo().getApellidos());
    lblNewLabel_1.setForeground(new Color(0, 64, 128));
    panel.add(lblNewLabel_1, BorderLayout.NORTH);
    
    JPanel panel_1 = new JPanel();
    panel.add(panel_1, BorderLayout.CENTER);
    panel_1.setLayout(new GridLayout(2, 2, 0, 0));
    
    JLabel lblNewLabel_3 = new JLabel("");
    lblNewLabel_3.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        ActReparacion ventana = new ActReparacion();
        ventana.setVisible(true);
      }
    });
    lblNewLabel_3.setIcon(new ImageIcon(PantallaEmpleado.class.getResource("/resources/reparaciones.png")));
    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(lblNewLabel_3);
    
    JLabel lblNewLabel_4 = new JLabel("");
    lblNewLabel_4.setIcon(new ImageIcon(PantallaEmpleado.class.getResource("/resources/listadoReparaciones.png")));
    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(lblNewLabel_4);
    
    JLabel lblNewLabel_5 = new JLabel("Actualizar estado de reparacion");
    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(lblNewLabel_5);
    
    JLabel lblNewLabel_6 = new JLabel("Ver mi trabajos");
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(lblNewLabel_6);
    
    JLabel lblNewLabel_2 = new JLabel("");
    lblNewLabel_2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Principal ventana = new Principal();
        ventana.setVisible(true);
        dispose();
      }
    });
    lblNewLabel_2.setIcon(new ImageIcon(PantallaEmpleado.class.getResource("/resources/logout.png")));
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
    contentPane.add(lblNewLabel_2, BorderLayout.SOUTH);
  }

}
