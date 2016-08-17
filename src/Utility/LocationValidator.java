package Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationValidator {
	private Pattern pattern;
	private Matcher matcher;

	private static final String LOCATION_WORD = "[A-Za-z0-9]+";

	public LocationValidator() {
		pattern = Pattern.compile(LOCATION_WORD);
	}
	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

}
