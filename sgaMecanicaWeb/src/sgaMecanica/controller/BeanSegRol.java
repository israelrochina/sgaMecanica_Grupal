package sgaMecanica.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.SegRol;
import sgaMecanica.model.manager.ManagerSegRol;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanSegRol implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerSegRol managerSegRol;
	private List<SegRol> listaSegRol;
	private SegRol nuevoSegRol;
	private boolean panelColpsada;
	private SegRol segRolSeleccionado;

	@PostConstruct
	public void inicilizar() {

		listaSegRol = managerSegRol.findAllSegRol();
		nuevoSegRol= new SegRol();
		panelColpsada = true; // para el panel que maximize y minimize
	}
	//insertar
	public void actionInsertarInvMarca() {
		try {
			managerSegRol.insertarSegRol(nuevoSegRol);
			listaSegRol = managerSegRol.findAllSegRol();
			nuevoSegRol= new SegRol();
			JSFUtil.crearMensajeInfo("Datos Estudiantes Insertados.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		};
		
	}
	//eliminar
	public void actionListenerEliminarSegRol(Integer id_rol) {
		managerSegRol.eliminarSegRol(id_rol);
		listaSegRol = managerSegRol.findAllSegRol();
		JSFUtil.crearMensajeInfo("Rol Eliminado");
	}
	/*GETTER AND SETTER*/

	public List<SegRol> getListaSegRol() {
		return listaSegRol;
	}

	public void setListaSegRol(List<SegRol> listaSegRol) {
		this.listaSegRol = listaSegRol;
	}
	//actualizar
	public void actionListenerSelccionarSegRol(SegRol segRol) {
		segRolSeleccionado=segRol;
	}
	public void actionListenerActualizarSegRol(){
		try {
			managerSegRol.actualizarSegRol(segRolSeleccionado);
			listaSegRol = managerSegRol.findAllSegRol();
			JSFUtil.crearMensajeInfo("Datos actualizados correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	/*PANEL*/
	
	public void actionListenerColapsarPanel() {
		panelColpsada = !panelColpsada;

	}

	public SegRol getNuevoSegRol() {
		return nuevoSegRol;
	}

	public void setNuevoSegRol(SegRol nuevoSegRol) {
		this.nuevoSegRol = nuevoSegRol;
	}

	public boolean isPanelColpsada() {
		return panelColpsada;
	}

	public void setPanelColpsada(boolean panelColpsada) {
		this.panelColpsada = panelColpsada;
	}
	public SegRol getSegRolSeleccionado() {
		return segRolSeleccionado;
	}
	public void setSegRolSeleccionado(SegRol segRolSeleccionado) {
		this.segRolSeleccionado = segRolSeleccionado;
	}
	
}
