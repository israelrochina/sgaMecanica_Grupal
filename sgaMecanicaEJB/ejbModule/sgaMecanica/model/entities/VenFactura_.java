package sgaMecanica.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-02-08T00:48:22.217-0500")
@StaticMetamodel(VenFactura.class)
public class VenFactura_ {
	public static volatile SingularAttribute<VenFactura, Integer> idFactura;
	public static volatile SingularAttribute<VenFactura, BigDecimal> baseCero;
	public static volatile SingularAttribute<VenFactura, BigDecimal> baseImponible;
	public static volatile SingularAttribute<VenFactura, Boolean> estadopagado;
	public static volatile SingularAttribute<VenFactura, Date> fechaEmicion;
	public static volatile SingularAttribute<VenFactura, String> numeroFactura;
	public static volatile SingularAttribute<VenFactura, BigDecimal> subtotal;
	public static volatile SingularAttribute<VenFactura, BigDecimal> total;
	public static volatile ListAttribute<VenFactura, VenCredito> venCreditos;
	public static volatile ListAttribute<VenFactura, VenDetalle> venDetalles;
	public static volatile SingularAttribute<VenFactura, SegColaborador> segColaborador;
	public static volatile SingularAttribute<VenFactura, SegPersona> segPersona;
	public static volatile SingularAttribute<VenFactura, VenEmisor> venEmisor;
	public static volatile SingularAttribute<VenFactura, VenTipopago> venTipopago;
}
