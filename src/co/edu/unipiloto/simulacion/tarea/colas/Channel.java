package co.edu.unipiloto.simulacion.tarea.colas;

import java.util.Random;

public class Channel {

	private final TimeArrivalProbabilityTable timeArrivalProbabilityTableChannel;
	private int actualTime = 0;

	public Channel(
			TimeArrivalProbabilityTable timeArrivalProbabilityTableChannel) {
		this.timeArrivalProbabilityTableChannel = timeArrivalProbabilityTableChannel;
	}

	public int getNext() {
		int random = timeArrivalProbabilityTableChannel.getRandomTime();
		actualTime += random;
		return actualTime;
	}
}
