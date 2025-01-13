package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelos.Serie;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JLayeredPane layeredPane;

 

  /**
   * Create the frame.
   */
  public Home() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 553, 381);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(0, 0, 0));
    panel.setForeground(new Color(255, 128, 0));
    contentPane.add(panel, BorderLayout.NORTH);
    panel.setLayout(new BorderLayout(0, 0));
    
    JLabel lblNewLabel = new JLabel("SerieFly");
    lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/resources/logo.png")));
    lblNewLabel.setForeground(new Color(255, 128, 0));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
    panel.add(lblNewLabel, BorderLayout.NORTH);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(0, 0, 0));
    panel.add(panel_1, BorderLayout.WEST);
    panel_1.setLayout(new GridLayout(1, 0, 20, 0));
    
    JLabel lblNewLabel_1 = new JLabel("Home");
    lblNewLabel_1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarPanel(new PanelHome(layeredPane));
        rellenarTabla();
      }
    });
    lblNewLabel_1.setForeground(new Color(255, 128, 0));
    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    panel_1.add(lblNewLabel_1);
    
    JLabel lblNewLabel_2 = new JLabel("Mis Series");
    lblNewLabel_2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarPanel(new MisSeries(layeredPane));
      }
    });
    lblNewLabel_2.setForeground(new Color(255, 128, 0));
    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    panel_1.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("Añadir");
    lblNewLabel_3.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarPanel(new AñadirSeries(layeredPane));
      }
    });
    lblNewLabel_3.setForeground(new Color(255, 128, 0));
    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
    panel_1.add(lblNewLabel_3);
    
    JLabel lblNewLabel_4 = new JLabel("Cerar sesión");
    lblNewLabel_4.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Principal ventana = new Principal();
        ventana.setVisible(true);
       dispose();
      }
    });
    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_4.setForeground(new Color(255, 128, 0));
    panel.add(lblNewLabel_4, BorderLayout.EAST);
    
     layeredPane = new JLayeredPane();
    
    contentPane.add(layeredPane, BorderLayout.CENTER);
    PanelHome panel2 = new PanelHome(layeredPane);
    
    JPanel panel_2 = new JPanel();
    panel_2.setBounds(0, 0, 529, 251);
    layeredPane.add(panel_2);
    cambiarPanel(panel2);
   
   
    
    
  }
 
  private void cambiarPanel(JPanel newPanel) {
    // Limpiar contenido anterior
    layeredPane.removeAll();
    // Ajustar tamaño
    newPanel.setBounds(0, 0, 529, 251);
    // Añadir nuevo panel
    layeredPane.add(newPanel);
    // Repaint para reflejar el cambio
    layeredPane.repaint();
    // Revalidar para que el nuevo panel se muestre
    layeredPane.revalidate();
  }
private void rellenarTabla() {
    
    for (Serie nuevaSerie : Principal.getClienteActivo().getMisSeries()) {
      PanelHome.tableModel.addRow(new Object[]{nuevaSerie.getNombre(),nuevaSerie.getPlataforma(),nuevaSerie.getLstTemporadas()});}
    }

}
