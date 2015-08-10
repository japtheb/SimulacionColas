package co.edu.unipiloto.simulacion.tarea.colas;

public class ColasApp {

	private static final int PROBABILITY_CHANNEL = 8;
	private static final int PROBABILITY_SERVER = 6;
	private static final int SERVICE_TIME = 100;

	public static void main(String[] args) {
		TimeArrivalProbabilityTable timeArrivalProbabilityTableChannel = new TimeArrivalProbabilityTable(
				PROBABILITY_CHANNEL);
		TimeArrivalProbabilityTable timeArrivalProbabilityTableServer = new TimeArrivalProbabilityTable(
				PROBABILITY_SERVER);

		new Simulation(timeArrivalProbabilityTableChannel,
				timeArrivalProbabilityTableServer, SERVICE_TIME).run();
	}

}
