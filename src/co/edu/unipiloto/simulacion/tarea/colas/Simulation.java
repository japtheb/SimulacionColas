package co.edu.unipiloto.simulacion.tarea.colas;

public class Simulation implements Runnable {

	private final Channel channel;
	private final Server server;
	private final int serviceTime;

	private int simulationTime = 0;
	
	public Simulation(
			TimeArrivalProbabilityTable timeArrivalProbabilityTableChannel,
			TimeArrivalProbabilityTable timeArrivalProbabilityTableServer,
			int serviceTime) {
		this.serviceTime = serviceTime;
		simulationTime = 0;
		this.channel = new Channel(timeArrivalProbabilityTableChannel);
		this.server = new Server(timeArrivalProbabilityTableServer);
	}

	@Override
	public void run() {
		while (simulationTime < serviceTime) {
			Client client = new Client();
			int nextTime = channel.getNext();
			simulationTime = simulationTime + nextTime;
			client.setArrivalTime(simulationTime);
			client.setBaseArrivalTime(nextTime);
			server.add(client);
		}
		server.printResults();
	}

}
