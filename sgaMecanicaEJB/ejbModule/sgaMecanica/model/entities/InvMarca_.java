package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-26T18:19:28.612-0500")
@StaticMetamodel(InvMarca.class)
public class InvMarca_ {
	public static volatile SingularAttribute<InvMarca, Integer> idMarca;
	public static volatile SingularAttribute<InvMarca, String> nombre;
	public static volatile ListAttribute<InvMarca, InvModelo> invModelos;
}
