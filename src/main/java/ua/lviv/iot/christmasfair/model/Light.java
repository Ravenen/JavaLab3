package ua.lviv.iot.christmasfair.model;

import java.util.EnumSet;

public class Light extends AbstractDecor {
	private double maxVoltage;
	private int numberOfBulbs;

	public Light(String color, double priceInHryvnas, EnumSet<DecorationType> type, double maxVoltage,
			int numberOfBulbs) {
		super(color, priceInHryvnas, type);
		this.maxVoltage = maxVoltage;
		this.numberOfBulbs = numberOfBulbs;
	}

	public double getMaxVoltage() {
		return maxVoltage;
	}

	public void setMaxVoltage(double maxVoltage) {
		this.maxVoltage = maxVoltage;
	}

	public int getNumberOfBulbs() {
		return numberOfBulbs;
	}

	public void setNumberOfBulbs(int numberOfBulbs) {
		this.numberOfBulbs = numberOfBulbs;
	}

	@Override
	public String toString() {
		return "Light [maxVoltage=" + maxVoltage + ", numberOfBulbs=" + numberOfBulbs + ", color=" + color
				+ ", priceInHryvnas=" + priceInHryvnas + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(maxVoltage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberOfBulbs;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Light other = (Light) obj;
		if (Double.doubleToLongBits(maxVoltage) != Double.doubleToLongBits(other.maxVoltage))
			return false;
		if (numberOfBulbs != other.numberOfBulbs)
			return false;
		return true;
	}

}
