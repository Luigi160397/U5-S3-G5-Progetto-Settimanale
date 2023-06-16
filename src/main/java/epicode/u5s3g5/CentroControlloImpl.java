package epicode.u5s3g5;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CentroControlloImpl implements CentroControllo {
	private int id;

	@Override
	public void aggiorna(List<SondaIncendi> sonde) {

		for (SondaIncendi sonda : sonde) {

			int livelloFumo = sonda.getLivelloFumo();
			if (livelloFumo > 5) {

				String url = "http://host/alarm?idsonda=" + sonda.getId() + "&lat=" + sonda.getLatitudine() + "&lon="
						+ sonda.getLongitudine() + "&smokelevel=" + livelloFumo;
				System.out.println(Colors.ANSI_CYAN + "Il centro di controllo n° " + this.getId()
						+ " ha ricevuto una segnalazione di incendio da: ");
				System.out.println(Colors.ANSI_GREEN + "La sonda con id: " + sonda.getId()
						+ " ha rilevato un livello di fumo superiore a 5, URL di allarme: ");
				System.out.println(Colors.ANSI_RED + url);
				System.out.println(Colors.ANSI_RESET
						+ "***************************************************************************************");

			}
		}
	}

}
