package fiuba.algo3.flightcontrol.vista;

import java.util.Observable;

import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;

public class ObservadorGameLoop implements ObservadorDeGameLoop{
	
	private SuperficieDeDibujo unaSuperficie;
	private ObservadorDeNivel observadorNivel;
	private GameLoop gameLoop;
	
	public ObservadorGameLoop(ObservadorDeNivel observadorNivel , GameLoop gameLoop, SuperficieDeDibujo unaSuperficie){
		
		this.gameLoop = gameLoop;
		this.observadorNivel = observadorNivel;
		this.unaSuperficie = unaSuperficie;
	}
		
	
	
	/*public void update(Observable arg0, Object aterrizo){
		
		ObjetoVolador avion = this.observadorNivel.getNave();
		this.gameLoop.agregar(avion);
		Circulo circulo = new VistaObjetoVolador((ObjetoVolador)avion);
		
		ObservadorDeObjetoVolador unObservador = new ObservadorDeObjetoVolador(gameLoop, circulo, unaSuperficie, avion);
	    avion.addObserver(unObservador);

	}*/
	
	public void notificarCicloFinalizado(){
		ObjetoVolador avion = this.observadorNivel.getNave();
		this.gameLoop.agregar(avion);
		Circulo circulo = new VistaObjetoVolador((ObjetoVolador)avion);
		
		ObservadorDeObjetoVolador unObservador = new ObservadorDeObjetoVolador(gameLoop, circulo, unaSuperficie, avion);
	    avion.addObserver(unObservador);
		
	}

}