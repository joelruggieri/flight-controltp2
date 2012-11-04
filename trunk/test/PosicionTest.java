import junit.framework.TestCase;


public class PosicionTest extends TestCase {
	
	public void testConstructorDeUnaPosicionDeberiaSetearSusCoordenadas(){
		
		int coordenadaX = 3;
		int coordenadaY = 29;
		Posicion unaPosicion = new Posicion (coordenadaX, coordenadaY);
		
		assertEquals ( coordenadaX, unaPosicion.getPosicionX());
		assertEquals (coordenadaY, unaPosicion.getPosicionY());
	}
   
  public void testDeDosPosicionesIgualesEqualsDeberiaDarVerdadero () {		
		
		//arrange
		int x = 1;
		int y = 5;
		boolean sonIguales;
		
		Posicion unaPosicion = new Posicion (x,y);
		Posicion otraPosicion = new Posicion (x,y);
		
		//act
		sonIguales = unaPosicion.equals(otraPosicion);
		
		//assert
		assertTrue (sonIguales);
		
	}
   
  public void testDeDosPosicionesDistintasEqualsDeberiaDarFalso () {		
		
		//arrange
		int x = 1;
		int y = 5;
		boolean sonIguales;
		
		Posicion unaPosicion = new Posicion (x,y);
		Posicion otraPosicion = new Posicion (x,1);
		
		//act
		sonIguales = unaPosicion.equals(otraPosicion);
		
		//assert
		assertFalse (sonIguales);
		
	}

}
