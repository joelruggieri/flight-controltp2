import java.util.ArrayList;


public class Simple extends Avion {
	
	private ArrayList<Posicion> puntosDeTrayectoria;
	private CalcularTrayectoria trayectoria;
	
	
	
	public Simple(int velocidadInicial){
		
		super (velocidadInicial);
		
	}
	
	public ArrayList<Posicion> getPuntosDeTrayectoria(){
		
		return this.puntosDeTrayectoria;
	}
	
	
	public void volar(){
		ArrayList<Posicion> puntosASeguir = this.getPuntosDeTrayectoria();
		
		if((puntosASeguir.size()) == 0){
			switch (this.getDireccion()){
			case "norte":
				this.moverAlNorte();
			
			case "sur":
				this.moverAlSur();
				
			case "este":
				this.moverAlEste();
			
			case "oeste":
				this.moverAlOeste();
			
			case "noreste":
				this.moverAlNoreste();
			
			case "sureste":
				this.moverAlSureste();
				
			case "noroeste":
				this.moverAlNoroeste();
			
			case "suroeste":
				this.moverAlSuroeste();	
				
			}
		}
	}
	
	

}
