package ups.edu.ec.ProyectoParqueadero.Datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.ProyectoParqueadero.Modelo.DetalleTicket;
import ups.edu.ec.ProyectoParqueadero.Modelo.Estacionamiento;

@Stateless
public class DAODetalleTicket implements Serializable{

private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void insertar(DetalleTicket detalleticket){
		em.persist(detalleticket);
	}
	
	public void update(DetalleTicket detalleticket) {
		
		em.merge(detalleticket);
	}
		
	public DetalleTicket read(int codigo) {
		DetalleTicket detticket = em.find(DetalleTicket.class, codigo);
		return detticket;
	}
		
	public void delete (int codigo) {
		DetalleTicket detticket = em.find(DetalleTicket.class, codigo);
		em.remove(detticket);
	}
		
	public List<DetalleTicket> getAll(){
			
		String jpql="SELECT e From DetalleTicket e";
		Query q=em.createQuery(jpql);
		return q.getResultList();
	}

}
