package ar.edu.unq.po2.EstadoDesafio;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.DesafioUsuario;
import ar.edu.unq.po2.Usuario;

public interface EstadoDesafioUsuario {

	public Boolean esDesafioCompleto(Desafio desafio, Usuario usuario);

	public Integer porcentajeDeCompletitud(Desafio desafio, Usuario usuario);

	public void actualizarDesafio(DesafioUsuario desafio, Usuario usuario) throws Exception;
}
