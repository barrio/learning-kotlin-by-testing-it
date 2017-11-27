fun giveHelloMessage() = "Hello world!"

fun functionsCanUse(namedParammeter: Int) = namedParammeter

fun functionsCanHaveDefaultArgs(Parameter: Int = 42) = Parameter

fun String.functionsCanExtendExistingTypes(): String =
    this + " has been extended!"

class ExistingType {
    fun functionOfType() = "Member functions shadow extending ones."
}
fun ExistingType.functionOfType() =
        "Extending functions with same signature will never be called!"

fun Any?.nullableTypesCanBeExtended() =
        when (this) {
            null -> "extension on null"
            else -> "extension on non-null"
        }
fun main(args: Array<String>) {
    println(giveHelloMessage())
}