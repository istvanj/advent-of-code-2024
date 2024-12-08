import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

data class NotFoundException(override val message: String?) : Exception(message)

fun <T> checkResult(expected: T, actual: T) = check(expected == actual) { "Expected value to be $expected but was $actual" }

fun readInputToStringList(inputFileName: String) = File("src", inputFileName).readLines()

fun readInputToString(inputFileName: String) = File("src", inputFileName).readText()

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
