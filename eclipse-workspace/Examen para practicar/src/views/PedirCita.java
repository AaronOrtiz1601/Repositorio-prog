package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import MainApp.App;
import models.Citas;

public class PedirCita extends JDialog {

    // Panel principal
    JPanel contentPanel = new JPanel();
    JTextField textFieldMatricula;
    JTextField textFieldMarca;
    JTextField textFieldModelo;
    JDateChooser dateChooser;

    // Constructor
    public PedirCita() {
        setModal(true);
        setBounds(100, 100, 486, 392);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(128, 255, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 20));

        // Panel superior
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 64, 128));
        contentPanel.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("Pedir Cita previa");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel_1);

        // Panel central
        JPanel panel_1 = new JPanel();
        contentPanel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(4, 2, 0, 35));

        JLabel lblNewLabel_15 = new JLabel("Matricula");
        lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_15);

        textFieldMatricula = new JTextField();
        panel_1.add(textFieldMatricula);
        textFieldMatricula.setColumns(10);

        JLabel lblNewLabel_13 = new JLabel("Marca");
        lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_13);

        textFieldMarca = new JTextField();
        textFieldMarca.setColumns(10);
        panel_1.add(textFieldMarca);

        JLabel lblNewLabel_11 = new JLabel("Modelo");
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_11);

        textFieldModelo = new JTextField();
        textFieldModelo.setColumns(10);
        panel_1.add(textFieldModelo);

        JLabel lblNewLabel_9 = new JLabel("Fecha");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_9);

        dateChooser = new JDateChooser();
        panel_1.add(dateChooser);

        // Panel inferior con los botones
        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(128, 255, 255));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Aceptar");
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (textFieldMatricula.getText().isEmpty() || textFieldMarca.getText().isEmpty() ||
                        textFieldModelo.getText().isEmpty() || dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Citas cita = new Citas(
                            textFieldMatricula.getText(),
                            textFieldMarca.getText(),
                            textFieldModelo.getText(),
                            dateChooser.getDate()
                    );

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    long citasEnFecha = App.listaCita.stream()
                            .filter(nuevaCita -> sdf.format(nuevaCita.getFecha()).equals(sdf.format(cita.getFecha())))
                            .count();

                    if (citasEnFecha >= 2) {
                        JOptionPane.showMessageDialog(null, "Ya hay dos coches ese día", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        App.listaCita.add(cita);
                        Principal.getClienteActivo().getMisCitas().add(cita);
                        JOptionPane.showMessageDialog(null, "Cita pedida", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                }
            }
        });
        buttonPane.add(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cancelar?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
        buttonPane.add(cancelButton);
    }

   
}
