package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import mainApp.App;
import models.Productos;

public class ListarProductos extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ListarProductos dialog = new ListarProductos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ListarProductos() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Listar Productos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(156, 10, 123, 13);
        contentPanel.add(lblNewLabel);
        
        textArea = new JTextArea(); 
        textArea.setEnabled(false);
        textArea.setBounds(26, 37, 386, 194);
        contentPanel.add(textArea);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
     
        actualizarTextArea();
    }
    
    private void actualizarTextArea() {
        // Limpiar el JTextArea antes de agregar nuevos datos
        textArea.setText("");

        // Iterar sobre los productos y concatenar los datos en el JTextArea
        for (Productos producto : App.productos) {
            String textoProducto = "Nombre: " + producto.getNombre()
                                + ", Precio: " + producto.getPrecio()
                                + ", Es perecedero?: " + producto.isPerecedero()
                                + "\n";

            // Agregamos el texto directamente al JTextArea
            textArea.append(textoProducto);
        }

        // Forzamos el repintado del JTextArea
        textArea.revalidate();
        textArea.repaint();
    }
}
