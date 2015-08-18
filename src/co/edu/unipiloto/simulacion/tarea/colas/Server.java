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
		client.setSystemTime(client.getDepartureTime()-client.getArrivalTime());
		clientList.add(client);
	}

	public void printResults() {
		double averageServiceTime = 0;
		double averageEnquedTime = 0;
		double leisureTimeServer = 0;
		double averageBetweenArrivalsTime = 0;
		double averageClientSystem = 0;
		double sumServiceTime = 0;
		double sumEnquedTime = 0;
		double sumBaseArrivalTime = 0;
		double sumSystemTime=0;

		System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
				"Cliente #", "T.ent arribos", "T. llegada", "T. inicio",
				"T. servicio", "T. Encolado", "T. salida ", "T.sistema"));
		int clientNumber = 1;
		for (Client client : clientList) {
			System.out.println(String.format(
					"%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s", clientNumber,
					client.getBaseArrivalTime(), client.getArrivalTime(),
					client.getInitServiceTime(), client.getServiceTime(),
					client.getEnquedTime(), client.getDepartureTime(),
					client.getServiceTime(), client.getSystemTime()));

			// Calculate Average service time
			sumServiceTime = (sumServiceTime + client.getServiceTime());
			averageServiceTime = sumServiceTime / clientList.size();

			clientNumber++;

			// Calculate average enqued time
			sumEnquedTime = (sumEnquedTime + client.getEnquedTime());
			averageEnquedTime = (sumEnquedTime / clientList.size());

			// calculate averange between arrivals
			sumBaseArrivalTime = (sumBaseArrivalTime + client
					.getBaseArrivalTime());
			averageBetweenArrivalsTime = (sumBaseArrivalTime / clientList
					.size());

			// Calculate average time of a customer in the system
			sumSystemTime =(sumSystemTime + client.getSystemTime());

		}
		leisureTimeServer = (1 - sumServiceTime
				/ clientList.get(clientList.size() - 1).getDepartureTime());
		
		averageClientSystem = sumSystemTime/clientList.size();


		System.out
				.println(String.format("\nPromedio servicio: %s %s",
						averageServiceTime, "\nPromedio en cola: "
								+ averageEnquedTime));
		System.out.println(String.format(
				"\nTiempo de Ocio del Servidor: %s %s %s", leisureTimeServer
						+ " %", "\nTiempo promedio entre arribos: "
						+ averageBetweenArrivalsTime,
				"\nTiempo promedio de un cliente en el sistema: "
						+ averageClientSystem));

	}
}
