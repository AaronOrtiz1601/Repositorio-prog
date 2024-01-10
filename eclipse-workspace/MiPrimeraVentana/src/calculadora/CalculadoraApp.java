package calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Toolkit;

public class CalculadoraApp extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField cajaResultado;
  int numero1;
  int numero2;
  String signoOperando;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CalculadoraApp frame = new CalculadoraApp();
          frame.setVisible(true);
          frame.setLocationRelativeTo(null);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public CalculadoraApp() {
    setIconImage(Toolkit.getDefaultToolkit().getImage("/home/tomas/Imágenes/6df58171de619b75b44d6efc56eda837.jpg"));
    setTitle("Calculator 3000");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 659, 370);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(61, 56, 70));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    cajaResultado = new JTextField();
    cajaResultado.setBackground(new Color(143, 240, 164));
    cajaResultado.setForeground(new Color(38, 162, 105));
    cajaResultado.setHorizontalAlignment(SwingConstants.RIGHT);
    cajaResultado.setFont(new Font("Ani", Font.PLAIN, 50));
    cajaResultado.setBounds(148, 28, 474, 80);
    contentPane.add(cajaResultado);
    cajaResultado.setColumns(10);
    
    JButton btnC_1 = new JButton("EXIT");
    btnC_1.setBackground(new Color(36, 31, 49));
    btnC_1.setIcon(new ImageIcon("/home/tomas/Imágenes/redimensionado.jpg"));
    btnC_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);        
      }
    });
    btnC_1.setFont(new Font("Abyssinica SIL", Font.PLAIN, 26));
    btnC_1.setBounds(21, 28, 100, 80);
    contentPane.add(btnC_1);
    
    JButton btnNewButton = new JButton("0");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"0");
      }
    });
    btnNewButton.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton.setForeground(new Color(255, 255, 255));
    btnNewButton.setBackground(new Color(36, 31, 49));
    btnNewButton.setBounds(21, 284, 357, 39);
    contentPane.add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("2");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"2");
      }
    });
    btnNewButton_1.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_1.setBackground(new Color(36, 31, 49));
    btnNewButton_1.setForeground(new Color(255, 255, 255));
    btnNewButton_1.setBounds(148, 232, 100, 39);
    contentPane.add(btnNewButton_1);
    
    JButton btnNewButton_2 = new JButton("3");
    btnNewButton_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"3");
      }
    });
    btnNewButton_2.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_2.setBackground(new Color(36, 31, 49));
    btnNewButton_2.setForeground(new Color(255, 255, 255));
    btnNewButton_2.setBounds(278, 232, 100, 40);
    contentPane.add(btnNewButton_2);
    
    JButton btnNewButton_3 = new JButton("6");
    btnNewButton_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"6");
      }
    });
    btnNewButton_3.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_3.setBackground(new Color(36, 31, 49));
    btnNewButton_3.setForeground(new Color(255, 255, 255));
    btnNewButton_3.setBounds(278, 180, 100, 39);
    contentPane.add(btnNewButton_3);
    
    JButton btnNewButton_4 = new JButton("9");
    btnNewButton_4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"9");
      }
    });
    btnNewButton_4.setBackground(new Color(36, 31, 49));
    btnNewButton_4.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_4.setForeground(new Color(255, 255, 255));
    btnNewButton_4.setBounds(278, 128, 100, 39);
    contentPane.add(btnNewButton_4);
    
    JButton btnNewButton_5 = new JButton("5");
    btnNewButton_5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"5");
      }
    });
    btnNewButton_5.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_5.setBackground(new Color(36, 31, 49));
    btnNewButton_5.setForeground(new Color(255, 255, 255));
    btnNewButton_5.setBounds(149, 180, 99, 39);
    contentPane.add(btnNewButton_5);
    
    JButton btnNewButton_6 = new JButton("8");
    btnNewButton_6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"8");
      }
    });
    btnNewButton_6.setBackground(new Color(36, 31, 49));
    btnNewButton_6.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_6.setForeground(new Color(255, 255, 255));
    btnNewButton_6.setBounds(148, 128, 100, 40);
    contentPane.add(btnNewButton_6);
    
    JButton btnNewButton_7 = new JButton("1");
    btnNewButton_7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"1");
      }
    });
    btnNewButton_7.setBackground(new Color(36, 31, 49));
    btnNewButton_7.setForeground(new Color(255, 255, 255));
    btnNewButton_7.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_7.setBounds(21, 232, 100, 40);
    contentPane.add(btnNewButton_7);
    
    JButton btnNewButton_8 = new JButton("4");
    btnNewButton_8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"4");
      }
      
    });
    btnNewButton_8.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_8.setBackground(new Color(36, 31, 49));
    btnNewButton_8.setForeground(new Color(255, 255, 255));
    btnNewButton_8.setBounds(21, 180, 100, 39);
    contentPane.add(btnNewButton_8);
    
    JButton btnNewButton_9 = new JButton("7");
    btnNewButton_9.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText(cajaResultado.getText()+"7");
      }
    });
    btnNewButton_9.setBackground(new Color(36, 31, 49));
    btnNewButton_9.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_9.setForeground(new Color(255, 255, 255));
    btnNewButton_9.setBounds(21, 128, 100, 40);
    contentPane.add(btnNewButton_9);
    
    JButton btnNewButton_10 = new JButton("=");
    btnNewButton_10.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        numero2 = Integer.parseInt(cajaResultado.getText());
        
        if (signoOperando.equals("+")) {
          cajaResultado.setText(Integer.toString(numero1 + numero2));
        }else if (signoOperando.equals("-")) {
          cajaResultado.setText(Integer.toString(numero1 - numero2));
        }else if (signoOperando.equals("*")) {
          cajaResultado.setText(Integer.toString(numero1 * numero2));
        }else if (signoOperando.equals("/")) {
          if (numero2 == 0) {
            cajaResultado.setText("Error");
          }else {
            cajaResultado.setText(Integer.toString(numero1 / numero2));
          }
        }
      }
    });
    btnNewButton_10.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_10.setBackground(new Color(165, 29, 45));
    btnNewButton_10.setForeground(new Color(255, 255, 255));
    btnNewButton_10.setBounds(522, 232, 100, 92);
    contentPane.add(btnNewButton_10);
    
    JButton btnNewButton_11 = new JButton("C");
    btnNewButton_11.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        cajaResultado.setText("");
      }
    });
    btnNewButton_11.setBackground(new Color(192, 28, 40));
    btnNewButton_11.setFont(new Font("Century Schoolbook L", Font.BOLD, 26));
    btnNewButton_11.setForeground(new Color(255, 255, 255));
    btnNewButton_11.setBounds(522, 127, 100, 92);
    contentPane.add(btnNewButton_11);
    
    JButton btnNewButton_12 = new JButton("/");
    btnNewButton_12.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        numero1 = Integer.parseInt(cajaResultado.getText());
        signoOperando = "/";
        cajaResultado.setText("");
      }
    });
    btnNewButton_12.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_12.setBackground(new Color(94, 92, 100));
    btnNewButton_12.setForeground(new Color(255, 255, 255));
    btnNewButton_12.setBounds(402, 128, 100, 40);
    contentPane.add(btnNewButton_12);
    
    JButton button = new JButton("*");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        numero1 = Integer.parseInt(cajaResultado.getText());
        signoOperando = "*";
        cajaResultado.setText("");
      }
    });
    button.setBackground(new Color(94, 92, 100));
    button.setFont(new Font("Ani", Font.BOLD, 26));
    button.setForeground(new Color(255, 255, 255));
    button.setBounds(402, 180, 100, 39);
    contentPane.add(button);
    
    JButton btnNewButton_13 = new JButton("-");
    btnNewButton_13.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        numero1 = Integer.parseInt(cajaResultado.getText());
        signoOperando = "-";
        cajaResultado.setText("");
      }
    });
    btnNewButton_13.setBackground(new Color(94, 92, 100));
    btnNewButton_13.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_13.setForeground(new Color(255, 255, 255));
    btnNewButton_13.setBounds(402, 232, 100, 39);
    contentPane.add(btnNewButton_13);
    
    JButton btnNewButton_14 = new JButton("+");
    btnNewButton_14.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        numero1 = Integer.parseInt(cajaResultado.getText());
        signoOperando = "+";
        cajaResultado.setText("");
      }
    });
    btnNewButton_14.setBackground(new Color(94, 92, 100));
    btnNewButton_14.setFont(new Font("Ani", Font.BOLD, 26));
    btnNewButton_14.setForeground(new Color(255, 255, 255));
    btnNewButton_14.setBounds(402, 284, 100, 40);
    contentPane.add(btnNewButton_14);
  }
}