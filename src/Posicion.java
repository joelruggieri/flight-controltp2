public class Posicion {
	
	private int x;
	private int y;
	
	
	public Posicion(int coordenadaX, int coordenadaY){
		
		
		this.x = coordenadaX;
		this.y = coordenadaY;
	}
	
	public int getPosicionX (){
		
		return this.x;
	}

	
	public int getPosicionY (){
		
		return this.y;
	}
  
  public boolean equals (Posicion otraPosicion){
		/* Devuelve si otraPosicion es igual */
      
		return (this.x == otraPosicion.getPosicionX()) && (this.y == otraPosicion.getPosicionY());
	}
	

}
