package prog.unidad05.gui.ejercicio04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionaComboSwingApp {

  private JFrame frame;
  private JTextArea textArea;
  private JButton btnAñadir;
  private JButton btnEliminar;
  private DefaultComboBoxModel <String> modelo = new DefaultComboBoxModel<>();
  private JComboBox comboBox;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionaComboSwingApp window = new GestionaComboSwingApp();
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
  public GestionaComboSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    comboBox = new JComboBox();
    
    
    textArea = new JTextArea();
    
    btnAñadir = new JButton("Añadir");
    btnAñadir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textoAAñadir = textArea.getText();
        modelo.addElement(textoAAñadir);
        comboBox.setModel(modelo);
        
      }
    });
    
    btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int marca = comboBox.getSelectedIndex();
        modelo.removeElementAt(marca);
        comboBox.setModel(modelo);
      }
    });
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(10)
              .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(btnEliminar)
                .addComponent(btnAñadir))))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(27)
          .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addGap(88)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAñadir))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(btnEliminar)
          .addContainerGap(76, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
