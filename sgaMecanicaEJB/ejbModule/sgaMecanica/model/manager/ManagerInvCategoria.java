package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvCategoria;

/**
 * Session Bean implementation class ManagerInvCategoria
 */
@Stateless
@LocalBean
public class ManagerInvCategoria {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerInvCategoria() {
		// TODO Auto-generated constructor stub
	}

	public List<InvCategoria> findAllInvCategoria() {
		String consulta = "select o from InvCategoria o";
		Query q = em.createQuery(consulta, InvCategoria.class);
		return q.getResultList();

	}

//insertar
	public void insertarInvCategoria(InvCategoria invCategoria) {

		em.persist(invCategoria);
	}

	// Eliminar
	public InvCategoria findInvCategoriaByCodigo(Integer codigo) { // busqueda por el codigo
		return em.find(InvCategoria.class, codigo);

	}

	public void eliminarInvCategoria(Integer id_categoria) {
		InvCategoria invCategoria = findInvCategoriaByCodigo(id_categoria);
		if (invCategoria != null) {
			em.remove(invCategoria);
		}
	}

	// actualizar
	public void actualizarCategoria(InvCategoria invCategoria) throws Exception {
		InvCategoria invCat = findInvCategoriaByCodigo(invCategoria.getIdCategoria());
		if (invCat == null) {
			throw new Exception("No existe la categoria especificada.");

		} else {
			invCat.setNombre(invCategoria.getNombre());

			em.merge(invCat);
		}

	}
}
