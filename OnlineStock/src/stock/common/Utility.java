package stock.common;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * @author arullap
 *
 */
public final class Utility {
	/**
	 * @author arullap
	 * @param e
	 * @return
	 */
	public static String getExceptionMessageWithStackTrace(Exception e){
		return e.getMessage() + 
				Arrays.asList(e.getStackTrace()).stream().map(Object::toString).collect(Collectors.joining(Constants.NEWLINE_CHAR));
	}
}