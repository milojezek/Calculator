package eu.milo4apps.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvInput: TextView
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.textview_input)
    }

    fun onDigit(view: View) {
        tvInput.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    fun onClear(view: View) {
        tvInput.text = ""
        lastNumeric = false
        lastDot = false
    }

    fun onDecimal(view: View) {
        if (lastNumeric && !lastDot) {
            tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        tvInput.text.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var tvValue = tvInput.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }

                doCalculation(tvValue, prefix)

            } catch (e: java.lang.ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun doCalculation(value: String, prefix: String) {
        var operator = ""
        when {
            value.contains("-") -> operator = "-"
            value.contains("+") -> operator = "+"
            value.contains("x") -> operator = "x"
            value.contains("/") -> operator = "/"
        }

        val splitValue = value.split(operator)

        var num1 = splitValue[0]
        val num2 = splitValue[1]

        if (prefix.isNotEmpty()) {
            num1 = prefix + num1
        }

        val result = when (operator) {
            "-" -> num1.toDouble() - num2.toDouble()
            "+" -> num1.toDouble() + num2.toDouble()
            "x" -> num1.toDouble() * num2.toDouble()
            "/" -> num1.toDouble() / num2.toDouble()
            else -> 0
        }

        tvInput.text = removeZeroAfterDot(result.toString())
    }

    private fun removeZeroAfterDot(result: String): String {
        return if (result.contains(".0")) {
            result.substring(0, result.length - 2)
        } else {
            result
        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("x")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}