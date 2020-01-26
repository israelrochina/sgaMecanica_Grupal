package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.entities.InvModelo;
import sgaMecanica.model.entities.SegColaborador;
import sgaMecanica.model.entities.SegPersona;
import sgaMecanica.model.entities.SegRol;

/**
 * Session Bean implementation class ManagerSegColaborador
 */
@Stateless
@LocalBean
public class ManagerSegColaborador {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerSegColaborador() {
		// TODO Auto-generated constructor stub
	}

	public List<SegColaborador> findAllSegColaborador() {
		String consulta = "select o from SegColaborador o";
		Query q = em.createQuery(consulta, SegColaborador.class);
		return q.getResultList();

	}

	// insertar
	public void insertarSegColaborador(SegColaborador segColaborador, Integer idPersona, Integer idRol) {
		SegPersona segPersona = (SegPersona) em.find(SegPersona.class, idPersona);
		segColaborador.setSegPersona(segPersona);

		SegRol segRol = (SegRol) em.find(SegRol.class, idRol);
		segColaborador.setSegRol(segRol);

		segColaborador.setClave(segPersona.getCedulaRuc());
		
		segColaborador.setUsuario(segPersona.getCedulaRuc());
		em.persist(segColaborador);
		
	}

//Eliminar
	public SegColaborador findSegColaboradorByCodigo(Integer id_colaborador) { // busqueda por el codigo
		return em.find(SegColaborador.class, id_colaborador);

	}

	public void eliminarSegColaborador(Integer id_colaborador) {
		SegColaborador segColaborador = findSegColaboradorByCodigo(id_colaborador);

		if (segColaborador != null) {
			em.remove(segColaborador);
		}
	}
	// actualizar

	public void actualizarSegColaborador(SegColaborador segColaborador, Integer id_rol) throws Exception {
		SegColaborador segCol = findSegColaboradorByCodigo(segColaborador.getIdColaborador());

		if (segCol == null) {
			throw new Exception("No existe el modelado especificada.");

		} else {
			SegRol segRol = (SegRol) em.find(SegRol.class, id_rol);
			segColaborador.setSegRol(segRol);

			em.merge(segColaborador);

		}

	}

}
