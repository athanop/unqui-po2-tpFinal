package ar.edu.unq.po2.Area;

public class Coordenada {

	private Double latitud;
	private Double longitud;
	
	public Double getLatitud() {
		return latitud;
	}

	public Double getLongitud() {
		return longitud;
	}
		
	public Coordenada(Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	
	public Double distanciaHasta(Coordenada coordenada) {
		return this.distanciaCoordenada(this.getLatitud(), this.getLongitud(), coordenada.getLatitud(),
				coordenada.getLongitud());
	}
	
	//calcula la distancia entre dos coordenadas
	private Double distanciaCoordenada(Double latitud1, Double longitud1, Double latitud2, Double longitud2) {
		Double radioTierra = 6371d;
		Double dLat = Math.toRadians(latitud2 - latitud1);
		Double dLng = Math.toRadians(longitud2 - longitud1);
		Double sindLat = Math.sin(dLat / 2);
		Double sindLng = Math.sin(dLng / 2);
		Double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(latitud1)) * Math.cos(Math.toRadians(latitud2));
		Double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		Double distancia = radioTierra * va2;
		return distancia;
	}
	
}
