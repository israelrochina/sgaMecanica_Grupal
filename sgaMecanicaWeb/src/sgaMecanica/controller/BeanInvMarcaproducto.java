package sgaMecanica.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.InvMarcaproducto;
import sgaMecanica.model.manager.ManagerInvMarcaproduto;

@Named
@SessionScoped
public class BeanInvMarcaproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerInvMarcaproduto managerInvMarcaproduto;
	private InvMarcaproducto invMarcaproducto;
	private List<InvMarcaproducto> listaInvMarcaproducto;
	private boolean panelColpsada;
	private InvMarcaproducto invMarcaproductoSelecionado;

	@PostConstruct
	private void inicializar() {
		listaInvMarcaproducto = managerInvMarcaproduto.findAllInvMarcaproucto();
		invMarcaproducto = new InvMarcaproducto();
		panelColpsada = true; // para el panel que maximize y minimize
	}

	// insertar
	public void actionInsertarInvMarcaproducto() {
		try {
			managerInvMarcaproduto.insertarinvMarcaproducto(invMarcaproducto);
			listaInvMarcaproducto = managerInvMarcaproduto.findAllInvMarcaproucto();
			invMarcaproducto = new InvMarcaproducto();
			JSFUtil.crearMensajeInfo("Datos Insertados.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		}

	}

	// Eliminar
	public void actionListenerEliminarInvMarcaproducto(Integer id) {
		managerInvMarcaproduto.eliminarInvMarcaproducto(id);
		
		listaInvMarcaproducto = managerInvMarcaproduto.findAllInvMarcaproucto();
		JSFUtil.crearMensajeInfo("Marca de producto Eliminada");
	}

	//actualizar
		public void actionListenerSelccionarInvMarcaproducto(InvMarcaproducto invMarcaproducto) {
			invMarcaproductoSelecionado = invMarcaproducto;
		}

		public void actionListenerActualizarInvMarcaproducto() {
			try {
				managerInvMarcaproduto.actualizarInvMarcaproducto(invMarcaproductoSelecionado);
				listaInvMarcaproducto = managerInvMarcaproduto.findAllInvMarcaproucto();
				JSFUtil.crearMensajeInfo("Datos actualizados correctamente");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.clearMensajeError(e.getMessage());
				e.printStackTrace();
			}
		}
	
	public List<InvMarcaproducto> getListaInvMarcaproducto() {
		return listaInvMarcaproducto;
	}

	public void setListaInvMarcaproducto(List<InvMarcaproducto> listaInvMarcaproducto) {
		this.listaInvMarcaproducto = listaInvMarcaproducto;
	}

	public InvMarcaproducto getInvMarcaproducto() {
		return invMarcaproducto;
	}

	public void setInvMarcaproducto(InvMarcaproducto invMarcaproducto) {
		this.invMarcaproducto = invMarcaproducto;
	}

	public boolean isPanelColpsada() {
		return panelColpsada;
	}

	public void setPanelColpsada(boolean panelColpsada) {
		this.panelColpsada = panelColpsada;
	}

	public InvMarcaproducto getInvMarcaproductoSelecionado() {
		return invMarcaproductoSelecionado;
	}

	public void setInvMarcaproductoSelecionado(InvMarcaproducto invMarcaproductoSelecionado) {
		this.invMarcaproductoSelecionado = invMarcaproductoSelecionado;
	}

	
	
	/* Panel */
	public void actionListenerColapsarPanel() {
		panelColpsada = !panelColpsada;
	}

}
