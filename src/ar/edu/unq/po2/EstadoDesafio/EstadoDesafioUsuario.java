package ar.edu.unq.po2.EstadoDesafio;

import ar.edu.unq.po2.Desafio;

public interface EstadoDesafioUsuario {
	
	public Boolean esDesafioCompleto();
	
	public Double porcentajeDeCompletitud();
	
	public void actualizarDesafio(Desafio desafio) throws Exception;
}
