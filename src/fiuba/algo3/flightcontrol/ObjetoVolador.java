package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

public abstract class ObjetoVolador {
	private int velocidad; //buscar para hacerlo atributo de clase
	protected Posicion posicionActual;
	protected boolean aterrizado; 
	protected Posicion direccion;
	protected Trayectoria trayectoria;
	protected Escenario plano;
	protected String tipoDeObjetoVolador;
	
	public String getTipoDeObjetoVolador(){
		/* Devuelve el tipo de objeto volador que es */
		
		return this.tipoDeObjetoVolador;
		
	}
	
	public ObjetoVolador(int velocidad, int limite, Escenario unPlano){
		/* Constructor del Objeto volador */
		
		int valorDeSalidaX = 0;
		int valorDeSalidaY = 0;
		ArrayList<Posicion> trayectoriaVacia = new ArrayList<Posicion>();
		
		this.plano = unPlano;
		this.posicionActual = new Posicion(valorDeSalidaX, valorDeSalidaY);
		this.direccion = new Posicion (1,-1);
		this.aterrizado = false;
		this.trayectoria = new Trayectoria(trayectoriaVacia);
		
	}
	
	public void crearTrayectoria(ArrayList<Posicion> unaTrayectoriaNueva){
		/* Crea una nueva trayectoria para el objeto volador */
		
		this.trayectoria = new Trayectoria(unaTrayectoriaNueva);
		
	}
	
	public void aterrizar(){
		/* Aterriza el objeto volador en una Pista */
		/* pre: debe de aterrizar */
		/* post: cambia el estado del objeto volador a aterrizado */
		
		this.aterrizado = true;
		this.plano.posicionOcupadaPor(posicionActual, "pista");
	}

	public void setPosicion(Posicion unaPosicion){
		/* Establece la posicion actual del objeto volador */
		
		this.posicionActual = unaPosicion;
	}
	
	public Posicion getPosicion(){
		/* Devuelve la posicion actual del objeto volador */
		
		return this.posicionActual;
	}
	
	public void setDireccion(Posicion posicion){
		/* Establece la direccion actual del objeto volador */
		
		this.direccion = posicion;
	}
	
	public Posicion getDireccion(){
		/* Devuelve la direccion actual del objeto volador */
		
		return this.direccion;
		
	}
	
	
	public void moverse(){
		// tiene que ser abstracto
	}
	
/*	
	public void invertirDireccion(){
		int nuevaDireccionEnX = this.getDireccion().getPosicionX() * (-1);
		int nuevaDireccionEnY = this.getDireccion().getPosicionY() * (-1);
		
		this.direccion = new Posicion(nuevaDireccionEnX, nuevaDireccionEnY);
	}
*/
	
}
	
