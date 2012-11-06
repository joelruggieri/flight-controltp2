
public class Posicion {
	
	private int x;
	private int y;
	
	public Posicion(){
		
		this.x = 0;
		this.y = 0;
		
	}
	
	public Posicion(int coordenadaX, int coordenadaY){
		/* Constructor de la clase Posicion */
		/* pre: Deben ingresarse dos enteros */
		/* post: La posicion fue creada */
		
		this.x = coordenadaX;
		this.y = coordenadaY;
	}
	
	public int getPosicionX(){
		/* Devuelve la coordenada x */
		return this.x;
	}

	public int getPosicionY(){
		/* Devuelve la coordenada y */
		return this.y;
	}
	
	public boolean equals (Posicion otraPosicion){
		/* Devuelve si la Posicion es igual a la posicion pasada por parametro */
		/* pre: Debe ingresarse una posicion */
		
		return (this.x == otraPosicion.getPosicionX()) && (this.y == otraPosicion.getPosicionY());
	}
	
	public Posicion sumar (Posicion otraPosicion){
		/* Suma la posicion con la posicion pasada por parametro */
		/* pre: Debe ingresarse una posicion */
		/* post: Devuelve la posicion suma */
		
		int x,y;
		Posicion suma;
		
		x = this.x + otraPosicion.getPosicionX();
		y = this.y + otraPosicion.getPosicionY();
		
		suma = new Posicion(x,y);
		
		return suma;
	}
	
	public Posicion restar (Posicion otraPosicion){
		/* Resta la posicion con la posicion pasada por parametro */
		/* pre: Debe ingresarse una posicion */
		/* post: Devuelve la posicion resta */
		
		int x,y;
		Posicion resta;
		
		x = this.x - otraPosicion.getPosicionX();
		y = this.y - otraPosicion.getPosicionY();
		
		resta = new Posicion(x,y);
		
		return resta;
	}

	public void ActualizarCoordenadas(int valorX, int valorY){
		
		this.x= valorX;
		this.y= valorY;
	}
}
