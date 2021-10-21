package com.example.calculadora

import android.content.res.Configuration
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var resultado = "0"
        var posicion = 0
        var valor = "0"
        var operacion = ""
        var formato = "decimal"
        var vertical = true

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            vertical = false
            btnComa.setEnabled(false)
            btnSigno.setEnabled(false)
            btn2.setEnabled(true)
            btn3.setEnabled(true)
            btn4.setEnabled(true)
            btn5.setEnabled(true)
            btn6.setEnabled(true)
            btn7.setEnabled(true)
            btn8.setEnabled(true)
            btn9.setEnabled(true)
            btnA.setEnabled(false)
            btnB.setEnabled(false)
            btnC.setEnabled(false)
            btnD.setEnabled(false)
            btnE.setEnabled(false)
            btnF.setEnabled(false)
            radioDecimal.setChecked(true)
            radioBinario.setChecked(false)
            radioHexadecimal.setChecked(false)
            radioOct.setChecked(false)

            radioDecimal.setOnClickListener{
                radioDecimal.setChecked(true);
                radioBinario.setChecked(false);
                radioHexadecimal.setChecked(false);
                radioOct.setChecked(false)
                resultado = convertirANumero(formato,resultado).toString()
                valor = convertirANumero(formato,valor).toString()
                if(valor.equals("0"))
                    txtResultado.setText(resultado)
                else
                    txtResultado.setText(valor)
                formato = "decimal"
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                btnE.setEnabled(false);
                btnF.setEnabled(false);
            }

            radioBinario.setOnClickListener{
                radioBinario.setChecked(true);
                radioDecimal.setChecked(false);
                radioHexadecimal.setChecked(false);
                radioOct.setChecked(false);
                resultado = Integer.toBinaryString(convertirANumero(formato,resultado))
                valor = Integer.toBinaryString(convertirANumero(formato,valor))
                if(valor.equals("0"))
                    txtResultado.setText(resultado)
                else
                    txtResultado.setText(valor)
                formato = "binario"
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                btnE.setEnabled(false);
                btnF.setEnabled(false);
            }

            radioHexadecimal.setOnClickListener{
                radioHexadecimal.setChecked(true);
                radioBinario.setChecked(false);
                radioDecimal.setChecked(false);
                radioOct.setChecked(false);
                resultado = Integer.toHexString(convertirANumero(formato,resultado))
                valor = Integer.toHexString(convertirANumero(formato,valor))
                if(valor.equals("0"))
                    txtResultado.setText(resultado)
                else
                    txtResultado.setText(valor)
                formato = "hexadecimal"
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                btnA.setEnabled(true);
                btnB.setEnabled(true);
                btnC.setEnabled(true);
                btnD.setEnabled(true);
                btnE.setEnabled(true);
                btnF.setEnabled(true);

            }

            radioOct.setOnClickListener{
                radioOct.setChecked(true);
                radioBinario.setChecked(false);
                radioHexadecimal.setChecked(false);
                radioDecimal.setChecked(false)
                resultado = Integer.toOctalString(convertirANumero(formato,resultado))
                valor = Integer.toOctalString(convertirANumero(formato,valor))
                if(valor.equals("0"))
                    txtResultado.setText(resultado)
                else
                    txtResultado.setText(valor)
                formato = "octal"
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                btnE.setEnabled(false);
                btnF.setEnabled(false);
            }

            btnA.setOnClickListener{
                if(posicion == 0)
                    valor = "A"
                else
                    valor += "A"
                txtResultado.setText(valor)
                posicion++
            }
            btnB.setOnClickListener{
                if(posicion == 0)
                    valor = "B"
                else
                    valor += "B"
                txtResultado.setText(valor)
                posicion++
            }
            btnC.setOnClickListener{
                if(posicion == 0)
                    valor = "C"
                else
                    valor += "C"
                txtResultado.setText(valor)
                posicion++
            }
            btnD.setOnClickListener{
                if(posicion == 0)
                    valor = "D"
                else
                    valor += "D"
                txtResultado.setText(valor)
                posicion++
            }
            btnE.setOnClickListener{
                if(posicion == 0)
                    valor = "E"
                else
                    valor += "E"
                txtResultado.setText(valor)
                posicion++
            }
            btnF.setOnClickListener{
                if(posicion == 0)
                    valor = "F"
                else
                    valor += "F"
                txtResultado.setText(valor)
                posicion++
            }

        }else{
            vertical = true
            btn2.setEnabled(true)
            btn3.setEnabled(true)
            btn4.setEnabled(true)
            btn5.setEnabled(true)
            btn6.setEnabled(true)
            btn7.setEnabled(true)
            btn8.setEnabled(true)
            btn9.setEnabled(true)
            btnComa.setEnabled(true)
            btnSigno.setEnabled(true)
        }

        btn0.setOnClickListener{
            if(posicion == 0){
                valor = "0"
            }else{
                valor += "0"
                posicion ++
            }
            txtResultado.setText(valor)
        }
        btn1.setOnClickListener{
            if(posicion == 0)
                valor = "1"
            else
                valor += "1"
            txtResultado.setText(valor)
            posicion++
        }
        btn2.setOnClickListener{
            if(posicion == 0)
                valor = "2"
            else
                valor += "2"
            txtResultado.setText(valor)
            posicion++
        }
        btn3.setOnClickListener{
            if(posicion == 0)
                valor = "3"
            else
                valor += "3"
            txtResultado.setText(valor)
            posicion++
        }
        btn4.setOnClickListener{
            if(posicion == 0)
                valor = "4"
            else
                valor += "4"
            txtResultado.setText(valor)
            posicion++
        }
        btn5.setOnClickListener{
            if(posicion == 0)
                valor = "5"
            else
                valor += "5"
            txtResultado.setText(valor)
            posicion++
        }
        btn6.setOnClickListener{
            if(posicion == 0)
                valor = "6"
            else
                valor += "6"
            txtResultado.setText(valor)
            posicion++
        }
        btn7.setOnClickListener{
            if(posicion == 0)
                valor = "7"
            else
                valor += "7"
            txtResultado.setText(valor)
            posicion++
        }
        btn8.setOnClickListener{
            if(posicion == 0)
                valor = "8"
            else
                valor += "8"
            txtResultado.setText(valor)
            posicion++
        }
        btn9.setOnClickListener{
            if(posicion == 0)
                valor = "9"
            else
                valor += "9"
            txtResultado.setText(valor)
            posicion++
        }
        btnComa.setOnClickListener{
            if(posicion == 0)
                valor = "0."
            else if(txtResultado.getText().toString().indexOf(",") == -1)
                valor += "."
            txtResultado.setText(valor)
            posicion++
        }
        btnSuma.setOnClickListener{
            if(operacion.equals("dividir") && valor.equals("0")){
                txtResultado.setText("ERROR")
                resultado = "0"
            }else{
                resultado = calcular(resultado,valor,operacion,vertical,formato)
                txtResultado.setText(resultado)
            }

            valor = "0"
            posicion = 0
            operacion = "sumar"
        }
        btnIgual.setOnClickListener{
            if(operacion.equals("dividir") && valor.equals("0")){
                txtResultado.setText("ERROR")
                resultado = "0"
            }else{
                resultado = calcular(resultado,valor,operacion,vertical,formato)
                txtResultado.setText(resultado)
            }
            valor = "0"
            posicion = 0
            operacion = ""
        }

        btnDividir.setOnClickListener{
            if(operacion.equals("dividir") && valor.equals("0")){
                txtResultado.setText("ERROR")
                resultado = "0"
            }else{
                resultado = calcular(resultado,valor,operacion,vertical,formato)
                txtResultado.setText(resultado)
            }
            valor = "0"
            posicion = 0
            operacion = "dividir"
        }

        btnMultiplicar.setOnClickListener{
            if(operacion.equals("dividir") && valor.equals("0")){
                txtResultado.setText("ERROR")
                resultado = "0"
            }else{
                resultado = calcular(resultado,valor,operacion,vertical,formato)
                txtResultado.setText(resultado)
            }
            valor = "0"
            posicion = 0
            operacion = "multiplicar"
        }
        btnResta.setOnClickListener{
            if(operacion.equals("dividir") && valor.equals("0")){
                txtResultado.setText("ERROR")
                resultado = "0"
            }else{
                resultado = calcular(resultado,valor,operacion,vertical,formato)
                txtResultado.setText(resultado)
            }
            valor = "0"
            posicion = 0
            operacion = "restar"
        }
        btnBorrar.setOnClickListener{
            txtResultado.setText("0")
            posicion = 0
        }
        btnSigno.setOnClickListener {
            if(posicion !=0){
                valor = (valor.toDouble()*-1).toString()
                txtResultado.setText(valor)
            }
        }
        btnAC.setOnClickListener {
            resultado = "0"
            valor = "0"
            txtResultado.setText("0")
            posicion = 0
            operacion = ""
        }


    }

    fun calcular(resultado:String,valor:String,operacion:String,vertical:Boolean,formato:String):String{
        if(vertical){
            if(operacion.equals("sumar")){
                return (resultado.toDouble() + valor.toDouble()).toString();
            }else if(operacion.equals("restar")){
                return (resultado.toDouble() - valor.toDouble()).toString();
            }else if(operacion.equals("multiplicar")){
                return (resultado.toDouble() * valor.toDouble()).toString();
            }else if(operacion.equals("dividir")){
                return (resultado.toDouble() / valor.toDouble()).toString();
            }
            return (resultado.toDouble() + valor.toDouble()).toString();
        }else{
            var numero1 = 0
            var numero2 = 0
            var result = 0

            if(formato.equals("decimal")){
                numero1 = resultado.toInt()
                numero2 = valor.toInt()
            }else if(formato.equals("binario")){
                numero1 = convertirADecimal(resultado,2)
                numero2 = convertirADecimal(valor,2)
            }else if(formato.equals("hexadecimal")){
                numero1 = convertirADecimal(resultado,16)
                numero2 = convertirADecimal(valor,16)
            }else if(formato.equals("octal")){
                numero1 = convertirADecimal(resultado,8)
                numero2 = convertirADecimal(valor,8)
            }

            if(operacion.equals("sumar"))
                result = numero1 + numero2
            else if(operacion.equals("restar"))
                if(numero1 < numero2)
                    result = 0
                else
                    result =numero1 - numero2
            else if(operacion.equals("multiplicar"))
                result = numero1 * numero2
            else if(operacion.equals("dividir"))
                if(numero2 == 0)
                    return "ERROR"
                else if(numero1 < numero2)
                    result = 0
                else
                    result = numero1 / numero2
            else
                result = numero1 + numero2

            if(formato.equals("decimal"))
                return result.toString()
            else if(formato.equals("binario"))
                return Integer.toBinaryString(result)
            else if(formato.equals("hexadecimal"))
                return Integer.toHexString(result)
            else
                return Integer.toOctalString(result)
        }
    }

    fun convertirADecimal(numero:String, base:Int): Int {
        return Integer.parseInt(numero,base)
    }

    fun convertirANumero(formato:String, numero:String): Int {

        if(formato.equals("binario"))
            return convertirADecimal(numero,2)
        else if(formato.equals("hexadecimal"))
            return convertirADecimal(numero,16)
        else if(formato.equals("octal"))
            return convertirADecimal(numero,8)
        else
            return numero.toInt()
    }

    /*fun calcularOperacion(resutado:Double, valor:String): String {
        var resultadoBinario = convertBinaryToDecimal(resutado.toLong());
        var resultadoValor = convertBinaryToDecimal(valor.toLong());
        var suma = resultadoBinario + resultadoValor;
        return Integer.toBinaryString(suma)
    }

    fun convertBinaryToDecimal(num: Long): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }*/
}