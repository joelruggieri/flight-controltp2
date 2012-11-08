package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;


public class TrayectoriaTest extends TestCase {
	
	
	public void testProximaPosicionDeberiaRetornarUnaPosicionParaContinuarConlaDireccionQueTraia(){
		
   //arange
		int x1 = 2;
		int y1 = 1;
		int x2 = 4;
		int y2 = 5;
		
		Posicion posicion1 = new Posicion (x1, y1);
		Posicion posicion2 = new Posicion (x2, y2);
		Posicion posicionDireccion = new Posicion (6,9);
		
		boolean direccionesIguales;
		
		
		//act
		Trayectoria trayectoria = new Trayectoria (posicion1, posicion2);
		Posicion proximaPosicion = trayectoria.calcularProximaPosicion ();
		
		direccionesIguales = proximaPosicion.equals(posicionDireccion);
		
		//assert
		assertTrue (direccionesIguales);
	
		
	}

}
