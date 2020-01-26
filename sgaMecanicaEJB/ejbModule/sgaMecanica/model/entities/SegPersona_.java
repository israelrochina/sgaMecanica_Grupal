package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-26T16:07:07.845-0500")
@StaticMetamodel(SegPersona.class)
public class SegPersona_ {
	public static volatile SingularAttribute<SegPersona, Integer> idPersona;
	public static volatile SingularAttribute<SegPersona, String> apellidos;
	public static volatile SingularAttribute<SegPersona, String> cedulaRuc;
	public static volatile SingularAttribute<SegPersona, String> email;
	public static volatile SingularAttribute<SegPersona, String> nombres;
	public static volatile SingularAttribute<SegPersona, String> sexo;
	public static volatile SingularAttribute<SegPersona, String> telefono;
	public static volatile ListAttribute<SegPersona, ProProveedor> proProveedors;
	public static volatile ListAttribute<SegPersona, SegColaborador> segColaboradors;
	public static volatile ListAttribute<SegPersona, VenFactura> venFacturas;
}
