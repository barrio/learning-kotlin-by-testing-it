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
                             functionsCanHandle(1, namedParameter = 42))
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
    given("a function returning two values") {
        on("accessing values by name") {
            val (valueB, valueA) = swapTwoNamedValues(valueA = "valueA", valueB = "valueB")
            it("should return correct named values") {
                assertEquals("valueA", valueA)
                assertEquals("valueB", valueB)
            }
        }
    }
    given("Two point objects") {
        val pointA = Point(1, 1)
        val pointB = Point(2, 2)
        on("overloading plus operator for class Point") {
            val pointC = pointA + pointB
            it("plus operator should add Points") {
                assertEquals(3,
                             pointC.x)
                assertEquals(3,
                             pointC.y)
            }
        }
    }
    given("a function with arbitrary number of string args") {
        on("calling it with different number of string args") {
            val oneArgCall = functionsCanHaveVariableNumberOfArgs("one")
            val twoArgsCall = functionsCanHaveVariableNumberOfArgs("one", "two")
            it("should return all provided string args") {
                assertEquals("one",    oneArgCall)
                assertEquals("onetwo", twoArgsCall)
            }
        }
    }
    given("") {
        on("") {
            it("") {

            }
        }
    }
})
