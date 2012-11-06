
public class Helicoptero extends ObjetoVolador{

	public Helicoptero(int velocidadInicial){
		/* Constructor de un helicoptero */
		
		super (velocidadInicial);
		
	}
	
	public void moverse(){
		/* Mueve el objeto volador siguiendo la trayectoria, y si no hay trayectoria definida se queda en el lugar */
		/* post: cambia el valor de la posicion actual, buscando el movimiento mas optimo posible */
		if (this.trayectoria.getPrimerPosicion() != null){
			
			this.trayectoria.calcularProximaPosicion(posicionActual);
			
		}
		
	}
	
}
