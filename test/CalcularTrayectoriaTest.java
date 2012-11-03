import junit.framework.TestCase;


public class CalcularTrayectoriaTest extends TestCase {
	
	
	public void testProximaPosicionDeberiaRetornarUnaPosicionParaContinuarConlaDireccionQueTraia(){
		
		int x1 = 2;
		int y1 = 1;
		int x2 = 4;
		int y2 = 5;
		
		Posicion posicion1 = new Posicion (x1, y1);
		Posicion posicion2 = new Posicion (x2, y2);
		
		
		CalcularTrayectoria trayectoria = new CalcularTrayectoria (posicion1, posicion2);
		
		Posicion proximaPosicion = trayectoria.calcularProximaPosicion ();
		
		assertEquals (proximaPosicion.getPosicionX(), 6);
		assertEquals (proximaPosicion.getPosicionY(), 9);
	
		
	}

}
