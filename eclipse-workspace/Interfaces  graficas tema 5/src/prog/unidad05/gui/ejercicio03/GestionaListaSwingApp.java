package prog.unidad05.gui.ejercicio03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class GestionaListaSwingApp {

  private JFrame frame;
  private JList list;
  private JTextArea textArea;
  private JButton btnAñadir;
  private JButton btnEliminar;
  private DefaultListModel <String> modelo = new DefaultListModel<>();
  

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionaListaSwingApp window = new GestionaListaSwingApp();
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
  public GestionaListaSwingApp() {
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
    
    textArea = new JTextArea();
    
    btnAñadir = new JButton("añadir");
    btnAñadir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textoAAñadir = textArea.getText();
        modelo.addElement(textoAAñadir);
        list.setModel(modelo);
       
      }
    });
    
    btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int marca = list.getSelectedIndex();
        modelo.remove(marca);
        list.setModel(modelo);
        
      }
    });
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(43)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
              .addGap(18)
              .addComponent(btnAñadir))
            .addComponent(btnEliminar, Alignment.TRAILING))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(36)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(18)
              .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(btnAñadir)))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(btnEliminar)
          .addContainerGap(39, Short.MAX_VALUE))
    );
    
    list = new JList();
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    
    scrollPane.setViewportView(list);
    frame.getContentPane().setLayout(groupLayout);
  }

}
