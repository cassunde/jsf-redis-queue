package br.com.cassunde.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.NodeExpandEvent;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import br.com.cassunde.services.Redis;
import br.com.cassunde.services.SalesServices;;

@Named
@ViewScoped
public class TreeBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private TreeNode tree;
	
	@Inject
	private UsuarioLogado usuarioLogado;
	
	@Inject
	private SalesServices salesServices;
	
	@Inject
	private Redis redis;

	@PostConstruct
	public void init() throws InterruptedException {
		tree = new DefaultTreeNode();
		montaTree();
		usuarioLogado.setName("jurema "+ UUID.randomUUID().toString());
	}
	
	public void montaTree() {
		
		for(int i = 0; i <= 10; i++ ) {
	
			Sector sectorActual = new Sector("Sector "+i,"LocalExample");			
			new DefaultTreeNode(sectorActual, tree)
				.setChildren( Arrays.asList( new DefaultTreeNode() ) );
		}
	}

	public void expand(NodeExpandEvent expand) {

		expand.getTreeNode().getChildren().clear();
		
		for(int i = 0; i <= 10; i++ ) {
			
			Sector sectorActual = new Sector("Sector "+i + " - Child of "+expand.getTreeNode().getData(),"LocalExample");			
			new DefaultTreeNode(sectorActual, expand.getTreeNode())
				.setChildren( Arrays.asList( new CheckboxTreeNode() ) );
		}
	}
	
	public TreeNode getTree() {
		return tree;
	}

	public void setTree(TreeNode tree) {
		this.tree = tree;
	}
	
	public String button() {
		System.out.println("clincando no btoao");
		return "/page?faces-redirect=true";
	}
	
	public String criacaoDeDados() {
		salesServices.createData();
		return "";
	}
	
	public String getDados() {
		salesServices.getAllData("05/2022");
		return "";
	}
	
	public UsuarioLogado getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public String bntPublish() throws InterruptedException {
		redis.pushStream(UUID.randomUUID().toString(), usuarioLogado.getName().substring((usuarioLogado.getName().length() - 4),usuarioLogado.getName().length()));
		return "";
	}
	
	
}
