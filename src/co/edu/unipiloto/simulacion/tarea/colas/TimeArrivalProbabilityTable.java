package co.edu.unipiloto.simulacion.tarea.colas;

import java.util.Random;

public class TimeArrivalProbabilityTable {

	private final int maxTime;

	private Random randomGenerator;

	public TimeArrivalProbabilityTable(int maxTime) {
		this.maxTime = maxTime - 1;
		this.randomGenerator = new Random();
	}

	public int getRandomTime() {
		return randomGenerator.nextInt(maxTime) + 1;
	}

}
