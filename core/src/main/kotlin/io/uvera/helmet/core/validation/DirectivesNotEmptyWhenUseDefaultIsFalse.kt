package io.uvera.helmet.core.validation

import io.uvera.helmet.core.HelmetProperties
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [DirectivesNotEmptyWhenUseDefaultIsFalseValidator::class])
annotation class DirectivesNotEmptyWhenUseDefaultIsFalse(
    val message: String = "Directives cannot be empty when use defaults is false",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Any>> = [],
)

class DirectivesNotEmptyWhenUseDefaultIsFalseValidator :
    ConstraintValidator<DirectivesNotEmptyWhenUseDefaultIsFalse, HelmetProperties> {
    override fun isValid(value: HelmetProperties?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return true
        if (!value.contentSecurityPolicy.useDefault && value.contentSecurityPolicy.directives.isEmpty()) {
            return false
        }
        return true
    }
}
