package ua.lviv.iot.christmasfair.manager;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.christmasfair.model.AbstractDecor;
import ua.lviv.iot.christmasfair.model.DecorationType;

public class ChristmasFairManager {
	private List<AbstractDecor> decorations;

	public List<AbstractDecor> getDecorations() {
		return decorations;
	}

	public void setDecorations(List<AbstractDecor> decorations) {
		this.decorations = decorations;
	}

	public ChristmasFairManager(List<AbstractDecor> decorations) {
		super();
		this.decorations = decorations;
	}

	public List<AbstractDecor> findDecorationsByType(EnumSet<DecorationType> criterion) {
		List<AbstractDecor> foundDecorations = new LinkedList<AbstractDecor>();
		for (AbstractDecor currentDecor : this.decorations) {
			if (currentDecor.checkCriterion(criterion)) {
				foundDecorations.add(currentDecor);
			}
		}
		return foundDecorations;
	}
}
