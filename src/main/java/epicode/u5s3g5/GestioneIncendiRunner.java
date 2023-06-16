package epicode.u5s3g5;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GestioneIncendiRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		SondaIncendi sonda1 = SondaFactory.creaSonda(1, 45.678, 9.123);
		SondaIncendi sonda2 = SondaFactory.creaSonda(2, 48.678, 7.123);
		SondaIncendi sonda3 = SondaFactory.creaSonda(3, 50.649, 10.143);
		CentroControllo centroControllo1 = new CentroControlloImpl(1);
		CentroControllo centroControllo2 = new CentroControlloImpl(2);

		GestoreComunicazione gestoreComunicazione = new GestoreComunicazione(List.of(sonda1, sonda2));
		gestoreComunicazione.aggiungiOsservatore(centroControllo1);
		GestoreComunicazione gestoreComunicazione2 = new GestoreComunicazione(List.of(sonda3));
		gestoreComunicazione2.aggiungiOsservatore(centroControllo2);
		sonda1.setLivelloFumo(6);
		sonda2.setLivelloFumo(6);
		sonda3.setLivelloFumo(6);

		gestoreComunicazione.rilevaIncendio();
		gestoreComunicazione2.rilevaIncendio();

	}

}
