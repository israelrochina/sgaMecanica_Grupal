package sgaMecanica.model.manager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import sgaMecanica.model.entities.InvProducto;
import sgaMecanica.model.entities.SegPersona;
import sgaMecanica.model.entities.VenDetalle;
import sgaMecanica.model.entities.VenEmisor;
import sgaMecanica.model.entities.VenFactura;
import sgaMecanica.model.entities.VenTipopago;

/**
 * Session Bean implementation class ManagerVenFactura
 */
@Stateless
@LocalBean
public class ManagerVenFactura {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerVenFactura() {
		// TODO Auto-generated constructor stub
	}

	public List<VenFactura> findAllVenFactura() {
		String consulta = "select o from VenFactura o";
		Query q = em.createQuery(consulta, VenFactura.class);
		return q.getResultList();
	}

	////////////// factura///////////
	public VenFactura crearVenFacturaTMP() {
		VenFactura venFacturaCabTmp = new VenFactura();
		venFacturaCabTmp.setVenDetalles(new ArrayList<>());
		return venFacturaCabTmp;
	}
	

	public void asignarClienteFacturaTmp(VenFactura venfacturaTmp, Integer id_usuario) throws Exception {
		SegPersona segPersona = null;
		if (id_usuario == 0 || id_usuario == null)
			throw new Exception("Error debe de especificar un Cliente.");
		try {
			segPersona = (SegPersona) em.find(SegPersona.class, id_usuario);
			if (segPersona == null)
				throw new Exception("Error al asignar cliente");
			venfacturaTmp.setSegPersona(segPersona);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al asignar cliente" + e.getMessage());
		}

	}
	

	private void calcularVenfactTemp(VenFactura venfactura) {
		double baseimponible;
		double basecero;
		double subtotaliva = 0, subtotalsiniva = 0;
		double total;
		double porcentaje = 0;
		for (VenDetalle det : venfactura.getVenDetalles()) {
			if (det.getIvaVendido().doubleValue() > 0) {
				subtotaliva += det.getCantidad().intValue() * det.getPrecioUnitario().doubleValue();
				porcentaje = det.getIvaVendido().doubleValue();
			} else {
				subtotalsiniva = det.getCantidad().intValue() * det.getPrecioUnitario().doubleValue();
			}

		}
		/////
		double baseImponible = (subtotaliva * 100) / (100 + porcentaje);
		double subtootalVenfactura = subtotaliva - baseImponible;

		venfactura.setBaseImponible(new BigDecimal(baseImponible));
		venfactura.setSubtotal(new BigDecimal(subtootalVenfactura));
		venfactura.setTotal(new BigDecimal(subtotaliva + subtotalsiniva));
venfactura.setBaseCero(new BigDecimal(subtotalsiniva));
	}

	
	/* detalle */
	public void agregarDetallevenfacturaTmp(VenFactura venfacturaTmp, String id_producto, Integer cantidad_producto)
			throws Exception {
		InvProducto invProd;
		VenDetalle venDetalle;

		if (venfacturaTmp == null)
			throw new Exception("Error primero debe de crear una nueva factura");
		if (id_producto == null)
			throw new Exception("Error primero debe de especificar el codigo del producto");
		if (cantidad_producto == null || cantidad_producto.intValue() <= 0)
			throw new Exception("Error primero debe especificar la cantidad de producto");
		
		// buamos producto
		invProd = (InvProducto) em.find(InvProducto.class, id_producto);
		
		// Con este if controlo que la cantidad del detalle de la factura no exeda la cantidada que se encuentra en inventario
		if(cantidad_producto>invProd.getCantidad())
			throw new Exception("La cantidad exede la cantidad en bodega , actualmente tiene : "+invProd.getCantidad()+" unidades en bodega");
		
						
		// creamos un nuevo detalle y llenamos sus propiedades
		venDetalle = new VenDetalle();
		venDetalle.setCantidad(cantidad_producto);
		venDetalle.setDetalle(invProd.getDescripcion());
		venDetalle.setPrecioUnitario(invProd.getPrecioVenta());
		BigDecimal p = new BigDecimal(cantidad_producto);

		//
		double subSinIva = invProd.getPrecioVenta().doubleValue() * cantidad_producto.intValue();

		venDetalle.setPrecioSubtotal(new BigDecimal(subSinIva));

		venDetalle.setIvaVendido(invProd.getVenIva().getPorcentaje());
		venDetalle.setInvProducto(invProd);

		venfacturaTmp.getVenDetalles().add(venDetalle);
		calcularVenfactTemp(venfacturaTmp);

	}

	
	public void eliminarItemDetalle( String codigoProducto,VenFactura venFacturaTmp) {
		
		int posicion = -1;
		for (int i=0;i < venFacturaTmp.getVenDetalles().size();i++) {
			if(venFacturaTmp.getVenDetalles().get(i).getInvProducto().getIdProducto().equals(codigoProducto)) {
				posicion=i;
				break;
			}	
		}
		
		venFacturaTmp.getVenDetalles().remove(posicion);
		calcularVenfactTemp(venFacturaTmp);
		
		
	}
	
	/*
	 * Guardar factura Temporal
	 */
	public void guardarVenFacturaTemp(Integer id_usuario, VenFactura venFacturaTmp, Integer id_tipopago,
	
			Integer id_emisor, Boolean estadofactura, String numeroFactura) throws Exception {
asignarClienteFacturaTmp(venFacturaTmp, id_usuario);
		
		
		if (venFacturaTmp == null)
			throw new Exception("Debe de Crear una Factura Primero");
		if (venFacturaTmp.getVenDetalles() == null || venFacturaTmp.getVenDetalles().size() == 0)
			throw new Exception("Debe de Ingresar Los productos en la Factura");
		if (venFacturaTmp.getSegPersona() == null)
			throw new Exception("Debe de Registrar al cliente");
		if (id_tipopago <= 0 || id_tipopago == null)
			throw new Exception("Debe de selecionar una forma de pago");
		if (id_emisor <= 0 || id_emisor == null)
			throw new Exception("Debe de selecionar un emisor");
		if (estadofactura == null)
			throw new Exception("Debe de selecionar un estado");

		// asignar cliente
		SegPersona segPersona = (SegPersona) em.find(SegPersona.class, id_usuario);
		venFacturaTmp.setSegPersona(segPersona);

		// asignar tipo pago
		VenTipopago venTipoPago = (VenTipopago) em.find(VenTipopago.class, id_tipopago);
		venFacturaTmp.setVenTipopago(venTipoPago);

		// asignar Emisor
		VenEmisor venEmisor = (VenEmisor) em.find(VenEmisor.class, id_emisor);
		venFacturaTmp.setVenEmisor(venEmisor);

		venFacturaTmp.setFechaEmicion(new Date());
		venFacturaTmp.setEstadopagado(estadofactura);

		venFacturaTmp.setNumeroFactura(numeroFactura);

		// verificamos calculos
		calcularVenfactTemp(venFacturaTmp);

		for (VenDetalle det : venFacturaTmp.getVenDetalles()) {
			det.setVenFactura(venFacturaTmp);
			System.out.println("llegue y guarde"+venFacturaTmp);
		}
		em.persist(venFacturaTmp);
		System.out.println(venFacturaTmp.getVenDetalles().get(0).getIdVenDetalle());
		
		venFacturaTmp = null;
	}

	

}
