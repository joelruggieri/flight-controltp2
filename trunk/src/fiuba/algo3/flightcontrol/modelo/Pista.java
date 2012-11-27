package fiuba.algo3.flightcontrol.modelo;
import java.util.ArrayList;
import java.util.Observable;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import java.util.List;

public abstract class Pista extends Observable implements ObjetoPosicionable{

	private List<Vector> posiciones;
	private List<Vector> direccionesDeIngreso;

	
	public Pista(List<Vector> unasEntradas) {
		/* Constructor de una pista */
		
		this.posiciones = unasEntradas;
		
		/* Se toman los dos extremos de la pista para conocer la 
		 * direccion en que deben entrar los
		 * objetos voladores por el extremo de entrada*/

		int limite = this.posiciones.size() - 1;
		
		Vector segundoExtremo = this.posiciones.get(limite);
		Vector extremoDeEntrada = this.posiciones.get(0);
		
		Vector direccionDeEntrada;
		
		direccionDeEntrada = segundoExtremo.restar(extremoDeEntrada);
		direccionDeEntrada.canonizarPosicion();
		
		this.direccionesDeIngreso = new ArrayList<Vector>();
		this.direccionesDeIngreso.add(direccionDeEntrada);
	}
	
	public int getX() {
		
		return this.getPosicionDeEntrada().getPosicionX();
	}
	
	public int getY() {
		
		return this.getPosicionDeEntrada().getPosicionY();
	}
	
	public List<Vector> getPosiciones() {
		
		return posiciones;
	}
	
	public List<Vector> getDireccionesDeIngreso() {
		
		return direccionesDeIngreso;
	}
	
	public void setDireccionesDeIngreso(List<Vector> direcciones) {
		
		direccionesDeIngreso = direcciones;
	}
		
	public Vector getPosicionDeEntrada() {
		
		return this.posiciones.get(0);
	}
	
	public Vector getDireccionDeEntrada() {
		
		return this.direccionesDeIngreso.get(0);
	}
	
	public void recibirAterrizajeDeObjetoVolador(AvionSimple simple) {
		
		boolean posicionesIguales, direccionesIguales;
		Vector miEntrada, miPosicion;
		
		miPosicion = this.getPosicionDeEntrada();
		miEntrada = this.getDireccionDeEntrada();
		
		posicionesIguales = simple.getPosicion().esIgual(miPosicion);
		direccionesIguales = simple.getDireccion().esIgual(miEntrada);
		
		if (posicionesIguales && direccionesIguales) {
			simple.aterrizar();
			this.setChanged();
			this.notifyObservers(simple);
		}
	}
	
	 public void recibirAterrizajeDeObjetoVolador(Helicoptero helicoptero) {
	 }
	
	 public void recibirAterrizajeDeObjetoVolador(AvionComputarizado avionComputarizado) {
		 
		boolean posicionesIguales, direccionesIguales;
		Vector miEntrada, miPosicion;
		
		miPosicion = this.getPosicionDeEntrada();
		miEntrada = this.getDireccionDeEntrada();
		
		posicionesIguales = avionComputarizado.getPosicion().esIgual(miPosicion);
		direccionesIguales = avionComputarizado.getDireccion().esIgual(miEntrada);
		
		if (posicionesIguales && direccionesIguales) {
			avionComputarizado.aterrizar();
			this.setChanged();
			this.notifyObservers(avionComputarizado);
		}
	 }
	
	 public void recibirAterrizajeDeObjetoVolador(AvionPesado pesado) {
	}
	 
	
}