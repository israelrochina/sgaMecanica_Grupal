package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-02-08T00:48:22.180-0500")
@StaticMetamodel(InvMarcaproducto.class)
public class InvMarcaproducto_ {
	public static volatile SingularAttribute<InvMarcaproducto, Integer> idMarcaproducto;
	public static volatile SingularAttribute<InvMarcaproducto, String> nombre;
	public static volatile ListAttribute<InvMarcaproducto, InvProducto> invProductos;
}
