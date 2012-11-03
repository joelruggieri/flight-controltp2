
public class CalcularTrayectoria {
	
	private Posicion posicion1;
	private Posicion posicion2;
	
	
	public CalcularTrayectoria (Posicion anteUltimaPosicion, Posicion ultimaPosicion){
		
		this.posicion1 = anteUltimaPosicion;
		this.posicion2 = ultimaPosicion;
		
	}
	
	public Posicion getPosicion1 (){
		
		return this.posicion1;
	}
	
	public Posicion getPosicion2 (){
		
		return this.posicion2;
	}
		
	
	public Posicion calcularProximaPosicion(){
		
		int proximoX= (posicion2.getPosicionX() - posicion1.getPosicionX()) + posicion2.getPosicionX();
		int proximoY= (posicion2.getPosicionY() - posicion1.getPosicionY()) + posicion2.getPosicionY();
		
		Posicion proximaPosicion = new Posicion (proximoX, proximoY);
		
		return proximaPosicion;
	}
		

}
