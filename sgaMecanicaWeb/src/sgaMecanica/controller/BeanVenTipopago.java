package sgaMecanica.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.VenTipopago;
import sgaMecanica.model.manager.ManagerVenTipopago;

@Named
@SessionScoped
public class BeanVenTipopago implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagerVenTipopago managerVenTipopago;
	private VenTipopago nuevoVenTipopago;
	private List<VenTipopago> listaVenTipopago;
	private boolean panelColpsada;
	private VenTipopago ventTipopagoSeleccionado;
	
	@PostConstruct
	public void inicializar() {
		listaVenTipopago=managerVenTipopago.findAllVenTipopago();
		nuevoVenTipopago= new VenTipopago();
		panelColpsada=true;
	}
	
	
	//insertar
	public void actionInsertarVenTipopago() {
		try {
			managerVenTipopago.insertarVenTipopago(nuevoVenTipopago);
			listaVenTipopago=managerVenTipopago.findAllVenTipopago();
			nuevoVenTipopago= new VenTipopago();
			JSFUtil.crearMensajeInfo("Tipo pago Insertado.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
		};	
	}

	//Eliminar
	public void actionListenerEliminarVenTipopago(Integer id) {
		managerVenTipopago.eliminarVenTipopago(id);
		
		listaVenTipopago= managerVenTipopago.findAllVenTipopago();
		JSFUtil.crearMensajeInfo("Tipo pago eliminado");
	}
	

	//actualizar
		public void actionListenerSelccionarVenTipopago(VenTipopago venTipoPago) {
			ventTipopagoSeleccionado = venTipoPago;
		}

		public void actionListenerActualizarVenTipopago() {
			try {
				managerVenTipopago.actualizarVenTipopago(ventTipopagoSeleccionado);
				listaVenTipopago= managerVenTipopago.findAllVenTipopago();
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

	public List<VenTipopago> getListaVenTipopago() {
		return listaVenTipopago;
	}

	public void setListaVenTipopago(List<VenTipopago> listaVenTipopago) {
		this.listaVenTipopago = listaVenTipopago;
	}


	public VenTipopago getNuevoVenTipopago() {
		return nuevoVenTipopago;
	}

	public void setNuevoVenTipopago(VenTipopago nuevoVenTipopago) {
		this.nuevoVenTipopago = nuevoVenTipopago;
	}


	public boolean isPanelColpsada() {
		return panelColpsada;
	}

	public void setPanelColpsada(boolean panelColpsada) {
		this.panelColpsada = panelColpsada;
	}


	
	public VenTipopago getVentTipopagoSeleccionado() {
		return ventTipopagoSeleccionado;
	}


	public void setVentTipopagoSeleccionado(VenTipopago ventTipopagoSeleccionado) {
		this.ventTipopagoSeleccionado = ventTipopagoSeleccionado;
	}
	
	
	
	
	
	
	

}
