
public abstract class Avion {
	private int velocidad;
	private Posicion posicion;
	private String direccion;
	
	public Avion(int velocidad){
		
		int valorDeSalidaX= 0;
		int valorDeSalidaY= 0;
		
		this.velocidad = velocidad;
		this.posicion = new Posicion(valorDeSalidaX, valorDeSalidaY);
		this.direccion = "norte";
		
	}
	
	public int getVelocidad(){
		
		return this.velocidad;
	}
	

}
