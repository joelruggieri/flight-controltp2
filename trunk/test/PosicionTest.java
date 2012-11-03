import junit.framework.TestCase;


public class PosicionTest extends TestCase {
	
	public void testConstructorDeUnaPosicionDeberiaSetearSusCoordenadas(){
		
		int coordenadaX = 3;
		int coordenadaY = 29;
		Posicion unaPosicion = new Posicion (coordenadaX, coordenadaY);
		
		assertEquals ( coordenadaX, unaPosicion.getPosicionX());
		assertEquals (coordenadaY, unaPosicion.getPosicionY());
	}

}
