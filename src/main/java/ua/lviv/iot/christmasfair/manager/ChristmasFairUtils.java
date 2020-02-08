package ua.lviv.iot.christmasfair.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.christmasfair.model.AbstractDecor;
import ua.lviv.iot.christmasfair.model.SortType;

public class ChristmasFairUtils {
	
	private static Comparator<AbstractDecor> priceComparator = new Comparator<AbstractDecor>() {

		@Override
		public int compare(AbstractDecor firstDecor, AbstractDecor secondDecor) {
			return (int)(firstDecor.getPriceInHryvnas() - secondDecor.getPriceInHryvnas());
		}
	};

	private static Comparator<AbstractDecor> colorComparator = new Comparator<AbstractDecor>() {
		@Override
		public int compare(AbstractDecor firstDecor, AbstractDecor secondDecor) {
			return firstDecor.getColor().compareTo(secondDecor.getColor());
		}
	};

	public static List<AbstractDecor> sortDecorationsByPrice(List<AbstractDecor> decorations, SortType sortType) {
		decorations = ChristmasFairUtils.sortDecorationsBy(decorations, sortType, priceComparator);
		return decorations;
	}

	public static List<AbstractDecor> sortDecorationsByColor(List<AbstractDecor> decorations, SortType sortType) {
		decorations = ChristmasFairUtils.sortDecorationsBy(decorations, sortType, colorComparator);
		return decorations;
	}

	private static List<AbstractDecor> sortDecorationsBy(List<AbstractDecor> decorations, SortType sortType,
			Comparator<AbstractDecor> comparator) {
		decorations.sort(sortType == SortType.ASCENDING ? comparator : Collections.reverseOrder(comparator));
		return decorations;
	}
}
