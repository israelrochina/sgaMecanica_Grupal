package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.entities.InvModelo;

/**
 * Session Bean implementation class ManagerInvModelo
 */
@Stateless
@LocalBean
public class ManagerInvModelo {
	
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerInvModelo() {
		// TODO Auto-generated constructor stub
	}

	public List<InvModelo> findAllInvModelo() {
		String consulta = "select o from InvModelo o";
		Query q = em.createQuery(consulta, InvModelo.class);
		return q.getResultList();

	}

	public void insertarModelo(InvModelo invModelo, Integer id_marca) {
		InvMarca invmMarca = (InvMarca) em.find(InvMarca.class, id_marca);
		invModelo.setInvMarca(invmMarca);
		em.persist(invModelo);

	}

	public InvModelo findInvModeloByCodigo(Integer id_invModelo) { // busqueda por el codigo
		
		return em.find(InvModelo.class, id_invModelo);

	}

	public void eliminarInvModelo(Integer id) {
		InvModelo invModelo = findInvModeloByCodigo(id);
		if (invModelo != null) {
			em.remove(invModelo);
		}
	}

	public void actualizarInvModelo(InvModelo invModelo, Integer idMarca) throws Exception {
		InvModelo invMod = findInvModeloByCodigo(invModelo.getIdModelo());
		if (invMod == null) {
			throw new Exception("No existe el modelado especificada.");

		} else {
			InvMarca invMarca = (InvMarca) em.find(InvMarca.class, idMarca);
			invMod.setInvMarca(invMarca);
			invMod.setNombre(invModelo.getNombre());
			em.merge(invMod);

		}

	}

}
