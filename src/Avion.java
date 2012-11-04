
public abstract class Avion {
	private int velocidad;
	private Posicion posicion;
	private String direccion;
	
	public Avion(int velocidad){
		
		int valorDeSalidaX= 1;
		int valorDeSalidaY= 1;
		
		this.velocidad = velocidad;
		this.posicion = new Posicion(valorDeSalidaX, valorDeSalidaY);
		this.direccion = "noreste";
		
	}
	
	public int getVelocidad(){
		
		return this.velocidad;
	}
	
	public Posicion getPosicion(){
		
		return this.posicion;
	}
	
	public void volar(){
		
	}
	
	public String getDireccion(){
		
		return this.direccion;
	}
	
	public void setPosicion(Posicion unaPosicion){
		this.posicion = unaPosicion;
	}
	
	public void moverAlNoreste(){
		
		Posicion posicionActual = this.getPosicion();
		
		int nuevoX = this.getVelocidad()*(posicionActual.getPosicionX());
		int nuevoY = this.getVelocidad()*(posicionActual.getPosicionY());
		
		Posicion nuevaPosicion = new Posicion (nuevoX,nuevoY);
		
		this.setPosicion(nuevaPosicion);
		
		}
	
	public void moverAlNorte(){
	}
	
	public void moverAlSur(){
	}
	
	public void moverAlEste(){
	}
	
	public void moverAlOeste(){
	}
	
	public void moverAlNoroeste(){
	}
	
	public void moverAlSureste(){
	}
	
	public void moverAlSuroeste(){
	}
	
}

