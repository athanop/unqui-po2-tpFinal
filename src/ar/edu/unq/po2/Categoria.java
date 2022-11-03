package ar.edu.unq.po2;

/**
 * Clase que representa una categoria.
 */
public class Categoria {

	private String tipoCategoria;

	/**
	 * Describe la categoria.
	 * @return el nombre de la categoria.
	 */
	public String getTipoCategoria() {
		return tipoCategoria;
	}
	/**
	 * Constructor de una Categoria.
	 * @param tipo el tipo de Categoria.
	 */
	public Categoria(String tipo) {
		tipoCategoria = tipo;
	}

}
