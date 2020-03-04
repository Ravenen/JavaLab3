package ua.lviv.iot.christmasfair;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.christmasfair.manager.ChristmasFairManager;
import ua.lviv.iot.christmasfair.model.AbstractDecor;
import ua.lviv.iot.christmasfair.model.DecorationType;

class ChristmasFairManagerTest extends BaseChristmasFairTest {

  @BeforeEach
  void setUp() {
    createDecorations();
  }

  @Test
  void testFindDecorationsByType() {
    ChristmasFairManager manager = new ChristmasFairManager(decorations);

    List<AbstractDecor> decorForWorkingPlaceFound = manager
        .findDecorationsByType(EnumSet.of(DecorationType.WORKING_PLACE));
    assertEquals(4, decorForWorkingPlaceFound.size());
    for (AbstractDecor currentDecor : decorForWorkingPlaceFound) {
      assertTrue(currentDecor.getType().contains(DecorationType.WORKING_PLACE));
    }

    List<AbstractDecor> decorForIndoorTreeFound = manager.findDecorationsByType(EnumSet.of(DecorationType.INDOOR_TREE));
    assertEquals(6, decorForIndoorTreeFound.size());
    for (AbstractDecor currentDecor : decorForIndoorTreeFound) {
      assertTrue(currentDecor.getType().contains(DecorationType.INDOOR_TREE));
    }

    List<AbstractDecor> decorForInteriorAndExteriorFound = manager
        .findDecorationsByType(EnumSet.of(DecorationType.HOUSE_EXTERIOR, DecorationType.HOUSE_INTERIOR));
    assertEquals(1, decorForInteriorAndExteriorFound.size());
    for (AbstractDecor currentDecor : decorForInteriorAndExteriorFound) {
      assertTrue(
          currentDecor.getType().containsAll(EnumSet.of(DecorationType.HOUSE_INTERIOR, DecorationType.HOUSE_EXTERIOR)));
    }
  }

}
