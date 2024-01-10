//package gui;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.FlowLayout;
//import javax.swing.JComboBox;
//import javax.swing.JEditorPane;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class HelloWorld extends JFrame {
//
//  private static final long serialVersionUID = 1L;
//  private JPanel contentPane;
//  private JTextField textField;
//  //Creamos la variable labelnombre
//  private JLabel lblNombre;
//
//  /**
//   * Launch the application.
//   */
//  public static void main(String[] args) {
//    EventQueue.invokeLater(new Runnable() {
//      public void run() {
//        try {
//          HelloWorld frame = new HelloWorld();
//          frame.setVisible(true);
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      }
//    });
//  }
//
//  /**
//   * Create the frame.
//   */
//  public HelloWorld() {
//    setTitle("Ventana");
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setBounds(100, 100, 450, 300);
//    contentPane = new JPanel();
//    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//    setContentPane(contentPane);
//    contentPane.setLayout(null);
//    
//    lblNombre lblNombre_1 = new JLabel("New label");
//    lblNombre_1.setBounds(27, 53, 114, 40);
//    contentPane.add(lblNombre_1);
//    
//    JButton btnNewButton = new JButton("New button");
//    btnNewButton.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        //Creamos un método para las funciones de los botones
//        btnNombrePressed(e);
//        
//      }
//
//     
//    });
//    btnNewButton.setBounds(308, 61, 117, 25);
//    contentPane.add(btnNewButton);
//    
//    textField = new JTextField();
//    textField.setBounds(108, 64, 188, 19);
//    contentPane.add(textField);
//    textField.setColumns(10);
//    
//    private void btnNombrePressed(ActionEvent e) {
//      
//      String textoDelTextField = txtNombre.getText();
//      lblNombre.setText(textoDelTextField);
//      
//    }
//  }
//}
