package io.github.safouenbez.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({
    ElementType.ANNOTATION_TYPE,
    ElementType.CONSTRUCTOR,
    ElementType.FIELD,
    ElementType.LOCAL_VARIABLE,
    ElementType.METHOD,
    ElementType.PACKAGE,
    ElementType.PARAMETER,
    ElementType.TYPE,
    ElementType.TYPE_PARAMETER,
    ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ADL {
	

    String identifier();
    String title();
    String jiraReference() default "";
    String problem();
    String[] alternatives() default {};
    String chosenAlternative() default "";
    String justification();
    String[] negativeConsequences() default {};
    String[] positiveConsequences() default {};
	

}
