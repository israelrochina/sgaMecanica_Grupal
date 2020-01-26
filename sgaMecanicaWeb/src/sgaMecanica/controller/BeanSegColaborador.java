package sgaMecanica.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import sgaMecanica.model.entities.SegColaborador;
import sgaMecanica.model.manager.ManagerSegColaborador;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanSegColaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerSegColaborador managerSegColaborador;
	private List<SegColaborador> listaSegColaborador;
	private SegColaborador nuevoSegColaborador;
	private Integer idRol;
	private Integer idPersona;
	private boolean panelColpsada;
	private SegColaborador segColaboradorSeleccionado;

	@PostConstruct
	private void inicializar() {

		listaSegColaborador = managerSegColaborador.findAllSegColaborador();
		nuevoSegColaborador = new SegColaborador();
		panelColpsada = true; // para el panel que maximize y minimize
		
	}
	
	//insertar
	public void actionInsertarSegColaborador() {
		try {
			managerSegColaborador.insertarSegColaborador(nuevoSegColaborador, idPersona, idRol);

			listaSegColaborador = managerSegColaborador.findAllSegColaborador();
			nuevoSegColaborador = new SegColaborador();
			idPersona=null;
			idRol=null;
			JSFUtil.crearMensajeInfo("Datos Modelos Insertados.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		};
		
	}
	//eliminar
	public void actionListenerEliminarSegColaborador(Integer id_colaborador) {
		managerSegColaborador.eliminarSegColaborador(id_colaborador);
		listaSegColaborador = managerSegColaborador.findAllSegColaborador();
		JSFUtil.crearMensajeInfo("Modelado Eliminado");
	}
	//actualizar
	public void actionListenerSelccionarSegColaborador(SegColaborador segColaborador) {
		segColaboradorSeleccionado=segColaborador;
	}
	public void actionListenerActualizarSegColaborador(){
		try {
			managerSegColaborador.actualizarSegColaborador(segColaboradorSeleccionado, idRol);
			listaSegColaborador = managerSegColaborador.findAllSegColaborador();
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
	
	
	/* SETTER AND SETTER */

	public boolean isPanelColpsada() {
		return panelColpsada;
	}

	public void setPanelColpsada(boolean panelColpsada) {
		this.panelColpsada = panelColpsada;
	}

	public List<SegColaborador> getListaSegColaborador() {
		return listaSegColaborador;
	}

	public void setListaSegColaborador(List<SegColaborador> listaSegColaborador) {
		this.listaSegColaborador = listaSegColaborador;
	}

	public SegColaborador getNuevoSegColaborador() {
		return nuevoSegColaborador;
	}

	public void setNuevoSegColaborador(SegColaborador nuevoSegColaborador) {
		this.nuevoSegColaborador = nuevoSegColaborador;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public SegColaborador getSegColaboradorSeleccionado() {
		return segColaboradorSeleccionado;
	}

	public void setSegColaboradorSeleccionado(SegColaborador segColaboradorSeleccionado) {
		this.segColaboradorSeleccionado = segColaboradorSeleccionado;
	}

	
}
