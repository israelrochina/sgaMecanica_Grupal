package sgaMecanica.model.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-02-08T00:48:22.211-0500")
@StaticMetamodel(VenDetalle.class)
public class VenDetalle_ {
	public static volatile SingularAttribute<VenDetalle, Integer> idVenDetalle;
	public static volatile SingularAttribute<VenDetalle, Integer> cantidad;
	public static volatile SingularAttribute<VenDetalle, String> detalle;
	public static volatile SingularAttribute<VenDetalle, BigDecimal> ivaVendido;
	public static volatile SingularAttribute<VenDetalle, BigDecimal> precioSubtotal;
	public static volatile SingularAttribute<VenDetalle, BigDecimal> precioUnitario;
	public static volatile SingularAttribute<VenDetalle, InvProducto> invProducto;
	public static volatile SingularAttribute<VenDetalle, VenFactura> venFactura;
}
