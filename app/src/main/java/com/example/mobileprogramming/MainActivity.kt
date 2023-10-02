package com.example.mobileprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //deklarasi variabel
    private lateinit var inputPanjang: EditText
    private lateinit var inputLebar: EditText
    private lateinit var inputTinggi: EditText
    private lateinit var btn: Button
    private lateinit var result: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inisialisasi variabel
        inputPanjang= findViewById(R.id.edt_length)
        inputLebar = findViewById(R.id.edt_width)
        inputTinggi = findViewById(R.id.edt_height)
        btn= findViewById(R.id.btn_result)
        result= findViewById(R.id.result)
        btn.setOnClickListener(this)

        //menampilkan value yang ada di bundle
        if(savedInstanceState != null){
            result.text = savedInstanceState.getString(STATE_RESULT)
        }
    }
    override fun onClick(v:View?){
        if (v?.id==R.id.btn_result){
            var tinggi = inputTinggi.text.toString().trim()
            var panjang = inputPanjang.text.toString().trim()
            var lebar = inputLebar.text.toString().trim()
            var volume = tinggi.toDouble() * panjang.toDouble() * lebar.toDouble()
            result.text = volume.toString()

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,result.text.toString())
    }
}