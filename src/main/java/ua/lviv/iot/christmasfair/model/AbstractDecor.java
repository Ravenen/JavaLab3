package ua.lviv.iot.christmasfair.model;

import java.util.Comparator;
import java.util.EnumSet;

public abstract class AbstractDecor {
	protected String color;
	protected double priceInHryvnas;
	protected EnumSet<DecorationType> type;

	public AbstractDecor(String color, double priceInHryvnas, EnumSet<DecorationType> type) {
		super();
		this.color = color;
		this.priceInHryvnas = priceInHryvnas;
		this.type = type;
	}

	public boolean checkCriterion(EnumSet<DecorationType> criterion) {
		return this.type.containsAll(criterion);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPriceInHryvnas() {
		return priceInHryvnas;
	}

	public void setPriceInHryvnas(double priceInHryvnas) {
		this.priceInHryvnas = priceInHryvnas;
	}

	public EnumSet<DecorationType> getType() {
		return type;
	}

	public void setType(EnumSet<DecorationType> type) {
		this.type = type;
	}

	public static Comparator<AbstractDecor> priceComparator = new Comparator<AbstractDecor>() {

		@Override
		public int compare(AbstractDecor firstDecor, AbstractDecor secondDecor) {
			return (firstDecor.priceInHryvnas < secondDecor.priceInHryvnas) ? -1
					: (firstDecor.priceInHryvnas == secondDecor.priceInHryvnas) ? 0 : 1;
		}
	};

	public static Comparator<AbstractDecor> colorComparator = new Comparator<AbstractDecor>() {
		@Override
		public int compare(AbstractDecor firstDecor, AbstractDecor secondDecor) {
			return firstDecor.color.compareTo(secondDecor.color);
		}
	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceInHryvnas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractDecor other = (AbstractDecor) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(priceInHryvnas) != Double.doubleToLongBits(other.priceInHryvnas))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
