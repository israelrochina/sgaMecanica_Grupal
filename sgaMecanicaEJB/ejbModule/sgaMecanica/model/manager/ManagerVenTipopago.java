package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.entities.VenTipopago;

/**
 * Session Bean implementation class ManagerVenTipopago
 */
@Stateless
@LocalBean
public class ManagerVenTipopago {
@PersistenceContext
private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerVenTipopago() {
        // TODO Auto-generated constructor stub
    }
    
    
    public List<VenTipopago> findAllVenTipopago(){
    	String consulta="select o from VenTipopago o";
    	Query q=em.createQuery(consulta,VenTipopago.class);
    	return q.getResultList();    	
    }
    
    
  //insertar
    public VenTipopago findVenTipopagoByCodigo(Integer codigo) {   // busqueda por el codigo
		return em.find(VenTipopago.class, codigo);
	}
    
    public void insertarVenTipopago(VenTipopago venTipopago)  {
		em.persist(venTipopago);
	}
    
  //eliminar
    public void eliminarVenTipopago(Integer id) {
		VenTipopago venTipopago =findVenTipopagoByCodigo(id);
		if (venTipopago!=null) {
			em.remove(venTipopago);
		}
	}
    
  //actualizar
  	public void actualizarVenTipopago(VenTipopago venTipopago) throws Exception {
  		VenTipopago venTP=findVenTipopagoByCodigo(venTipopago.getIdTipopago());
  		if (venTP==null) {
  			throw new Exception("No existe la marca especificada.");
  		}
  		venTP.setNombre(venTipopago.getNombre());
  		
  		em.merge(venTP);
  	}
    

}
