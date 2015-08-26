package co.edu.unipiloto.simulacion.tarea.colas;

import java.util.Random;

public class TimeArrivalProbabilityTable {

	private final int maxTime;

	private Random randomGenerator;

	public TimeArrivalProbabilityTable(double PROBABILITY_CHANNEL) {
		this.maxTime = (int) (PROBABILITY_CHANNEL - 1);
		this.randomGenerator = new Random();
	}

	public int getRandomTime() {
		if (maxTime == 0) {
			return 1;
		}
		return randomGenerator.nextInt(maxTime) + 1;
	}

}
