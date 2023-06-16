package epicode.u5s3g5;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GestioneIncendiRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		SondaIncendi sonda = SondaFactory.creaSonda(1, 45.678, 9.123);
		SondaIncendi sonda1 = SondaFactory.creaSonda(2, 48.678, 7.123);
		CentroControllo centroControllo = new CentroControlloImpl();
		CentroControllo centroControllo1 = new CentroControlloImpl();

		GestoreComunicazione gestoreComunicazione = new GestoreComunicazione(List.of(sonda, sonda1));
		gestoreComunicazione.aggiungiOsservatore(centroControllo);
		gestoreComunicazione.aggiungiOsservatore(centroControllo1);

		gestoreComunicazione.rilevaIncendio();

	}

}
