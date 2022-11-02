package ar.edu.unq.po2.Area;

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
		return 3.1416 * Math.pow(radio, 2); // pi x radio al cuadrado
	}
	
	// Se calcula que una coordenada esta dentro del Area utilizando el calculo de esta documentacion: https://techlandia.com/utilizar-java-determinar-punto-contenido-circulo-como_236727/
	public boolean coordenadaEstaDentroDelArea(Coordenada coordenada) {
		 return Math.sqrt(Math.pow(Math.abs(this.getEpicentro().getLatitud() - coordenada.getLatitud()), 2)
				 + Math.pow(Math.abs(this.getEpicentro().getLongitud() - coordenada.getLongitud()), 2))
				  <= this.getRadio();
	}

}
