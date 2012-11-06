import java.util.ArrayList;

public abstract class Avion {
	private int velocidad; //buscar para hacerlo atributo de clase
	private Posicion posicionActual;
	private boolean aterrizado; 
	private Posicion direccion;
	private Trayectoria trayectoria;
	
	
	public Avion(int velocidad){
		
		int valorDeSalidaX = 0;
		int valorDeSalidaY = 0;
		ArrayList<Posicion> trayectoriaVacia = new ArrayList<Posicion>();
		
		this.posicionActual = new Posicion(valorDeSalidaX, valorDeSalidaY);
		this.direccion = new Posicion (1,-1);
		this.aterrizado = false;
		this.trayectoria = new Trayectoria(trayectoriaVacia);
		
	}
	
	public void crearTrayectoria(ArrayList<Posicion> unaTrayectoriaNueva){
		
		this.trayectoria = new Trayectoria(unaTrayectoriaNueva);
		
	}
	
	public void aterrizar(){
		
		this.aterrizado = true;
		
	}

	public void setPosicion(Posicion unaPosicion){
		
		this.posicionActual = unaPosicion;
	}
	
	public Posicion getPosicion(){
		
		return this.posicionActual;
	}
	
	public void setDireccion(Posicion posicion){
		
		this.direccion = posicion;
	}
	
	public Posicion getDireccion(){
		
		return this.direccion;
		
	}
	
	
	public void moverse(){
		
		
	}
	

	
	
	public void invertirDireccion(){
		int nuevaDireccionEnX = this.getDireccion().getPosicionX() * (-1);
		int nuevaDireccionEnY = this.getDireccion().getPosicionY() * (-1);
		
		this.direccion = new Posicion(nuevaDireccionEnX, nuevaDireccionEnY);
	}
}
	
