package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.entities.InvModelo;
import sgaMecanica.model.entities.ProProveedor;
import sgaMecanica.model.entities.SegPersona;

/**
 * Session Bean implementation class ManagerProProveedor
 */
@Stateless
@LocalBean
public class ManagerProProveedor {
@PersistenceContext
private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerProProveedor() {
        // TODO Auto-generated constructor stub
    }
    //Mostrar
    public List<ProProveedor> findAllProProveedor(){
    	String consulta="select o from ProProveedor o";
    	Query q=em.createQuery(consulta,ProProveedor.class);
    	return q.getResultList();
    	
    }
    //INsertar
    public void insertarProProveedor(ProProveedor proproveedor, Integer id_persona) {
		SegPersona segPersona = (SegPersona) em.find(SegPersona.class,id_persona);
		proproveedor.setSegPersona(segPersona);
		
		em.persist(proproveedor);

	}
    // Eliminar 
    public ProProveedor findProProveedorBycodigo(Integer id_proveedor) { // busqueda por el codigo
		return em.find(ProProveedor.class, id_proveedor);

	}
    public void eliminarProProveedor(Integer id) {
		ProProveedor proProveedor = findProProveedorBycodigo(id);
		if (proProveedor != null) {
			em.remove(proProveedor);
		}
	}
    // actualizar
    public void actualizarProProveedor(ProProveedor proProveedor, Integer id_persona) throws Exception {
		ProProveedor proProo= findProProveedorBycodigo(proProveedor.getIdProveedor());
		if (proProo == null) {
			throw new Exception("No existe el Proveedor especificada.");

		} else {
			SegPersona segPersona= (SegPersona) em.find(SegPersona.class,id_persona);
			proProveedor.setSegPersona(segPersona);
		
			
			em.merge(proProveedor);

		}

	}


}
