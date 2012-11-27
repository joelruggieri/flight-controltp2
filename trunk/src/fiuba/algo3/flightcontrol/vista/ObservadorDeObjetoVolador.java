package fiuba.algo3.flightcontrol.vista;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class ObservadorDeObjetoVolador implements Observer {

	private Circulo unaVista;
	private SuperficieDeDibujo unaSuperficie;
	private ObjetoVolador unObjetoVolador;
	
	public ObservadorDeObjetoVolador(Circulo unaVista, SuperficieDeDibujo unPanel, ObjetoVolador unObjetoVolador) {
		
		this.unaVista = unaVista;
		this.unaSuperficie = unPanel;
		this.unObjetoVolador = unObjetoVolador;
	}
	
	public void update(Observable arg0, Object aterrizo) {
		if (!this.unObjetoVolador.aterrizo()) {
			unaVista.dibujar(unaSuperficie);
		}

	}

}
