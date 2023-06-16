package epicode.u5s3g5;

public interface RilevatoreIncendi {
	void aggiungiOsservatore(CentroControllo osservatore);

	void rimuoviOsservatore(CentroControllo osservatore);

	void notificaOsservatori();
}