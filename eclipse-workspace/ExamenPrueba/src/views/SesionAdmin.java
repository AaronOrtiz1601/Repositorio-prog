package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane; // Importa JOptionPane para mostrar diálogos
import java.awt.event.MouseAdapter; // Importa MouseAdapter
import java.awt.event.MouseEvent; // Importa MouseEvent

/**
 * Clase que se encarga de la sesion si es por parte de un administrador
 */
public class SesionAdmin extends JFrame {
    //Atributos privados de la clase
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SesionAdmin frame = new SesionAdmin();
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
    public SesionAdmin() {
        setTitle("Sesión Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 749, 511);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); 

        setContentPane(contentPane);

        initializeComponents();
    }

    private void initializeComponents() {
        JLabel lblNewLabel = new JLabel("GYM PICASSO");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setBackground(new Color(173, 216, 230));
        lblNewLabel.setForeground(new Color(0, 64, 128));
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/resources/logoApp.png")));
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 749, 56);

        JLabel lblNewLabel_1 = new JLabel("Aarón Ortiz Sánchez");
        lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setBackground(new Color(173, 216, 230));
        lblNewLabel_1.setForeground(new Color(0, 64, 128));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 454, 749, 30); 

        JLabel lblNewLabel_2 = new JLabel("Añadir clase");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(122, 165, 86, 16); 

        JLabel lblClases = new JLabel("");
        lblClases.setIcon(new ImageIcon(SesionAdmin.class.getResource("/resources/addClase.png")));
        lblClases.setBounds(122, 102, 86, 79); 
        lblClases.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            Clases ventana = new Clases();
            ventana.setVisible(true);
             
          }
      });

        JLabel lblNewLabel_2_1 = new JLabel("Ver reservas");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_1.setBounds(513, 165, 86, 16); 

        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            VerReservas reserva = new VerReservas();
            reserva.setVisible(true);
          }
        });
        lblNewLabel_4.setIcon(new ImageIcon(SesionAdmin.class.getResource("/resources/listarReservas.png")));
        lblNewLabel_4.setBounds(524, 104, 62, 62); 

        // Agregar los componentes al panel
        contentPane.add(lblNewLabel);
        contentPane.add(lblNewLabel_1);
        contentPane.add(lblNewLabel_2);
        contentPane.add(lblClases);
        contentPane.add(lblNewLabel_2_1);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_2_2 = new JLabel("Ver clientes");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_2.setBounds(122, 336, 86, 16);
        contentPane.add(lblNewLabel_2_2);
        
        JLabel lblClientes = new JLabel("");
        lblClientes.setIcon(new ImageIcon(SesionAdmin.class.getResource("/resources/listarUsuarios.png")));
        lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblClientes.setBounds(122, 278, 86, 48);
        contentPane.add(lblClientes);
        
        lblClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              ListaClientes lista = new ListaClientes();
              lista.setVisible(true);
               
            }
        });
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Cerrar sesión");
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_1_1.setBounds(531, 336, 86, 16);
        contentPane.add(lblNewLabel_2_1_1);
        
        JLabel lblCerrarSesion = new JLabel("New label");
        lblCerrarSesion.setIcon(new ImageIcon(SesionAdmin.class.getResource("/resources/cierreSesion.png")));
        lblCerrarSesion.setBounds(537, 264, 62, 62);
        
        // Agregar un MouseListener para cerrar la ventana
        lblCerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    SesionAdmin.this,
                    "¿Estás seguro de que deseas cerrar sesión?",
                    "Cerrar sesión",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    Principal ventana = new Principal();
                    ventana.setVisible(true);
                    dispose(); 
                }
            }
        });
        
        contentPane.add(lblCerrarSesion);
    }
}
