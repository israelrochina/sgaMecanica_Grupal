package sgaMecanica.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.InvProducto;
import sgaMecanica.model.manager.ManagerInvProducto;


@Named
@SessionScoped
public class BeanInvProducto implements Serializable {

	
	@EJB
	private ManagerInvProducto managerInvProduto;
	private List<InvProducto> listaInvProducto;
	private InvProducto nuevoInvProducto;
	private boolean panelColpsada;
	private Integer id_iva;
	private Integer id_marcaproducto;
	private Integer id_categoria;
	private Integer id_modelo;
	private Integer id_proveedor;	
	private InvProducto invProductoSelecionado;
	@PostConstruct
	public void inicializar() {
		
		listaInvProducto=managerInvProduto.findAllInvProducto();
		nuevoInvProducto= new InvProducto();
		panelColpsada = true; // para el panel que maximize y minimize
	}
	//insertar
	
	public void actionInsertarInvProducto() {
		try {
			managerInvProduto.insertarInvProducto(nuevoInvProducto, id_iva, id_marcaproducto, id_categoria, id_modelo, id_proveedor);
			
			listaInvProducto=managerInvProduto.findAllInvProducto();
			nuevoInvProducto= new InvProducto();
			
			JSFUtil.crearMensajeInfo("Datos Producto Insertados.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		};
		
	}
	//Eliminar
	public void actionListenerEliminarInvProducto(String id_producto) {
		managerInvProduto.eliminarInvProducto(id_producto);
		listaInvProducto=managerInvProduto.findAllInvProducto();
		JSFUtil.crearMensajeInfo("Producto Eliminado");
	}
	public void actionListenerSelccionarInvProducto(InvProducto invProducto) {
		invProductoSelecionado= invProducto;
	}
	public void actionListenerActualizarInvProducto(){
		try {
			managerInvProduto.actualizarInvProducto(invProductoSelecionado, id_iva, id_marcaproducto, id_categoria, id_modelo, id_proveedor);
			
			listaInvProducto=managerInvProduto.findAllInvProducto();
			JSFUtil.crearMensajeInfo("Datos actualizados correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	/* Panel */
	public void actionListenerColapsarPanel() {
		panelColpsada = !panelColpsada;

	}
	
	public List<InvProducto> getListaInvProducto() {
		return listaInvProducto;
	}

	public void setListaInvProducto(List<InvProducto> listaInvProducto) {
		this.listaInvProducto = listaInvProducto;
	}

	public InvProducto getNuevoInvProducto() {
		return nuevoInvProducto;
	}

	public void setNuevoInvProducto(InvProducto nuevoInvProducto) {
		this.nuevoInvProducto = nuevoInvProducto;
	}

	public boolean isPanelColpsada() {
		return panelColpsada;
	}

	public void setPanelColpsada(boolean panelColpsada) {
		this.panelColpsada = panelColpsada;
	}

	public Integer getId_iva() {
		return id_iva;
	}

	public void setId_iva(Integer id_iva) {
		this.id_iva = id_iva;
	}

	public Integer getId_marcaproducto() {
		return id_marcaproducto;
	}

	public void setId_marcaproducto(Integer id_marcaproducto) {
		this.id_marcaproducto = id_marcaproducto;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public Integer getId_modelo() {
		return id_modelo;
	}

	public void setId_modelo(Integer id_modelo) {
		this.id_modelo = id_modelo;
	}

	public Integer getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Integer id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public InvProducto getInvProductoSelecionado() {
		return invProductoSelecionado;
	}

	public void setInvProductoSelecionado(InvProducto invProductoSelecionado) {
		this.invProductoSelecionado = invProductoSelecionado;
	}
	
	
}
