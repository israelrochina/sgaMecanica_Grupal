package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-02-08T00:48:22.177-0500")
@StaticMetamodel(InvMarca.class)
public class InvMarca_ {
	public static volatile SingularAttribute<InvMarca, Integer> idMarca;
	public static volatile SingularAttribute<InvMarca, String> nombre;
	public static volatile ListAttribute<InvMarca, InvModelo> invModelos;
}
