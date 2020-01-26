package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.SegRol;

/**
 * Session Bean implementation class ManagerSegRol
 */
@Stateless
@LocalBean
public class ManagerSegRol {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerSegRol() {
		// TODO Auto-generated constructor stub
	}

	public List<SegRol> findAllSegRol() {
		String consulta = "select o from SegRol o";
		Query q = em.createQuery(consulta, SegRol.class);
		return q.getResultList();

	}

	// insertar
	public void insertarSegRol(SegRol segRol) {

		em.persist(segRol);
	}

	// eliminar
	public SegRol findSegRolByCodigo(Integer id_rol) { // busqueda por el codigo
		return em.find(SegRol.class, id_rol);

	}

	public void eliminarSegRol(Integer id_rol) {
		SegRol segRol = findSegRolByCodigo(id_rol);
		if (segRol != null) {
			em.remove(segRol);
		}
	}

	// actualizar
	public void actualizarSegRol(SegRol segRol) throws Exception {
		SegRol segR = findSegRolByCodigo(segRol.getIdRol());

		if (segR == null) {
			throw new Exception("No existe el rol especificada.");

		}
		segR.setNombre(segRol.getNombre());

		em.merge(segR);
	}
}
