
public abstract class Avion {
	private int velocidad;
	private Posicion posicion;
	private Posicion direccion;
	
	public Avion(int velocidad){
		
		int valorDeSalidaX = 0;
		int valorDeSalidaY = 0;
		
		this.velocidad = velocidad;
		this.posicion = new Posicion(valorDeSalidaX, valorDeSalidaY);
		this.direccion = new Posicion (1,1);
		
	}
	
	public int getVelocidad(){
		
		return this.velocidad;
	}
	
	public Posicion getPosicion(){
		
		return this.posicion;
	}
	
	public void volar(){
		
	}
	
	public Posicion getDireccion(){
		
		return this.direccion;
	}
	
	public void setDireccion(Posicion posicion){
		
		this.direccion = posicion;
	}
	
	public void setPosicion(Posicion unaPosicion){
		this.posicion = unaPosicion;
	}
	
	
}

