package ar.edu.unq.po2;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.EstadoDesafio.DesafioIncompleto;
import ar.edu.unq.po2.Recomendacion.Recomendacion;

public class Usuario {

	private List<Muestra> muestrasRecolectadas;
	private List<Proyecto> proyectosActivos;
	private Preferencia preferencia;
	private List<DesafioUsuario> desafiosUsuario;

	public List<Proyecto> getProyectosActivos() {
		return proyectosActivos;
	}

	public List<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}

	public List<DesafioUsuario> getDesafiosUsuario() {
		return desafiosUsuario;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public Usuario(Preferencia preferencia) {
		this.preferencia = preferencia;
		this.muestrasRecolectadas = new ArrayList<Muestra>();
		this.proyectosActivos = new ArrayList<Proyecto>();
		this.desafiosUsuario = new ArrayList<DesafioUsuario>();
	}

	public List<Desafio> buscarDesafios(Recomendacion recomendacion) {
		List<Desafio> desafiosFiltrados = new ArrayList<Desafio>();
		desafiosFiltrados.addAll(recomendacion.seleccionDeDesafios(this));
		return desafiosFiltrados;
	}

	public void aceptarDesafio(DesafioUsuario desafioUsuario) throws Exception {
		if (!this.getDesafiosUsuario().contains(desafioUsuario)) {
			getDesafiosUsuario().add(desafioUsuario);
			desafioUsuario.setEstado(new DesafioIncompleto());
		}
	}

	public void votarDesafio(DesafioUsuario desafioUsuario, Integer valoracion) throws Exception {
		desafioUsuario.votoDelUsuario(valoracion);
	}

	public void agregarMuestra(Muestra muestra) {
		if (!this.muestrasRecolectadas.contains(muestra))
			this.muestrasRecolectadas.add(muestra);
	}

	public void registrarseEnProyecto(Proyecto proyecto) {
		if (!this.getProyectosActivos().contains(proyecto)) {
			proyecto.agregarUsuario(this);
			this.proyectosActivos.add(proyecto);
		}
	}
}
