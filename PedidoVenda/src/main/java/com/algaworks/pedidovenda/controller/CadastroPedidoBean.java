package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.pedidovenda.controller.validation.SKU;
import com.algaworks.pedidovenda.converter.PedidoEdicao;
import com.algaworks.pedidovenda.events.PedidoAlteradoEvent;
import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.EnderecoEntrega;
import com.algaworks.pedidovenda.model.FormaPagamento;
import com.algaworks.pedidovenda.model.ItemPedido;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.ClienteRepository;
import com.algaworks.pedidovenda.repository.ProdutosRepository;
import com.algaworks.pedidovenda.repository.UsuariosRepository;
import com.algaworks.pedidovenda.service.CadastroPedidoService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;


@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SKU
	private String sku;
	
	@Produces
	@PedidoEdicao
	private Pedido pedido;
	private Produto produtoLinhaEditavel;
	
	private List<Usuario> vendedores;
	
	@Inject
	private ClienteRepository clienteRepository;
	
	@Inject
	private UsuariosRepository usuariosRepository;
	
	@Inject
	private ProdutosRepository prosutosRepository;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	public List<Cliente> completarCliente(String nome) {
		return this.clienteRepository.porNome(nome);
	}
	
	public FormaPagamento[] getFormasPagamento(){
		return FormaPagamento.values();
	}
	
	public CadastroPedidoBean() {
		limpar();
	}
	
	public void inicializar() {
		if(FacesUtil.isNotPostBack()) {
			this.vendedores = usuariosRepository.vendedores();
			this.pedido.adicionarItemVazio();
		}
		
		this.calculaTotalPedido();
	}
	
	public void limpar() {
		pedido = new Pedido();
		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		pedido.setEnderecoEntrega(enderecoEntrega);
	}
	
	public void pedidoAlterado(@Observes PedidoAlteradoEvent event) {
		this.pedido = event.getPedido();
	}
	
	public boolean isEditando() {
		return pedido.getId() != null;
	}
	
	public void calculaTotalPedido() {
		
		if(this.pedido != null) {
			this.pedido.recalcularValorTotal();
		}
		
	}
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void salvar(){
		this.pedido.removerItemVazio();
		
		try {
			this.pedido = cadastroPedidoService.salvarPedido(pedido);
			FacesUtil.addInfoMessage("Pedido salvo com sucesso.");
		}finally {
			this.pedido.adicionarItemVazio();
		}
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}
	
	public List<Produto> completarProduto(String nome){
		return prosutosRepository.porNome(nome);
	}
	
	public void carregarProdutoLinhaEditavel() {
		ItemPedido item = this.pedido.getItensPedido().get(0);
		
		if(this.produtoLinhaEditavel != null) {
			if(this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil.addErrorMessage("Já existe um item no pedido cm  produto informado");
			}else {
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());
				
				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.sku = null;
				
				this.pedido.recalcularValorTotal();
			}
		}
	}
	
	private boolean existeItemComProduto(Produto produto) {
		boolean existeItem = false;
		
		for(ItemPedido item : this.getPedido().getItensPedido()) {
			if(produto.equals(item.getProduto())) {
				existeItem = true;
				break;
			}
		}
		
		
		return existeItem;
	}

	public void carregaProdutoPorSku() {
		if(StringUtils.isNotEmpty(this.sku)) {
			this.produtoLinhaEditavel = this.prosutosRepository.porSKU(this.sku);
			this.carregarProdutoLinhaEditavel();
		}
	}
	
	public void atualizarQuantidade(ItemPedido item, int linha){
		if(item.getQuantidade() < 1) {
			if(linha == 0) {
				item.setQuantidade(1);
			}else {
				this.getPedido().getItensPedido().remove(linha);
			}
		}
		
		this.pedido.recalcularValorTotal();
		
	}

}
