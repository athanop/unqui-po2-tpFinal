package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.DesafioUsuario;
import ar.edu.unq.po2.Usuario;

public class DesafioIncompleto implements EstadoDesafioUsuario {

	@Override
	public Boolean esDesafioCompleto(Desafio desafio, Usuario usuario) {
		return porcentajeDeCompletitud(desafio, usuario) >= 100;
	}

	@Override
	public Integer porcentajeDeCompletitud(Desafio desafio, Usuario usuario) {
		return (usuario.getMuestrasRecolectadas().size() * 100) / desafio.getMuestrasRecolectadas();
	}

	@Override
	public void actualizarDesafio(DesafioUsuario desafio) throws Exception {
		if (esDesafioCompleto(desafio.getDesafio(), desafio.getUsuario())) {
			desafio.setEstado(new DesafioCompleto());
			desafio.setFechaCompletitud(LocalDate.now());
		}
	}

}
