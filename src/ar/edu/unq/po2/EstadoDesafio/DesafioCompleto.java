package ar.edu.unq.po2.EstadoDesafio;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.DesafioUsuario;
import ar.edu.unq.po2.Usuario;

public class DesafioCompleto implements EstadoDesafioUsuario {

	@Override
	public Boolean esDesafioCompleto(Desafio desafio, Usuario usuario) {
		return true;
	}

	@Override
	public Integer porcentajeDeCompletitud(Desafio desafio, Usuario usuario) {
		return (usuario.getMuestrasRecolectadas().size() * 100) / desafio.getMuestrasRecolectadas();
	}

	@Override
	public void actualizarDesafio(DesafioUsuario desafio, Usuario usuario) throws Exception {
		throw new Exception("El desafio esta completo");
	}

}
