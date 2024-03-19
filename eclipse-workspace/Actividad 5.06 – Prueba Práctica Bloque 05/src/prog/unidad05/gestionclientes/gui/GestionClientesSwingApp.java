package prog.unidad05.gestionclientes.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import prog.unidad05.gestionclientes.core.Cliente;
import prog.unidad05.gestionclientes.core.Clientes;
import prog.unidad05.gestionclientes.core.VisitadorClientes;
import prog.unidad05.gestionclientes.impl.ProveedorAlmacenamientoClientesFichero;
import prog.unidad05.gestionclientes.core.VisitadorUsuario;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class GestionClientesSwingApp {
  //Declaracion de todos los atributos privados
  private JFrame frmGestinDeClientes;
  private JTextArea textAreaNIF;
  private JTextArea textAreaNombre;
  private JTextArea textAreaEmpleados;
  private JTextArea textAreaApellidos;
  private JTextArea textAreaFacturación;
  private JButton btnNuevo;
  private JButton btnEliminar;
  private JButton btnActualizar;
  private JButton btnCancelar;
  private JButton btnAceptar;
  private String rutaArchivo = "clientes.dat";
  private ProveedorAlmacenamientoClientesFichero Proveedor;
  private Clientes clientes;
  private JList list = new JList();
  private DefaultListModel<String> modelo = new DefaultListModel<>();
  private JCheckBox chckbxNewCheckBox;
  private VisitadorUsuario visitador;
  private boolean comprueba;

  /**
   * Launch the application.
   */

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionClientesSwingApp window = new GestionClientesSwingApp();
          window.frmGestinDeClientes.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * list Create the application.
   */
  public GestionClientesSwingApp() {
    //Inicio el proveedor, la clase clientes y el visitador
    Proveedor = new ProveedorAlmacenamientoClientesFichero(rutaArchivo);
    clientes = new Clientes(Proveedor);
    visitador = new VisitadorUsuario(modelo);
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    //Llamo al visitador para mostrar los clientes que haya almacenados desde primera hora en el fichero
    clientes.visita(visitador);
    //Le paso a la lista el modelo con los clientes actuales
    list.setModel(modelo);
    //Evento que salta al seleccionar un elemento de la lista
    list.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        //Llamo al metodo privado eventoSeleccion
       eventoSeleccion();

      }
    });
    

    frmGestinDeClientes = new JFrame();
    frmGestinDeClientes.setForeground(new Color(0, 0, 0));
    frmGestinDeClientes.setFont(new Font("Dialog", Font.BOLD, 12));
    frmGestinDeClientes.setTitle("Gestión de Clientes");
    frmGestinDeClientes.setBounds(100, 100, 517, 374);
    frmGestinDeClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JScrollPane scrollPane = new JScrollPane();

    JLabel lblNewLabel = new JLabel("NIF:");
    lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 12));
    //Cuadro de texto donde escribire el dni, le doy a ese cuadro un valor inicial para que este inactivo al principio
    textAreaNIF = new JTextArea();
    textAreaNIF.setEnabled(false);

    JLabel lblNewLabel_1 = new JLabel("Apellidos:");
    lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 12));

    JLabel lblNewLabel_2 = new JLabel("Nombre:");
    lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 12));
    //Cuadro de texto donde escribire los apellidos, le doy a ese cuadro un valor inicial para que este inactivo al principio
    textAreaApellidos = new JTextArea();
    textAreaApellidos.setEnabled(false);
    //Cuadro de texto donde escribire el nombre, le doy a ese cuadro un valor inicial para que este inactivo al principio
    textAreaNombre = new JTextArea();
    textAreaNombre.setEnabled(false);

    JLabel lblNewLabel_2_1 = new JLabel("Empleados:");
    lblNewLabel_2_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
    //Cuadro de texto donde escribire el numero de empleados, le doy a ese cuadro un valor inicial para que este inactivo al principio
    textAreaEmpleados = new JTextArea();
    textAreaEmpleados.setEnabled(false);

    JLabel lblNewLabel_2_1_1 = new JLabel("Facturación:");
    lblNewLabel_2_1_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
    //Cuadro de texto donde escribire la facturacion, le doy a ese cuadro un valor inicial para que este inactivo al principio
    textAreaFacturación = new JTextArea();
    textAreaFacturación.setEnabled(false);
    //checkbox que indica si el cliente es nacional o no de la UE, al principio esta esta desactivada
    chckbxNewCheckBox = new JCheckBox("¿Es nacional de la UE?");
    chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
    chckbxNewCheckBox.setEnabled(false);
    
    btnNuevo = new JButton("Nuevo");
    btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
    //Evento que se activa al pulsar el boton nuevo 
    btnNuevo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //Llamo al metodo privado eventoNuevo
        eventoNuevo();
      }
    });

    btnEliminar = new JButton("Eliminar");
  //Evento que se activa al pulsar el boton eliminar
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      //Llamo al metodo privado eventoEliminar
        eventoEliminar();
      }
    });
    btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
    //El boton eliminar aparece desactivado
    btnEliminar.setEnabled(false);

    btnActualizar = new JButton("Actualizar");

    btnActualizar.addActionListener(new ActionListener() {
    //Evento que se activa al pulsar el boton actualizar
      public void actionPerformed(ActionEvent e) {
      //Llamo al metodo privado eventoActualizar
        eventoActualizar();
      }
    });
    btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
    //El boton actualizar aparece desactivado
    btnActualizar.setEnabled(false);

    JButton btnSalir = new JButton("Salir");
    btnSalir.addActionListener(new ActionListener() {
    //Evento que se activa al pulsar el boton salir
      public void actionPerformed(ActionEvent e) {
        //Instruccion para salir de la ventana
        System.exit(0);
      }
    });
    btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));

    btnAceptar = new JButton("Aceptar");
    //El boton aceptar aparece desactivado
    btnAceptar.setEnabled(false);
  //Evento que se activa al pulsar el boton aceptar
    btnAceptar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //Try catch que se actica en el caso de que haya errores al guardar los clientes o al actualizarlos
        try {
          //Llamo al eventoAceptar
          eventoAceptar();
          //En el caso de error capturo la excepcion
        } catch (Exception e2) {
          //Llamo al eventoExcepcion
          eventoExcepcion();
        }
      }
    });
    btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));

    btnCancelar = new JButton("Cancelar");
  //Evento que se activa al pulsar el boton cancelar
    btnCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      //Llamo al eventoCancelar
        eventoCancelar();

      }
    });
    btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
  //El boton cancelar aparece desactivado
    btnCancelar.setEnabled(false);
    JLabel lblNewLabel_3 = new JLabel("Clientes");
    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
    GroupLayout groupLayout = new GroupLayout(frmGestinDeClientes.getContentPane());
    groupLayout
        .setHorizontalGroup(
            groupLayout
                .createParallelGroup(
                    Alignment.LEADING)
                .addGroup(
                    groupLayout.createSequentialGroup().addContainerGap()
                        .addGroup(
                            groupLayout
                                .createParallelGroup(
                                    Alignment.LEADING)
                                .addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 483,
                                    Short.MAX_VALUE)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(textAreaNIF, GroupLayout.PREFERRED_SIZE, 66,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(18).addComponent(lblNewLabel_2).addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(
                                        textAreaNombre, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_2_1)
                                    .addPreferredGap(ComponentPlacement.RELATED).addComponent(textAreaEmpleados,
                                        GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                                .addGroup(
                                    groupLayout.createSequentialGroup()
                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 69,
                                            GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(textAreaApellidos, GroupLayout.PREFERRED_SIZE, 167,
                                            GroupLayout.PREFERRED_SIZE)
                                        .addGap(40)
                                        .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 88,
                                            GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textAreaFacturación,
                                            GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                .addComponent(chckbxNewCheckBox)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                    .addGap(10)
                                    .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 83,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 100,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                .addGroup(groupLayout.createSequentialGroup().addComponent(btnAceptar).addGap(18)
                                    .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 81,
                                        GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45,
                                    GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
        .createSequentialGroup().addContainerGap().addComponent(lblNewLabel_3)
        .addPreferredGap(ComponentPlacement.RELATED)
        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE).addGap(18)
        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
            .addComponent(textAreaNIF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
            .addComponent(textAreaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE).addComponent(
                textAreaEmpleados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(18)
        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
            .addComponent(textAreaApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE).addComponent(
                textAreaFacturación, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(18).addComponent(chckbxNewCheckBox).addPreferredGap(ComponentPlacement.UNRELATED)
        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNuevo)
            .addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        .addContainerGap()));

    scrollPane.setViewportView(list);
    frmGestinDeClientes.getContentPane().setLayout(groupLayout);
  }
  //metodo que se llama al pulsar el evento nuevo
  private void eventoNuevo() {
    //Activa los botones aceptar y cancelar
    btnAceptar.setEnabled(true);
    btnCancelar.setEnabled(true);
    //Desactiva el boton nuevo
    btnNuevo.setEnabled(false);
    //Activa todos los cuadros de texto para introducir los datos del cliente
    textAreaNIF.setEnabled(true);
    textAreaApellidos.setEnabled(true);
    textAreaNombre.setEnabled(true);
    textAreaEmpleados.setEnabled(true);
    textAreaFacturación.setEnabled(true);
    chckbxNewCheckBox.setEnabled(true);
    //Igualo comprueba a true para indicar que quiero crear un nuevo cliente
    comprueba = true;
  }
//metodo que se llama al pulsar el evento eliminar
  private void eventoEliminar() {
    // Tras pulsar el boton eliminar, salta un mensaje 
    int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar esto?",
        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
    //Si tu aceptas , el cliente eliminado, si no lo haces no pasa nada
    if (respuesta == JOptionPane.YES_OPTION) {
      //Creo un array con los eventos de seleccion
      ListSelectionListener[] listeners = list.getListSelectionListeners();
      //Recorro dicho array y voy desavtivando todos estos eventos para evitar errores a la hora de borrar
      for (ListSelectionListener listener : listeners) {
        list.removeListSelectionListener(listener);
      }

      // Realiza las operaciones de eliminación
      clientes.removeCliente(textAreaNIF.getText());
      modelo.clear();
      clientes.visita(visitador);

      // Tras haber eliminado el cliente vuelvo a activar los eventos de selecion 
      for (ListSelectionListener listener : listeners) {
        list.addListSelectionListener(listener);
      }
      //Tras eso le doy a todos los cuadros de texto su valor inicial y desavtivo los botones actualizar y eliminar
      textAreaNIF.setText("");
      textAreaApellidos.setText("");
      textAreaNombre.setText("");
      textAreaEmpleados.setText("");
      textAreaFacturación.setText("");
      btnEliminar.setEnabled(false);
      btnActualizar.setEnabled(false);
    }
  }
 //Metodo que se llama al pulsar el boton actualizar
  private void eventoActualizar() {
    //Activo todos los cuadros de texto menos el dni
    textAreaApellidos.setEnabled(true);
    textAreaNombre.setEnabled(true);
    textAreaEmpleados.setEnabled(true);
    textAreaFacturación.setEnabled(true);
    chckbxNewCheckBox.setEnabled(true);
    //Activo los botones de aceptar y cancekar y desactico los de eliminar, nuevo y actualizar
    btnAceptar.setEnabled(true);
    btnCancelar.setEnabled(true);
    btnActualizar.setEnabled(false);
    btnNuevo.setEnabled(false);
    btnEliminar.setEnabled(false);
    //Igualo comprueba a falso para decir que quiero actualizar un cliente
    comprueba = false;
  }
  
  //Metodo que se llama al pulsar el boton aceptar
  private void eventoAceptar() {
    //Saco la informacion de los clientes de los cuadros de texto
    String nif = textAreaNIF.getText();
    String nombre = textAreaNombre.getText();
    String apellidos = textAreaApellidos.getText();
    String empleadosEnTexto = textAreaEmpleados.getText();
    int empleados = Integer.parseInt(empleadosEnTexto);
    String facturacionEnTexto = textAreaFacturación.getText();
    double facturacion = Double.parseDouble(facturacionEnTexto);
    boolean nacionalidad = chckbxNewCheckBox.isSelected();

    // Verificar si el cliente ya existe en la lista
    Cliente clienteExistente = clientes.getByNif(nif);
    //Si comprueba es falso empezamos el proceso para actualizar un cliente, si no lo es empezamos el proceso para crear un cliente
    if (comprueba == false)
    {
    
      // Actualizar el cliente existente
      Cliente clienteActualizado = new Cliente(nif, apellidos, nombre, empleados, facturacion, nacionalidad);
      clientes.updateCliente(clienteActualizado);
      
      //Para evitar errores desactivamos los eventos de seleccion y cuando la actualización de la lista haya terminado los volvemos a activar
      ListSelectionListener[] listeners = list.getListSelectionListeners();
      for (ListSelectionListener listener : listeners) {
        list.removeListSelectionListener(listener);
      }

      modelo.clear();
      clientes.visita(visitador);

      // Vuelve a vincular los manejadores de eventos a la JList
      for (ListSelectionListener listener : listeners) {
        list.addListSelectionListener(listener);
      }

    }else {
      //Si el cliente no existe empezamos a crear el cliente
      if (clienteExistente == null)
      {
      
       //Creo un nuevo cliente con los datos introducidos
      Cliente clienteNuevo = new Cliente(nif, apellidos, nombre, empleados, facturacion, nacionalidad);
      //Añado el cliente a la lista de clientes
      clientes.addCliente(clienteNuevo);
      //Limpio el modelo anterior y llamo al visitador
      modelo.clear();
      clientes.visita(visitador);
      
      }else
      {
        //Si el cliente si que existe llamo al eventoException
        eventoExcepcion();
      }
    }
    
    //Tras haber terminado las operaciones hacemos que todo vuelva a su estado inicial
    btnAceptar.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnNuevo.setEnabled(true);
    textAreaNIF.setEnabled(false);
    textAreaApellidos.setEnabled(false);
    textAreaNombre.setEnabled(false);
    textAreaEmpleados.setEnabled(false);
    textAreaFacturación.setEnabled(false);
    chckbxNewCheckBox.setEnabled(false);
    textAreaNIF.setText("");
    textAreaApellidos.setText("");
    textAreaNombre.setText("");
    textAreaEmpleados.setText("");
    textAreaFacturación.setText("");
    chckbxNewCheckBox.setSelected(false);
  }
  //Metodo que se llama al pulsar el boton cancelar
  private void eventoCancelar() {
    //Hacemos que todo vuelva a su estado inicial y no guardamos el cliente
    btnAceptar.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnNuevo.setEnabled(true);
    textAreaNIF.setEnabled(false);
    textAreaApellidos.setEnabled(false);
    textAreaNombre.setEnabled(false);
    textAreaEmpleados.setEnabled(false);
    textAreaFacturación.setEnabled(false);
    chckbxNewCheckBox.setEnabled(false);
    textAreaNIF.setText("");
    textAreaApellidos.setText("");
    textAreaNombre.setText("");
    textAreaEmpleados.setText("");
    textAreaFacturación.setText("");
    chckbxNewCheckBox.setSelected(false);
  }
  //Metodo privado que se activa simpre que hay un error
  private void eventoExcepcion() {
    
    //Se muestra un mensaje que dice que ha habido un error al introducir los datos de los clientes
    JOptionPane.showMessageDialog(null,
        "Ha habido un error al introducir los datos.Los datos de este cliente no han sido guardados ", "Error",
        JOptionPane.INFORMATION_MESSAGE);
    //Retornamos todo a su estado inicial
    btnAceptar.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnNuevo.setEnabled(true);
    textAreaNIF.setEnabled(false);
    textAreaApellidos.setEnabled(false);
    textAreaNombre.setEnabled(false);
    textAreaEmpleados.setEnabled(false);
    textAreaFacturación.setEnabled(false);
    chckbxNewCheckBox.setEnabled(false);
    textAreaNIF.setText("");
    textAreaApellidos.setText("");
    textAreaNombre.setText("");
    textAreaEmpleados.setText("");
    textAreaFacturación.setText("");
    chckbxNewCheckBox.setSelected(false);
  }
  //Metodo que se activa siempre que seleccionamos un elemento de la lista
  private void eventoSeleccion() {
    //Activo los botones actualizar y eliminar
    btnActualizar.setEnabled(true);
    btnEliminar.setEnabled(true);
    //Saco el numero en el que se encuentra el cliente seleccionado
    int indice = list.getSelectedIndex();
    //Hago que la informacion completa del  cliente selecionado se guarde en una variable
    String nif = (modelo.elementAt(indice));
    //Declaro la variable donde guardare el dni del cliente
    String nifABuscar;

    //Voy sacando atraves del dni todos los datos de los clientes y estos los muestro en los cuadros de texto
    textAreaNIF.setText(clientes.getByNif(nifABuscar = nif.substring(0, 9)).getNif());
    textAreaNombre.setText(clientes.getByNif(nifABuscar = nif.substring(0, 9)).getNombre());
    textAreaApellidos.setText(clientes.getByNif(nifABuscar = nif.substring(0, 9)).getApellidos());
    textAreaEmpleados.setText(String.valueOf(clientes.getByNif(nifABuscar = nif.substring(0, 9)).getEmpleados()));
    textAreaFacturación.setText(String.valueOf(clientes.getByNif(nifABuscar = nif.substring(0, 9)).getFacturacion()));
    chckbxNewCheckBox.setSelected(clientes.getByNif(nifABuscar = nif.substring(0, 9)).isNacionalUe());
  }
}
