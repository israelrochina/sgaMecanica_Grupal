package sgaMecanica.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import sgaMecanica.model.entities.SegPersona;
import sgaMecanica.model.manager.ManagerSegPersona;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanSegPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerSegPersona managerSegPersona;
	private List<SegPersona> listaSegPersona;
	private SegPersona nuevoSegPersona;
	private boolean panelColpsada;
	private SegPersona segPersonaSeleccionada;

	@PostConstruct
	private void inicializar() {
		listaSegPersona = managerSegPersona.findAllSegPersona();
		nuevoSegPersona = new SegPersona();
		panelColpsada = true; // para el panel que maximize y minimize
	}

//insertar
	public void actionInsertarSegPersona() {
		try {
			managerSegPersona.insertarSegPersona(nuevoSegPersona);

			listaSegPersona = managerSegPersona.findAllSegPersona();
			nuevoSegPersona = new SegPersona();
			JSFUtil.crearMensajeInfo("Datos Persona Insertados.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		}
		;

	}

//eliminar
	public void actionListenerEliminarSegPersona(Integer id_segPersona) {
		managerSegPersona.eliminarSegPersona(id_segPersona);

		listaSegPersona = managerSegPersona.findAllSegPersona();
		JSFUtil.crearMensajeInfo("Persona Eliminado");
	}
//actualizar
	public void actionListenerSelccionarSegPersona(SegPersona segPerosna) {
		
		segPersonaSeleccionada= segPerosna;
	}
	public void actionListenerActualizarSegPersona(){
		try {
			managerSegPersona.actualizarSegPersona(segPersonaSeleccionada);
			listaSegPersona = managerSegPersona.findAllSegPersona();
			
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

	public boolean isPanelColpsada() {
		return panelColpsada;
	}

	public void setPanelColpsada(boolean panelColpsada) {
		this.panelColpsada = panelColpsada;
	}

	/* GETtER ADN SETTER */
	public List<SegPersona> getListaSegPersona() {
		return listaSegPersona;
	}

	public void setListaSegPersona(List<SegPersona> listaSegPersona) {
		this.listaSegPersona = listaSegPersona;
	}

	public SegPersona getNuevoSegPersona() {
		return nuevoSegPersona;
	}

	public void setNuevoSegPersona(SegPersona nuevoSegPersona) {
		this.nuevoSegPersona = nuevoSegPersona;
	}

	public SegPersona getSegPersonaSeleccionada() {
		return segPersonaSeleccionada;
	}

	public void setSegPersonaSeleccionada(SegPersona segPersonaSeleccionada) {
		this.segPersonaSeleccionada = segPersonaSeleccionada;
	}

}
