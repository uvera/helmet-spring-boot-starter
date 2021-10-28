package io.uvera.helmet.core.validation

import io.uvera.helmet.core.CSPDirectives
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [DefaultSrcDirectiveValidator::class])
annotation class DefaultSrcDirectiveValid(
    val message: String = "",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Any>> = [],
)

class DefaultSrcDirectiveValidator :
    ConstraintValidator<DefaultSrcDirectiveValid, CSPDirectives> {

    override fun isValid(value: CSPDirectives?, ctx: ConstraintValidatorContext): Boolean {
        if (value == null) return true
        value["default-src"]?.let {
            if (it.isEmpty()) {
                ctx.disableDefaultConstraintViolation()
                ctx.buildConstraintViolationWithTemplate("CSP: 'default-src' directive value is empty")
                    .addConstraintViolation()
                return false
            }
        }
        return true
    }
}
