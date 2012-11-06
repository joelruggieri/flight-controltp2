
public class Helicoptero extends ObjetoVolador{

	public Helicoptero(int velocidadInicial,int limite,Plano unPlano){
		/* Constructor de un helicoptero */
		
		super (velocidadInicial, limite, unPlano);
		
		this.tipoDeObjetoVolador = "helicoptero" ;
	}
	
	public void moverse(){
		/* Mueve el objeto volador siguiendo la trayectoria, y si no hay trayectoria definida se queda en el lugar */
		/* post: cambia el valor de la posicion actual, buscando el movimiento mas optimo posible */
		
		this.plano.posicionQuedaVacio(posicionActual);
		
		if (this.trayectoria.getPrimerPosicion() != null){
			
			this.trayectoria.calcularProximaPosicion(posicionActual);
			
		}
		
		this.plano.posicionOcupadaPor(posicionActual, "objetoVolador");
		
	}
	
}
