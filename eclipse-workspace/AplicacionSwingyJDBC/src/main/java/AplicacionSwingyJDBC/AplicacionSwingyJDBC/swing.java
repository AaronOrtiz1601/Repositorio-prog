package AplicacionSwingyJDBC.AplicacionSwingyJDBC;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import utils.jdbc;

public class swing {

    private List<Pelicula> peliculas = new ArrayList<>();
    private JFrame frame;
    private JTextField textFieldId;
    private JTextField textFieldTitle;
    private JTextField textFieldDescription;
    private JTextField textFieldReleaseYear;
    private JTextField textFieldLanguageId;
    private JTextField textFieldOriginalLanguageId;
    private JTextField textFieldRentalDuration;
    private JTextField textFieldRentalRate;
    private JTextField textFieldLength;
    private JTextField textFieldReplacementCost;
    private JTextField textFieldRating;
    private JTextField textFieldSpecialFeatures;
    private JTextField textFieldLastUpdate;
    private  JButton btnNuevo;
    private JTable tablaActores;
    private DefaultTableModel tableModel;
    private jdbc jdbcInstance = new jdbc();
    private Connection conexion = jdbcInstance.conectar();
    private   JScrollPane scrollPane;
    private DefaultTableModel actorTableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    swing window = new swing();
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
    public swing() {
      initialize();
      cargarPeliculasDesdeBaseDeDatos(); 
      mostrarPeliculaInicial();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels y TextFields para cada campo de la tabla 'film'
        JLabel etiquetaId = new JLabel("Film ID");
        textFieldId = new JTextField();
        textFieldId.setColumns(10);

        JLabel lblTitle = new JLabel("Title");
        textFieldTitle = new JTextField();
        textFieldTitle.setColumns(10);

        JLabel lblDescription = new JLabel("Description");
        textFieldDescription = new JTextField();
        textFieldDescription.setColumns(10);

        JLabel lblReleaseYear = new JLabel("Release Year");
        textFieldReleaseYear = new JTextField();
        textFieldReleaseYear.setColumns(10);

        JLabel lblLanguageId = new JLabel("Language ID");
        textFieldLanguageId = new JTextField();
        textFieldLanguageId.setColumns(10);

        JLabel lblOriginalLanguageId = new JLabel("Original Language ID");
        textFieldOriginalLanguageId = new JTextField();
        textFieldOriginalLanguageId.setColumns(10);

        JLabel lblRentalDuration = new JLabel("Rental Duration");
        textFieldRentalDuration = new JTextField();
        textFieldRentalDuration.setColumns(10);

        JLabel lblRentalRate = new JLabel("Rental Rate");
        textFieldRentalRate = new JTextField();
        textFieldRentalRate.setColumns(10);

        JLabel lblLength = new JLabel("Length");
        textFieldLength = new JTextField();
        textFieldLength.setColumns(10);

        JLabel lblReplacementCost = new JLabel("Replacement Cost");
        textFieldReplacementCost = new JTextField();
        textFieldReplacementCost.setColumns(10);

        JLabel lblRating = new JLabel("Rating");
        textFieldRating = new JTextField();
        textFieldRating.setColumns(10);

        JLabel lblSpecialFeatures = new JLabel("Special Features");
        textFieldSpecialFeatures = new JTextField();
        textFieldSpecialFeatures.setColumns(10);

        JLabel lblLastUpdate = new JLabel("Last Update");
        textFieldLastUpdate = new JTextField();
        textFieldLastUpdate.setColumns(10);

     // Configuración de la tabla
        String[] columnNames = {"ID", "First Name", "Last Name"};
         actorTableModel = new DefaultTableModel(columnNames, 0); // Crear el modelo con las columnas
         tablaActores = new JTable(actorTableModel);

        // Crear un JScrollPane para la tabla y agregar la tabla en él
        JScrollPane scrollPane = new JScrollPane(tablaActores);

        


     // Botones
        JButton btnNewButton = new JButton("Primero");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!peliculas.isEmpty()) { // Verificar si la lista no está vacía
                    Pelicula primeraPelicula = peliculas.get(0); // Obtener la primera película de la lista
                    
                    // Rellenar los campos con los datos de la primera película
                    textFieldId.setText(String.valueOf(primeraPelicula.getFilmId()));
                    textFieldTitle.setText(primeraPelicula.getTitle());
                    textFieldDescription.setText(primeraPelicula.getDescription());
                    textFieldReleaseYear.setText(String.valueOf(primeraPelicula.getReleaseYear()));
                    textFieldLanguageId.setText(String.valueOf(primeraPelicula.getLanguageId()));
                    textFieldOriginalLanguageId.setText(String.valueOf(primeraPelicula.getOriginalLanguageId()));
                    textFieldRentalDuration.setText(String.valueOf(primeraPelicula.getRentalDuration()));
                    textFieldRentalRate.setText(String.valueOf(primeraPelicula.getRentalRate()));
                    textFieldLength.setText(String.valueOf(primeraPelicula.getLength()));
                    textFieldReplacementCost.setText(String.valueOf(primeraPelicula.getReplacementCost()));
                    textFieldRating.setText(primeraPelicula.getRating());
                    textFieldSpecialFeatures.setText(primeraPelicula.getSpecialFeatures());
                    textFieldLastUpdate.setText(primeraPelicula.getLastUpdate());
                    
                    cargarActores(primeraPelicula.getFilmId());
                } else {
                    System.out.println("La lista de películas está vacía.");
                }
            }
        });


     // Dentro de la clase 'swing'

     // Botón "Guardar"
     JButton btnGuardar = new JButton("Guardar");
     btnGuardar.setEnabled(false);
     btnGuardar.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           // Validar que todos los campos necesarios están llenos
           if (textFieldTitle.getText().isEmpty() || textFieldReleaseYear.getText().isEmpty() ||
               textFieldLanguageId.getText().isEmpty() || textFieldRentalDuration.getText().isEmpty()) {
               // Mostrar un mensaje de error o advertencia
               System.out.println("Por favor, completa todos los campos requeridos.");
               return;
           }

           // Determinar el nuevo ID: si la lista está vacía, comenzamos en 1
           int nuevoId = 1; // ID por defecto
           if (!peliculas.isEmpty()) {
               // Obtener el último ID de la lista
               int ultimoId = peliculas.get(peliculas.size() - 1).getFilmId();
               nuevoId = ultimoId + 1; // Incrementar en 1 para el nuevo ID
           }

           // Crear un nuevo objeto Pelicula con los datos de los campos de texto
           Pelicula nuevaPelicula = new Pelicula(
               nuevoId, // Usar el nuevo ID
               textFieldTitle.getText(), // title
               textFieldDescription.getText(), // description
               Integer.parseInt(textFieldReleaseYear.getText()), // releaseYear
               Integer.parseInt(textFieldLanguageId.getText()), // languageId
               Integer.parseInt(textFieldOriginalLanguageId.getText()), // originalLanguageId
               Integer.parseInt(textFieldRentalDuration.getText()), // rentalDuration
               Double.parseDouble(textFieldRentalRate.getText()), // rentalRate
               Integer.parseInt(textFieldLength.getText()), // length
               Double.parseDouble(textFieldReplacementCost.getText()), // replacementCost
               textFieldRating.getText(), // rating
               textFieldSpecialFeatures.getText(), // specialFeatures
               textFieldLastUpdate.getText() // lastUpdate
           );

           // Agregar la nueva película a la lista
           peliculas.add(nuevaPelicula); // Agregar a la lista

           // Limpiar campos después de guardar
           limpiarCampos();
           btnGuardar.setEnabled(false);
           btnNuevo.setEnabled(true);
       }
   });


     

       //Boton nuevo
         btnNuevo = new JButton("Nuevo");
         btnNuevo.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // Determinar el próximo ID
               // ID por defecto
               int nuevoId = 1; 
               if (!peliculas.isEmpty()) {
                   // Obtener el último ID de la lista
                   int ultimoId = peliculas.get(peliculas.size() - 1).getFilmId();
                   nuevoId = ultimoId + 1; // Incrementar en 1 para el nuevo ID
               }

               // Limpiar todos los campos de texto excepto el ID
               limpiarCampos();
               
               // Establecer el próximo ID en el campo de texto
               textFieldId.setText(String.valueOf(nuevoId));

               // Habilitar el botón de guardar y deshabilitar el de nuevo
               btnGuardar.setEnabled(true);
               btnNuevo.setEnabled(false);
           }
       });


        JButton btnAnterior_1 = new JButton("Anterior");
        btnAnterior_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idActual = Integer.parseInt(textFieldId.getText()); 
                    Pelicula anteriorPelicula = buscarAnteriorPelicula(idActual); 
                    
                    if (anteriorPelicula != null) {
                        // Rellenar los campos con los datos de la película anterior
                        textFieldId.setText(String.valueOf(anteriorPelicula.getFilmId()));
                        textFieldTitle.setText(anteriorPelicula.getTitle());
                        textFieldDescription.setText(anteriorPelicula.getDescription());
                        textFieldReleaseYear.setText(String.valueOf(anteriorPelicula.getReleaseYear()));
                        textFieldLanguageId.setText(String.valueOf(anteriorPelicula.getLanguageId()));
                        textFieldOriginalLanguageId.setText(String.valueOf(anteriorPelicula.getOriginalLanguageId()));
                        textFieldRentalDuration.setText(String.valueOf(anteriorPelicula.getRentalDuration()));
                        textFieldRentalRate.setText(String.valueOf(anteriorPelicula.getRentalRate()));
                        textFieldLength.setText(String.valueOf(anteriorPelicula.getLength()));
                        textFieldReplacementCost.setText(String.valueOf(anteriorPelicula.getReplacementCost()));
                        textFieldRating.setText(anteriorPelicula.getRating());
                        textFieldSpecialFeatures.setText(anteriorPelicula.getSpecialFeatures());
                        textFieldLastUpdate.setText(anteriorPelicula.getLastUpdate());
                        cargarActores(anteriorPelicula.getFilmId());
                    } else {
                        System.out.println("No hay más películas anteriores.");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Por favor, introduce un ID válido.");
                }
            }
        });

     // Botón Último
        JButton btnUltimo_1 = new JButton("Último");
        btnUltimo_1.addActionListener(new ActionListener() {
          //Va directamente al final de la lista y te muestra la informacion del ultimo registro
            public void actionPerformed(ActionEvent e) {
                if (!peliculas.isEmpty()) {
                    Pelicula ultimaPelicula = peliculas.get(peliculas.size() - 1); 
                    textFieldId.setText(String.valueOf(ultimaPelicula.getFilmId()));
                    textFieldTitle.setText(ultimaPelicula.getTitle());
                    textFieldDescription.setText(ultimaPelicula.getDescription());
                    textFieldReleaseYear.setText(String.valueOf(ultimaPelicula.getReleaseYear()));
                    textFieldLanguageId.setText(String.valueOf(ultimaPelicula.getLanguageId()));
                    textFieldOriginalLanguageId.setText(String.valueOf(ultimaPelicula.getOriginalLanguageId()));
                    textFieldRentalDuration.setText(String.valueOf(ultimaPelicula.getRentalDuration()));
                    textFieldRentalRate.setText(String.valueOf(ultimaPelicula.getRentalRate()));
                    textFieldLength.setText(String.valueOf(ultimaPelicula.getLength()));
                    textFieldReplacementCost.setText(String.valueOf(ultimaPelicula.getReplacementCost()));
                    textFieldRating.setText(ultimaPelicula.getRating());
                    textFieldSpecialFeatures.setText(ultimaPelicula.getSpecialFeatures());
                    textFieldLastUpdate.setText(ultimaPelicula.getLastUpdate());
                    cargarActores(ultimaPelicula.getFilmId());
                }
            }
        });
        //Boton siguiente
        JButton btnSiguiente_1 = new JButton("Siguiente");
        btnSiguiente_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idActual = Integer.parseInt(textFieldId.getText()); 
                    Pelicula siguientePelicula = buscarSiguientePelicula(idActual); 
                    
                    if (siguientePelicula != null) {
                        // Rellenar los campos con los datos de la siguiente película
                        textFieldId.setText(String.valueOf(siguientePelicula.getFilmId()));
                        textFieldTitle.setText(siguientePelicula.getTitle());
                        textFieldDescription.setText(siguientePelicula.getDescription());
                        textFieldReleaseYear.setText(String.valueOf(siguientePelicula.getReleaseYear()));
                        textFieldLanguageId.setText(String.valueOf(siguientePelicula.getLanguageId()));
                        textFieldOriginalLanguageId.setText(String.valueOf(siguientePelicula.getOriginalLanguageId()));
                        textFieldRentalDuration.setText(String.valueOf(siguientePelicula.getRentalDuration()));
                        textFieldRentalRate.setText(String.valueOf(siguientePelicula.getRentalRate()));
                        textFieldLength.setText(String.valueOf(siguientePelicula.getLength()));
                        textFieldReplacementCost.setText(String.valueOf(siguientePelicula.getReplacementCost()));
                        textFieldRating.setText(siguientePelicula.getRating());
                        textFieldSpecialFeatures.setText(siguientePelicula.getSpecialFeatures());
                        textFieldLastUpdate.setText(siguientePelicula.getLastUpdate());
                        cargarActores(siguientePelicula.getFilmId());
                    } else {
                        System.out.println("No hay más películas siguientes.");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Por favor, introduce un ID válido.");
                }
            }
        });


        // Configuración del layout con GroupLayout
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(30)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(etiquetaId)
                                        .addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblTitle)
                                        .addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblDescription)
                                        .addComponent(textFieldDescription, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblReleaseYear)
                                        .addComponent(textFieldReleaseYear, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblLanguageId)
                                        .addComponent(textFieldLanguageId, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblOriginalLanguageId)
                                        .addComponent(textFieldOriginalLanguageId, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblRentalDuration)
                                        .addComponent(textFieldRentalDuration, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblRentalRate)
                                        .addComponent(textFieldRentalRate, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblLength)
                                        .addComponent(textFieldLength, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblReplacementCost)
                                        .addComponent(textFieldReplacementCost, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblRating)
                                        .addComponent(textFieldRating, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblSpecialFeatures)
                                        .addComponent(textFieldSpecialFeatures, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(lblLastUpdate)
                                    .addGap(18)
                                    .addComponent(textFieldLastUpdate, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnNewButton)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(btnAnterior_1)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(btnSiguiente_1)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(btnUltimo_1)))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(btnGuardar)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(btnNuevo)))
                    .addGap(30))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(etiquetaId)
                        .addComponent(lblTitle)
                        .addComponent(lblDescription))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblReleaseYear)
                        .addComponent(lblLanguageId)
                        .addComponent(lblOriginalLanguageId))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textFieldReleaseYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldLanguageId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldOriginalLanguageId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblRentalDuration)
                        .addComponent(lblRentalRate)
                        .addComponent(lblLength))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textFieldRentalDuration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldRentalRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblReplacementCost)
                        .addComponent(lblRating)
                        .addComponent(lblSpecialFeatures))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textFieldReplacementCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldRating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldSpecialFeatures, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblLastUpdate)
                        .addComponent(textFieldLastUpdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton)
                        .addComponent(btnAnterior_1)
                        .addComponent(btnSiguiente_1)
                        .addComponent(btnUltimo_1)
                        .addComponent(btnGuardar)
                        .addComponent(btnNuevo))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGap(30))
        );

        frame.getContentPane().setLayout(groupLayout);
    }
 // Método para limpiar los campos
    private void limpiarCampos() {
        textFieldId.setText("");
        textFieldTitle.setText("");
        textFieldDescription.setText("");
        textFieldReleaseYear.setText("");
        textFieldLanguageId.setText("");
        textFieldOriginalLanguageId.setText("");
        textFieldRentalDuration.setText("");
        textFieldRentalRate.setText("");
        textFieldLength.setText("");
        textFieldReplacementCost.setText("");
        textFieldRating.setText("");
        textFieldSpecialFeatures.setText("");
        textFieldLastUpdate.setText("");
    }
    //Metodo para cargar las pelisculas que tiene de base la base de datos
    private void cargarPeliculasDesdeBaseDeDatos() {
      String consulta = "SELECT film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update FROM film";
      if (conexion != null) {
          try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {
              while (rs.next()) {
                  // Obtener datos de la base de datos
                  int filmId = rs.getInt("film_id");
                  String title = rs.getString("title");
                  String description = rs.getString("description");
                  int releaseYear = rs.getInt("release_year");
                  int languageId = rs.getInt("language_id");
                  int originalLanguageId = rs.getInt("original_language_id");
                  int rentalDuration = rs.getInt("rental_duration");
                  double rentalRate = rs.getDouble("rental_rate");
                  int length = rs.getInt("length");
                  double replacementCost = rs.getDouble("replacement_cost");
                  String rating = rs.getString("rating");
                  String specialFeatures = rs.getString("special_features");
                  String lastUpdate = rs.getTimestamp("last_update").toString();

                  // Crear y agregar la película a la lista
                  Pelicula pelicula = new Pelicula(filmId, title, description, releaseYear, languageId,
                          originalLanguageId, rentalDuration, rentalRate, length, replacementCost, rating,
                          specialFeatures, lastUpdate);
                  peliculas.add(pelicula);
              }
              System.out.println("Películas cargadas desde la base de datos: " + peliculas.size());
          } catch (SQLException ex) {
              ex.printStackTrace();
          }
      }
      
  }
    private Pelicula buscarSiguientePelicula(int idActual) {
      for (Pelicula pelicula : peliculas) {
          if (pelicula.getFilmId() == idActual + 1) { // Compara si el ID de la película es el siguiente
              return pelicula; // Retorna la película si se encuentra
          }
      }
   // Retorna null si no se encuentra la película siguiente
      return null; 
  }
    private Pelicula buscarAnteriorPelicula(int idActual) {
      for (int i = 0; i < peliculas.size(); i++) {
          Pelicula pelicula = peliculas.get(i);
          if (pelicula.getFilmId() == idActual) {
            // Verifica que no sea la primera película
            // Retorna la película anterior
              if (i > 0) {
                  return peliculas.get(i - 1); 
              }
           // Si es la primera película, termina el ciclo
              break; 
          }
      }
   // Retorna null si no se encuentra la película anterior
      return null; 
  }
    
  

  // Método para mostrar la primera película en los campos de texto
  private void mostrarPeliculaInicial() {
      if (!peliculas.isEmpty()) {
          Pelicula primeraPelicula = peliculas.get(0); // Obtener la primera película
          textFieldId.setText(String.valueOf(primeraPelicula.getFilmId()));
          textFieldTitle.setText(primeraPelicula.getTitle());
          textFieldDescription.setText(primeraPelicula.getDescription());
          textFieldReleaseYear.setText(String.valueOf(primeraPelicula.getReleaseYear()));
          textFieldLanguageId.setText(String.valueOf(primeraPelicula.getLanguageId()));
          textFieldOriginalLanguageId.setText(String.valueOf(primeraPelicula.getOriginalLanguageId()));
          textFieldRentalDuration.setText(String.valueOf(primeraPelicula.getRentalDuration()));
          textFieldRentalRate.setText(String.valueOf(primeraPelicula.getRentalRate()));
          textFieldLength.setText(String.valueOf(primeraPelicula.getLength()));
          textFieldReplacementCost.setText(String.valueOf(primeraPelicula.getReplacementCost()));
          textFieldRating.setText(primeraPelicula.getRating());
          textFieldSpecialFeatures.setText(primeraPelicula.getSpecialFeatures());
          textFieldLastUpdate.setText(primeraPelicula.getLastUpdate());
          cargarActores(primeraPelicula.getFilmId());
      }



}
  //Metodo para mostrar los actores segun el id de la pelicula
  private void cargarActores(int filmId) {
    String consultaActores = "SELECT a.actor_id, a.first_name, a.last_name " +
                             "FROM actor a " +
                             "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                             "WHERE fa.film_id = ?";

    try (PreparedStatement stmt = conexion.prepareStatement(consultaActores)) {
        stmt.setInt(1, filmId); // Pasar el filmId como parámetro

        try (ResultSet rs = stmt.executeQuery()) {
            // Limpiar la tabla de actores (actorTableModel es el modelo de la tabla de actores)
          actorTableModel.setRowCount(0);

            // Llenar la tabla de actores
            while (rs.next()) {
                int actorId = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                // Añadir cada actor al modelo de la tabla
                actorTableModel.addRow(new Object[] { actorId, firstName, lastName });
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


}
