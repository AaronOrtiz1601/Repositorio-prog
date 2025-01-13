package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import MainApp.App;
import models.Citas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActReparacion extends JDialog {

    private JPanel contentPanel = new JPanel();
    private JTextField textFieldMarca;
    private JTextField textFieldModelo;
    private JTextField textFieldEstado;
    private JTextField textFieldImporte;
    private JComboBox<String> comboBoxNuevoEstado;
    private JLabel lblImporte;
    private JLabel lblObservaciones;
    private JTextArea textAreaObservaciones;

    public ActReparacion() {
        setModal(true);
        setBounds(100, 100, 549, 561);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(128, 255, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 20));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 64, 128));
        contentPanel.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("Actualizar Reparación");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setForeground(Color.WHITE);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        contentPanel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(7, 2, 0, 35));

        JLabel lblMatricula = new JLabel("Matrícula");
        lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblMatricula);

        JComboBox<String> comboBoxMatricula = new JComboBox<>(lista().toArray(new String[0]));
        panel_1.add(comboBoxMatricula);

        JLabel lblMarca = new JLabel("Marca");
        lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblMarca);

        textFieldMarca = new JTextField();
        textFieldMarca.setEditable(false);
        panel_1.add(textFieldMarca);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblModelo);

        textFieldModelo = new JTextField();
        textFieldModelo.setEditable(false);
        panel_1.add(textFieldModelo);

        JLabel lblEstado = new JLabel("Estado Actual");
        lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblEstado);

        textFieldEstado = new JTextField();
       
       
        textFieldEstado.setEditable(false);
        panel_1.add(textFieldEstado);

        JLabel lblNuevoEstado = new JLabel("Nuevo Estado");
        lblNuevoEstado.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNuevoEstado);

        comboBoxNuevoEstado = new JComboBox<>();
        comboBoxNuevoEstado.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String matriculaSeleccionada = comboBoxMatricula.getSelectedItem().toString();
            for (int i = 0; i < App.listaCita.size(); i++) {
              if (matriculaSeleccionada.equals(App.listaCita.get(i).getMatricula())) {
                String estado = comboBoxNuevoEstado.getSelectedItem().toString();
                if (estado.equals("Finalizado")) {
                setVisibility(true);
                }else {
                  setVisibility(false);
                }
              
          }
        }
          }});
        
        panel_1.add(comboBoxNuevoEstado);

        lblImporte = new JLabel("Importe");
        lblImporte.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblImporte);

        textFieldImporte = new JTextField();
        panel_1.add(textFieldImporte);

        lblObservaciones = new JLabel("Observaciones");
        lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblObservaciones);

        textAreaObservaciones = new JTextArea();
        panel_1.add(textAreaObservaciones);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(128, 255, 255));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Aceptar");
        buttonPane.add(okButton);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   

                    // Actualizar la cita seleccionada
                    String matriculaSeleccionada = comboBoxMatricula.getSelectedItem().toString();
                    for (int i = 0; i < App.listaCita.size(); i++) {
                        if (matriculaSeleccionada.equals(App.listaCita.get(i).getMatricula())) {
                            Citas cita = App.listaCita.get(i);
                            cita.setEstado(comboBoxNuevoEstado.getSelectedItem().toString());
                            cita.setImporte(textFieldImporte.getText());
                            cita.setObservaciones(textAreaObservaciones.getText());
                            JOptionPane.showMessageDialog(ActReparacion.this, "Datos actualizados correctamente.");
                            break;
                        }
                    }

                    dispose();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ActReparacion.this, "Ocurrió un error al actualizar los datos.");
                }
            }
        });

        JButton cancelButton = new JButton("Cancelar");
        buttonPane.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(ActReparacion.this, "¿Estás seguro de que quieres cancelar?",
                        "Confirmación", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // Listener para actualizar los campos al seleccionar una matrícula
        comboBoxMatricula.addActionListener(e -> {
            if (App.listaCita == null || App.listaCita.isEmpty()) {
                JOptionPane.showMessageDialog(ActReparacion.this, "No hay citas disponibles.");
                return;
            }

            String matriculaSeleccionada = comboBoxMatricula.getSelectedItem().toString();
            for (Citas cita : App.listaCita) {
                if (matriculaSeleccionada.equals(cita.getMatricula())) {
                    textFieldMarca.setText(cita.getMarca());
                    textFieldModelo.setText(cita.getModelo());
                    textFieldEstado.setText(cita.getEstado());

                    comboBoxNuevoEstado.removeAllItems();
                    for (String estado : valorComboBox(cita.getMatricula())) {
                        comboBoxNuevoEstado.addItem(estado);
                    }
                    break;
                }
            }
        });

        setVisibility(false); // Inicialmente oculta los campos de importe y observaciones
    }

    private static List<String> lista() {
        List<String> lista = new ArrayList<>();
        for (Citas cita : App.listaCita) {
            if (!"Finalizado".equals(cita.getEstado())) {
                lista.add(cita.getMatricula());
            }
        }
        return lista;
    }

    private static String[] valorComboBox(String matricula) {
        for (Citas cita : App.listaCita) {
            if (cita.getMatricula().equals(matricula)) {
                switch (cita.getEstado()) {
                    case "Pendiente":
                        return new String[]{"En curso", "Pendiente"};
                    case "En curso":
                        return new String[]{"Finalizado", "En curso"};
                    case "Finalizado":
                        return new String[]{"Finalizado"};
                    default:
                        return new String[]{cita.getEstado()};
                }
            }
        }
        return new String[0];
    }

    private void setVisibility(boolean visible) {
        lblImporte.setVisible(visible);
        lblObservaciones.setVisible(visible);
        textFieldImporte.setVisible(visible);
        textAreaObservaciones.setVisible(visible);
    }
}
