package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.entities.InvModelo;
import sgaMecanica.model.entities.SegRol;
import sgaMecanica.model.entities.VenEmisor;

/**
 * Session Bean implementation class ManagerVenEmisor
 */
@Stateless
@LocalBean
public class ManagerVenEmisor {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerVenEmisor() {
		// TODO Auto-generated constructor stub
	}

	public List<VenEmisor> findAllVenEmisor() {
		String consulta = "select o from VenEmisor o";
		Query q = em.createQuery(consulta, VenEmisor.class);
		return q.getResultList();

	}

	public void insertarVenEmisor(VenEmisor venEmisor) {

		em.persist(venEmisor);

	}

	// ELIMINAR
	public VenEmisor findVenEmisorlByCodigo(Integer id_emisor) { // busqueda por el codigo
		return em.find(VenEmisor.class, id_emisor);

	}

	public void eliminarVenEmisor(Integer id_emisor) {
		VenEmisor venEmi = findVenEmisorlByCodigo(id_emisor);

		if (venEmi != null) {
			em.remove(venEmi);
		}
	}

	// actualizar
	public void actualizarVenEmisor(VenEmisor venEmisor) throws Exception {
		VenEmisor vE = findVenEmisorlByCodigo(venEmisor.getIdEmisor());

		if (vE == null) {
			throw new Exception("No existe el rol especificada.");

		} else {
			em.merge(venEmisor);
		}

	}

}
