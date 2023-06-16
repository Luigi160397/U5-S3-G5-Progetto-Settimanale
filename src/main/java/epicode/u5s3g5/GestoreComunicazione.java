package epicode.u5s3g5;

import java.util.ArrayList;
import java.util.List;

public class GestoreComunicazione implements RilevatoreIncendi {
	private List<CentroControllo> osservatori;
	private List<SondaIncendi> sonde;

	public GestoreComunicazione(List<SondaIncendi> sonde) {
		this.osservatori = new ArrayList<>();
		this.sonde = sonde;
	}

	@Override
	public void aggiungiOsservatore(CentroControllo osservatore) {
		osservatori.add(osservatore);
	}

	@Override
	public void rimuoviOsservatore(CentroControllo osservatore) {
		osservatori.remove(osservatore);
	}

	@Override
	public void notificaOsservatori() {
		for (CentroControllo osservatore : osservatori) {
			List<SondaIncendi> sondeConIncendio = new ArrayList<>();
			for (SondaIncendi sonda : sonde) {
				if (sonda.getLivelloFumo() > 5) {
					sondeConIncendio.add(sonda);
				}
			}
			osservatore.aggiorna(sondeConIncendio);
		}
	}

	public void rilevaIncendio() {

		notificaOsservatori();
	}
}