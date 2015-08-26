package co.edu.unipiloto.simulacion.tarea.colas;

import javax.swing.JOptionPane;

public class ColasApp {

	public static void main(String[] args) {
		int PROBABILITY_CHANNEL = Integer.parseInt(JOptionPane
				.showInputDialog("Probabilidad canal"));
		int PROBABILITY_SERVER = Integer.parseInt(JOptionPane
				.showInputDialog("Probabilidad servidor"));
		int SERVICE_TIME = Integer.parseInt(JOptionPane
				.showInputDialog("Tiempo de servicio"));

		TimeArrivalProbabilityTable timeArrivalProbabilityTableChannel = new TimeArrivalProbabilityTable(
				PROBABILITY_CHANNEL);
		TimeArrivalProbabilityTable timeArrivalProbabilityTableServer = new TimeArrivalProbabilityTable(
				PROBABILITY_SERVER);

		new Simulation(timeArrivalProbabilityTableChannel,
				timeArrivalProbabilityTableServer, SERVICE_TIME).run();
	}

}
