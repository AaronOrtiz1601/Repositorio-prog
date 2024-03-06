package prog.unidad05.gui.ejercicio01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class CalculadoraSwingApp {

  private JFrame frame;
  private JTextField primerOperando;
  private JTextField segundoOperando;
  private JLabel lblResultadoVisible;
  private JButton División;
  private JButton btnProducto;
  private JButton btnResta;
  private JButton btnSuma;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CalculadoraSwingApp window = new CalculadoraSwingApp();
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
  public CalculadoraSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 657, 333);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblPrimerOperando = new JLabel("Primer Operando :");
    
    JLabel lblSegundoOperando = new JLabel("segundo operando:");
    
    primerOperando = new JTextField();
    primerOperando.setColumns(10);
    
    segundoOperando = new JTextField();
    segundoOperando.setColumns(10);
    
    btnSuma = new JButton("Suma");
    btnSuma.addActionListener(new ActionListener() {
 
      public void actionPerformed(ActionEvent e) {
       String numero1 = primerOperando.getText();
       String numero2 = segundoOperando.getText();
       double numeroParaSuma1 = Integer.parseInt(numero1);
       double numeroParaSuma2 = Integer.parseInt(numero2);
       double sumaNumeros = numeroParaSuma1 + numeroParaSuma2;
       String sumaCadena = String.valueOf(sumaNumeros);
       lblResultadoVisible.setText(sumaCadena);
        
        
      }
    });
    
    btnResta = new JButton("Resta");
    btnResta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String numero1 = primerOperando.getText();
        String numero2 = segundoOperando.getText();
        double numeroParaResta1 = Integer.parseInt(numero1);
        double numeroParaResta2 = Integer.parseInt(numero2);
        double restaNumeros = numeroParaResta1 - numeroParaResta2;
        String restaCadena = String.valueOf(restaNumeros);
        lblResultadoVisible.setText(restaCadena);
      }
    });
    
    btnProducto = new JButton("Producto");
    btnProducto.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String numero1 = primerOperando.getText();
        String numero2 = segundoOperando.getText();
        double numeroParaProducto1 = Integer.parseInt(numero1);
        double numeroParaProducto2 = Integer.parseInt(numero2);
        double productoNumeros = numeroParaProducto1 * numeroParaProducto2;
        String productoCadena = String.valueOf(productoNumeros);
        lblResultadoVisible.setText(productoCadena);
      }
    });
    
    División = new JButton("División");
    División.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String numero1 = primerOperando.getText();
        String numero2 = segundoOperando.getText();
        double numeroParaDivision1 = Integer.parseInt(numero1);
        double numeroParaDivision2 = Integer.parseInt(numero2);
        double divisionNumeros = numeroParaDivision1 / numeroParaDivision2;
        String divisionCadena = String.valueOf(divisionNumeros);
        if (!numero2.equals("0"))
        {
        lblResultadoVisible.setText(divisionCadena);
        }else
        {
          lblResultadoVisible.setText("No se puede dividir entre 0");
        }
        
      }
    });
    
    JLabel lblResultado = new JLabel("Resultado :");
    
    lblResultadoVisible = new JLabel("          ");
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(lblPrimerOperando, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(primerOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(lblSegundoOperando, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(segundoOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
              .addGap(178)
              .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                .addComponent(División, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuma, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProducto, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(lblResultadoVisible, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(26)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblPrimerOperando, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
            .addComponent(primerOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSuma))
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(18)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblSegundoOperando, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addComponent(segundoOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(3)
              .addComponent(btnResta)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(btnProducto, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(18)
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblResultadoVisible)))
            .addGroup(groupLayout.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(División)))
          .addContainerGap(147, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
