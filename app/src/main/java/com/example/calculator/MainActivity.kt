package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() ,View.OnClickListener, View.OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
    }

var firstVal = ""
    var operator = ""
    var secondVal = ""


    private fun init(){
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

deleteButton.setOnLongClickListener(this)
    }
fun delete(view: View){
resultText.text = resultText.text.toString().dropLast(1);

}
    fun division(view: View){
firstVal = resultText.text.toString()
        operator = "/"
resultText.text = ""
    }
    fun addition(view: View){
        firstVal = resultText.text.toString()
        operator = "+"
        resultText.text = ""

    }
 fun subtraction(view: View){
     firstVal = resultText.text.toString()
     operator = "-"
     resultText.text = ""

}
    fun multiplication(view: View){
        firstVal = resultText.text.toString()
        operator = "x"
        resultText.text = ""

    }
    fun checkDot(view: View){
        if(resultText.text.toString().contains('.')){


            Toast.makeText(this, "no more dot",Toast.LENGTH_SHORT).show()

        }else{
            resultText.text = resultText.text.toString() + "."
        }


    }

    fun equal(view: View){
        secondVal = resultText.text.toString()
        val firstNum = firstVal.toDouble()
        val  secondNum = secondVal.toDouble()
        var resultTxt = ""

        if (operator == "/"){

            if (firstVal != "0" && secondVal != "0"){
            resultTxt = (firstNum / secondNum).toString()
            resultText.text = resultTxt
            }else{

                Toast.makeText(this,"zero division error",Toast.LENGTH_SHORT).show()
            }
        }
        if (operator == "+"){


                resultTxt = (firstNum + secondNum).toString()
                resultText.text = resultTxt

            }

        if (operator == "-"){


            resultTxt = (firstNum - secondNum).toString()
            resultText.text = resultTxt

        }
        if (operator == "x"){


            resultTxt = (firstNum * secondNum).toString()
            resultText.text = resultTxt

        }

    }

    override fun onClick(v: View?) {

        val button  = v as Button;
        resultText.text = resultText.text.toString() + button.text.toString();

    }

    override fun onLongClick(p0: View?): Boolean {

        resultText.text = ""
        return true
    }


}




