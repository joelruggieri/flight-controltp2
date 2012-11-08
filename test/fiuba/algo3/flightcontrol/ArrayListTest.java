package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

import junit.framework.TestCase;

public class ArrayListTest extends TestCase {

	public void testElMetodoSizeEnUnArrayVacioDeberiaDarCero(){
		
		ArrayList<Integer> unaLista = new ArrayList<Integer>();
		
		assertEquals(unaLista.size(), 0);
	}
	
}
