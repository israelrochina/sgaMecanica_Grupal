package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.Auditoria;

/**
 * Session Bean implementation class ManagerAuditoria
 */
@Stateless
@LocalBean
public class ManagerAuditoria {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerAuditoria() {
		// TODO Auto-generated constructor stub
	}

	public List<Auditoria> findAllAuditoria() {
		String consulta = "select o from Auditoria o";
		Query q = em.createQuery(consulta, Auditoria.class);
		return q.getResultList();
	}

}
