import java.util.ArrayList;

public class Trayectoria {
	
	private ArrayList<Posicion> listaDePosiciones;
	
	public Trayectoria (ArrayList<Posicion> unaListaDePosiciones){
		/* Constructor de una trayectoria */
		/* pre: una lista de posiciones con posiciones, o vacia */
		/* post: establece la trayectoria deseada */
		
		this.listaDePosiciones = unaListaDePosiciones;
		
	}	
	
	public Posicion calcularProximaPosicion(Posicion posicionActual){
		/* Calcula la proxima posicion mas optima para moverse */
		/* pre: la lista de posiciones debe tener al menos una posicion a ir */
		/* post: cambia la posicion actual a la posicion siguiente, que es mas eficiente */
		Posicion nuevaPosicion = new Posicion ();
		
		return nuevaPosicion;
		
	}
	
	public Posicion getPrimerPosicion(){
		/* Devuelve la primer posicion destino de la trayectoria */
		/* post: devuelve la primer posicion, o null de no haber ningun destino definido */
		return this.listaDePosiciones.get(0);
	}
		
}
