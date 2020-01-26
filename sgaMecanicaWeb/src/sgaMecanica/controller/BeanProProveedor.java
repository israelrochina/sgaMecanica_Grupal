package sgaMecanica.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.ProProveedor;
import sgaMecanica.model.manager.ManagerProProveedor;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped  
public class BeanProProveedor implements Serializable {
	private static final long serialVersionUID=1L;
	
@EJB
private ManagerProProveedor managerProProvedor;
private List<ProProveedor> listaProProvedor;
private ProProveedor nuevoProProveedor;
private Integer id_persona;
private boolean panelColpsada;
private ProProveedor proProveedorSeleccionado;

@PostConstruct
public void inicializar() {
	listaProProvedor=managerProProvedor.findAllProProveedor();
	nuevoProProveedor=new ProProveedor();
	panelColpsada = true; // para el panel que maximize y minimize
}
//insertar
public void actionInsertarProProveedor() {
	try {
		managerProProvedor.insertarProProveedor(nuevoProProveedor, id_persona);
		listaProProvedor=managerProProvedor.findAllProProveedor();
		nuevoProProveedor=new ProProveedor();
		
		id_persona=null;
		JSFUtil.crearMensajeInfo("Datos Proveedor Insertados.");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		JSFUtil.clearMensajeError(e.getMessage());
		e.printStackTrace();
	};
	
}
//Eliminar 
public void actionListenerEliminarProProveedor(Integer id) {
	managerProProvedor.eliminarProProveedor(id);
	listaProProvedor=managerProProvedor.findAllProProveedor();
	JSFUtil.crearMensajeInfo("Proveedor Eliminado");
}
//actualizar 
public void actionListenerSelccionarProProveedor(ProProveedor proProveedor) {
	
	proProveedorSeleccionado= proProveedor;
}
public void actionListenerMostrarRepesentantesProProveedor(ProProveedor proProveedor) {
	proProveedorSeleccionado= proProveedor;
}
public void actionListenerActualizarProProveedor(){
	try {
		managerProProvedor.actualizarProProveedor(proProveedorSeleccionado, id_persona);
		listaProProvedor=managerProProvedor.findAllProProveedor();
		
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
public List<ProProveedor> getListaProProvedor() {
	return listaProProvedor;
	
}

public void setListaProProvedor(List<ProProveedor> listaProProvedor) {
	this.listaProProvedor = listaProProvedor;
}
public ProProveedor getNuevoProProveedor() {
	return nuevoProProveedor;
}
public void setNuevoProProveedor(ProProveedor nuevoProProveedor) {
	this.nuevoProProveedor = nuevoProProveedor;
}
public Integer getId_persona() {
	return id_persona;
}
public void setId_persona(Integer id_persona) {
	this.id_persona = id_persona;
}
public ProProveedor getProProveedorSeleccionado() {
	return proProveedorSeleccionado;
}
public void setProProveedorSeleccionado(ProProveedor proProveedorSeleccionado) {
	this.proProveedorSeleccionado = proProveedorSeleccionado;
}

}
