package pl.stepniewski.kata.loadBalancerKataMto;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {

	private static final double EPSILON = 0.01d;
	private double expectedLoadPercentage;

	public CurrentLoadPercentageMatcher(double expectedLoadPercentage) {
		this.expectedLoadPercentage = expectedLoadPercentage;
	}

	public void describeTo(Description description) {
		description.appendText("a server with load percentage of ")
				.appendValue(expectedLoadPercentage);

	}

	@Override
	protected void describeMismatchSafely(Server item, Description description) {
		description.appendText("a server with load percentage of ")
				.appendValue(item.getCurrentLoadPecentage());
	}

	@Override
	protected boolean matchesSafely(Server server) {
		return equalsDouble(server.getCurrentLoadPecentage(), expectedLoadPercentage);
	}

	private boolean equalsDouble(double d1, double d2) {
		return Math.abs(d1 - d2) < EPSILON;
	}

	public static CurrentLoadPercentageMatcher hasLoadPercentageOf(
			double expectedLoadPercentage) {
		return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
	}

}
