package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.DesafioUsuario;
import ar.edu.unq.po2.Usuario;

public class DesafioIncompleto implements EstadoDesafioUsuario {

	@Override
	public Boolean esDesafioCompleto(DesafioUsuario desafio, Usuario usuario) {
		return porcentajeDeCompletitud(desafio, usuario) >= 100;
	}

	@Override
	public Integer porcentajeDeCompletitud(DesafioUsuario desafioUsuario, Usuario usuario) {
		//arreglar que rompemos encapsulamiento
		return (usuario.getMuestrasRecolectadas().size() * 100) / desafioUsuario.getDesafio().getMuestrasRecolectadas();
	}

	@Override
	public void actualizarDesafio(DesafioUsuario desafio, Usuario usuario) throws Exception {
		if (esDesafioCompleto(desafio, usuario)) {
			desafio.setEstado(new DesafioCompleto());
			desafio.setFechaCompletitud(LocalDate.now());
		}
	}

	@Override
	public void setearValoracion(DesafioUsuario desafioUsuario, Integer valoracion) throws Exception {
		throw new Exception("No podes valorar un desafio incompleto");
	}

}
