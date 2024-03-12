package prog.unidad05.gui.ejercicio05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AficionesSwingApp {

  private JFrame frame;
  private JCheckBox chckbxAnime;
  private JCheckBox chckbxComic;
  private JCheckBox chckbxSeries;
  private JCheckBox chckbxLectura;
  private JLabel lblAficiones;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AficionesSwingApp window = new AficionesSwingApp();
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
  public AficionesSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    chckbxLectura = new JCheckBox("Lectura ");
    chckbxLectura.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(chckbxLectura.isSelected())
        {
          lblAficiones.setText(lblAficiones.getText()+chckbxLectura.getText());
        }else {
          lblAficiones.setText("");
        }
      }
    });
    
    chckbxSeries = new JCheckBox("series ");
    chckbxSeries.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        if(chckbxSeries.isSelected())
        {
          lblAficiones.setText( lblAficiones.getText()+chckbxSeries.getText());
        }else {
          lblAficiones.setText(lblAficiones.getText());
        }
      }
    });
    
    chckbxComic = new JCheckBox("Comic");
    
    chckbxAnime = new JCheckBox("Anime");
    
    JLabel lblNewLabel = new JLabel("Tus aficiones son");
    
    lblAficiones = new JLabel("                                           ");
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(19)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblAficiones, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
              .addComponent(chckbxAnime, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
              .addComponent(chckbxComic, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
              .addComponent(chckbxSeries, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
              .addComponent(chckbxLectura, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
              .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addContainerGap(93, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(20)
          .addComponent(chckbxLectura)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(chckbxSeries)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(chckbxComic)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(chckbxAnime)
          .addGap(42)
          .addComponent(lblNewLabel)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblAficiones)
          .addContainerGap(75, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
