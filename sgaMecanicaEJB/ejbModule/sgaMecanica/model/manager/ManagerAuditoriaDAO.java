package sgaMecanica.model.manager;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.Auditoria;

/**
 * Session Bean implementation class ManagerAuditoriaDAO
 */
@Stateless
@LocalBean
public class ManagerAuditoriaDAO {
@PersistenceContext
private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerAuditoriaDAO() {
        // TODO Auto-generated constructor stub
    }

    public void crearEvento(Integer idColaborador,Class clase,String metodo,String descripcion) throws Exception{
		Auditoria evento= new Auditoria();
		//cambio para probar git
		
		if(idColaborador==null||idColaborador==0)
			throw new Exception("Error auditoria: debe indicar el codigo del usuario.");
		if(metodo==null||metodo.length()==0)
			throw new Exception("Error auditoria: debe indicar el metodo que genera el evento.");
        if (clase==null)
        	throw new Exception("No se puede insertar un objeto null.");
        
		
		evento.setFechaEvento(new Date());
		evento.setMetodo(clase.getSimpleName()+"/"+metodo);
		evento.setDescripcion(descripcion);
		evento.setDireccionIp("localhost");
		evento.setIdColaborador(idColaborador);
		em.persist(evento);
	}
}
