import junit.framework.TestCase;


public class AvionSimpleTest extends TestCase {
	
	public void testConstructorDeUnAvionSimpleConUnaVelocidadConstante(){
		
		int velocidad = 1;
		
		Simple avion = new Simple(velocidad);
		
		assertEquals (velocidad, avion.getVelocidad());
	}

}
