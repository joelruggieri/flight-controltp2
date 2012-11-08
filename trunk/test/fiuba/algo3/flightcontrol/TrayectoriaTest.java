package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;

public class TrayectoriaTest extends TestCase {
	
	
	public void testProximaPosicionDeberiaRetornarUnaPosicionParaContinuarConlaDireccionQueTraia(){
		
   //arrange
		int x1 = 1;
		int y1 = 1;
		int x2 = 1;
		int y2 = 2;
		
		Posicion posicion1 = new Posicion (x1, y1);
		Posicion posicion2 = new Posicion (x2, y2);

		
		ArrayList<Posicion> puntos = new ArrayList<Posicion>();
		puntos.add(posicion1);
		puntos.add(posicion2);
		
		boolean direccionesIguales;
		
		
	//act
		Trayectoria trayectoria = new Trayectoria (puntos);
		Posicion proximaPosicion = trayectoria.calcularProximaPosicion(posicion1);
		
		direccionesIguales = proximaPosicion.equals(posicion2);
		
	//assert
		assertTrue (direccionesIguales);
	
		
	}

}
