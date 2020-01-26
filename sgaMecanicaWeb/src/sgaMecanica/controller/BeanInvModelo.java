package sgaMecanica.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import sgaMecanica.model.entities.InvModelo;
import sgaMecanica.model.manager.ManagerInvModelo;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanInvModelo implements Serializable {
	private static final long serialVersionUID=1L;

@EJB
private ManagerInvModelo managerInvModelo;
private List<InvModelo> listaInvModelo;
private InvModelo nuevoInvModelo;
private boolean panelColpsada;
private Integer id_marca;
private InvModelo invModeloSeleccionado;

@PostConstruct
private void inicializar() {
	
	listaInvModelo=managerInvModelo.findAllInvModelo();
	nuevoInvModelo= new InvModelo();
	panelColpsada = true; // para el panel que maximize y minimize
	
}
/* Panel */
public void actionListenerColapsarPanel() {
	panelColpsada = !panelColpsada;

}
//insertar
public void actionInsertarInvModelo() {
	try {
		managerInvModelo.insertarModelo(nuevoInvModelo, id_marca);
		listaInvModelo=managerInvModelo.findAllInvModelo();
		nuevoInvModelo= new InvModelo();
		id_marca=null;
		JSFUtil.crearMensajeInfo("Datos Modelos Insertados.");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		JSFUtil.clearMensajeError(e.getMessage());
		e.printStackTrace();
	};
	
}
//eliminar
public void actionListenerEliminarInvModelo(Integer id) {
	managerInvModelo.eliminarInvModelo(id);
	listaInvModelo=managerInvModelo.findAllInvModelo();
	JSFUtil.crearMensajeInfo("Modelado Eliminado");
}
//actualizar
public void actionListenerSelccionarInvModelo(InvModelo invModelo) {
	invModeloSeleccionado= invModelo;
}
public void actionListenerActualizarInvModelo(){
	try {
		managerInvModelo.actualizarInvModelo(invModeloSeleccionado, id_marca);
		listaInvModelo=managerInvModelo.findAllInvModelo();
		JSFUtil.crearMensajeInfo("Datos actualizados correctamente");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		JSFUtil.clearMensajeError(e.getMessage());
		e.printStackTrace();
	}
}
/* GETTER AND SETTER*/

public boolean isPanelColpsada() {
	return panelColpsada;
}
public void setPanelColpsada(boolean panelColpsada) {
	this.panelColpsada = panelColpsada;
}
public List<InvModelo> getListaInvModelo() {
	return listaInvModelo;
}

public void setListaInvModelo(List<InvModelo> listaInvModelo) {
	this.listaInvModelo = listaInvModelo;
}
public InvModelo getNuevoInvModelo() {
	return nuevoInvModelo;
}
public void setNuevoInvModelo(InvModelo nuevoInvModelo) {
	this.nuevoInvModelo = nuevoInvModelo;
}
public Integer getId_marca() {
	return id_marca;
}
public void setId_marca(Integer id_marca) {
	this.id_marca = id_marca;
}
public InvModelo getInvModeloSeleccionado() {
	return invModeloSeleccionado;
}
public void setInvModeloSeleccionado(InvModelo invModeloSeleccionado) {
	this.invModeloSeleccionado = invModeloSeleccionado;
}

}
