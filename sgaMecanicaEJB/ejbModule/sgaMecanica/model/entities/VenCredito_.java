package sgaMecanica.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-02-08T00:48:22.209-0500")
@StaticMetamodel(VenCredito.class)
public class VenCredito_ {
	public static volatile SingularAttribute<VenCredito, Integer> idCredito;
	public static volatile SingularAttribute<VenCredito, Date> fecha;
	public static volatile SingularAttribute<VenCredito, BigDecimal> monto;
	public static volatile SingularAttribute<VenCredito, BigDecimal> total;
	public static volatile SingularAttribute<VenCredito, VenFactura> venFactura;
}
