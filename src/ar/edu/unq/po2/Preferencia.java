package ar.edu.unq.po2;

public class Preferencia {

	private Integer dificultad;
	private Integer recompensa;
	private Integer cantidadDeMuestras;
	
	public Integer getDificultad() {
		return dificultad;
	}

	public Integer getRecompensa() {
		return recompensa;
	}

	public Integer getCantidadDeMuestras() {
		return cantidadDeMuestras;
	}
	
	public Preferencia(Integer dificultad, Integer recompensa, Integer cantidadDeMuestras) {
		super();
		this.dificultad = dificultad;
		this.recompensa = recompensa;
		this.cantidadDeMuestras = cantidadDeMuestras;
	}

}
