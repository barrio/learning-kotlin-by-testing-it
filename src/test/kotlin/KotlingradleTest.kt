import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertEquals


object KotlingradleTest: Spek({
    given("a hello world function") {
        on("calling it") {
            it("should return 'Hello world!'") {
                assertEquals("Hello world!", giveHelloMessage())
            }
        }
    }
    given("a function with named parameter") {
        on("providing parameter by name") {
            it("should be returned") {
                assertEquals(42,
                             functionsCanUse(namedParammeter = 42))
            }
        }
    }
    given("a function with default parameter") {
        on("calling it without argument") {
            it("should return the default value") {
                assertEquals(42,
                             functionsCanHaveDefaultArgs())
            }
        }
    }
    given("a builtin type") {
        val builtinString = "builtin string"
        on("calling an extension function") {
            it("should extend existing string methods") {
                assertEquals("builtin string has been extended!",
                             builtinString.functionsCanExtendExistingTypes())
            }
        }
    }
    given("an existing type") {
        val existingType = ExistingType()
        on("calling an identical extension function") {
            it("will be shadowed by the member") {
                assertEquals("Member functions shadow extending ones.",
                             existingType.functionOfType())
            }
        }
    }
    given("a nullable type") {
        val stringOrNull: String? = null
        on("extending it") {
            val result = stringOrNull.nullableTypesCanBeExtended()
            it("should even be extendable on null") {
                assertEquals("extension on null", result)
            }
        }
    }
})