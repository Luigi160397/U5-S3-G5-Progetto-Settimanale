package epicode.u5s3g5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SondaIncendi {
	private int id;
	private double latitudine;
	private double longitudine;
	private int livelloFumo;

	public SondaIncendi(int id, double latitudine, double longitudine) {
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = 0;
	}

}