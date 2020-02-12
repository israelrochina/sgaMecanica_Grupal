package sgaMecanica.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sgaMecanica.model.entities.Auditoria;
import sgaMecanica.model.manager.ManagerAuditoria;


@Named
@SessionScoped

public class BeanAuditoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagerAuditoria managerAuditoria;
	private List<Auditoria> listaAuditoria;
	private Auditoria nuevoAuditor;
	
	@PostConstruct
	public void inicializar() {
		listaAuditoria = managerAuditoria.findAllAuditoria();
		nuevoAuditor= new Auditoria();
	}

	public List<Auditoria> getListaAuditoria() {
		return listaAuditoria;
	}

	public void setListaAuditoria(List<Auditoria> listaAuditoria) {
		this.listaAuditoria = listaAuditoria;
	}

	public Auditoria getNuevoAuditor() {
		return nuevoAuditor;
	}

	public void setNuevoAuditor(Auditoria nuevoAuditor) {
		this.nuevoAuditor = nuevoAuditor;
	}
	
	
	
	
	
	
	
	
	

	
}
