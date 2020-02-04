package ua.lviv.iot.christmasfair;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.christmasfair.model.AbstractDecor;
import ua.lviv.iot.christmasfair.model.DecorationType;
import ua.lviv.iot.christmasfair.model.Garland;
import ua.lviv.iot.christmasfair.model.Light;
import ua.lviv.iot.christmasfair.model.TreeToy;

abstract public class BaseChristmasFairTest {
	protected List<AbstractDecor> decorations = new LinkedList<AbstractDecor>();

	public void createDecorations() {
		decorations.add(new Light("Red", 120.50,
				EnumSet.of(DecorationType.HOUSE_INTERIOR, DecorationType.HOUSE_EXTERIOR, DecorationType.INDOOR_TREE),
				250.0, 20));
		decorations.add(new Light("Blue", 110.0,
				EnumSet.of(DecorationType.DOOR, DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), 260.0, 50));
		decorations.add(new TreeToy("Green", 50.25,
				EnumSet.of(DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), "sphere", 20));
		decorations.add(new TreeToy("Red", 75.0, EnumSet.of(DecorationType.INDOOR_TREE), "Santa Clause", 15));
		decorations.add(new Garland("Yellow", 105.0, EnumSet.of(DecorationType.DOOR, DecorationType.HOUSE_INTERIOR,
				DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), 2.0, false));
		decorations.add(new Garland("Yellow-Red", 145.0, EnumSet.of(DecorationType.DOOR, DecorationType.HOUSE_INTERIOR,
				DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), 3.0, true));
		decorations.add(new Garland("Yellow-Red", 145.0, EnumSet.of(DecorationType.HOUSE_EXTERIOR), 3.0, true));
	}
}
