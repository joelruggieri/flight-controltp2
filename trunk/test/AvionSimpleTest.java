import junit.framework.TestCase;


public class AvionSimpleTest extends TestCase {
	
	public void testConstructorDeUnAvionSimpleConUnaVelocidadConstante(){
		
		int velocidad = 1;
		
		Simple avion = new Simple(velocidad);
		
		assertEquals (velocidad, avion.getVelocidad());
	}
	
	public void testAvionVolarCuandoNoHayTrayectoriaMarcadaDeberiaActualizarSuPosicionDependiendoDeSuVelocidadYDeLaDireccionQueTraia(){
		
		int velocidad = 2;
		Simple avion = new Simple(velocidad);
		
		avion.volar();
		
		Posicion posicionActualAvion = avion.getPosicion();
		
		assertEquals(posicionActualAvion.getPosicionX() , 2);
		assertEquals(posicionActualAvion.getPosicionY() , 2);
	}

}
