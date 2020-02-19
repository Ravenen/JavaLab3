package ua.lviv.iot.christmasfair.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.christmasfair.model.AbstractDecor;
import ua.lviv.iot.christmasfair.model.SortType;

public class ChristmasFairUtils {

	public static List<AbstractDecor> sortDecorationsByPrice(List<AbstractDecor> decorations, SortType sortType) {
		Comparator<AbstractDecor> comparator = new PriceComparator();
		return sortDecorationsBy(decorations, sortType, comparator);
	}

	public static List<AbstractDecor> sortDecorationsByColor(List<AbstractDecor> decorations, SortType sortType) {
		Comparator<AbstractDecor> comparator = (new ChristmasFairUtils()).new ColorComparator();
		return sortDecorationsBy(decorations, sortType, comparator);
	}

	public static List<AbstractDecor> sortDecorationsByProducer(List<AbstractDecor> decorations, SortType sortType) {
		ChristmasFairUtils utils = new ChristmasFairUtils();
		Comparator<AbstractDecor> comparator = utils.producerComparator;
		return sortDecorationsBy(decorations, sortType, comparator);
	}

	public static List<AbstractDecor> sortDecorationsByYearOfProduction(List<AbstractDecor> decorations,
			SortType sortType) {
		Comparator<AbstractDecor> comparator = (AbstractDecor firstDecor,
				AbstractDecor secondDecor) -> firstDecor.getYearOfProduction() - secondDecor.getYearOfProduction();
		return sortDecorationsBy(decorations, sortType, comparator);
	}

	private static List<AbstractDecor> sortDecorationsBy(List<AbstractDecor> decorations, SortType sortType,
			Comparator<AbstractDecor> comparator) {
		decorations.sort(sortType == SortType.ASCENDING ? comparator : Collections.reverseOrder(comparator));
		return decorations;
	}

	private Comparator<AbstractDecor> producerComparator = new Comparator<AbstractDecor>() {
		@Override
		public int compare(AbstractDecor firstDecor, AbstractDecor secondDecor) {
			return firstDecor.getProducer().compareTo(secondDecor.getProducer());
		}

	};

	private static class PriceComparator implements Comparator<AbstractDecor> {
		@Override
		public int compare(AbstractDecor firstDecor, AbstractDecor secondDecor) {
			return (int) (firstDecor.getPriceInHryvnas() - secondDecor.getPriceInHryvnas());
		}
	};

	private class ColorComparator implements Comparator<AbstractDecor> {
		@Override
		public int compare(AbstractDecor firstDecor, AbstractDecor secondDecor) {
			return firstDecor.getColor().compareTo(secondDecor.getColor());
		}
	};
}
