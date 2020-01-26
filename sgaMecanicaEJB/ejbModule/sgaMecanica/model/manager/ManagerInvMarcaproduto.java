package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvMarcaproducto;

/**
 * Session Bean implementation class ManagerInvMarcaproduto
 */
@Stateless
@LocalBean
public class ManagerInvMarcaproduto {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerInvMarcaproduto() {
		// TODO Auto-generated constructor stub
	}

	public List<InvMarcaproducto> findAllInvMarcaproucto() {
		String consulta = "select o from InvMarcaproducto o";
		Query q = em.createQuery(consulta, InvMarcaproducto.class);
		return q.getResultList();
	}

	// insertar
	public InvMarcaproducto findInvMarcaproductoByCodigo(Integer codigo) { // busqueda por el codigo
		return em.find(InvMarcaproducto.class, codigo);
	}

	public void insertarinvMarcaproducto(InvMarcaproducto invMarcaproducto) throws Exception {
		em.persist(invMarcaproducto);
	}

	// eliminar
	public void eliminarInvMarcaproducto(Integer id) {
		InvMarcaproducto invMarcaproducto = findInvMarcaproductoByCodigo(id);
		if (invMarcaproducto != null) {
			em.remove(invMarcaproducto);
		}
	}

	// actualizar
	public void actualizarInvMarcaproducto(InvMarcaproducto invMarcaproducto) throws Exception {
		InvMarcaproducto invMP = findInvMarcaproductoByCodigo(invMarcaproducto.getIdMarcaproducto());
		if (invMP == null) {
			throw new Exception("No existe la marca especificada.");

		} else {
			

			em.merge(invMarcaproducto);
		}

	}

}
