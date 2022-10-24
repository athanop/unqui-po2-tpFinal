package ar.edu.unq.po2;

public class Area {

	private Double radio;
	private Coordenada epicentro;

	public Coordenada getEpicentro() {
		return epicentro;
	}

	public Double getRadio() {
		return radio;
	}

	public Area(Coordenada coordenada, Double radio) {
		this.epicentro = coordenada;
		this.radio = radio;
	}

	public Double calcularArea() {
		return 3.1416 * Math.pow(radio,2); //pi x radio al cuadrado
	}
	
}
