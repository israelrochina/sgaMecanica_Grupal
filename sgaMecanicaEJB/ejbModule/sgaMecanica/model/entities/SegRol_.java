package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-26T18:19:28.623-0500")
@StaticMetamodel(SegRol.class)
public class SegRol_ {
	public static volatile SingularAttribute<SegRol, Integer> idRol;
	public static volatile SingularAttribute<SegRol, String> nombre;
	public static volatile ListAttribute<SegRol, SegColaborador> segColaboradors;
}
