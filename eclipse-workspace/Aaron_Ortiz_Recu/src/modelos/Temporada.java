package modelos;

import java.time.LocalDate;
import java.util.Date;


public class Temporada {
	
	private int numeroTemporada;
	private Date inicioTemporada;
	private Date finTemporada;
	private int numerocapitulos;
	
	
	public Temporada(int numeroTemporada, Date date, Date date2, int numerocapitulos) {
		super();
		this.numeroTemporada = numeroTemporada;
		this.inicioTemporada = date;
		this.finTemporada = date2;
		this.numerocapitulos = numerocapitulos;
	}


	public int getNumeroTemporada() {
		return numeroTemporada;
	}


	public void setNumeroTemporada(int numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}


	public Date getInicioTemporada() {
		return inicioTemporada;
	}


	public void setInicioTemporada(Date inicioTemporada) {
		this.inicioTemporada = inicioTemporada;
	}


	public Date getFinTemporada() {
		return finTemporada;
	}


	public void setFinTemporada(Date finTemporada) {
		this.finTemporada = finTemporada;
	}


	public int getNumerocapitulos() {
		return numerocapitulos;
	}


	public void setNumerocapitulos(int numerocapitulos) {
		this.numerocapitulos = numerocapitulos;
	}
	
	
	
	
	

}
