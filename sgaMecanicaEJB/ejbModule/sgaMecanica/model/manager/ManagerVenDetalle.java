package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.entities.VenDetalle;

/**
 * Session Bean implementation class ManegerVenDetalle
 */
@Stateless
@LocalBean
public class ManagerVenDetalle {

@PersistenceContext
private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerVenDetalle() {
        // TODO Auto-generated constructor stub
    }
    
    
    public List<VenDetalle> findAllVenDetalle(){
    	String consulta="select o from VenDetalle o";
    	Query q=em.createQuery(consulta,VenDetalle.class);
    	return q.getResultList();
    }
    
    public List<VenDetalle> findSelectVenDetalle(String f){
    	
    	String consulta="select o from VenDetalle o where o.id_factura= "+f;
    	Query q=em.createQuery(consulta,VenDetalle.class);
    	return q.getResultList();
    }
    
    
    
    

}
