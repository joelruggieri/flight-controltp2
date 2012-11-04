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
  
	public void testSumarDosPosicionesDeberiaDarLaSuma (){
		
		//arange
		Posicion unaPosicion = new Posicion (1,2);
		Posicion otraPosicion = new Posicion (4,7);
		Posicion adicion = new Posicion (5,9);
		Posicion suma;
		
		//act
		suma = unaPosicion.sumar (otraPosicion);
		
		//assert
		assertTrue (suma.equals(adicion));
		
	}
	
	public void testRestarDosPosicionesDeberiaDarLaResta (){
		
		//arange
		Posicion unaPosicion = new Posicion (1,2);
		Posicion otraPosicion = new Posicion (4,7);
		Posicion sustraccion = new Posicion (-3,-5);
		Posicion resta;
		
		//act
		resta = unaPosicion.restar (otraPosicion);
		
		//assert
		assertTrue (resta.equals(sustraccion));

	}
	
}
