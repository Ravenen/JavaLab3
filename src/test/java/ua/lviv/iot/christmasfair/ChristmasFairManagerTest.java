package ua.lviv.iot.christmasfair;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.christmasfair.manager.ChristmasFairManager;
import ua.lviv.iot.christmasfair.model.AbstractDecor;
import ua.lviv.iot.christmasfair.model.DecorationType;
import ua.lviv.iot.christmasfair.model.Garland;
import ua.lviv.iot.christmasfair.model.Light;
import ua.lviv.iot.christmasfair.model.TreeToy;

class ChristmasFairManagerTest extends BaseChristmasFairTest {

	private List<AbstractDecor> decorForWorkingPlaceExpected = new LinkedList<AbstractDecor>();
	private List<AbstractDecor> decorForIndoorTreeExpected = new LinkedList<AbstractDecor>();
	private List<AbstractDecor> decorForInteriorAndExteriorExpected = new LinkedList<AbstractDecor>();

	private void createDecorationsForWorkingPlace() {
		decorForWorkingPlaceExpected.add(new Light("Blue", 110.0,
				EnumSet.of(DecorationType.DOOR, DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), 260.0, 50));
		decorForWorkingPlaceExpected.add(new TreeToy("Green", 50.25,
				EnumSet.of(DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), "sphere", 20));
		decorForWorkingPlaceExpected.add(new Garland("Yellow", 105.0, EnumSet.of(DecorationType.DOOR,
				DecorationType.HOUSE_INTERIOR, DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), 2.0, false));
		decorForWorkingPlaceExpected.add(new Garland("Yellow-Red", 145.0, EnumSet.of(DecorationType.DOOR,
				DecorationType.HOUSE_INTERIOR, DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), 3.0, true));
	}

	private void createDecorationsForInteriorAndExterior() {
		decorForInteriorAndExteriorExpected.add(new Light("Red", 120.50,
				EnumSet.of(DecorationType.HOUSE_INTERIOR, DecorationType.HOUSE_EXTERIOR, DecorationType.INDOOR_TREE),
				250.0, 20));
	}

	private void createDecorationsForIndoorTree() {
		decorForIndoorTreeExpected.add(new Light("Red", 120.50,
				EnumSet.of(DecorationType.HOUSE_INTERIOR, DecorationType.HOUSE_EXTERIOR, DecorationType.INDOOR_TREE),
				250.0, 20));
		decorForIndoorTreeExpected.add(new Light("Blue", 110.0,
				EnumSet.of(DecorationType.DOOR, DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), 260.0, 50));
		decorForIndoorTreeExpected.add(new TreeToy("Green", 50.25,
				EnumSet.of(DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), "sphere", 20));
		decorForIndoorTreeExpected
				.add(new TreeToy("Red", 75.0, EnumSet.of(DecorationType.INDOOR_TREE), "Santa Clause", 15));
		decorForIndoorTreeExpected.add(new Garland("Yellow", 105.0, EnumSet.of(DecorationType.DOOR,
				DecorationType.HOUSE_INTERIOR, DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), 2.0, false));
		decorForIndoorTreeExpected.add(new Garland("Yellow-Red", 145.0, EnumSet.of(DecorationType.DOOR,
				DecorationType.HOUSE_INTERIOR, DecorationType.INDOOR_TREE, DecorationType.WORKING_PLACE), 3.0, true));
	}

	@BeforeEach
	void setUp() throws Exception {
		createDecorations();
		createDecorationsForWorkingPlace();
		createDecorationsForIndoorTree();
		createDecorationsForInteriorAndExterior();
	}

	@Test
	void testFindDecorationsByType() {
		ChristmasFairManager manager = new ChristmasFairManager(decorations);

		List<AbstractDecor> decorForWorkingPlaceFound = manager
				.findDecorationsByType(EnumSet.of(DecorationType.WORKING_PLACE));
		assertEquals(decorForWorkingPlaceExpected, decorForWorkingPlaceFound);

		List<AbstractDecor> decorForIndoorTreeFound = manager
				.findDecorationsByType(EnumSet.of(DecorationType.INDOOR_TREE));
		assertEquals(decorForIndoorTreeExpected, decorForIndoorTreeFound);

		List<AbstractDecor> decorForInteriorAndExteriorFound = manager
				.findDecorationsByType(EnumSet.of(DecorationType.HOUSE_EXTERIOR, DecorationType.HOUSE_INTERIOR));
		assertEquals(decorForInteriorAndExteriorExpected, decorForInteriorAndExteriorFound);
	}

}
