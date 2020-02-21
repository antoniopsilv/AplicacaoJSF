package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();
	private Integer autorId;

	
	public void carregarAutorPelaId() {
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
		System.out.println("\n\n\n *************************************");
		System.out.println("Autor que veio do banco: "+autor.getNome());
		}
	
	public void carregarAutor(Autor autor) {
		System.out.println("\n\n\n *************************************");
		System.out.println("Carregando Autor");
		this.autor = autor;
	}
	
	public void remove(Autor autor) {
		System.out.println("\n\n\n *************************************");
		System.out.println("Removendo Autor");
		new DAO<Autor>(Autor.class).remove(autor);
	}
	
	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (this.autor.getId() == null ) {
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		} else {
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}
		
		
		this.autor = new Autor();
		return "livro?faces-redirect=true";
	}
	
	// Getters and Setters
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
}
