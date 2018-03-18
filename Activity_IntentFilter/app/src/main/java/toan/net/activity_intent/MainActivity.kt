package toan.net.activity_intent

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)
        btnCustom.setOnClickListener { customStartActivity() }

        btnDefault.setOnClickListener { displayAlert() }
    }

    private fun customStartActivity() {
        val sendIntent = Intent().apply {
            action = "toan.net.action.SEND"
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, edtSendMessage.text.toString())
        }
        // Toast.makeText(applicationContext, "Toan", Toast.LENGTH_LONG).show()
        startActivity(sendIntent)
    }


    fun displayAlert() {
        val alert = AlertDialog.Builder(this)
        var editTextAge: EditText? = null

        // Builder
        with(alert) {
            setTitle("Title of Alert")
            var name = edtSendMessage.text.toString()
            setMessage("${name} \n\nEnter your Age Here!!")

            // Add any  input field here
            editTextAge = EditText(context)
            editTextAge!!.hint = "age"
            editTextAge!!.inputType = InputType.TYPE_CLASS_NUMBER

            setPositiveButton("OK") { dialog, whichButton ->
                //showMessage("display the game score or anything!")
                dialog.dismiss()
                var age = editTextAge!!.text.toString()
                edtSendMessage.setText("Age: " + age)
            }

            setNegativeButton("NO") { dialog, whichButton ->
                //showMessage("Close the game or anything!")
                dialog.dismiss()
            }
        }

        // Dialog
        val dialog = alert.create()
        dialog.setView(editTextAge)
        dialog.show()
    }


    private fun defaultStartActivity() {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SENDTO
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, edtSendMessage.text.toString())
        }
        // Toast.makeText(applicationContext, "Toan", Toast.LENGTH_LONG).show()
        startActivity(sendIntent)
        finish()
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}
