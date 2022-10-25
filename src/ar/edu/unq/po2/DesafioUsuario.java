package ar.edu.unq.po2;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafioUsuario;

public class DesafioUsuario {

	private Desafio desafio;
	private Usuario usuario;
	private EstadoDesafioUsuario estado;

	public EstadoDesafioUsuario getEstado() {
		return estado;
	}

	public void setEstado(EstadoDesafioUsuario estado) {
		this.estado = estado;
	}

	public Desafio getDesafio() {
		return desafio;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
