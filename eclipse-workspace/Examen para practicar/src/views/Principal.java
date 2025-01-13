package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import MainApp.App;
import models.Usuario;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_1;
    private static Usuario clienteActivo; 

    public static Usuario getClienteActivo() {
        return clienteActivo;
    }

    /**
     * Constructor para crear el marco principal.
     */
    public Principal() {
        // Configuración del JFrame
        setTitle("Talleres Picasso - Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(506, 577);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        getContentPane().setLayout(new BorderLayout(0, 0));

        // Panel principal con fondo azul claro
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 255, 255));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        // Panel superior
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(128, 255, 255));
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        // Icono del coche
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/resources/cocheAzul.png")));
        panel_1.add(lblNewLabel);

        // Título
        JLabel lblNewLabel_1 = new JLabel("Talleres Picasso");
        lblNewLabel_1.setForeground(new Color(0, 64, 128));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_1.add(lblNewLabel_1);

        // Panel central
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(128, 255, 255));
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(3, 2, 0, 80));

        // Etiqueta y campo de texto para Usuario
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        panel_2.add(lblUsuario);

        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(10);

        // Etiqueta y campo de texto para Contraseña
        JLabel lblContrasena = new JLabel("Contraseña");
        lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
        lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_2.add(lblContrasena);

        textField_1 = new JTextField();
        panel_2.add(textField_1);
        textField_1.setColumns(10);

        // Etiqueta para registro
        JLabel lblNoCuenta = new JLabel("¿No tienes cuenta?");
        lblNoCuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Registro ventana = new Registro();
                ventana.setVisible(true);
            }
        });
        lblNoCuenta.setForeground(new Color(0, 0, 255));
        lblNoCuenta.setHorizontalAlignment(SwingConstants.CENTER);
        panel_2.add(lblNoCuenta);

        // Botón para iniciar sesión
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.addActionListener(e -> {
          String usuario = textField.getText();
          String contrasena = textField_1.getText();
          boolean avisador = false;

          // Recorre la lista de clientes
          for (int i = 0; i < App.clientes.size(); i++) {
              if (usuario.equals(App.clientes.get(i).getEmail()) && contrasena.equals(App.clientes.get(i).getContraseña())) {
                  avisador = true;
                  clienteActivo = App.clientes.get(i);
                  PantallaCliente ventana = new PantallaCliente();
                  ventana.setVisible(true);
                  dispose();
                  break; // Salimos del bucle si encontramos una coincidencia
              }
          }

          // Recorre la lista de empleados
          if (!avisador) { // Si no se ha encontrado en clientes, comprobamos en empleados
              for (int i = 0; i < App.empleados.size(); i++) {
                  if (usuario.equals(App.empleados.get(i).getEmail()) && contrasena.equals(App.empleados.get(i).getContraseña())) {
                      avisador = true;
                     clienteActivo = App.empleados.get(i);
                     PantallaEmpleado ventana = new PantallaEmpleado();
                     ventana.setVisible(true);
                     dispose();
                      break; // Salimos del bucle si encontramos una coincidencia
                  }
              }
          }

          // Si no se encuentra coincidencia, mostrar el mensaje de error
          if (!avisador) {
              JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Ups...", JOptionPane.ERROR_MESSAGE);
          }
      });

        panel_2.add(btnIniciarSesion);

        // Panel lateral derecho
        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(new Color(128, 255, 255));
        getContentPane().add(panelDerecho, BorderLayout.EAST);

        // Panel lateral izquierdo
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(new Color(128, 255, 255));
        getContentPane().add(panelIzquierdo, BorderLayout.WEST);

        // Panel inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(128, 255, 255));
        getContentPane().add(panelInferior, BorderLayout.SOUTH);
    }

  
}
