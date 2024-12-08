package day01

import checkResult
import readInputToStringList
import kotlin.math.abs

private const val PART1_CRITERIA = 11

private const val PART2_CRITERIA = 31

/**
 * [Description](https://adventofcode.com/2024/day/1)
 */
fun main() {
    val sampleInput = readToList("day01/Day01_sample.txt")
    checkResult(PART1_CRITERIA, part1(sampleInput))
    val input = readToList("day01/Day01.txt")
    println(part1(input))
    checkResult(PART2_CRITERIA, part2(sampleInput))
    println(part2(input))
}

fun part1(locationIDData: LocationIDData): Int {
    var result = 0
    val sortedFirstList = locationIDData.firstList.sorted()
    val sortedSecondList = locationIDData.secondList.sorted()

    for (i in sortedFirstList.indices) {
        result += abs(sortedFirstList[i] - sortedSecondList[i])
    }

    return result
}

fun part2(locationIDData: LocationIDData): Int {
    var result = 0
    locationIDData.firstList.forEach {
        result += it * locationIDData.secondList.count { i -> i == it }
    }
    return result
}

fun readToList(inputFileName: String): LocationIDData {
    val stringList = readInputToStringList(inputFileName)
    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()
    stringList.forEach {
        val split = it.split(Regex("\\s+"))
        firstList.add(split[0].toInt())
        secondList.add(split[1].toInt())
    }
    return LocationIDData(firstList, secondList)
}

data class LocationIDData(val firstList: List<Int>, val secondList: List<Int>)