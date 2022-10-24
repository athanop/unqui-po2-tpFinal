package ar.edu.unq.po2.EstadoDesafio;

import ar.edu.unq.po2.Desafio;

public class DesafioCompleto implements EstadoDesafioUsuario {

	@Override
	public Boolean esDesafioCompleto() {
		return null;
	}

	@Override
	public Double porcentajeDeCompletitud() {
		return null;
	}

	@Override
	public void actualizarDesafio(Desafio desafio) throws Exception {
		throw new Exception("El desafio esta completo");
	}
}
