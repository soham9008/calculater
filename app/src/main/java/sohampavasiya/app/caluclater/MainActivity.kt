package sohampavasiya.app.caluclater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    lateinit var plus: Button
    lateinit var input: TextView
    lateinit var result: TextView
    lateinit var not_visible_text: TextView
    lateinit var secondValue: TextView
    lateinit var condition: TextView
    lateinit var firstValue: TextView
    var eualclick = false
    lateinit var point : Button
    lateinit var percent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        point = findViewById(R.id.point)
        firstValue = findViewById<TextView>(R.id.firstvalue)
        secondValue = findViewById<TextView>(R.id.secondvalue)
        condition = findViewById<TextView>(R.id.condition)
        not_visible_text = findViewById(R.id.not_visile)
        input = findViewById(R.id.input_text)
        result = findViewById(R.id.result_text)
        val clean = findViewById<Button>(R.id.clear_text)
        val clean_one_digit = findViewById<ImageButton>(R.id.remove_one_digit)
        val nine = findViewById<Button>(R.id.nine)
        val eight = findViewById<Button>(R.id.eight)
        val sevan = findViewById<Button>(R.id.seven)
        val six = findViewById<Button>(R.id.six)
        val five = findViewById<Button>(R.id.five)
        val four = findViewById<Button>(R.id.four)
        val three = findViewById<Button>(R.id.three)
        val two = findViewById<Button>(R.id.two)
        val one = findViewById<Button>(R.id.one)
        val zero = findViewById<Button>(R.id.zero)
        val mutliply = findViewById<Button>(R.id.multiply)
        val divider = findViewById<Button>(R.id.divided)
        val minues = findViewById<Button>(R.id.minues)
        val equlas = findViewById<Button>(R.id.equls)
        percent = findViewById(R.id.percent)
        plus = findViewById(R.id.pluse)

        input.text = "0"
        result.text = "0"
        firstValue.text = "0"
        secondValue.text = "0"
        condition.text = ""

        clean.setOnClickListener {
            input.text = "0"
            result.text = "0"
            not_visible_text.text = "0"
            firstValue.text = "0"
            secondValue.text = "0"
            condition.text = ""
        }
        clean_one_digit.setOnClickListener {

            var currantText = input.text.toString()
            val secondText = secondValue.text.toString().toInt()
            val secondInString = secondText.toString()
            if (secondText == 0) {
                val newText = secondInString.substring(0, currantText.length - 1)
                secondValue.text = newText

            }
            if (currantText.isNotEmpty()) {
                val newText = currantText.substring(0, currantText.length - 1)
                input.text = newText
            }
           currantTextIszero()

        }

        plus.setOnClickListener {
            conditions("+")
        }
        minues.setOnClickListener {
            conditions("-")
        }
        mutliply.setOnClickListener {
            conditions("X")
        }
        divider.setOnClickListener {
            conditions("/")
        }
        percent.setOnClickListener{
            conditions("%")
        }
        equlas.setOnClickListener {
            input.text = ""
            firstValue.text = "0"
            secondValue.text = "0"
            condition.text = ""
            eualclick = true
        }

        nine.setOnClickListener {
            setvalue("9")
        }
        eight.setOnClickListener {
            setvalue("8")

        }
        sevan.setOnClickListener {
            setvalue("7")
        }
        six.setOnClickListener {
            setvalue("6")

        }
        five.setOnClickListener {
            setvalue("5")

        }
        four.setOnClickListener {
            setvalue("4")

        }
        three.setOnClickListener {
            setvalue("3")

        }
        two.setOnClickListener {
            setvalue("2")
        }
        one.setOnClickListener {
            setvalue("1")
        }
        zero.setOnClickListener {
            setvalue("0")
        }
        point.setOnClickListener{
            setvalue(".")}
    }

    private fun currantTextIszero() {
        if (input.text.toString() == "0"){
            input.text = "0"
        }
    }

    private fun conditions(conitions: String, zeroValue: String = "0") {
        condition.text = conitions
        secondValue.text = zeroValue
        input.append(conitions)
        var pointNumber = result.text.toString()
        if (pointNumber.endsWith(".0")){
            var newresultText = result.text.toString().replace(".0","")
            result.text = newresultText

        }

    }

    private fun setvalue(setValue: String, zeroValue: String = "0") {
        var equals = eualclick
        if (equals == true){
            result.text = "0"
        }
        secondValue.append(setValue)
        val condition = condition.text.toString()
        val firstNumberInResult = result.text.toString().toDouble()
        val seconvalue = secondValue.text.toString().toDouble()

        if (condition.isEmpty()) {
            if (result.text.toString() == zeroValue) {
                result.text = setValue
            } else {
                result.append(setValue)
            }
        } else {
            result.text = addnumner(firstNumberInResult, condition, seconvalue).toString()
        }
        if (input.text.toString() == zeroValue) {
            input.text = setValue
        } else {
            input.append(setValue)
        }
        eualclick = false
        var pointNumber = result.text.toString()
        if (pointNumber.endsWith(".0")){
            var newresultText = result.text.toString().replace(".0","")
            result.text = newresultText
        }

    }

    private fun addnumner(firstvalue: Double, condition: String, secondValue: Double): String {
        var sum = "0"

        when (condition) {
            "+" -> {
                sum = (firstvalue + secondValue).toString()
            }

            "-" -> {
                sum = (firstvalue - secondValue).toString()
            }

            "X" -> {
                sum = (firstvalue * secondValue).toString()
            }

            "/" -> {
                val firL = firstvalue.toDouble()
                val secL = secondValue.toDouble()
                sum = (firL / secL).toString()

            }
            "%" -> sum = (secondValue % firstvalue).toString()
        }
        return sum


    }


}


