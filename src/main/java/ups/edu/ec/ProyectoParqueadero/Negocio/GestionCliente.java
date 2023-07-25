package ups.edu.ec.ProyectoParqueadero.Negocio;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoParqueadero.Datos.DAOPersona;
import ups.edu.ec.ProyectoParqueadero.Modelo.Persona;

@Stateless
public class GestionCliente {
		
@Inject 
private DAOPersona daopersona;

private Validaciones validar;

	public GestionCliente() {
		validar= new Validaciones();
	}
	public void guardarPersona(Persona persona) throws Exception {
		if (!validar.validarCedula(persona.getCedula())) {
			throw new Exception("Cedula incorrecta");
		} 
		
		if(!validar.validacionletras(persona.getNombre())) {
			throw new Exception("nombres incorrectos contiene nunmeros");
		}
			
		if(daopersona.read(persona.getCedula())==null) {
			try {
					daopersona.insertar(persona);
				} catch (Exception e) {
					throw new Exception("error la guardar"+e.getMessage());
				}
		}
		else {
			try {
					daopersona.update(persona);
				}catch(Exception e) {
					throw new Exception("Error al actualizar: " + e.getMessage());
				}
			}
		}
			
	public void eliminarPersona(String cedula){
		daopersona.delete(cedula);
	}
	
	public Persona personabuscada(String cedula){
		Persona perbus=daopersona.read(cedula);
		return perbus;
	}
			
	public List<Persona>listadopersonas() {
		List<Persona>personas=daopersona.getAll();
		return personas;
	}
		
}