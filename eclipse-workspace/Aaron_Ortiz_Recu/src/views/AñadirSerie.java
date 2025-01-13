package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import mainApp.App;
import modelos.Serie;
import modelos.Temporada;
import modelos.Usuario;

public class AñadirSerie extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField textFieldNombre;
  private JTextField textFielfPlataforma;
  private JTextField textFieldNumero;
  private JDateChooser dateChooserIni;
  private JDateChooser dateChooserFin;

  

  /**
   * Create the dialog.
   */
  public AñadirSerie() {
    setModal(true);
    setBounds(100, 100, 372, 493);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBackground(new Color(0, 0, 0));
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JPanel panel = new JPanel();
      contentPanel.add(panel, BorderLayout.NORTH);
      panel.setLayout(new BorderLayout(0, 0));
      {
        JLabel lblNewLabel = new JLabel("Nueva Serie");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setForeground(new Color(255, 128, 0));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel, BorderLayout.NORTH);
      }
      {
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(128, 128, 128));
        panel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(2, 2, 0, 0));
        {
          JLabel lblNewLabel_2 = new JLabel("Nombre");
          lblNewLabel_2.setForeground(new Color(255, 255, 255));
          lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
          panel_1.add(lblNewLabel_2);
        }
        {
          textFieldNombre = new JTextField();
          panel_1.add(textFieldNombre);
          textFieldNombre.setColumns(10);
        }
        {
          JLabel lblNewLabel_3 = new JLabel("Plataforma");
          lblNewLabel_3.setForeground(new Color(255, 255, 255));
          lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
          panel_1.add(lblNewLabel_3);
        }
        {
          textFielfPlataforma = new JTextField();
          panel_1.add(textFielfPlataforma);
          textFielfPlataforma.setColumns(10);
        }
      }
    }
    {
      JPanel panel = new JPanel();
      panel.setBackground(new Color(128, 128, 128));
      contentPanel.add(panel, BorderLayout.CENTER);
      panel.setLayout(new GridLayout(5, 2, 0, 80));
      {
        JLabel lblNewLabel_5 = new JLabel("");
        panel.add(lblNewLabel_5);
      }
      {
        JLabel lblNewLabel_6 = new JLabel("");
        panel.add(lblNewLabel_6);
      }
      {
        JLabel lblNewLabel_1 = new JLabel("Temporada");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel_1);
      }
      {
        JLabel lblNewLabel_8 = new JLabel("1");
        lblNewLabel_8.setForeground(new Color(255, 255, 255));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_8);
      }
      {
        JLabel lblNewLabel_7 = new JLabel("Fecha inicio");
        lblNewLabel_7.setForeground(new Color(255, 255, 255));
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_7);
      }
      {
         dateChooserIni = new JDateChooser();
        panel.add(dateChooserIni);
      }
      {
        JLabel lblNewLabel_9 = new JLabel("Fecha Fin");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel_9);
      }
      {
         dateChooserFin = new JDateChooser();
        panel.add(dateChooserFin);
      }
      {
        JLabel lblNewLabel_4 = new JLabel("Numero de capitulos");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel_4);
      }
      {
        textFieldNumero = new JTextField();
        textFieldNumero.setColumns(10);
        panel.add(textFieldNumero);
      }
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setBackground(new Color(0, 0, 0));
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            int numero = Integer.parseInt(textFieldNumero.getText());
            Temporada nuevaTemporada = new Temporada(1,dateChooserIni.getDate() , dateChooserFin.getDate(),numero );
            List<Temporada> temporada = new ArrayList<>();
            
            temporada.add(nuevaTemporada);
            Serie nuevaSerie = new Serie(textFieldNombre.getText(),textFielfPlataforma.getText(),temporada);
            JOptionPane.showMessageDialog(null, "Serie creada con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
            App.series.add(nuevaSerie);
            dispose();
          }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
      {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

}
