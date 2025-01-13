package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Principal frame = new Principal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 853, 591);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 64, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        
        JLayeredPane layeredPane = new JLayeredPane();
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/resources/descarga (1).png")));
        
        JLabel lblNewLabel_1 = new JLabel("Sistema de gestion by Aarón Ortiz Sánchez");
        lblNewLabel_1.setForeground(new Color(0, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        
        JLabel lblClientes = new JLabel("Clientes", JLabel.CENTER);
        lblClientes.setIcon(new ImageIcon(Principal.class.getResource("/resources/images.png")));
        lblClientes.setBackground(new Color(0, 64, 128));
        lblClientes.setForeground(Color.WHITE);
        lblClientes.setOpaque(true);
        lblClientes.setHorizontalTextPosition(JLabel.RIGHT);
        lblClientes.setVerticalTextPosition(JLabel.CENTER);
        lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
     lblClientes.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseClicked(MouseEvent e) {
         // Limpia el contenido anterior
           layeredPane.removeAll();
           Clientes clientesPanel = new Clientes(layeredPane); 
           clientesPanel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight()); 
        // Añade el panel Clientes al layeredPane
           layeredPane.add(clientesPanel); 
           layeredPane.repaint(); 
           layeredPane.revalidate(); 
       }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                lblClientes.setBackground(new Color(0, 32, 100));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblClientes.setBackground(new Color(0, 64, 128));
            }
        });

        JLabel lblProductos = new JLabel("Productos", SwingConstants.CENTER);
        lblProductos.setIcon(new ImageIcon(Principal.class.getResource("/resources/1170628.png")));
        lblProductos.setVerticalTextPosition(SwingConstants.CENTER);
        lblProductos.setOpaque(true);
        lblProductos.setHorizontalTextPosition(SwingConstants.RIGHT);
        lblProductos.setForeground(Color.WHITE);
        lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblProductos.setBackground(new Color(0, 64, 128));
        
        // Añadir manejador de eventos para lblProductos
        lblProductos.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            // Limpia el contenido anterior
              layeredPane.removeAll();
              Productos productosPanel = new Productos(layeredPane); 
              productosPanel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight()); 
           // Añade el panel Clientes al layeredPane
              layeredPane.add(productosPanel); 
              layeredPane.repaint(); 
              layeredPane.revalidate(); 
          }

               @Override
               public void mouseEntered(MouseEvent e) {
                   lblProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                   lblProductos.setBackground(new Color(0, 32, 100));
               }

               @Override
               public void mouseExited(MouseEvent e) {
                 lblProductos.setBackground(new Color(0, 64, 128));
               }
        });

        JLabel lblFacturas = new JLabel("Facturas", SwingConstants.CENTER);
        lblFacturas.setIcon(new ImageIcon(Principal.class.getResource("/resources/522575.png")));
        lblFacturas.setVerticalTextPosition(SwingConstants.CENTER);
        lblFacturas.setOpaque(true);
        lblFacturas.setHorizontalTextPosition(SwingConstants.RIGHT);
        lblFacturas.setForeground(Color.WHITE);
        lblFacturas.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFacturas.setBackground(new Color(0, 64, 128));
        
        // Añadir manejador de eventos para lblFacturas
        lblFacturas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Facturas clicked");
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                lblFacturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
           
        });

        JLabel lblUsuario = new JLabel("Usuario", SwingConstants.CENTER);
        lblUsuario.setIcon(new ImageIcon(Principal.class.getResource("/resources/pngtree-professor-transparent-icon-user-avatar-symbol-professional-people-and-character-vector-png-image_11753717.png")));
        lblUsuario.setVerticalTextPosition(SwingConstants.CENTER);
        lblUsuario.setOpaque(true);
        lblUsuario.setHorizontalTextPosition(SwingConstants.RIGHT);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsuario.setBackground(new Color(0, 64, 128));
        
        // Añadir manejador de eventos para lblUsuario
        lblUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Usuario clicked");
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                lblUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            
           
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(78)
                    .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGap(18)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addGap(79))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblClientes, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblProductos, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblFacturas, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(109, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(24)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addGap(38)
                    .addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addComponent(lblUsuario, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addComponent(lblFacturas, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addComponent(lblProductos, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addComponent(lblClientes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)))
        );
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 192));
        panel.setBounds(0, 0, 819, 296);
        layeredPane.add(panel);
        contentPane.setLayout(gl_contentPane);
    }
}
