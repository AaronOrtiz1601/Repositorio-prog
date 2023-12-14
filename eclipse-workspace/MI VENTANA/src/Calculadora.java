import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private double num1=0,num2=0,result=0;
    private String operator;
    private String exc = "No se puede dividir entre 0";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculadora frame = new Calculadora();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Calculadora() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 265, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(5, 5, 170, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        
        for(int i=0;i<=9;i++) {
            JButton btnNewButton = new JButton(Integer.toString(i));
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + arg0.getActionCommand());
                }
            });
            btnNewButton.setBounds(5 + ((i-1)%3)*50, 40 + ((i-1)/3)*50, 50, 50);
            if(i==0) btnNewButton.setBounds(5, 190, 50, 50);
            contentPane.add(btnNewButton);
        }

        
        String[] operations = {"+", "-", "*", "/"};
        for(int i=0;i<4;i++) {
            JButton btnNewButton = new JButton(operations[i]);
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = e.getActionCommand();
                    textField.setText("");
                }
            });
            btnNewButton.setBounds(115, 40 + i*50, 50, 50);
            contentPane.add(btnNewButton);
        }

        
        JButton btnNewButton = new JButton("=");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num2=Double.parseDouble(textField.getText());
                switch(operator) {
                    case "+":
                        result=num1+num2;
                        break;
                    case "-":
                        result=num1-num2;
                        break;
                    case "*":
                        result=num1*num2;
                        break;
                    case "/":
                    {
                      if (num2 == 0) {
                        
                       textField.setText(exc);
                       break;
                      }
                      else
                      {
                        result=num1/num2;
                        break;
                      }
                    }
                        
                }
                textField.setText(Double.toString(result));
            }
        });
        btnNewButton.setBounds(60, 190, 50, 50);
        contentPane.add(btnNewButton);
    }
}
