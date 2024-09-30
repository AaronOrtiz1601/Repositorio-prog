package refactorizacion_realizada;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private ArrayList<Alquiler> alquileres = new ArrayList<>();
    private static final int DIAS_MAXIMOS_TURISMOS = 10;
    private static final int DIAS_MAXIMOS_MOTOCICLETAS = 5;
    private static final double PENALIZACION = 7.5;
    private static final int COSTE_ALQUILAR_TURISMO = 20;
    private static final int COSTE_ALQUILAR_MOTOCICLETA = 10;
    private static final int COSTE_ALQUILAR_FURGONETA = 30;
    private static final int DIAS_PARA_PUNTOS = 2;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void addAlquiler(Alquiler arg) {
        alquileres.add(arg);
    }

    public String getNombre() {
        return nombre;
    }

    public String cuenta() {
        String resultado = cabeceraCuenta();
        double precioTotal = 0;
        int puntosFrecuenciaAlquiler = 0;

        for (Alquiler alquiler : alquileres) {
            double importeAlquiler = calcularImporteAlquiler(alquiler);
            precioTotal += importeAlquiler;
            puntosFrecuenciaAlquiler += calcularPuntosFidelidad(alquiler);
            resultado += detalleAlquiler(alquiler, importeAlquiler);
        }

        resultado += pieDeCuenta(precioTotal, puntosFrecuenciaAlquiler);
        return resultado;
    }

    private String cabeceraCuenta() {
        return "Registro de alquiler para " + getNombre() + "\n";
    }

    private double calcularImporteAlquiler(Alquiler alquiler) {
        double importeAlquiler = 0;
        switch (alquiler.getVehiculo().getCodigoPrecio()) {
            case Vehiculo.TURISMO:
                importeAlquiler += COSTE_ALQUILAR_TURISMO;
                if (alquiler.getDiasAlquiler() > DIAS_MAXIMOS_TURISMOS)
                    importeAlquiler += (alquiler.getDiasAlquiler() - DIAS_MAXIMOS_TURISMOS) * PENALIZACION;
                break;
            case Vehiculo.FURGONETA:
                importeAlquiler += alquiler.getDiasAlquiler() * COSTE_ALQUILAR_FURGONETA;
                break;
            case Vehiculo.MOTOCICLETA:
                importeAlquiler += COSTE_ALQUILAR_MOTOCICLETA;
                if (alquiler.getDiasAlquiler() > DIAS_MAXIMOS_MOTOCICLETAS)
                    importeAlquiler += (alquiler.getDiasAlquiler() - DIAS_MAXIMOS_MOTOCICLETAS) * PENALIZACION;
                break;
        }
        return importeAlquiler;
    }

    private int calcularPuntosFidelidad(Alquiler alquiler) {
        int puntos = 1;
        if (alquiler.getVehiculo().getCodigoPrecio() == Vehiculo.FURGONETA && alquiler.getDiasAlquiler() > DIAS_PARA_PUNTOS)
            puntos++;
        return puntos;
    }

    private String detalleAlquiler(Alquiler alquiler, double importeAlquiler) {
        return "\t" + alquiler.getVehiculo().getMatricula() + "\t" + importeAlquiler + "\n";
    }

    private String pieDeCuenta(double precioTotal, int puntosFrecuenciaAlquiler) {
        return "Importe total " + precioTotal + "\n" + "Has ganado " + puntosFrecuenciaAlquiler + " puntos de fidelidad";
    }
}
