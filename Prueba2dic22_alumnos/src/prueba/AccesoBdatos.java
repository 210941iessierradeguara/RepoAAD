package prueba;

import primero.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// DME

public class AccesoBdatos {
	private SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
	private Session session = sesion.openSession();

	public void conectar() {
		sesion = SessionFactoryUtil.getSessionFactory();
		session = sesion.openSession();
	}

	public void desconectar() {
		session.close();
		sesion.close();
		System.exit(0);
	}

	public boolean pregunta1(String nombre, String telefono) {
		
		if(nombre == null || nombre.isEmpty() || nombre.equals("") || nombre.equals(" ") 
				|| nombre.equalsIgnoreCase("null"))
		{
			System.out.print("El nombre no puede ser null o vacío" );
			return false;
		}
		else
		{
			Tienda tienda = new Tienda();
			tienda.setNombre(nombre);
			tienda.setTlf(telefono);
			
			Transaction tx = null;
			tx = session.beginTransaction();
			session.save(tienda);
			tx.commit();
			//tx.rollback();
			
			System.out.print("Insertado correctamente ");
			return true;
		}
	}

	public boolean pregunta2(int codigo, String telefono) { 
		try {
			Tienda t = new Tienda();
			t = (Tienda) session.load(Tienda.class, codigo);
			t.setTlf(telefono);
			
			Transaction tx = null;
			tx = session.beginTransaction();
			session.update(t);
			tx.commit();
			//tx.rollback();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public long pregunta3() {
		Query q = session.createQuery("select count(*) from Familia");
		return (long) q.uniqueResult();
	}
	/*
	public  void pregunta4(String codigoP, int codigoT){
		
		
		Transaction tx = null;
		tx = session.beginTransaction();
		
		tx.commit();
		//tx.rollback();
	}*/
	/*
	public  void pregunta5(){
		
		
		Transaction tx = null;
		tx = session.beginTransaction();
		
		tx.commit();
		//tx.rollback();
	}*/
	/*
	public  void pregunta6(){
		
		
		Transaction tx = null;
		tx = session.beginTransaction();
		
		tx.commit();
		//tx.rollback();
	}*/
	
} // de la clase AccesoBdatos
