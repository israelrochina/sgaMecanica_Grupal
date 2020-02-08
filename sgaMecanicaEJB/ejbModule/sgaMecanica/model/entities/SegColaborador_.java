package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-02-08T00:48:22.199-0500")
@StaticMetamodel(SegColaborador.class)
public class SegColaborador_ {
	public static volatile SingularAttribute<SegColaborador, Integer> idColaborador;
	public static volatile SingularAttribute<SegColaborador, Boolean> activo;
	public static volatile SingularAttribute<SegColaborador, String> clave;
	public static volatile SingularAttribute<SegColaborador, String> usuario;
	public static volatile SingularAttribute<SegColaborador, SegPersona> segPersona;
	public static volatile SingularAttribute<SegColaborador, SegRol> segRol;
	public static volatile ListAttribute<SegColaborador, VenFactura> venFacturas;
}
