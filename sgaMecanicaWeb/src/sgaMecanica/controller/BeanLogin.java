package sgaMecanica.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import sgaMecanica.model.entities.SegColaborador;
import sgaMecanica.model.manager.ManagerLogin;

import java.io.IOException;
import java.io.Serializable;

@Named
@javax.enterprise.context.SessionScoped
public class BeanLogin implements Serializable {

	@EJB
	private ManagerLogin managerLogin;
	List<SegColaborador> listaColaborador;
	String usuario;
	String clave;
	String ruta;

	@PostConstruct
	public void inicializar() {
		System.out.println("Login Inizialalizado");

	}

	public String actionListenerLogin() {
		try {
			managerLogin.accederRuta(usuario, clave);
			return managerLogin.getRuta()+"?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.clearMensajeError(e.getMessage());
			e.printStackTrace();
			return "";
		}
		
	
	}
	
	/////////////////////////

	public void actionVerificarLogin(){
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String requestPath=ec.getRequestPathInfo();
		try {
			//si no paso por login:
			if(managerLogin==null || managerLogin.isEmpty(managerLogin.getRuta())){
				ec.redirect(ec.getRequestContextPath() + "/faces/loginp.xhtml");
			}else{
				//validar las rutas de acceso:
				if(requestPath.contains("/colaborador") && managerLogin.getRuta().startsWith("/colaborador"))
					return;
				if(requestPath.contains("/Duenio") && managerLogin.getRuta().startsWith("/Duenio"))
					return;
				//caso contrario significa que hizo login pero intenta acceder a ruta no permitida:
				ec.redirect(ec.getRequestContextPath() + "/loginp.xhtml");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//////////////////////

	public List<SegColaborador> getListaColaborador() {
		return listaColaborador;
	}

	public void setListaColaborador(List<SegColaborador> listaColaborador) {
		this.listaColaborador = listaColaborador;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String consulta) {
		this.usuario = consulta;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
