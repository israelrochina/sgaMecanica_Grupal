package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-26T12:08:20.567-0500")
@StaticMetamodel(InvCategoria.class)
public class InvCategoria_ {
	public static volatile SingularAttribute<InvCategoria, Integer> idCategoria;
	public static volatile SingularAttribute<InvCategoria, String> nombre;
	public static volatile ListAttribute<InvCategoria, InvProducto> invProductos;
}
