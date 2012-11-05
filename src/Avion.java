
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
	
	public void volar(int dimension){
		
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
	

	public boolean esDireccionNorte(){
		
		return ((this.getDireccion()).getPosicionX() == 0) && ((this.getDireccion()).getPosicionY() == 1);
	}
	
	public boolean esDireccionSur(){
		
		return ((this.getDireccion()).getPosicionX() == 0) && ((this.getDireccion()).getPosicionY() == -1);
	}
	
	public boolean esDireccionEste(){
		
		return ((this.getDireccion()).getPosicionX() == 1) && ((this.getDireccion()).getPosicionY() == 0);
	}
	
	public boolean esDireccionOeste(){
		
		return ((this.getDireccion()).getPosicionX() == -1) && ((this.getDireccion()).getPosicionY() == 0);
	}	
		
	public boolean esDireccionNoroeste(){
		
		return ((this.getDireccion()).getPosicionX() == -1) && ((this.getDireccion()).getPosicionY() == 1);
	}
	
	public boolean esDireccionNoreste(){
		
		return ((this.getDireccion()).getPosicionX() == 1) && ((this.getDireccion()).getPosicionY() == 1);
	}
	
	public boolean esDireccionSureste(){
		
		return ((this.getDireccion()).getPosicionX() == 1) && ((this.getDireccion()).getPosicionY() == -1);
	}
	
	public boolean esDireccionSuroeste(){
		
		return ((this.getDireccion()).getPosicionX() == -1) && ((this.getDireccion()).getPosicionY() == -1);
		
	}
	
	
	public void invertirDireccion(){
		int nuevaDireccionEnX = this.getDireccion().getPosicionX() * (-1);
		int nuevaDireccionEnY = this.getDireccion().getPosicionY() * (-1);
		
		this.direccion = new Posicion(nuevaDireccionEnX, nuevaDireccionEnY);
	}
	
	public void validarExtremoSuperiorDerecho(int dimension, boolean cambioDeSentido){
		
		int valorX = (this.getPosicion()).getPosicionX();
		int valorY = (this.getPosicion()).getPosicionY();
		
		int nuevoX = valorX - (this.getVelocidad());
		int nuevoY = valorY - (this.getVelocidad());
		
		if((valorX == dimension) && (valorY == dimension)){
			
			if(this.esDireccionNorte()){
				this.getPosicion().ActualizarCoordenadas(valorX, nuevoY);
				this.invertirDireccion();
				cambioDeSentido = true;
			}else{
				if(this.esDireccionEste()){
					this.getPosicion().ActualizarCoordenadas(nuevoX, valorY);
					this.invertirDireccion();
					cambioDeSentido = true;
				}else{
					if(this.esDireccionNoreste()){
						this.getPosicion().ActualizarCoordenadas(nuevoX, nuevoY);
						this.invertirDireccion();
						cambioDeSentido = true;
					}	
				}
			}
		
		}
	}
	
}
