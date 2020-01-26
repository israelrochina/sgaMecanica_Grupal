package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvCategoria;
import sgaMecanica.model.entities.InvMarca;
import sgaMecanica.model.entities.InvMarcaproducto;
import sgaMecanica.model.entities.InvModelo;
import sgaMecanica.model.entities.InvProducto;
import sgaMecanica.model.entities.ProProveedor;
import sgaMecanica.model.entities.VenIva;

/**
 * Session Bean implementation class ManagerInvProducto
 */
@Stateless
@LocalBean
public class ManagerInvProducto {
@PersistenceContext
private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerInvProducto() {
        // TODO Auto-generated constructor stub
    }

	public List<InvProducto> findAllInvProducto() {
		String consulta = "select o from InvProducto o";
		Query q = em.createQuery(consulta, InvProducto.class);
		return q.getResultList();

	}

	public InvProducto findInvPoductoByCodigo(String id_producto) {
		return em.find(InvProducto.class,id_producto);

	}
	public void insertarInvProducto(InvProducto invProducto,Integer id_iva,Integer id_marcaproducto, Integer id_categoria,Integer id_modelo,Integer id_proveedor) throws Exception {
		if (findInvPoductoByCodigo(invProducto.getIdProducto())!= null) {
			throw new Exception("Ya existe eL Codigo indicado.");

		}else {
			VenIva venIva=(VenIva) em.find(VenIva.class, id_iva);
			invProducto.setVenIva(venIva);
			
			InvMarcaproducto invMarcaproducto=(InvMarcaproducto) em.find(InvMarcaproducto.class, id_marcaproducto);
			invProducto.setInvMarcaproducto(invMarcaproducto);
			
			InvCategoria invCategoria=(InvCategoria) em.find(InvCategoria.class, id_categoria);
			invProducto.setInvCategoria(invCategoria);
			
			InvModelo invModelo=(InvModelo) em.find(InvModelo.class, id_modelo);
			invProducto.setInvModelo(invModelo);
			
			ProProveedor proProveedor=(ProProveedor) em.find(ProProveedor.class, id_proveedor);
			invProducto.setProProveedor(proProveedor);
			
			em.persist(invProducto);
		}
	
	}
	//Eliminar
	public void eliminarInvProducto(String id_producto) {
		InvProducto invProducto= findInvPoductoByCodigo(id_producto);
		if (invProducto != null) {
			em.remove(invProducto);
		}
	}
	//actualizar
	public void actualizarInvProducto(InvProducto invProducto,Integer id_iva,Integer id_marcaproducto, Integer id_categoria,Integer id_modelo,Integer id_proveedor) throws Exception {
		InvProducto invProd=findInvPoductoByCodigo(invProducto.getIdProducto());
		if (invProd == null) {
			throw new Exception("No existe el producto especificado.");

		} else {
			VenIva venIva=(VenIva) em.find(VenIva.class, id_iva);
			invProducto.setVenIva(venIva);
			
			InvMarcaproducto invMarcaproducto=(InvMarcaproducto) em.find(InvMarcaproducto.class, id_marcaproducto);
			invProducto.setInvMarcaproducto(invMarcaproducto);
			
			InvCategoria invCategoria=(InvCategoria) em.find(InvCategoria.class, id_categoria);
			invProducto.setInvCategoria(invCategoria);
			
			InvModelo invModelo=(InvModelo) em.find(InvModelo.class, id_modelo);
			invProducto.setInvModelo(invModelo);
			
			ProProveedor proProveedor=(ProProveedor) em.find(ProProveedor.class, id_proveedor);
			invProducto.setProProveedor(proProveedor);
			em.merge(invProducto);

		}

	}
}
