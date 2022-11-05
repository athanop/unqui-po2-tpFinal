package ar.edu.unq.po2.EstadoDesafio;

import ar.edu.unq.po2.DesafioUsuario;
import ar.edu.unq.po2.Usuario;

public class DesafioCompleto implements EstadoDesafioUsuario {

	@Override
	public Boolean esDesafioCompleto(DesafioUsuario desafio, Usuario usuario) {
		return true;
	}

	@Override
	public Integer porcentajeDeCompletitud(DesafioUsuario desafioUsuario, Usuario usuario) {
		return (desafioUsuario.muestrasValidas(usuario) * 100) / desafioUsuario.getDesafio().getMuestrasRecolectadas();
	}

	@Override
	public void actualizarDesafio(DesafioUsuario desafio, Usuario usuario) throws Exception {
		throw new Exception("El desafio esta completo");
	}

}
