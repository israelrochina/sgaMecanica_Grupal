package sgaMecanica.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sgaMecanica.model.entities.InvModelo;
import sgaMecanica.model.entities.SegColaborador;

/**
 * Session Bean implementation class ManagerLogin
 */
@Stateless
@LocalBean
public class ManagerLogin {
	private String ruta;
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerLogin() {
		// TODO Auto-generated constructor stub
	}

	public List<SegColaborador> consultaUsuario(String usuario) {
		String consulta = "select o from SegColaborador o where o.usuario=" + "'" + usuario + "'";
		return em.createQuery(consulta, SegColaborador.class).getResultList();

	}

	public void accederRuta(String usuario, String clave) throws Exception {
		if (consultaUsuario(usuario).size() != 0) {
			SegColaborador segColaborador = consultaUsuario(usuario).get(0);
			if (segColaborador.getClave().equals(clave)) {
				if (segColaborador.getSegRol().getNombre().equals("Dueño")) {
					System.out.println("Dueño");
					ruta = "/Duenio/invmarca.xhtml";
				} else if (segColaborador.getSegRol().getNombre().equals("Colaborador")) {
					System.out.println("Colaborador");
					ruta = "/colaborador/invproductoc.xhtml";
				}
			} else {
				throw new Exception("El usuario o contraseña incorrectas.");
			}
		} else {
			throw new Exception("El usuario o contraseña incorrecta.");
		}

	}

	public static boolean isEmpty(String cadena) {
		if (cadena == null || cadena.length() == 0)
			return true;
		return false;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	///////// obetener id
	public Integer obtenerId(String usuario)  {
		
			SegColaborador segColaborador = consultaUsuario(usuario).get(0);
	return segColaborador.getIdColaborador();
	}
}
