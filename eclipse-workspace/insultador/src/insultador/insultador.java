package insultador;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class insultador {

    private JFrame frame;
    private List<String> insultos = new ArrayList<>();
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    insultador window = new insultador();
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
    public insultador() {
        initialize();
        // Añadir insultos a la lista
        insultos.add("rata");
        insultos.add("Gabacha");
        insultos.add("Croassant");
        insultos.add("Baguette");
        insultos.add("Jugadora de Roblox");
        insultos.add("Pez globo");
        insultos.add("Galleta maría");
        insultos.add("Tortuga ninja");
        insultos.add("Fideo");
        insultos.add("Cacahuate");
        insultos.add("Sopa instantánea");
        insultos.add("Papel higiénico usado");
        insultos.add("Sandwich de mermelada");
        insultos.add("Cacique de barrio");
        insultos.add("Zanahoria");
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 638, 476);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("¿Que es Gemita hoy?");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(204, 10, 193, 13);
        frame.getContentPane().add(lblNewLabel);
        
        // Establecer la imagen en el JLabel
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\Aarón\\Downloads\\Imagen de WhatsApp 2024-10-09 a las 13.21.27_1937ba9e.png"));
        label.setBounds(197, 186, 200, 200); // Ajusta la posición y el tamaño según sea necesario
        frame.getContentPane().add(label);
        
        JButton btnNewButton = new JButton("Comprobar que es Gema hoy");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numeroDeInsultos = insultos.size();
                Random random = new Random();
                int numeroDeInsulto = random.nextInt(insultos.size());

                // Obtener un insulto aleatorio
                String insultoAleatorio = insultos.get(numeroDeInsulto);
                textArea.setText(insultoAleatorio);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(173, 123, 257, 21);
        frame.getContentPane().add(btnNewButton);
        
        textArea = new JTextArea();
        textArea.setBounds(129, 52, 367, 48);
        frame.getContentPane().add(textArea);
    }
}
