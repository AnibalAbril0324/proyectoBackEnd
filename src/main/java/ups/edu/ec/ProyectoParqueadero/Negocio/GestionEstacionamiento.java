package ups.edu.ec.ProyectoParqueadero.Negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoParqueadero.Datos.DAOEstacionamiento;
import ups.edu.ec.ProyectoParqueadero.Modelo.Estacionamiento;

@Stateless
public class GestionEstacionamiento {
	
	@Inject
	private DAOEstacionamiento daoest;
	
	
	public void GuardarEstacionamiento(Estacionamiento estacionamiento) throws Exception {
		if(daoest.read(estacionamiento.getCodigo())==null) {
			System.out.println("llego aqui " +estacionamiento.getCodigo());
			try {
				daoest.insertar(estacionamiento);
			} catch (Exception e) {
				
				throw new Exception("error la guardar"+e.getMessage());
			}
			
		}
		else {
		
			try {
				daoest.update(estacionamiento);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	public void eliminarEstacionamiento(int codigo){
		daoest.delete(codigo);
	}
	
	public Estacionamiento estacionamientobuscado(int codigo){
		Estacionamiento estbus=daoest.read(codigo);
		return estbus;
	}
			
	public List<Estacionamiento>listadoestacionamiento() {
		List<Estacionamiento>estacionamientos=daoest.getAll();
		return estacionamientos;
	}
}
