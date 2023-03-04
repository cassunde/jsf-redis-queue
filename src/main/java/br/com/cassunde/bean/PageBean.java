package br.com.cassunde.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;;

@Named
@ViewScoped
public class PageBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioLogado usuarioLogado;
	
	@PostConstruct
	public void init() throws InterruptedException {
		System.out.println(usuarioLogado.getName());
	}

	public UsuarioLogado getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	

}
