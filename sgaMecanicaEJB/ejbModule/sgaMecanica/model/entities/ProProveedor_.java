package sgaMecanica.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-26T12:08:20.695-0500")
@StaticMetamodel(ProProveedor.class)
public class ProProveedor_ {
	public static volatile SingularAttribute<ProProveedor, Integer> idProveedor;
	public static volatile SingularAttribute<ProProveedor, String> correo;
	public static volatile SingularAttribute<ProProveedor, String> direccion;
	public static volatile SingularAttribute<ProProveedor, String> nombreEmpresa;
	public static volatile SingularAttribute<ProProveedor, String> ruc;
	public static volatile SingularAttribute<ProProveedor, String> telefono;
	public static volatile ListAttribute<ProProveedor, InvProducto> invProductos;
	public static volatile SingularAttribute<ProProveedor, SegPersona> segPersona;
}
