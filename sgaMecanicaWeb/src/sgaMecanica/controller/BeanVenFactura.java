package sgaMecanica.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.VenFactura;
import sgaMecanica.model.manager.ManagerVenFactura;
import java.io.Serializable;

@Named
@SessionScoped
public class BeanVenFactura implements Serializable {
	@EJB
	private ManagerVenFactura managerVenFactura;
	private List<VenFactura> listaVenFactura;
	private VenFactura nuevoVenFactura;
	private Boolean facturaCabTempGuardada;
	private String id_producto;
	private Integer cantidadProducto;
	private Integer id_usuario;
	private Integer id_tipopago;
	private Integer id_emisor;
	private Boolean estadoFactura;
	private String numerofactura;

	@PostConstruct
	public void inicializar() {
		listaVenFactura = managerVenFactura.findAllVenFactura(); // InvProducto=managerInvProduto.findAllInvProducto();

	}

	public String crearNuevaFactura() {
		nuevoVenFactura = managerVenFactura.crearVenFacturaTMP();
		facturaCabTempGuardada = false;
		id_producto = null;
		cantidadProducto = 0;
		id_usuario = 0;
		id_tipopago = 0;
		id_emisor = 0;
		estadoFactura = null;
		return "";
	}

	/* Asignar Cliente */
	

	public void asignarCliente() {
		if (facturaCabTempGuardada == true) {
			JSFUtil.crearrMensajeWarning("La factura ya fue Gardada");
		}
		try {
			managerVenFactura.asignarClienteFacturaTmp(nuevoVenFactura, id_usuario);
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.clearMensajeError(e.getMessage());
		}

	}

	public String insertarDetalle() {
		if (facturaCabTempGuardada == true) {
			JSFUtil.crearrMensajeWarning("La factura ya fue creada");
			return "";
		}
		try {
			managerVenFactura.agregarDetallevenfacturaTmp(nuevoVenFactura, id_producto, cantidadProducto);
			id_producto = null;
			cantidadProducto = 0;
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.clearMensajeError(e.getMessage());
		}
		return "";
	}

	public String guradarfactura() {
		if (facturaCabTempGuardada == true) {
			JSFUtil.crearrMensajeWarning("La factura ya fue gradada");
			return "";
		}
		try {
			managerVenFactura.guardarVenFacturaTemp(id_usuario, nuevoVenFactura, id_tipopago, id_emisor, estadoFactura,
					numerofactura);
			facturaCabTempGuardada = true;
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.clearMensajeError(e.getMessage());
		}
		return "";
	}

///////////////////////////////////////////////////////////////////////////////////////
	public List<VenFactura> getListaVenFactura() {
		return listaVenFactura;
	}

	public void setListaVenFactura(List<VenFactura> listaVenFactura) {
		this.listaVenFactura = listaVenFactura;
	}

	public void actionInsertarVenfactura() {

	}

	public VenFactura getNuevoVenFactura() {
		return nuevoVenFactura;
	}

	public void setNuevoVenFactura(VenFactura nuevoVenFactura) {
		this.nuevoVenFactura = nuevoVenFactura;
	}

	public Boolean getFacturaCabTempGuardada() {
		return facturaCabTempGuardada;
	}

	public void setFacturaCabTempGuardada(Boolean facturaCabTempGuardada) {
		this.facturaCabTempGuardada = facturaCabTempGuardada;
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Integer getId_tipopago() {
		return id_tipopago;
	}

	public void setId_tipopago(Integer id_tipopago) {
		this.id_tipopago = id_tipopago;
	}

	public Integer getId_emisor() {
		return id_emisor;
	}

	public void setId_emisor(Integer id_emisor) {
		this.id_emisor = id_emisor;
	}

	public Boolean getEstadoFactura() {
		return estadoFactura;
	}

	public void setEstadoFactura(Boolean estadoFactura) {
		this.estadoFactura = estadoFactura;
	}

	public String getNumerofactura() {
		return numerofactura;
	}

	public void setNumerofactura(String numerofactura) {
		this.numerofactura = numerofactura;
	}

}
