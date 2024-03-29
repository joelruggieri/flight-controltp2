package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.flightcontrol.modelo.AvionPesado;
import fiuba.algo3.flightcontrol.modelo.AvionSimple;
import fiuba.algo3.flightcontrol.modelo.Helicoptero;
import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.PistaDobleEntrada;
import fiuba.algo3.flightcontrol.modelo.PosicionFueraDeLasDimensionesEstablecidasException;
import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;

public class PistaDobleEntradaTest extends TestCase {
	
	private Vector posicion0,posicion1,posicion2,posicion3,posicion4,posicion5;
	int velocidad,dimension;
	private Nivel unNivel;
	private List<Vector> listaDePosiciones;
	private Trayectoria unaTrayectoria;
	private AvionSimple avion;
	private Helicoptero helicoptero;
	private AvionPesado avionPesado;
	
	protected void setUp () throws Exception {
		
		super.setUp();
		
		posicion0 = new Vector (0,0);
		posicion1 = new Vector(1,1);
		posicion2 = new Vector(2,2);
		posicion3 = new Vector(1,2);
		posicion4 = new Vector (5,5);
		posicion5 = new Vector (6,6);
		velocidad = 1;
		dimension = 768;
		unNivel = new Nivel(velocidad, dimension);
		
		listaDePosiciones = new ArrayList<Vector>();

		avion = new AvionSimple(velocidad,unNivel);
		helicoptero = new Helicoptero(velocidad,unNivel);
		avionPesado = new AvionPesado(velocidad,unNivel);
	}
	
	private void moverAvion (ObjetoVolador unAvion, Vector destino){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una Vector */
		/* post: El avion se movio */
		
		listaDePosiciones.add(destino);
		unaTrayectoria = new Trayectoria (listaDePosiciones);
		unAvion.setTrayectoria(unaTrayectoria);
		
		while (!unAvion.getPosicion().equals(destino)){
			unAvion.vivir();
		}
		
	}
	
	private void removerLasPistasDelNivel(){
		
		Iterator iterador = this.unNivel.getPistas();
		
		while(iterador.hasNext()){
			iterador.next();
			iterador.remove();
		}
	}
		
	
	

	public void testConstructorDeUnaPistaDobleEntradaDeberianQuedarDefinidasLasDosdireccionesDeEntrada() 
		throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
		
		// creo las Vectores de la pista
		Vector VectorDeEntrada = new Vector(4,1);
		Vector otraVectorDeLaPista = new Vector(3,2);
			
		//act
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
	
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
	
		Vector direccionDePrimeraEntrada = new Vector(-1,1);
		Vector direccionDeSegundaEntrada = new Vector(1,-1);
			
