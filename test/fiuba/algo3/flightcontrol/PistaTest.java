package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;

public class PistaTest extends TestCase {

	
	public void testPistaColocadaDentroDeLasDimensionesDeberiaCrearseCorrectamente() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
			int unLimite = 10;
			String objetoVoladorQuePuedeRecibir = "avionSimple";
			
			Posicion unaEntrada = new Posicion(1,1);
			ArrayList<Posicion> posicionDeEntradaDeAviones = new ArrayList<Posicion>();
			posicionDeEntradaDeAviones.add(unaEntrada);
			
			Escenario unPlano = new Escenario(unLimite);
			
		//act
			Pista unaPista = new Pista(unPlano,objetoVoladorQuePuedeRecibir,posicionDeEntradaDeAviones);
			unaPista.noHacerNada();
		
		//assert
			assertTrue( unPlano.getPosicion(unaEntrada) == "pista" );
			
	}
}
