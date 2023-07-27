package ups.edu.ec.ProyectoParqueadero.Datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.ProyectoParqueadero.Modelo.Vehiculo;


@Stateless
public class DAOVehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insertar(Vehiculo vehiculo){
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo Vehiculo) {
		
	em.merge(Vehiculo);
	}
	
	public Vehiculo read(int codigo) {
		Vehiculo c = em.find(Vehiculo.class, codigo);
		return c;
	}
	
	public void delete (String codigo) {
		Vehiculo c = em.find(Vehiculo.class, codigo);
		em.remove(c);
	}
	
	public List<Vehiculo> getAll(){
		
		String jpql="SELECT p From Vehiculo p";
		Query q=em.createQuery(jpql);
		return q.getResultList();
	}	
}
