package ar.edu.unq.po2.Area;

/**
 * Clase que representa un Area geografica.
 */
public class Area {

	private Double radio;
	private Coordenada epicentro;

	/**
	 * Describe el centro del Area.
	 * @return el epicentro como Coordenada.
	 */
	public Coordenada getEpicentro() {
		return epicentro;
	}

	/**
	 * Describe el radio del Area.
	 * @return el radio como double.
	 */
	public Double getRadio() {
		return radio;
	}

	/**
	 * Constructor de un Area geografica.
	 * @param coordenada, es una coordenada que representa el centro del Area.
	 * @param radio, es el radio del Area.
	 */
	public Area(Coordenada coordenada, Double radio) {
		this.epicentro = coordenada;
		this.radio = radio;
	}

	/**
	 * Calcula el Area 
	 * @return la medida del area.
	 */
	public Double calcularArea() {
		return 3.1416 * Math.pow(radio, 2); // pi x radio al cuadrado
	}
	/**
	 * Indica si una Coordenada dada se encuentra dentro del Area geografica.
	 * @param coordenada es una Coordenada.
	 * @return True si Coordenada es un punto que se encuentra dentro del Area geografica.
	 * Se calcula que una coordenada esta dentro del Area utilizando el calculo de esta documentacion: https://techlandia.com/utilizar-java-determinar-punto-contenido-circulo-como_236727/
	 */
	public boolean coordenadaEstaDentroDelArea(Coordenada coordenada) {
		 return Math.sqrt(Math.pow(Math.abs(this.getEpicentro().getLatitud() - coordenada.getLatitud()), 2)
				 + Math.pow(Math.abs(this.getEpicentro().getLongitud() - coordenada.getLongitud()), 2))
				  <= this.getRadio();
	}

}
