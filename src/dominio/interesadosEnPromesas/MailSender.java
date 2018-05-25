package dominio.interesadosEnPromesas;

import dominio.Candidato;
import dominio.Promesa;
import externo.MailSenderPosta;

public class MailSender implements InteresadoEnPromesa {

	private String textoDelMail;
	
	@Override
	public void onPromesaCumplida(Candidato candidato, Promesa promesa) {

		if(candidato.getZona().toString().equals("Shelbyville"))
			
			MailSenderPosta.enviarMail("gustavo.rabuffetti@administrador.com.ar", textoDelMail);
	}	
}