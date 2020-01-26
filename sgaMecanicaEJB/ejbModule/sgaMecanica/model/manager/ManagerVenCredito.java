package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.entities.VenCredito;
import sgaMecanica.model.entities.VenDetalle;

/**
 * Session Bean implementation class ManagerVenCredito
 */
@Stateless
@LocalBean
public class ManagerVenCredito {
	@PersistenceContext
	private EntityManager em;
	    
    /**
     * Default constructor. 
     */
    public ManagerVenCredito() {
        // TODO Auto-generated constructor stub
    }
    
    public List<VenCredito> findAllVenCredito(){
    	String consulta="select o from VenCredito o";
    	Query q=em.createQuery(consulta,VenCredito.class);
    	return q.getResultList();    	
    }
    
    //insertar
    public VenCredito findVenCreditoByCodigo(Integer codigo) {   // busqueda por el codigo
		return em.find(VenCredito.class, codigo);
	}
    
    public void insertarvenCredito(VenCredito venCredito) throws Exception  {
		em.persist(venCredito);
	}

	public List<VenDetalle> findAllVenDetalle() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
