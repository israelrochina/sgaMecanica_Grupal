package sgaMecanica.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.InvCategoria;

import sgaMecanica.model.manager.ManagerInvCategoria;

@Named
@SessionScoped
public class BeanInvCategoria implements Serializable{
	private static final long serialVersionUID=1L;
	
@EJB
private ManagerInvCategoria managerInvCategoria;
private List<InvCategoria> listaInvCategoria;
private InvCategoria invCategoria;
private boolean panelColpsada;
private InvCategoria invCategoriaSeleccionada;

@PostConstruct
public  void inicializar() {
	listaInvCategoria=managerInvCategoria.findAllInvCategoria();
	invCategoria= new InvCategoria();
	panelColpsada = true; // para el panel que maximize y minimize
}

//Insertar
public void actionInsertarInvCategoria() {
	try {
		managerInvCategoria.insertarInvCategoria(invCategoria);
		
		listaInvCategoria=managerInvCategoria.findAllInvCategoria();
		invCategoria= new InvCategoria();
		JSFUtil.crearMensajeInfo("Datos Categoria Insertados.");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		JSFUtil.clearMensajeError(e.getMessage());
		e.printStackTrace();
	};
	
}
//eliminar 
public void actionListenerEliminarInvCategoria(Integer id_categoria) {
	managerInvCategoria.eliminarInvCategoria(id_categoria);;
	
	listaInvCategoria=managerInvCategoria.findAllInvCategoria();
	JSFUtil.crearMensajeInfo("Categoria Eliminado");
}
//actualizar
public void actionListenerSelccionarInvCategoria(InvCategoria invCategoria) {
	invCategoriaSeleccionada= invCategoria;
}
public void actionListenerActualizarInvCategoria(){
	try {
		managerInvCategoria.actualizarCategoria(invCategoriaSeleccionada);
		listaInvCategoria=managerInvCategoria.findAllInvCategoria();
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
/*GETTER ADN SETTER */



public List<InvCategoria> getListaInvCategoria() {
	return listaInvCategoria;
}

public void setListaInvCategoria(List<InvCategoria> listaInvCategoria) {
	this.listaInvCategoria = listaInvCategoria;
}

public InvCategoria getInvCategoria() {
	return invCategoria;
}

public void setInvCategoria(InvCategoria invCategoria) {
	this.invCategoria = invCategoria;
}

public InvCategoria getInvCategoriaSeleccionada() {
	return invCategoriaSeleccionada;
}

public void setInvCategoriaSeleccionada(InvCategoria invCategoriaSeleccionada) {
	this.invCategoriaSeleccionada = invCategoriaSeleccionada;
}

}
