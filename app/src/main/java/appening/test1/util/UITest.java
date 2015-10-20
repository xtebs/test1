package appening.test1.util;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by Ze on 07/10/2015.
 * Mark-up annotation to indicate a given method exists only for UI testing purposes and should be removed in production builds
 */
@Retention(CLASS)
@Target({METHOD, PARAMETER, FIELD})
public @interface UITest
{
    //description:
    public String value();
}
