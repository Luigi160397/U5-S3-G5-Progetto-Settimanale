package epicode.u5s3g5;

import java.util.List;

public class CentroControlloImpl implements CentroControllo {
	@Override
	public void aggiorna(List<SondaIncendi> sonde) {

		for (SondaIncendi sonda : sonde) {

			int livelloFumo = sonda.getLivelloFumo();
			if (livelloFumo > 5) {

				String url = "http://host/alarm?idsonda=" + sonda.getId() + "&lat=" + sonda.getLatitudine() + "&lon="
						+ sonda.getLongitudine() + "&smokelevel=" + livelloFumo;

				System.out.println("La sonda con id: " + sonda.getId()
						+ " ha rilevato un livello di fumo superiore a 5, URL di allarme: ");
				System.out.println(Colors.ANSI_RED + url);
				System.out.println(Colors.ANSI_RESET
						+ "***************************************************************************************");

			}
		}
	}
}
