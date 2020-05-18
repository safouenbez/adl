package io.github.safouenbez.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE,
		ElementType.METHOD, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE, ElementType.TYPE_PARAMETER,
		ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ADC {

	// ISO 9126
	public enum NFR {
		FUNCTIONAL_COMPLETENESS, PERFORMANCE_EFFICIENCY, USABILITY, MANAGEABILITY, RELIABILITY, COMPATIBILITY, SECURITY,
		MISC
	}

	public enum Architecure {
		SOA, MSA, MHA, EDA, ES, CQRS, NONE
	}

	NFR[] nfrs() default NFR.MISC;

	Architecure[] architectre() default Architecure.MSA;

	String concerns() default "";

}
