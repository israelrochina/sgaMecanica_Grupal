package sgaMecanica.model.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-02-08T00:48:22.098-0500")
@StaticMetamodel(Auditoria.class)
public class Auditoria_ {
	public static volatile SingularAttribute<Auditoria, Integer> idAuditoria;
	public static volatile SingularAttribute<Auditoria, String> descripcion;
	public static volatile SingularAttribute<Auditoria, String> direccionIp;
	public static volatile SingularAttribute<Auditoria, Date> fechaEvento;
	public static volatile SingularAttribute<Auditoria, Integer> idColaborador;
	public static volatile SingularAttribute<Auditoria, String> metodo;
}
