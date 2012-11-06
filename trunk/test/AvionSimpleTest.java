import junit.framework.TestCase;


public class AvionSimpleTest extends TestCase {
	
	private AvionSimple avion;
	private int velocidad;
	private int limite;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		velocidad = 2;
		limite = 768;
		avion = new AvionSimple(velocidad,limite);
	}
	
	public void testAvionVolarCuandoNoHayTrayectoriaMarcadaDeberiaActualizarSuPosicionDependiendoDeSuVelocidadYDeLaDireccionQueTraia(){
		
		//arrange
		
		Posicion direccion, posicionFinal;
		Posicion inicial = avion.getPosicion();
		
		//act
		avion.moverse();
		direccion = avion.getDireccion();
		
		Posicion posicionActualAvion = avion.getPosicion();
		posicionFinal = inicial.sumar(direccion.multiplicar(velocidad));
		
		//assert
		assertTrue (posicionActualAvion.equals(posicionFinal));		
	}
		
}