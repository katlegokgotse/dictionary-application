package com.example.dictionaryapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.dictionaryapplication.data.api.DictionaryApiClient
import com.example.dictionaryapplication.data.model.WordModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtWord: EditText = findViewById<EditText>(R.id.edtWord)
        val btnSearch: Button = findViewById<Button>(R.id.btnSearchWord)
        btnSearch.setOnClickListener{
            if (edtWord.text.isNotEmpty()){
                lifecycleScope.launch{
                    fetchWord(edtWord.text.toString())
                }
            }

        }
    }
    private fun fetchWord(word: String) {
        val callApi = DictionaryApiClient.dictionaryService.getDefinition(word)
        lifecycleScope.launch {
            callApi.enqueue(object: Callback<List<WordModel>> {
                override fun onResponse(p0: Call<List<WordModel>>, response: Response<List<WordModel>>) {
                    if (response.isSuccessful){
                        val definitions = response.body()
                        if (definitions != null){
                            definitions.let{
                                val definition = it[0].meanings[0].definitions[0].definition
                                findViewById<TextView>(R.id.txtWord).text = definition
                            }
                        }else{
                            findViewById<TextView>(R.id.txtWord).text = "Word not found"
                        }
                    }else{
                        findViewById<TextView>(R.id.txtWord).text = "Harde buddy"
                    }
                }
                override fun onFailure(p0: Call<List<WordModel>>, throwable: Throwable) {
                    Log.i("MainActivity", "Error: ${throwable.message}")
                    findViewById<TextView>(R.id.txtWord).text = "${throwable.message}"
                }
            })
        }
    }
}