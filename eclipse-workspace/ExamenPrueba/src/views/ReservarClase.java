package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import MainApp.App;
import models.Clase;
import models.Reservas;
/**
 * Clase que se encarga de la reserva de clases
 */
public class ReservarClase extends JDialog {
  //Atributos privados de la clase
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;

    public ReservarClase() {
        setModal(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("ReservarClase");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setBackground(new Color(0, 128, 192));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(lblNewLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        contentPanel.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 2, 0, 50));

        JLabel lblClase = new JLabel("Clase");
        panel.add(lblClase);
        comboBox1 = new JComboBox<>(generarListaClases().toArray(new String[0]));
        panel.add(comboBox1);

        JLabel lblTurno = new JLabel("Turno");
        panel.add(lblTurno);
        String[] turnos = {"Tardes", "Mañana"};
        comboBox2 = new JComboBox<>(turnos);
        panel.add(comboBox2);

        JLabel lblEspacio = new JLabel("");
        panel.add(lblEspacio);

        JButton btnReservar = new JButton("Reservar");
        btnReservar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              String nombreClase = comboBox1.getSelectedItem().toString();
              String turno = comboBox2.getSelectedItem().toString();
              String nombreCliente = Principal.getClienteActivo().getNombre(); 
              String apellidoCliente = Principal.getClienteActivo().getApellidos();

              // Verificación de existencia de la clase en el turno seleccionado
              boolean claseEncontrada = false;
              for (Clase clase : App.clases) {
                  if (clase.getNombre().equals(nombreClase) && clase.getTiempo().equals(turno)) {
                      claseEncontrada = true;
                      break;
                  }
              }
              //Si la clase ha sido encontrada damos el visto bueno a la reserva y si no mostramos el mensaje respectivo de error
              if (claseEncontrada) {
                  if (nombreCliente != null) {
                      Reservas nuevaReserva = new Reservas(nombreCliente, apellidoCliente, nombreClase, turno);
                      App.reservas.add(nuevaReserva);
                      JOptionPane.showMessageDialog(null, "Reserva realizada con éxito para " + nombreCliente, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                      dispose();
                  } else {
                      JOptionPane.showMessageDialog(null, "Error: No hay cliente activo", "Error", JOptionPane.ERROR_MESSAGE);
                  }
              } else {
                  JOptionPane.showMessageDialog(null, "La clase '" + nombreClase + "' no está disponible en el turno '" + turno + "'.", "Error de Reserva", JOptionPane.WARNING_MESSAGE);
              }
          }
      });

        panel.add(btnReservar);
    }
    /**
     * Metodo privado que se encarga de generar una lista para sacar todas las clases creadas
     * @return
     */
    private List<String> generarListaClases() {
        List<String> clases = new ArrayList<>();
        for (Clase nuevaClase : App.clases) {
            clases.add(nuevaClase.getNombre());
        }
        return clases;
    }
}
