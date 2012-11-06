
public class Plano {

	private String[][] plano;
	
	public Plano( int limite ){
		/* Constructor del plano del juego */
		
		plano = new String [limite][limite];
		for( int i = 0 ; i < limite ; i++ ){
			for( int j = 0 ; j < limite ; j++ ){
				plano[i][j] = "vacio";
			}
		}
		
	}
	
	public String getPosicion(Posicion unaPosicion){
		/* Devuelve que hay en una Posicion pedida */
		
		return plano[unaPosicion.getPosicionX()][unaPosicion.getPosicionY()];
		
	}
	
	public void posicionQuedaVacio(Posicion unaPosicion){
		/* Establece que una posicion ya no tiene nada */
		/* pre: posicion debe estar ocupada */
		/* post: posicion queda vacia */
		
		plano[unaPosicion.getPosicionX()][unaPosicion.getPosicionY()] = "vacio";
		
	}
	
	public void posicionOcupadaPor(Posicion unaPosicion,String unObjeto){
		/* Establece que ahora la posicion esta ocupada por un objeto */
		/* pre: la posicion debe estar vacia */
		/* post: la posicion queda ocupada por un objeto */
		plano[unaPosicion.getPosicionX()][unaPosicion.getPosicionY()] = unObjeto;
		
	}
	
}
