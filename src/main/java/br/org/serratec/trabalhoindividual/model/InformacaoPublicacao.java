package br.org.serratec.trabalhoindividual.model;

import java.util.Date;

import jakarta.persistence.Embeddable;



@Embeddable
public class InformacaoPublicacao {
	
	private String autor;
	private Date dataPublicacao;
	private String editora;
		

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
}
