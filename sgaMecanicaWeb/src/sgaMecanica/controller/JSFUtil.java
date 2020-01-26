package sgaMecanica.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

	public static void crearMensajeInfo(String mensaje) {

		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		msg.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public static void crearrMensajeWarning(String mensaje) {

		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_WARN);
		msg.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public static void clearMensajeError(String mensaje) {

		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		msg.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
