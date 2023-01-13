import java.awt.print.Printable;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

//DME

public class AccesoBdatos {
	private EntityManagerFactory emf;
	private EntityManager em;

	public void conectar() {
		emf = Persistence.createEntityManagerFactory("db/gestionStock.odb");
		em = emf.createEntityManager();
	}

	public void desconectar() {
		em.close();
		emf.close();
		System.exit(0);
	}
	
	public Tienda buscarTienda(int codigo) {
		return em.find(Tienda.class, codigo);
	}
	
	public boolean pregunta1(int codigo, String telefono)
	{
		System.out.println("--------------------------Pregunta 1--------------------------");
		Tienda t = buscarTienda(codigo);
		if (t == null)
		{
			return false;
		}
		try {
			em.getTransaction().begin();
			t.setTlf(telefono);
			em.persist(t);
			em.getTransaction().commit();			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public long pregunta2()
	{
		System.out.println("--------------------------Pregunta 2--------------------------");
		TypedQuery<Familia> tQuery = em.createQuery("select f from Familia f", Familia.class);
		List<Familia> listaFamilias = tQuery.getResultList();
		return listaFamilias.size();
	}
	
	public void pregunta3(String codigoP, int codigoT)
	{
		System.out.println("--------------------------Pregunta 3--------------------------");
		int n = 0;
		TypedQuery<Tienda> tQuery3 = em.createQuery("select t from Tienda t where t.getCod() == " + codigoT + "", Tienda.class);
		List<Tienda> listaTiendas = tQuery3.getResultList();
		
		for (Tienda tienda : listaTiendas) {
			for (Stock stock : tienda.getStocks()) {
				if(stock.getProducto().getCod().equals(codigoP))
				{
					n = stock.getUnidades();
				}
			}
		}
		System.out.println(n);
	}
}
