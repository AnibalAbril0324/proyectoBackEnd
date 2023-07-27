package ups.edu.ec.ProyectoParqueadero.Datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.ProyectoParqueadero.Modelo.Persona;


@Stateless
public class DAOPersona implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insertar(Persona persona){
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		
	em.merge(persona);
	}
	
	public Persona read(String cedula) {
		Persona c = em.find(Persona.class, cedula);
		return c;
	}
	
	public void delete (String cedula) {
		Persona c = em.find(Persona.class, cedula);
		em.remove(c);
	}
	
	public List<Persona> getAll(){
		
		String jpql="SELECT p From Persona p";
		Query q=em.createQuery(jpql);
		return q.getResultList();
	}	
}