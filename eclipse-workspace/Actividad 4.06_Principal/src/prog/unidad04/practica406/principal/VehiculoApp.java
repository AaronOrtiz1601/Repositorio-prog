package prog.unidad04.practica406.principal;

import java.time.LocalDate;
import java.util.Scanner;
import prog.unidad04.practica406.libreria.*;

public class VehiculoApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declaro todas las variables
        String matricula = "";
        int mes;
        int dia;
        int anyo = 0;
        String color;
        int plazas;
        Fecha fechaMatriculacion = null;
        boolean prueba;
        int cilindrada;
        LocalDate fechaActual = LocalDate.now();
        Fecha fecha2 = null;
        Automovil audi = null;
        Motocicleta harley = null;
        System.out.println(" PRACTICA DE AARON ORTIZ. GESTIÓN DE VEHICULOS");
        // Hago un bucle para asegurarme que hasta que no esten bien introducidos los datos del automovil el usuario no pueda avanzar
        do {
            // Inicializo mi bandera que mas adelante me dirá si se ha cumplido la condición impuesta
            prueba = true;
            // Empiezo introduciendo la matricula del vehiculo
            System.out.println("Introduce la matricula de tu vehiculo, cuatro numeros, 0 o más espacios y tres letras mayusculas");
            matricula = sc.nextLine();
            // Compruebo que la fecha se está introduciendo bien
            try {
                // Introduzco la fecha
                System.out.println("Introduce el dia de la fecha de matriculación");
                dia = Integer.parseInt(sc.nextLine());

                System.out.println("Introduce el mes de la fecha de  matriculacion");
                mes = Integer.parseInt(sc.nextLine());

                System.out.println("Introduce el año de la fecha de matriculacion");
                anyo = Integer.parseInt(sc.nextLine());

                fechaMatriculacion = new Fecha(dia, mes, anyo);
                // Si la fecha no ha sido bien creada capturo la excepcion y muestro un mensaje
            } catch (IllegalArgumentException e2) {
                System.out.println("La fecha no es una fecha valida. Introducela de nuevo");
                prueba = false;
            }
            // Muestro si el automovil ha sido matriculado en año bisiesto
            if ((anyo % 4 == 0) && (anyo != 1900)) {
                System.out.println("El automovil ha sido matriculado en año bisiesto");
            }

            // Introduzco el color del coche
            System.out.println("Introduce el color del automovil (blanco, negro o azul)");
            color = sc.nextLine();
            // Introduzco el numero de plazas
            System.out.println("Introduce el numero de plaza (1 o mas) ");
            plazas = Integer.parseInt(sc.nextLine());
            // Si alguno de los datos no ha sido introducido correctamente capturo la excepcion y muestro el mensaje
            try {
                // Creo un objeto de la clase automovil
                audi = new Automovil(matricula, fechaMatriculacion, color, plazas);
            } catch (IllegalArgumentException e) {
                System.out.println("No se pudo crear el automovil. Revise los datos para comprobar que todo esta correcto ");
                prueba = false;
            }
        } while (!prueba == true);
        // Vuelvo a usar un bucle para comprobar que el usuario no puede avanzar hasta haber introducido bien los datos de la motocicleta

        do {
            prueba = true;
            // Introduzo la matricula
            System.out.println("Introduce la matricula de la motocicleta");
            matricula = sc.nextLine();
            try {
                // Introduzco la fecha de matriculacion
                System.out.println("Introduce el dia de matriculacion de la motocicleta");
                dia = Integer.parseInt(sc.nextLine());
                System.out.println("Introduce el mes de matriculacion de la motocicleta");
                mes = Integer.parseInt(sc.nextLine());
                System.out.println("Introduce el año de matriculacion de la motocicleta");
                anyo = Integer.parseInt(sc.nextLine());
                fecha2 = new Fecha(dia, mes, anyo);
            } catch (IllegalArgumentException e3) {
                System.out.println("La fecha no es una fecha valida. Introducela de nuevo");
                prueba = false;
            }
            // Muestro si la motocicleta ha sido matriculada en año bisiesto
            if ((anyo % 4 == 0) && (anyo != 1900)) {
                System.out.println("La motocicleta ha sido matriculada en año bisiesto");
            }
            // Introduzco la cilindrada
            System.out.println("Introduce la cilindrada de la motocicleta (50 o mas)");
            cilindrada = Integer.parseInt(sc.nextLine());
            try {
                // Creo un objeto de la clase motocicleta
                harley = new Motocicleta(matricula, fechaMatriculacion, cilindrada);
            } catch (IllegalArgumentException e4) {
                System.out.println("No se pudo crear la motocicleta. Revise los datos para comprobar que todo esta correcto ");
                prueba = false;
            }
        } while (!prueba == true);
        // Muestro los datos del automovil
        System.out.println("Datos del automovil = " + audi.aTexto());
        // Muestro los datos de la motocicleta ya creada
        System.out.println("Datos de la motocicleta = " + harley.aTexto());
        // Saco la fecha actual gracias a la clase LocalDate y a la clase String
        anyo = fechaActual.getYear();
        mes = fechaActual.getMonthValue();
        dia = fechaActual.getDayOfMonth();

        Fecha fechaAct = new Fecha(dia, mes, anyo);
        // Hago un try catch que comprueba si las fechas de matriculacion no son superiores a la fecha actual
        try {
            // Calculo el numero de dias que lleva matriculado el automovil
            System.out.println("El automovil lleva matriculado " + fechaMatriculacion.diasEntre(fechaAct) + " dias");
            // Calculo el numero de dias que lleva matriculada la motocicleta
            System.out.println("La motocicleta lleva matriculada " + fecha2.diasEntre(fechaAct) + " dias");
        } catch (FechaException e5) {
            System.out.println("La fecha de matriculacion de uno de los vehiculos es posterior a la fecha actual ");
        }
        // Compruebo cual de los dos Vehiculos fue matriculado antes
        if (fechaMatriculacion.compara(fecha2) == 1)   {
            System.out.println("La motocicleta se matriculo antes que el automovil");
        } else if (fechaMatriculacion.compara(fecha2) == -1 )   {
            System.out.println("El automovil se matriculo antes que la motoocileta");
        } else if (fechaMatriculacion.compara(fecha2) == 0) {
            System.out.println("La motocicleta y el automovil se matricularon el mismo dia");
        }
        // Muestro el numero total de vehiculos matriculados
        System.out.println("Se han matriculado " + Vehiculo.getVehiculosMatriculados() + " vehiculos");
    }
}
