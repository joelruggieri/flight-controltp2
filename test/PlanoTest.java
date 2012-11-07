import junit.framework.TestCase;


public class PlanoTest extends TestCase {
	
	public void testConstructorDelPlanoConUnaDimensionEstablecidaDeberiaCrearUnPlanoDeDichaDimension(){
		
		int dimension = 768;
		Plano pantalla = new Plano(dimension);
		
		assertTrue(pantalla.getDimension() == dimension);
	}
	
	
	public void testConstructorDelPlanoDeberiaCrearUnPlanoConPosicionesVacias() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension= 5;
		
		Plano pantalla = new Plano(dimension);
		
		int x = 0;
		int y = 0;
		Posicion posicion1 = new Posicion (x,y);
		String valor1 = pantalla.getPosicion(posicion1);

		
		 x = 1;
		 y = 0;
		Posicion posicion2 = new Posicion (x,y);
		String valor2 = pantalla.getPosicion(posicion2);
		
		x = 0;
		y = 1;
		Posicion posicion3 = new Posicion (x,y);
		String valor3 = pantalla.getPosicion(posicion3);
		
		x = 1;
		y = 1;
		Posicion posicion4 = new Posicion (x,y);
		String valor4 = pantalla.getPosicion(posicion4);
		
		
		assertEquals(valor1 , "vacio");
		assertEquals(valor2 , "vacio");
		assertEquals(valor3 , "vacio");
		assertEquals(valor4 , "vacio");
		
	
	}
	
	
	
	public void testDevolverUnaPosicionFueraDelRangoDelPlanoDeberiaLanzarUnaExcepcion(){
		
		int dimension = 25;
		
		Plano pantalla = new Plano(dimension);
		
		int x = 30;
		int y = 4;
		Posicion unaPosicion = new Posicion(x,y);
		
		try{
			pantalla.getPosicion(unaPosicion);
		
		}catch(PosicionFueraDeLasDimensionesEstablecidasException excepcion){
			
		}
		
	}
	
	public void testPosicionQuedaOcupadaPorAvionDichaPosicionDeberiaQuedarActualzadaConAvion() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Plano plano = new Plano(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Posicion unaPosicion = new Posicion(coordenadaX, coordenadaY);
		
		String avion = "avion";
		plano.posicionOcupadaPor(unaPosicion, avion);
		
		assertEquals(plano.getPosicion(unaPosicion),avion);
	}
		
	}
		
		

