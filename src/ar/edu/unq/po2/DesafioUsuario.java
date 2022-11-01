package ar.edu.unq.po2;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafioUsuario;

public class DesafioUsuario {

	private Desafio desafio;
	private Usuario usuario;
	private EstadoDesafioUsuario estado;
	private Integer valoracion;

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

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public void votoDelUsuario(Integer valoracion) throws Exception {
		if (estado.esDesafioCompleto(desafio, usuario) && valoracion <= 5) {
			this.setValoracion(valoracion);
		} else {
			throw new Exception("la valoracion debe ser de 0 a 5");
		}
	}

}
