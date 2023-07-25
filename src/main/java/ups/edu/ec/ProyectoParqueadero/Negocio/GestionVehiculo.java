package ups.edu.ec.ProyectoParqueadero.Negocio;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import ups.edu.ec.ProyectoParqueadero.Datos.DAOVehiculo;
import ups.edu.ec.ProyectoParqueadero.Modelo.Vehiculo;

@Stateless
public class GestionVehiculo {

	@Inject 
	private DAOVehiculo daovehiculo;
	
	private Validaciones validar;
	
	public GestionVehiculo() {
		validar=new Validaciones();
	}
	public void guardarVehiculo(Vehiculo vehiculo) throws Exception {
		
		if(!validar.validarPlaca(vehiculo.getPlaca())) {
			throw new Exception("placa incorrecta");
		}
		
		if(!validar.validacionletras(vehiculo.getMarca()))
			throw new Exception("marca incorrecta");
			
		if(!validar.validacionletras(vehiculo.getColor()))
			throw new Exception("color incorrecto");
		
		if(daovehiculo.read(vehiculo.getCodigo())==null) {
			System.out.println("llego aqui " +vehiculo.getCodigo());
			try {
				daovehiculo.insertar(vehiculo);
			} catch (Exception e) {
				
				throw new Exception("error la guardar"+e.getMessage());
			}
			
		}
		else {
		
			try {
				daovehiculo.update(vehiculo);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
		
	public void eliminarVehiculo(String cedula){
		daovehiculo.delete(cedula);
	}
	
	public Vehiculo vechiculobuscada(int codigo){
		Vehiculo perbus=daovehiculo.read(codigo);
		return perbus;
	}
			
	public List<Vehiculo>listadovehiculos() {
		List<Vehiculo>vechiculos=daovehiculo.getAll();
		return vechiculos;
	}
		
}
