package sgaMecanica.model.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-02-08T00:48:22.221-0500")
@StaticMetamodel(VenIva.class)
public class VenIva_ {
	public static volatile SingularAttribute<VenIva, Integer> idIva;
	public static volatile SingularAttribute<VenIva, BigDecimal> porcentaje;
	public static volatile ListAttribute<VenIva, InvProducto> invProductos;
}
