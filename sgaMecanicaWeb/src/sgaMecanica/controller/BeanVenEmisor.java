package sgaMecanica.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import sgaMecanica.model.entities.VenEmisor;
import sgaMecanica.model.manager.ManagerVenEmisor;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanVenEmisor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerVenEmisor managerVenEmisor;
	private List<VenEmisor> listaVenEmisor;
	private boolean panelColpsada;
	private VenEmisor nuevoVenEmisor;
	private VenEmisor venEmisorSeleccionado;

	@PostConstruct
	public void inicializar() {
		listaVenEmisor = managerVenEmisor.findAllVenEmisor();
		nuevoVenEmisor = new VenEmisor();
		panelColpsada = true; // para el panel que maximize y minimize
	}

//insertar
	public void actionInsertarVenEmisor() {
		try {
			managerVenEmisor.insertarVenEmisor(nuevoVenEmisor);
			listaVenEmisor = managerVenEmisor.findAllVenEmisor();
			nuevoVenEmisor = new VenEmisor();
			JSFUtil.crearMensajeInfo("Datos Emisor Insertados.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		}

	}

	// eliminar
	public void actionListenerEliminarVenEmisor(Integer id_em) {
		managerVenEmisor.eliminarVenEmisor(id_em);
		listaVenEmisor = managerVenEmisor.findAllVenEmisor();
		JSFUtil.crearMensajeInfo("Emisor Eliminado");
	}

	
	// actualizar
	public void actionListenerSelccionarVenEmisor(VenEmisor venEmisor) {
		venEmisorSeleccionado = venEmisor;
	}

	public void actionListenerActualizarVenEmisor() {
		try {
			managerVenEmisor.actualizarVenEmisor(venEmisorSeleccionado);
			listaVenEmisor = managerVenEmisor.findAllVenEmisor();
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

	/* GETTER AND SETTER */

	public List<VenEmisor> getListaVenEmisor() {
		return listaVenEmisor;
	}

	public void setListaVenEmisor(List<VenEmisor> listaVenEmisor) {
		this.listaVenEmisor = listaVenEmisor;
	}

	public boolean isPanelColpsada() {
		return panelColpsada;
	}

	public void setPanelColpsada(boolean panelColpsada) {
		this.panelColpsada = panelColpsada;
	}

	public VenEmisor getNuevoVenEmisor() {
		return nuevoVenEmisor;
	}

	public void setNuevoVenEmisor(VenEmisor nuevoVenEmisor) {
		this.nuevoVenEmisor = nuevoVenEmisor;
	}

	public VenEmisor getVenEmisorSeleccionado() {
		return venEmisorSeleccionado;
	}

	public void setVenEmisorSeleccionado(VenEmisor venEmisorSeleccionado) {
		this.venEmisorSeleccionado = venEmisorSeleccionado;
	}
	

}
