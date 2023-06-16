package epicode.u5s3g5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class U5S3G5ApplicationTests {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testNotificaCentroControllo() {
		SondaIncendi sonda = SondaFactory.creaSonda(1, 45.678, 9.123);
		CentroControllo centroControllo = new CentroControlloImpl();

		GestoreComunicazione gestoreComunicazione = new GestoreComunicazione(List.of(sonda));
		gestoreComunicazione.aggiungiOsservatore(centroControllo);

		gestoreComunicazione.rilevaIncendio();
	}

	@Test
	void testInvocazioneURL() {

		SondaIncendi sonda1 = SondaFactory.creaSonda(2, 48.678, 7.123);
		CentroControllo centroControllo = new CentroControlloImpl();

		GestoreComunicazione gestoreComunicazione = new GestoreComunicazione(List.of(sonda1));
		gestoreComunicazione.aggiungiOsservatore(centroControllo);

		gestoreComunicazione.rilevaIncendio();

		String expectedUrl = "http://host/alarm?idsonda=2&lat=48.678&lon=7.123&smokelevel=6";

		assertTrue(outputStreamCaptor.toString().replaceAll("\\r?\\n", "").contains(expectedUrl));
	}

}
