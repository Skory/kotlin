package org.jetbrains.kotlin.tools

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

private fun generateDownTos(outputFile: File, header: String) {

    fun getMaxType(fromType: String, toType: String): String {
        return when {
            fromType == "Double" || toType == "Double" -> "Double"
            fromType == "Float"  || toType == "Float"  -> "Float"
            fromType == "Long"   || toType == "Long"   -> "Long"
            fromType == "Int"    || toType == "Int"    -> "Int"
            fromType == "Short"  || toType == "Short"  -> "Short"
            fromType == "Char"   || toType == "Char"   -> "Char"
            else -> "Byte"
        }
    }

    fun generateDownTo(writer: PrintWriter, fromType: String, toType: String) {
        val elementType = getMaxType(fromType, toType)
        val rangeType = elementType + "Range"
        val fromExpr = "this${ if (elementType == fromType) "" else ".to$elementType()" }"
        if (elementType == "Float" || elementType == "Double") {
            writer.println("""
public inline fun $fromType.downTo(to: $toType): $rangeType {
    return $rangeType($fromExpr, to - this)
}""")
        } else {
            writer.println("""
public inline fun $fromType.downTo(to: $toType): $rangeType {
    return if (this >= to) $rangeType($fromExpr, to - this - 1) else $rangeType.EMPTY
}""")
        }
    }

    println("Writing $outputFile")

    outputFile.getParentFile()?.mkdirs()
    val writer = PrintWriter(FileWriter(outputFile))
    try {
        writer.println(header)

        writer.println("""
$COMMON_AUTOGENERATED_WARNING
""")

        val types = array("Byte", "Char", "Short", "Int", "Long", "Float", "Double")
        for (fromType in types) {
            for (toType in types) {
                generateDownTo(writer, fromType, toType)
            }
        }
    } finally {
        writer.close()
    }
}