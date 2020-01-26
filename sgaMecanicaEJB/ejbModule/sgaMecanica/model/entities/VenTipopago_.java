package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-26T12:08:20.704-0500")
@StaticMetamodel(VenTipopago.class)
public class VenTipopago_ {
	public static volatile SingularAttribute<VenTipopago, Integer> idTipopago;
	public static volatile SingularAttribute<VenTipopago, String> nombre;
	public static volatile ListAttribute<VenTipopago, VenFactura> venFacturas;
}
