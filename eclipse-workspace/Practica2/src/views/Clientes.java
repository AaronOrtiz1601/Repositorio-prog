package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class Clientes extends JPanel {
  private JLayeredPane layeredPane;

  /**
   * Interfaz para las operaciones de los clientes
   * 
   * @param layeredPane
   */
  public Clientes(JLayeredPane layeredPane) {

    this.layeredPane = layeredPane;

    setBackground(new Color(0, 128, 192));

    JLabel lblNewLabel = new JLabel("Bienvenido a la gestión de clientes");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

    JLabel lblNewLabel_1 = new JLabel("¿Qué operación quieres realizar?");
    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

    JButton btnDarAlta = new JButton("Dar de alta a un cliente");
    JButton btnListarClientes = new JButton("Listar clientes");
    JButton btnEliminarCliente = new JButton("Eliminar un cliente");

    // Acción para el botón "Dar de alta a un cliente"
    btnDarAlta.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Cambiar al panel correspondiente
        cambiarPanel(new DarAltaCliente(layeredPane));
      }
    });

    // Acción para el botón "Listar clientes"
    btnListarClientes.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Cambiar al panel correspondiente
        cambiarPanel(new ListarClientes(layeredPane));
      }
    });

    // Acción para el botón "Eliminar un cliente"
    btnEliminarCliente.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Cambiar al panel correspondiente
        cambiarPanel(new EliminarCliente(layeredPane));
      }
    });

    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addContainerGap(262, Short.MAX_VALUE)
            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE).addGap(228))
        .addGroup(groupLayout.createSequentialGroup().addGap(299)
            .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(309, Short.MAX_VALUE))
        .addGroup(groupLayout.createSequentialGroup().addGap(328)
            .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(btnEliminarCliente, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnListarClientes, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnDarAlta))
            .addContainerGap(405, Short.MAX_VALUE)));
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lblNewLabel_1).addGap(18)
            .addComponent(btnDarAlta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnListarClientes).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnEliminarCliente).addContainerGap(144, Short.MAX_VALUE)));
    setLayout(groupLayout);
  }

  private void cambiarPanel(JPanel newPanel) {
    // Limpiar contenido anterior
    layeredPane.removeAll();
    // Ajustar tamaño
    newPanel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
    // Añadir nuevo panel
    layeredPane.add(newPanel);
    // Repaint para reflejar el cambio
    layeredPane.repaint();
    // Revalidar para que el nuevo panel se muestre
    layeredPane.revalidate();
  }
}
