package views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import modelos.Serie;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelHome extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTable table;
  private JTextField textFieldPlataforma;
  static DefaultTableModel tableModel;
  

  /**
   * Create the panel.
   */
  public PanelHome(JLayeredPane layeredPane) {
    
    rellenarTabla();
    
    setBounds(0,0,529,251);
    setLayout(new BorderLayout(0, 0));
    String[] columnNames = {
       "Serie",
       "Platafora",
       "Numero de Temporadas"
    };
     tableModel = new DefaultTableModel(columnNames, 0);
    
    table = new JTable(tableModel);
    // Hacer que las columnas sean ordenables
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
    table.setRowSorter(sorter);
    JScrollPane scrollPane = new JScrollPane(table);
   
    
    add(scrollPane, BorderLayout.CENTER);
    
    JPanel panel = new JPanel();
    panel.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        filtrarTabla();
      }
    });
    add(panel, BorderLayout.SOUTH);
    
    JLabel lblNewLabel = new JLabel("Plataforma");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    
    textFieldPlataforma = new JTextField();
    textFieldPlataforma.setColumns(10);
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGap(163)
          .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(textFieldPlataforma, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(196, Short.MAX_VALUE))
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel)
            .addComponent(textFieldPlataforma, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
    );
    panel.setLayout(gl_panel);

  }
  private void rellenarTabla() {
    
    for (Serie nuevaSerie : Principal.getClienteActivo().getMisSeries()) {
      tableModel.addRow(new Object[]{nuevaSerie.getNombre(),nuevaSerie.getPlataforma(),nuevaSerie.getLstTemporadas()});}
    }
    private void filtrarTabla() {
      String plataforma = textFieldPlataforma.getText().toLowerCase();
      

      // Limpiar el modelo de la tabla
      tableModel.setRowCount(0);

      // Iterar sobre los clientes y agregar los que coincidan con los filtros
      for (Serie nuevaSerie : Principal.getClienteActivo().getMisSeries()) {
          boolean matches = true;

          if (!plataforma.isEmpty() && !nuevaSerie.getPlataforma().toLowerCase().contains(plataforma)) {
              matches = false;
          }
         

          if (matches) {
            String numero = "" + nuevaSerie.getLstTemporadas().get(nuevaSerie.getLstTemporadas().size() - 1);
              String[] rowData = {
                nuevaSerie.getNombre(),
                nuevaSerie.getPlataforma(),
                numero
              };
              tableModel.addRow(rowData);
          }
      }
  
  }
}
