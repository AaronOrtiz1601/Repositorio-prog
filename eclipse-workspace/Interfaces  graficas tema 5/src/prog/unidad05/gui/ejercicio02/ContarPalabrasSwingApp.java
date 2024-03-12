package prog.unidad05.gui.ejercicio02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ContarPalabrasSwingApp {

  private JFrame frame;
  private JButton btnNewButton;
  private JTextArea textArea;
  private JLabel lblNewLabel;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ContarPalabrasSwingApp window = new ContarPalabrasSwingApp();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public ContarPalabrasSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JScrollPane scrollPane = new JScrollPane();
    
    btnNewButton = new JButton("Contar");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textoDondeBuscar = textArea.getText();
        String[] palabras = textoDondeBuscar.split("\\s+");

        Map<String, Integer> contadorDePalabras = new HashMap<>();
        for (String palabra : palabras) {
            if (contadorDePalabras.containsKey(palabra)) {
                int clave = contadorDePalabras.get(palabra);
                clave = clave + 1;
                contadorDePalabras.put(palabra, clave); 
            } else {
                contadorDePalabras.put(palabra, 1);
            }
        }

        int mayorClave = -1;
        String keyPalabra = "";
        for (String clave : contadorDePalabras.keySet()) {
            int nuevaClave = contadorDePalabras.get(clave);
            if (nuevaClave > mayorClave) {
                mayorClave = nuevaClave;
                keyPalabra = clave;
            }
        }

        lblNewLabel.setText("La palabra que mas se repite, con un numero de " + mayorClave + " repeticiones es " + keyPalabra);
      }
    });
    
    lblNewLabel = new JLabel("                                ");
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(62)
              .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(49)
              .addComponent(btnNewButton)
              .addGap(18)
              .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(723, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(23)
          .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(btnNewButton)
            .addComponent(lblNewLabel))
          .addGap(19))
    );
    
    textArea = new JTextArea();
    scrollPane.setViewportView(textArea);
    frame.getContentPane().setLayout(groupLayout);
  }
}
