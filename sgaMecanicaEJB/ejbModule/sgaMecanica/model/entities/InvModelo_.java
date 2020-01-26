package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-26T16:07:07.842-0500")
@StaticMetamodel(InvModelo.class)
public class InvModelo_ {
	public static volatile SingularAttribute<InvModelo, Integer> idModelo;
	public static volatile SingularAttribute<InvModelo, String> nombre;
	public static volatile SingularAttribute<InvModelo, InvMarca> invMarca;
	public static volatile ListAttribute<InvModelo, InvProducto> invProductos;
}
