package sgaMecanica.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.manager.ManagerInvMarca;

@Named
@SessionScoped
public class BeanInvMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerInvMarca manageInvMarca;
	private InvMarca invMaca;
	private List<InvMarca> listaInvMarca;
	private boolean panelColpsada;
	private InvMarca invMarcaSelecionado;

	@PostConstruct
	private void inicializar() {
		
		listaInvMarca = manageInvMarca.findAllInvMarca();
		invMaca = new InvMarca();
		panelColpsada = true; // para el panel que maximize y minimize
	}

	/* InvMarca */
//insertar
	public void actionInsertarInvMarca() {
		try {
			manageInvMarca.insertarinvMarca(invMaca);
			listaInvMarca = manageInvMarca.findAllInvMarca();
			invMaca = new InvMarca();
			JSFUtil.crearMensajeInfo("Datos Estudiantes Insertados.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		}
		
	}

//Eliminar
	public void actionListenerEliminarINvMarca(Integer id) {
		manageInvMarca.eliminarInvMarca(id);

		listaInvMarca = manageInvMarca.findAllInvMarca();
		JSFUtil.crearMensajeInfo("Marca Eliminado");
	}

	
//actualizar
	public void actionListenerSelccionarInvMarca(InvMarca invMarca) {
		invMarcaSelecionado = invMarca;
	}

	public void actionListenerActualizarInvMarca() {
		try {
			manageInvMarca.actualizarInvMarca(invMarcaSelecionado);
			listaInvMarca = manageInvMarca.findAllInvMarca();
			JSFUtil.crearMensajeInfo("Datos actualizados correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	
//getter and setter //
	public List<InvMarca> getListaInvMarca() {
		return listaInvMarca;
	}

	public void setListaInvMarca(List<InvMarca> listaInvMarca) {
		this.listaInvMarca = listaInvMarca;
	}

	public InvMarca getInvMaca() {
		return invMaca;
	}

	public void setInvMaca(InvMarca invMaca) {
		this.invMaca = invMaca;
	}

	/* Panel */
	public void actionListenerColapsarPanel() {
		panelColpsada = !panelColpsada;
	}

	public boolean isPanelColpsada() {
		return panelColpsada;
	}

	public void setPanelColpsada(boolean panelColpsada) {
		this.panelColpsada = panelColpsada;
	}

	public InvMarca getInvMarcaSelecionado() {
		return invMarcaSelecionado;
	}

	public void setInvMarcaSelecionado(InvMarca invMarcaSelecionado) {
		this.invMarcaSelecionado = invMarcaSelecionado;
	}

}
