package epicode.u5s3g5;

public class SondaFactory {
	public static SondaIncendi creaSonda(int id, double latitudine, double longitudine) {
		return new SondaIncendi(id, latitudine, longitudine);
	}
}