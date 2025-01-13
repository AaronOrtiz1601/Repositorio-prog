package pruebaHibernate.pruebaHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import model.Alumno;
import utils.HibernateUtil;



public class MainApp {

	public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
    	
    	// Creaci�n de objetos simples
    	Alumno alumno1 = new Alumno();
    	alumno1.setNombre("Nacho");
    	alumno1.setApellido("Lorenzo");
    	alumno1.setEdad(44);
    	    	
    	Alumno alumno2 = new Alumno("PEpe", "Perez", 44);
    	
    	// Guardar objetos en BBDD (insert)
    	// me lo traigo porque luego voy a hacer update de alumno1
    	alumno1 = session.merge(alumno1);
    	alumno2 = session.merge(alumno2);
    	
    	
    	// Guardar objetos en BBDD (update)
    	alumno1.setEdad(33);
    	session.merge(alumno1);
    	
    	session.getTransaction().commit();
    	
    	HibernateUtil.closeSession();
	
	}

}
