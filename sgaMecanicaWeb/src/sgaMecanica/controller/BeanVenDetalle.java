package sgaMecanica.controller;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import sgaMecanica.model.entities.VenDetalle;
import sgaMecanica.model.manager.ManagerVenDetalle;

@Named
@SessionScoped
public class BeanVenDetalle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagerVenDetalle manageVenDetalle;
	private VenDetalle venDetalle;
	private List<VenDetalle> listaVenDetalle;
	
	@PostConstruct
	private void inicializar() {
		listaVenDetalle = manageVenDetalle.findAllVenDetalle();
		venDetalle = new VenDetalle();
		
	}

	public List<VenDetalle> getListaVenDetalle() {
		return listaVenDetalle;
	}

	public void setListaVenDetalle(List<VenDetalle> listaVenDetalle) {
		this.listaVenDetalle = listaVenDetalle;
	}
	
	

}
