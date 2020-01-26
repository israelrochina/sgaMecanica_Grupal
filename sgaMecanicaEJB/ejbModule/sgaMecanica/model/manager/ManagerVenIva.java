package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import sgaMecanica.model.entities.VenIva;

/**
 * Session Bean implementation class ManagerVenIva
 */
@Stateless
@LocalBean
public class ManagerVenIva {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerVenIva() {
		// TODO Auto-generated constructor stub
	}

//Mostrar
	public List<VenIva> findAllVenIva() {
		String consulta = "select o from VenIva o";
		Query q = em.createQuery(consulta, VenIva.class);
		return q.getResultList();

	}

	// insertar
	public void insertarVenIva(VenIva venIva) {

		em.persist(venIva);
	}
	// Eliminar

	public VenIva findVenIvaByCodigo(Integer codigo) { // busqueda por el codigo
		return em.find(VenIva.class, codigo);

	}

	public void eliminarVenIva(Integer id_iva) {
		VenIva venIva = findVenIvaByCodigo(id_iva);
		if (venIva != null) {
			em.remove(venIva);
		}
	}

	// actualizar
	public void actualizarVenIva(VenIva venIva) throws Exception {
		VenIva venIv = findVenIvaByCodigo(venIva.getIdIva());
		if (venIv == null) {
			throw new Exception("No existe el Iva especificada.");

		} else {
			venIv.setPorcentaje(venIva.getPorcentaje());

			em.merge(venIv);
		}
	}
}
