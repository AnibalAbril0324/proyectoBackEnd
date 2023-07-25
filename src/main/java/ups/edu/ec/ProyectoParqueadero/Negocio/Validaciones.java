package ups.edu.ec.ProyectoParqueadero.Negocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

	public boolean validarPlaca(String placa) {
		//System.out.println("llegamos aqui  "+ placa);
		String patron = "^[A-Z]{3}-\\d{3,4}$";
	    Pattern pattern = Pattern.compile(patron);
	    Matcher matcher = pattern.matcher(placa);
	    return matcher.matches();
	}
	
	public boolean validacionletras(String cadena) {
		String patron = "^[a-zA-Z ]+$";
		Pattern pattern = Pattern.compile(patron);
		Matcher matcher = pattern.matcher(cadena);
		return matcher.matches();
	}
	
	public boolean validarCedula(String cedula) throws Exception {
		
		if (cedula.length() != 10) {
			return false;
		}

		try {
				int sum = 0;
				for (int i = 0; i < 9; i++) {
					int digit = Integer.parseInt(cedula.substring(i, i + 1));
					if (i % 2 == 0) {
						digit *= 2;
						if (digit > 9) {
							digit -= 9;
						}
					}
					sum += digit;
				}
				int lastDigitCalculated = (sum % 10 == 0) ? 0 : 10 - (sum % 10);
				int lastDigit = Integer.parseInt(cedula.substring(9));
				
				return lastDigit == lastDigitCalculated;
					            
				} catch (NumberFormatException e) {
					        	//throw new Exception("Error al validar cedula: " + e.getMessage());
					return false;
			}
	}
}
