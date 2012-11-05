import junit.framework.TestCase;


public class AvionSimpleTest extends TestCase {
	
	public void testConstructorDeUnAvionSimpleConUnaVelocidadConstante(){
		
		int velocidad = 1;
		
		Simple avion = new Simple(velocidad);
		
		assertEquals (velocidad, avion.getVelocidad());
	}
	
	public void testAvionVolarCuandoNoHayTrayectoriaMarcadaDeberiaActualizarSuPosicionDependiendoDeSuVelocidadYDeLaDireccionQueTraia(){
		
		int dimension = 300;
		int velocidad = 2;
		Simple avion = new Simple(velocidad);
		
		avion.volar(dimension);
		
		Posicion posicionActualAvion = avion.getPosicion();
		
		assertEquals(posicionActualAvion.getPosicionX() , 2);
		assertEquals(posicionActualAvion.getPosicionY() , 2);
		
	}
	
	public void testVolarAunaPosicionMasAllaDelLimitePermitidoEnDireccionAlNoresteDeberiaHacerQueElAvionReboteEnDichaDireccion(){
		
		int dimensionLimite = 768;
		
		int velocidad = 768;
		
		Simple avion = new Simple (velocidad);
		
		avion.volar(dimensionLimite);
		
		assertTrue(((avion.getPosicion()).getPosicionX() == dimensionLimite) && (((avion.getPosicion()).getPosicionX() == dimensionLimite)));
		assertTrue (avion.esDireccionNoreste());
		
		avion.volar(dimensionLimite);
		assertTrue (avion.esDireccionSuroeste());
		
		//assertTrue((avion.getPosicion()).getPosicionX() == 0);
		//assertTrue((avion.getPosicion()).getPosicionY() == 0);
		
		
	}

}
