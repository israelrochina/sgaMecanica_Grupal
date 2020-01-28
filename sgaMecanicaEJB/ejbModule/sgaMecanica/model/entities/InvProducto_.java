package sgaMecanica.model.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-26T18:19:28.616-0500")
@StaticMetamodel(InvProducto.class)
public class InvProducto_ {
	public static volatile SingularAttribute<InvProducto, String> idProducto;
	public static volatile SingularAttribute<InvProducto, Integer> cantidad;
	public static volatile SingularAttribute<InvProducto, String> descripcion;
	public static volatile SingularAttribute<InvProducto, Integer> maximo;
	public static volatile SingularAttribute<InvProducto, Integer> minimo;
	public static volatile SingularAttribute<InvProducto, String> nombre;
	public static volatile SingularAttribute<InvProducto, BigDecimal> precioCoste;
	public static volatile SingularAttribute<InvProducto, BigDecimal> precioVenta;
	public static volatile SingularAttribute<InvProducto, InvCategoria> invCategoria;
	public static volatile SingularAttribute<InvProducto, InvMarcaproducto> invMarcaproducto;
	public static volatile SingularAttribute<InvProducto, InvModelo> invModelo;
	public static volatile SingularAttribute<InvProducto, ProProveedor> proProveedor;
	public static volatile SingularAttribute<InvProducto, VenIva> venIva;
	public static volatile ListAttribute<InvProducto, VenDetalle> venDetalles;
}