		//assert
		assertTrue(pista.getDireccionesDeIngreso().get(0).equals(direccionDePrimeraEntrada));
		assertTrue(pista.getDireccionesDeIngreso().get(1).equals(direccionDeSegundaEntrada));
	}
	
	public void testValidarEntradaYDireccionDeUnAvionQueSeEncuentreEnAlgunaDeLasVectoresDeEntradaYConLaDireccionAdecuadaDeberiaDarVerdadero(){
		
		//arrange
	
		this.moverAvion(avion,posicion0);
		this.moverAvion(avion, posicion1);
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,3);
		Vector otraVectorDeLaPista2 = new Vector(4,4);
		Vector ultimaVectorDeLaPista = new Vector(5,5);
	
		//act
			
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
	
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
		
		//assert
		assertTrue(pista.validarEntradaYDireccion(avion));
		
	}
	
	public void testValidarEntradaYDireccionDeUnAvionQueSeEncuentreEnAlgunaDeLasVectoresDeEntradaPeroConUnaDireccionIndaecuadaDeberiaDarFalso(){
		
		//arrange
	
		this.moverAvion (avion,posicion3);
		this.moverAvion(avion,posicion1);
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,3);
		Vector otraVectorDeLaPista2 = new Vector(4,4);
		Vector ultimaVectorDeLaPista = new Vector(5,5);
	
		//act	
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
	
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
	
		//assert
		assertTrue(!pista.validarEntradaYDireccion(avion));
	
	}

	public void testLlegadaDeUnAvionSimpleALaPistaDobleEntradaEnUnaVectorQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
		
		//arrange
		this.moverAvion(avion,posicion5);
		this.moverAvion(avion,posicion4);
		
		//act
		
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,3);
		Vector otraVectorDeLaPista2 = new Vector(4,4);
		Vector ultimaVectorDeLaPista = new Vector(5,5);
		
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
		
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
		
		//assert
		assertTrue(avion.aterrizo());
	}

	public void testLlegadaDeUnAvionSimpleALaPistaDobleEntradaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		//borramos las pistas del nivel para evitar que el avion aterrice antes en una de ellas antes de llegar a la pista creada en el
		//test
		this.removerLasPistasDelNivel();
		this.moverAvion(avion,posicion2);
		this.moverAvion(avion,posicion1);
		
		//act
				
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(1,2);
		Vector otraVectorDeLaPista1 = new Vector(1,3);
		Vector otraVectorDeLaPista2 = new Vector(1,4);
		Vector ultimaVectorDeLaPista = new Vector(1,5);
		
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
		
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionSimpleALaPistaDobleEntradaEnUnaVectorQueNoEsLaDeEntradaPeroEstaEnELRangoNoDeberiaAterrizar(){
		
		//arrange
		this.removerLasPistasDelNivel();
		this.moverAvion(avion, posicion4);
		this.moverAvion(avion, posicion2);
			
		//act	
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,2);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,2);
		Vector otraVectorDeLaPista2 = new Vector(4,2);
		Vector ultimaVectorDeLaPista = new Vector(5,2);
		
		
		
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
	
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
	
		pista.recibirAterrizajeDeObjetoVolador(avion);	
		
		assertTrue(!avion.aterrizo());
	}


	public void testLlegadaDeUnHelicopteroALaPistaDobleEntradaEnUnaVectorQueEsLaDeEntradaYConDireccionApropiadaNoDeberiaAterrizar(){
		
		//arrange
		Iterator iterador = this.unNivel.getPistas();
		// borramos el helipuerto para evitar que aterrice antes de llegar a la pista que queremos
		iterador.next();
		iterador.remove();
		//act
		
		/*creo las Vectores de la pista*/
		
		this.moverAvion(helicoptero,posicion0);
		this.moverAvion(helicoptero,posicion1);
					
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,3);
		Vector otraVectorDeLaPista2 = new Vector(4,4);
		Vector ultimaVectorDeLaPista = new Vector(5,5);
	
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
		
		//act
	
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
		
		//assert
		assertTrue(!helicoptero.aterrizo());
		
	}

	public void testLlegadaDeUnAvionHelicopteroALaPistaDobleEntradaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		Iterator iterador = this.unNivel.getPistas();
		// borramos el helipuerto para evitar que aterrice antes de llegar a la pista que queremos
		iterador.next();
		iterador.remove();
		//act
		
		/*creo las Vectores de la pista*/
		
		this.moverAvion(helicoptero,posicion2);
		this.moverAvion(helicoptero,posicion1);
		//act
		helicoptero.vivir();
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(1,2);
		Vector otraVectorDeLaPista1 = new Vector(1,3);
		Vector otraVectorDeLaPista2 = new Vector(1,4);
		Vector ultimaVectorDeLaPista = new Vector(1,5);
		
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
		
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
		
		//assert
		assertTrue(!helicoptero.aterrizo());
	}

	public void testLlegadaDeUnAvionHelicopteroALaPistaDobleEntradaEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		Iterator iterador = this.unNivel.getPistas();
		// borramos el helipuerto para evitar que aterrice antes de llegar a la pista que queremos
		iterador.next();
		iterador.remove();
		//act
		
		/*creo las Vectores de la pista*/
		
		//arrange
		this.moverAvion(helicoptero,posicion2);
		
		//act
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,2);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,2);
		Vector otraVectorDeLaPista2 = new Vector(4,2);
		Vector ultimaVectorDeLaPista = new Vector(5,2);
		
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
		
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
		
		//assert
		assertTrue(!helicoptero.aterrizo());
	}


	public void testLlegadaDeUnAvionPesadoALaPistaDobleEntradaEnUnaVectorQueEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		this.removerLasPistasDelNivel();
		this.moverAvion(avionPesado,posicion0);
		this.moverAvion(avionPesado,posicion1);
		
		//act

		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,3);
		Vector otraVectorDeLaPista2 = new Vector(4,4);
		Vector ultimaVectorDeLaPista = new Vector(5,5);
	
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
	
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
	
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}


	public void testLlegadaDeUnAvionPesadoALaPistaDobleEntradaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		this.removerLasPistasDelNivel();
		this.moverAvion(avionPesado,posicion2);
		this.moverAvion(avionPesado,posicion4);	
	
		//act
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(1,2);
		Vector otraVectorDeLaPista1 = new Vector(1,3);
		Vector otraVectorDeLaPista2 = new Vector(1,4);
		Vector ultimaVectorDeLaPista = new Vector(1,5);
		
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
		
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
		
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaDobleEntradaeEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		this.removerLasPistasDelNivel();
		this.moverAvion(avionPesado,posicion2);
	
		//act
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,2);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,2);
		Vector otraVectorDeLaPista2 = new Vector(4,2);
		Vector ultimaVectorDeLaPista = new Vector(5,2);
		
		listaDePosiciones.add(VectorDeEntrada);
		listaDePosiciones.add(otraVectorDeLaPista);
		listaDePosiciones.add(otraVectorDeLaPista1);
		listaDePosiciones.add(otraVectorDeLaPista2);
		listaDePosiciones.add(ultimaVectorDeLaPista);
		
		PistaDobleEntrada pista = new PistaDobleEntrada(listaDePosiciones);
		
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
		
		//assert
		assertTrue(!avionPesado.aterrizo());
	}
	
}
