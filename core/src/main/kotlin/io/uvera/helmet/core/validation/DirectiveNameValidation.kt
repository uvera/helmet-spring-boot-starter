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
@Constraint(validatedBy = [DirectiveNameValidator::class])
annotation class DirectiveNameValid(
    val message: String = "",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Any>> = [],
)

class DirectiveNameValidator :
    ConstraintValidator<DirectiveNameValid, CSPDirectives> {
    private val matchingRegex: Regex = "[^a-zA-Z0-9-]".toRegex()

    override fun isValid(value: CSPDirectives?, ctx: ConstraintValidatorContext): Boolean {
        if (value == null) return true
        if (value.keys.any {
                it.isBlank()
            }) {
            ctx.disableDefaultConstraintViolation()
            ctx.buildConstraintViolationWithTemplate("CSP: Found empty directive names")
        }
        value.keys.firstOrNull {
            matchingRegex.matches(it)
        }?.let {
            ctx.disableDefaultConstraintViolation()
            ctx.buildConstraintViolationWithTemplate("CSP: Directive name $it doesn't match $matchingRegex")
                .addConstraintViolation()
            return false
        }
        return true
    }
}
