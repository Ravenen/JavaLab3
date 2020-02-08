package ua.lviv.iot.christmasfair;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.christmasfair.manager.ChristmasFairUtils;
import ua.lviv.iot.christmasfair.model.AbstractDecor;
import ua.lviv.iot.christmasfair.model.SortType;

class ChristmasFairUtilsTest extends BaseChristmasFairTest {

	@BeforeEach
	void setUp() throws Exception {
		createDecorations();
	}

	@Test
	void testSortDecorationsByPriceAscending() {	
		List<AbstractDecor> sortedDecorations = ChristmasFairUtils.sortDecorationsByPrice(decorations, SortType.ASCENDING);
		assertEquals(50.25, sortedDecorations.get(0).getPriceInHryvnas());
		assertEquals(75.0, sortedDecorations.get(1).getPriceInHryvnas());
		assertEquals(105.0, sortedDecorations.get(2).getPriceInHryvnas());
		assertEquals(110.0, sortedDecorations.get(3).getPriceInHryvnas());
		assertEquals(120.50, sortedDecorations.get(4).getPriceInHryvnas());
		assertEquals(145.0, sortedDecorations.get(5).getPriceInHryvnas());
		assertEquals(145.0, sortedDecorations.get(6).getPriceInHryvnas());
	}
	
	@Test
	void testSortDecorationsByPriceDescending() {
		List<AbstractDecor> sortedDecorations = ChristmasFairUtils.sortDecorationsByPrice(decorations, SortType.DESCENDING);
		assertEquals(145.0, sortedDecorations.get(0).getPriceInHryvnas());
		assertEquals(145.0, sortedDecorations.get(1).getPriceInHryvnas());
		assertEquals(120.50, sortedDecorations.get(2).getPriceInHryvnas());
		assertEquals(110.0, sortedDecorations.get(3).getPriceInHryvnas());
		assertEquals(105.0, sortedDecorations.get(4).getPriceInHryvnas());
		assertEquals(75.0, sortedDecorations.get(5).getPriceInHryvnas());
		assertEquals(50.25, sortedDecorations.get(6).getPriceInHryvnas());
	}

	@Test
	void testSortDecorationsByColorAscending() {
		List<AbstractDecor> sortedDecorations = ChristmasFairUtils.sortDecorationsByColor(decorations, SortType.ASCENDING);
		assertEquals("Blue", sortedDecorations.get(0).getColor());
		assertEquals("Green", sortedDecorations.get(1).getColor());
		assertEquals("Red", sortedDecorations.get(2).getColor());
		assertEquals("Red", sortedDecorations.get(3).getColor());
		assertEquals("Yellow", sortedDecorations.get(4).getColor());
		assertEquals("Yellow-Red", sortedDecorations.get(5).getColor());
		assertEquals("Yellow-Red", sortedDecorations.get(6).getColor());
	}
	
	@Test
	void testSortDecorationsByColorDescending() {
		List<AbstractDecor> sortedDecorations = ChristmasFairUtils.sortDecorationsByColor(decorations, SortType.DESCENDING);
		assertEquals("Yellow-Red", sortedDecorations.get(0).getColor());
		assertEquals("Yellow-Red", sortedDecorations.get(1).getColor());
		assertEquals("Yellow", sortedDecorations.get(2).getColor());
		assertEquals("Red", sortedDecorations.get(3).getColor());
		assertEquals("Red", sortedDecorations.get(4).getColor());
		assertEquals("Green", sortedDecorations.get(5).getColor());
		assertEquals("Blue", sortedDecorations.get(6).getColor());
	}

}
