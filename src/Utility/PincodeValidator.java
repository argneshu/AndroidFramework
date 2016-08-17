package Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PincodeValidator {
	private Pattern pattern;
	private Matcher matcher;

	private static final String PINCODE_PATTERN = ".*[0-9]{6}";

	public PincodeValidator() {
		pattern = Pattern.compile(PINCODE_PATTERN);
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
