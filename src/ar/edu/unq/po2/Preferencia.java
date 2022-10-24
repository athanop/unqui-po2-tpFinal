package ar.edu.unq.po2;

public class Preferencia {

	private Integer dificultad;
	private Double recompensa;
	private Integer cantidadDeMuestras;
	
	public Integer getDificultad() {
		return dificultad;
	}

	public Double getRecompensa() {
		return recompensa;
	}

	public Integer getCantidadDeMuestras() {
		return cantidadDeMuestras;
	}
	
	public Preferencia(Integer dificultad, Double recompensa, Integer cantidadDeMuestras) {
		super();
		this.dificultad = dificultad;
		this.recompensa = recompensa;
		this.cantidadDeMuestras = cantidadDeMuestras;
	}

}
