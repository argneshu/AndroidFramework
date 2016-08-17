package Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductDescValidator{
	private Matcher matcher;
	private Pattern pattern;
	
	public static final String PRODUCT_DESCRIPTION_PATTERN="[^\\s+[A-Za-z,;'\"\\s]+[.?!]$]+";
	
	public ProductDescValidator(){
		  pattern = Pattern.compile(PRODUCT_DESCRIPTION_PATTERN);
	  }
	
	public boolean validate(final String product_description)
	{	  
		  matcher = pattern.matcher(product_description);
		  return matcher.matches();    	    
	}
}
