import kotlin.coroutines.experimental.buildIterator

fun giveHelloMessage() = "Hello world!"

fun functionsCanHandle(unnamedParameter: Int, namedParameter: Int) = namedParameter

fun functionsCanHaveDefaultArgs(Parameter: Int = 42) = Parameter

fun String.functionsCanExtendExistingTypes(): String =
    this + " has been extended!"

class ExistingType {
    fun functionOfType() = "Member functions shadow extending ones."
}
fun ExistingType.functionOfType() =
        "Extension functions with same signature as members will never be called!"

fun Any?.nullableTypesCanBeExtended() =
        when (this) {
            null -> "extension on null"
            else -> "extension on non-null"
        }
/** Have to use classes for multiple named return values */
data class TwoNamedValues(val valueB:String, val valueA: String)
fun swapTwoNamedValues(valueA: String, valueB: String) = TwoNamedValues(valueB, valueA)

/** Operator overloading */
class Point(val x: Int, val y: Int) {
    operator fun plus(point: Point) = Point(x + point.x, y + point.y)
}

fun functionsCanHaveVariableNumberOfArgs(vararg strings: String) =
        strings.fold("", { string1, string2 -> string1 + string2 })

fun functionsCanTakeFunctionsAsParameters(str: String, fn: (String) -> String) = fn(str)

fun functionsCanReturnFunctions() = { str:String -> str.reversed() }

val undecoratedFunction = { "undecorated " }

fun decoratorFunction(fn: () -> String): () -> String = { "before " + fn() + "after" }

fun decoratedFunction() = decoratorFunction(undecoratedFunction)

fun main(args: Array<String>) {
    println(giveHelloMessage())
}