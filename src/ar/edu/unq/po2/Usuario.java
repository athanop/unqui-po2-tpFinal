package ar.edu.unq.po2;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Recomendacion.Recomendacion;

/**
 * Clase encargada de representar un usuario del sistema.
 */
public class Usuario {

	private List<Muestra> muestrasRecolectadas;
	private List<Proyecto> proyectosActivos;
	private Preferencia preferencia;
	private List<DesafioUsuario> desafiosUsuario;

	/**
	 * Getter proyectos activos.
	 * 
	 * @return Devuelve los proyectos en los que esta participando el Usuario.
	 */
	public List<Proyecto> getProyectosActivos() {
		return proyectosActivos;
	}

	/**
	 * Getter muestras recolectadas
	 * 
	 * @return Devuelve las muestras que fueron enviadas por el Usuario.
	 */
	public List<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}

	/**
	 * Getter desafios usuario
	 * 
	 * @return Devuelve los desafios en los que esta participando el Usuario.
	 */
	public List<DesafioUsuario> getDesafiosUsuario() {
		return desafiosUsuario;
	}

	/**
	 * Getter preferencia
	 * 
	 * @return Devuelve la preferencia que tiene el Usuario sobre los desafios.
	 */
	public Preferencia getPreferencia() {
		return preferencia;
	}

	/**
	 * Constructor de usuario.
	 * 
	 * @param preferencia    es la preferencia que tiene el usuario sobre los desafios.
	 */
	public Usuario(Preferencia preferencia) {
		this.preferencia = preferencia;
		this.muestrasRecolectadas = new ArrayList<Muestra>();
		this.proyectosActivos = new ArrayList<Proyecto>();
		this.desafiosUsuario = new ArrayList<DesafioUsuario>();
	}

	/**
	 * Realiza la busqueda de desafios que puede aceptar el usuario.
	 * @param recomendacion, es la estrategia de busqueda que se utiliza para encontrar los desafios que puede aceptar el usuario.
	 * @return desafiosFiltrados, una lista de desafios que cumplen la recomendacion dada.
	 */
	public List<Desafio> buscarDesafios(Recomendacion recomendacion) {
		return recomendacion.seleccionDeDesafios(this);
	}

	/**
	 * El usuario acepta realizar un desafio.
	 * @param desafioUsuario, el desafio que esta aceptando el usuario.
	 */
	public void aceptarDesafio(DesafioUsuario desafioUsuario) throws Exception {
			getDesafiosUsuario().add(desafioUsuario);
	}

	/**
	 * Realiza la votacion del usuario hacia el desafio que acepto.
	 * @param desafioUsuario, el desafio que esta realizando el usuario.
	 * @param valoracion, el usuario puede votar cuanto le gusto realizar este desafio indicando un valor entre 0 y 5, donde 0 significa que no le gusto nada y 5 que le gusto mucho
	 */
	public void votarDesafio(DesafioUsuario desafioUsuario, Integer valoracion) throws Exception {
		desafioUsuario.votoDelUsuario(valoracion);
	}

	/**
	 * Agrega una muestra y notifica a los desafios aceptados por el usuario que se agrego una muestra para actualizar su estado.
	 * @param muestra, es la muestra enviada por el usuario.
	 */
	public void agregarMuestra(Muestra muestra) throws Exception {
			this.muestrasRecolectadas.add(muestra);
			this.notificarADesafiosActualizacionDeMuestras();
	}

	private void notificarADesafiosActualizacionDeMuestras() {
		this.getDesafiosUsuario().stream().forEach(d -> {
			try {
				d.actualizarDesafio(this);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
	}

	/**
	 * Realiza el alta del usuario en un proyecto.
	 * @param proyecto, el proyecto en donde se esta registrando el usuario.
	 */
	public void registrarseEnProyecto(Proyecto proyecto) {
		if (!this.getProyectosActivos().contains(proyecto)) {
			proyecto.agregarUsuario(this);
			this.proyectosActivos.add(proyecto);
		}
	}

}
