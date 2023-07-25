package ups.edu.ec.ProyectoParqueadero.Datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.ProyectoParqueadero.Modelo.Estacionamiento;


@Stateless
public class DAOEstacionamiento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void insertar(Estacionamiento estacionamiento){
		em.persist(estacionamiento);
	}
	
	public void update(Estacionamiento estacionamiento) {
		
		em.merge(estacionamiento);
	}
		
	public Estacionamiento read(int codigo) {
		Estacionamiento est = em.find(Estacionamiento.class, codigo);
		return est;
	}
		
	public void delete (int codigo) {
		Estacionamiento est = em.find(Estacionamiento.class, codigo);
		em.remove(est);
	}
		
	public List<Estacionamiento> getAll(){
			
		String jpql="SELECT e From Estacionamiento e";
		Query q=em.createQuery(jpql);
		return q.getResultList();
	}

}
