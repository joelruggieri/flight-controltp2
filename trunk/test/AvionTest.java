import java.util.ArrayList;

import junit.framework.TestCase;

public class AvionTest extends TestCase {
	
	public void testMoverseDeberiaMoverseALaPosicionIndicada (){
		
		//arrange
		Posicion unaPosicion = new Posicion (4,5);
		Posicion posicionFinal;
		ArrayList<Posicion> puntosDeTrayectoria = new ArrayList<Posicion>();
		Simple unaAvion = new Simple (1);
		
		//act
		avion.crearTrayectoria (puntosDeTrayectoria);
		avion.moverse();
		posicionFinal = avion.getPosicion();
		
		//assert
		assertTrue (unaPosicion.equals(posicionFinal));		
		
	}
	
}
