package br.com.fiap.client.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cadastroes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cadastros {
	
	@XmlElement(name="cadastro")
	private List<Cadastro> cadastro;

	public List<Cadastro> getCadastro() {
		return cadastro;
	}

	public void setCadastro(List<Cadastro> cadastro) {
		this.cadastro = cadastro;
	}
}
