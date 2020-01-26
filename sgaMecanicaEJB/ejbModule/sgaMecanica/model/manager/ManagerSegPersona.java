package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import sgaMecanica.model.entities.SegPersona;

/**
 * Session Bean implementation class ManagerSegPersona
 */
@Stateless
@LocalBean
public class ManagerSegPersona {
@PersistenceContext
private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerSegPersona() {
        // TODO Auto-generated constructor stub
    }
    //Mostrar
    public List<SegPersona> findAllSegPersona() {
		String consulta = "select o from SegPersona o";
		Query q = em.createQuery(consulta, SegPersona.class);
		return q.getResultList();

	}
    //insertar
    public void insertarSegPersona(SegPersona segPersona) {

		em.persist(segPersona);
	}
    //Eliminar
    public SegPersona findSegPersonaByCodigo(Integer id_segPersona) {   // busqueda por el codigo
		return em.find(SegPersona.class, id_segPersona);

	}
    public void eliminarSegPersona(Integer id_segPersona) {
    	SegPersona segPersona= findSegPersonaByCodigo(id_segPersona);
		
		if (segPersona!=null) {
			em.remove(segPersona);
		}
	}
    //actualizar
    public void actualizarSegPersona(SegPersona segPersona) throws Exception {
    	SegPersona segPer= findSegPersonaByCodigo(segPersona.getIdPersona());
  		
  		if (segPer == null) {
  			throw new Exception("No existe la persona especificada.");

  		} else {
  			
  		
  			
  			em.merge(segPersona);

  		}

  	}

}
