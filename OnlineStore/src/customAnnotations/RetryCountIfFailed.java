/**
 * 
 */
package customAnnotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author v-victw
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RetryCountIfFailed {
	int value() default 0;
}
