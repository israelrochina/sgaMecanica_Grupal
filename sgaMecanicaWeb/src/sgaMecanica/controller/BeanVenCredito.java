package sgaMecanica.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.entities.VenCredito;
import sgaMecanica.model.manager.ManagerVenCredito;

@Named
@SessionScoped
public class BeanVenCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerVenCredito managerVenCredito;
	private VenCredito venCredito;
	private boolean panelColpsada;
	private InvMarca venCreditoSelecionado;	
	private List<VenCredito> listaVenCredito;

	@PostConstruct
	private void Inicializar() {
		listaVenCredito = managerVenCredito.findAllVenCredito();
		venCredito = new VenCredito();
	}

	// insertar
	public void actionInsertarInvMarca() {
		try {
			managerVenCredito.insertarvenCredito(venCredito);
			listaVenCredito = managerVenCredito.findAllVenCredito();
			venCredito = new VenCredito();
			JSFUtil.crearMensajeInfo("Datos de credito Insertados.");
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

	public List<VenCredito> getListaVenCredito() {
		return listaVenCredito;
	}

	public void setListaVenCredito(List<VenCredito> listaVenCredito) {
		this.listaVenCredito = listaVenCredito;
	}
	
	

	public VenCredito getVenCredito() {
		return venCredito;
	}

	public void setVenCredito(VenCredito venCredito) {
		this.venCredito = venCredito;
	}

	public boolean isPanelColpsada() {
		return panelColpsada;
	}

	public void setPanelColpsada(boolean panelColpsada) {
		this.panelColpsada = panelColpsada;
	}
	
	

}
