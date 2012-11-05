import java.util.ArrayList;


public class Simple extends Avion {
	
	private ArrayList<Posicion> puntosDeTrayectoria;
	private CalcularTrayectoria trayectoria;
	
	
	
	public Simple(int velocidadInicial){
		
		super (velocidadInicial);
		
		this.puntosDeTrayectoria = new ArrayList<Posicion>();
		
	}
	
	public ArrayList<Posicion> getPuntosDeTrayectoria(){
		
		return this.puntosDeTrayectoria;
	}
	
	
	
	public void volar(int dimension){
		boolean modificacionDelSentidoDeVuelo = false;
		ArrayList<Posicion> puntosASeguir = this.getPuntosDeTrayectoria();
		
		this.validarExtremoSuperiorDerecho(dimension,modificacionDelSentidoDeVuelo);
		
		if((puntosASeguir.size() == 0) && (!modificacionDelSentidoDeVuelo)){
			int xDireccion = (this.getDireccion()).getPosicionX();
			int yDireccion = (this.getDireccion()).getPosicionY();
			
			int nuevaX = (this.getPosicion()).getPosicionX() + (xDireccion * (this.getVelocidad()));
			int nuevaY = (this.getPosicion()).getPosicionY() + (yDireccion * (this.getVelocidad()));
			
			Posicion nuevaPosicion = new Posicion (nuevaX, nuevaY);
			this.setPosicion(nuevaPosicion);
		}
	}
	
	

}
