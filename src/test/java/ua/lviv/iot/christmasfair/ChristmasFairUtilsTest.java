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
		double previousPrice = 0;
		for (AbstractDecor currentDecoration : sortedDecorations) {
			if(previousPrice == 0) {
				previousPrice = currentDecoration.getPriceInHryvnas();
			}
			assertTrue(currentDecoration.getPriceInHryvnas() >= previousPrice);
			previousPrice = currentDecoration.getPriceInHryvnas();
		}
	}
	
	@Test
	void testSortDecorationsByPriceDescending() {
		List<AbstractDecor> sortedDecorations = ChristmasFairUtils.sortDecorationsByPrice(decorations, SortType.DESCENDING);
		double previousPrice = 0;
		for (AbstractDecor currentDecoration : sortedDecorations) {
			if(previousPrice == 0) {
				previousPrice = currentDecoration.getPriceInHryvnas();
			}
			assertTrue(currentDecoration.getPriceInHryvnas() <= previousPrice);
			previousPrice = currentDecoration.getPriceInHryvnas();
		}
	}

	@Test
	void testSortDecorationsByColorAscending() {
		List<AbstractDecor> sortedDecorations = ChristmasFairUtils.sortDecorationsByColor(decorations, SortType.ASCENDING);
		char[] previousColor = null;
		char[] currentColor = null;
		for (AbstractDecor currentDecoration : sortedDecorations) {
			if(previousColor == null) {
				previousColor = currentDecoration.getColor().toCharArray();
			}
			currentColor = currentDecoration.getColor().toCharArray();
			
			assertTrue(currentColor[0] >= previousColor[0]);
			previousColor = currentDecoration.getColor().toCharArray();
		}
	}
	
	@Test
	void testSortDecorationsByColorDescending() {
		List<AbstractDecor> sortedDecorations = ChristmasFairUtils.sortDecorationsByColor(decorations, SortType.DESCENDING);
		char[] previousColor = null;
		char[] currentColor = null;
		for (AbstractDecor currentDecoration : sortedDecorations) {
			if(previousColor == null) {
				previousColor = currentDecoration.getColor().toCharArray();
			}
			currentColor = currentDecoration.getColor().toCharArray();
			
			assertTrue(currentColor[0] <= previousColor[0]);
			previousColor = currentDecoration.getColor().toCharArray();
		}
	}

}
