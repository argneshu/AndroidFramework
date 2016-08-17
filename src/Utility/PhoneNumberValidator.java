package Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
	
	private Pattern pattern;
	private Matcher matcher;
	
	public static final String PHONE_NUMBER="[0-9]{10}";
	
	public PhoneNumberValidator() {
		pattern = Pattern.compile(PHONE_NUMBER);
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
