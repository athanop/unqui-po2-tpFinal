package ar.edu.unq.po2;

import org.mockito.internal.stubbing.answers.ThrowsException;

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
	
	public Integer votoDelUsuario(Integer valoracion) throws Exception{
		Integer votoDelUsuario = 0;
		if(estado.esDesafioCompleto(desafio, usuario) && valoracion <= 5) {
			votoDelUsuario = valoracion;
		}
		else { 
			throw new Exception("la valoracion debe ser de 0 a 5");
			}
		return votoDelUsuario;
	}
}
