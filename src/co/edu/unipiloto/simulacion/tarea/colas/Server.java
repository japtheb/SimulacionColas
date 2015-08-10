package co.edu.unipiloto.simulacion.tarea.colas;

import java.util.ArrayList;
import java.util.List;

public class Server {

	private final TimeArrivalProbabilityTable timeArrivalProbabilityTableChannel;
	private List<Client> clientList = new ArrayList<Client>();

	public Server(TimeArrivalProbabilityTable timeArrivalProbabilityTableChannel) {
		this.timeArrivalProbabilityTableChannel = timeArrivalProbabilityTableChannel;
	}

	public void add(Client client) {
		client.setServiceTime(timeArrivalProbabilityTableChannel
				.getRandomTime());

		if (clientList.size() == 0) { // the client does not needs to wait
			client.setInitServiceTime(client.getArrivalTime());
		} else { // the client needs to wait
			int clientInitServiceTime = Math.max(
					clientList.get(clientList.size() - 1).getDepartureTime(),
					client.getArrivalTime());
			client.setInitServiceTime(clientInitServiceTime);

		}
		client.setEnquedTime(client.getInitServiceTime()
				- client.getArrivalTime());
		client.setDepartureTime(client.getArrivalTime()
				+ client.getServiceTime());
		clientList.add(client);
	}

	public void printResults() {
		double averageServiceTime = clientList.get(0).getServiceTime();
		double averageEnquedTime = clientList.get(0).getEnquedTime();

		System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s", "Cliente #",
				"T. llegada", "T. inicio", "T. servicio", "T. Encolado",
				"T. salida"));
		int clientNumber = 1;
		for (Client client : clientList) {
			System.out.println(String.format(
					"%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s", clientNumber,
					client.getArrivalTime(), client.getInitServiceTime(),
					client.getServiceTime(), client.getEnquedTime(),
					client.getDepartureTime()));

			averageServiceTime = (averageServiceTime + client.getServiceTime()) / 2;

			clientNumber++;

			averageEnquedTime = (averageEnquedTime + client.getEnquedTime()) / 2;
			clientNumber++;

		}

		System.out.println(String
				.format("\nPromedio servicio: %s %s", averageServiceTime,
						"\nPromedio en cola:", averageEnquedTime));
	}

}
