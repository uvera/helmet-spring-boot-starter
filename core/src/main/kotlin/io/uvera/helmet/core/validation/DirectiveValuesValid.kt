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
@Constraint(validatedBy = [DirectiveValuesValidator::class])
annotation class DirectiveValuesValid(
    val message: String = "",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Any>> = [],
)

class DirectiveValuesValidator :
    ConstraintValidator<DirectiveValuesValid, CSPDirectives> {
    private val matchingRegex: Regex = ".*[;,]".toRegex()

    override fun isValid(value: CSPDirectives?, ctx: ConstraintValidatorContext): Boolean {
        if (value == null) return true
        var retVal = true
        value.forEach { mapEntry ->
            mapEntry.value.forEach { listValue ->
                if (listValue.matches(matchingRegex)) {
                    ctx.buildConstraintViolationWithTemplate("""CSP: Directive [key: ${mapEntry.key}] contains invalid value: $listValue
                       |    Illegal characters: [',', ';']
                    """.trimMargin())
                        .addConstraintViolation()
                    retVal = false
                }
            }
        }
        if (!retVal) {
            ctx.disableDefaultConstraintViolation()
        }
        return retVal
    }
}
