package ua.lviv.iot.christmasfair.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.christmasfair.model.AbstractDecor;
import ua.lviv.iot.christmasfair.model.SortType;

public class ChristmasFairUtils {

	public static List<AbstractDecor> sortDecorationsByPrice(List<AbstractDecor> decorations, SortType sortType) {
		decorations = ChristmasFairUtils.sortDecorationsBy(decorations, sortType, AbstractDecor.priceComparator);
		return decorations;
	}

	public static List<AbstractDecor> sortDecorationsByColor(List<AbstractDecor> decorations, SortType sortType) {
		decorations = ChristmasFairUtils.sortDecorationsBy(decorations, sortType, AbstractDecor.colorComparator);
		return decorations;
	}

	private static List<AbstractDecor> sortDecorationsBy(List<AbstractDecor> decorations, SortType sortType,
			Comparator<AbstractDecor> comparator) {
		if (sortType == SortType.ASCENDING) {
			decorations.sort(comparator);
		} else if (sortType == SortType.DESCENDING) {
			decorations.sort(Collections.reverseOrder(comparator));
		}
		return decorations;
	}
}
