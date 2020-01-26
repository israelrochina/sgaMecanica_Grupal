package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-26T12:08:20.700-0500")
@StaticMetamodel(VenEmisor.class)
public class VenEmisor_ {
	public static volatile SingularAttribute<VenEmisor, Integer> idEmisor;
	public static volatile SingularAttribute<VenEmisor, String> codigoEstableciemitno;
	public static volatile SingularAttribute<VenEmisor, String> codigoPuntoemicion;
	public static volatile SingularAttribute<VenEmisor, String> direccionEstablecimiento;
	public static volatile SingularAttribute<VenEmisor, String> direccionMatriz;
	public static volatile SingularAttribute<VenEmisor, String> nombre;
	public static volatile SingularAttribute<VenEmisor, String> nombreComercial;
	public static volatile SingularAttribute<VenEmisor, String> numAutoriSri;
	public static volatile SingularAttribute<VenEmisor, String> ruc;
	public static volatile ListAttribute<VenEmisor, VenFactura> venFacturas;
}
