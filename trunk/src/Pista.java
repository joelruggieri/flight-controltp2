import java.util.ArrayList;

public class Pista {

	private ArrayList<Posicion> entradas;
	private String objetosVoladoresPermitidos;
	private Posicion direccionDeIngreso;
	
	public Pista(Plano unPlano, String tipoDeObjetoVolador, ArrayList<Posicion> unasEntradas){
		/* Constructor de una pista */
		
		this.entradas = unasEntradas;
		this.direccionDeIngreso = new Posicion (1,-1);
		this.objetosVoladoresPermitidos = tipoDeObjetoVolador;
		
		int i = 0;
		while( entradas.get(i) != null ){
			
			unPlano.posicionOcupadaPor(entradas.get(i), "pista");
			i++;
			
		}
	}
	
	public void noHacerNada(){
		//no hace nada, pero lo hardcoree para un test
	}
	
	public void validarObjetoVolador (ObjetoVolador unObjetoVolador){
		/* Si la direccion y posicion del objeto volador coinciden con las de la pista y el objeto volador puede aterrizar 
		 * en esa pista entonces permite el aterrizaje */
		/* post: el avion sigue volando, o aterriza */
		
		boolean mismaDireccion = false;
		boolean mismaPosicion = false;
		boolean mismoTipoDeObjetoVolador = false;
		
		mismaDireccion = (unObjetoVolador.getDireccion().equals(this.direccionDeIngreso));
		mismaPosicion = (unObjetoVolador.getPosicion().equals(this.direccionDeIngreso));
		mismoTipoDeObjetoVolador = (this.objetosVoladoresPermitidos == unObjetoVolador.getTipoDeObjetoVolador());
		
		if (mismaDireccion && mismaPosicion && mismoTipoDeObjetoVolador){
			
			unObjetoVolador.aterrizar();
			
			
		}
		
	}
}