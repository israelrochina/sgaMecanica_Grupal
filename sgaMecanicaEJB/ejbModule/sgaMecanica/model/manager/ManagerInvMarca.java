package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import sgaMecanica.model.entities.InvMarca;

/**
 * Session Bean implementation class ManejarMecanica
 */
@Stateless
@LocalBean
public class ManagerInvMarca {
@PersistenceContext
private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerInvMarca() {
        // TODO Auto-generated constructor stub
    }
    
    public List<InvMarca> findAllInvMarca(){
    	String consulta="select o from InvMarca o";
    	Query q=em.createQuery(consulta,InvMarca.class);
    	return q.getResultList();
    	
    }
    
    //insertar
    public InvMarca findInvMarcaByCodigo(Integer codigo) {   // busqueda por el codigo
		return em.find(InvMarca.class, codigo);
	}
    
    public void insertarinvMarca(InvMarca invMarca) throws Exception  {
		em.persist(invMarca);
	}
    
    //eliminar
    public void eliminarInvMarca(Integer id) {
		InvMarca invMarca=findInvMarcaByCodigo(id);
		if (invMarca!=null) {
			em.remove(invMarca);
		}
	}
    
    //actualizar
	public void actualizarInvMarca(InvMarca invMarca) throws Exception {
		InvMarca invM=findInvMarcaByCodigo(invMarca.getIdMarca());
		if (invM==null) {
			throw new Exception("No existe la marca especificada.");
			
		}
		invM.setNombre(invMarca.getNombre());
		
		em.merge(invM);
	}
	
	
}
