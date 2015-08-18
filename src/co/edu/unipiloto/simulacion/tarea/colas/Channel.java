package co.edu.unipiloto.simulacion.tarea.colas;

public class Channel {

	private final TimeArrivalProbabilityTable timeArrivalProbabilityTableChannel;

	public Channel(
			TimeArrivalProbabilityTable timeArrivalProbabilityTableChannel) {
		this.timeArrivalProbabilityTableChannel = timeArrivalProbabilityTableChannel;
	}

	public int getNext() {
		return timeArrivalProbabilityTableChannel.getRandomTime();
	}
}
