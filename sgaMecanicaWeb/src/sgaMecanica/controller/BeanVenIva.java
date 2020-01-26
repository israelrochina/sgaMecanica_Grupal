package sgaMecanica.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import sgaMecanica.model.entities.VenIva;
import sgaMecanica.model.manager.ManagerVenIva;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanVenIva implements Serializable {
	private static final long serialVersionUID=1L;
	
@EJB
private ManagerVenIva managerVenIva;
private List<VenIva> listaInvIva;
private VenIva venIva;
private boolean panelColpsada;
private VenIva venIvaSeleccionado;

@PostConstruct
public void inicializar() {
	listaInvIva=managerVenIva.findAllVenIva();
	venIva= new VenIva();
	panelColpsada = true; // para el panel que maximize y minimize
}
//insertar
public void actionInsertarVenIva() {
	try {
		managerVenIva.insertarVenIva(venIva);
		listaInvIva=managerVenIva.findAllVenIva();
		venIva= new VenIva();
		JSFUtil.crearMensajeInfo("Datos Iva Insertados.");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		JSFUtil.clearMensajeError(e.getMessage());
		e.printStackTrace();
	};
	
}
//Eliminar
public void actionListenerEliminarVenIva(Integer id_iva) {
	managerVenIva.eliminarVenIva(id_iva);
	
	listaInvIva=managerVenIva.findAllVenIva();
	JSFUtil.crearMensajeInfo("Iva Eliminado");
}
//actaulizar
public void actionListenerSelccionarVenIva(VenIva venIva) {
	venIvaSeleccionado= venIva;
}
public void actionListenerActualizarVenIva(){
	try {
		managerVenIva.actualizarVenIva(venIvaSeleccionado);
		listaInvIva=managerVenIva.findAllVenIva();
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



/*GETTER AND SETTER*/

public boolean isPanelColpsada() {
	return panelColpsada;
}
public void setPanelColpsada(boolean panelColpsada) {
	this.panelColpsada = panelColpsada;
}
public List<VenIva> getListaInvIva() {
	return listaInvIva;
}

public void setListaInvIva(List<VenIva> listaInvIva) {
	this.listaInvIva = listaInvIva;
}
public VenIva getVenIva() {
	return venIva;
}
public void setVenIva(VenIva venIva) {
	this.venIva = venIva;
}
public VenIva getVenIvaSeleccionado() {
	return venIvaSeleccionado;
}
public void setVenIvaSeleccionado(VenIva venIvaSeleccionado) {
	this.venIvaSeleccionado = venIvaSeleccionado;
}


}
