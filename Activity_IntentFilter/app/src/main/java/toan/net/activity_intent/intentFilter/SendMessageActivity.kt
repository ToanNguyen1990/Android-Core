package toan.net.activity_intent.intentFilter

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.send_message_activity.*
import toan.net.activity_intent.R

/**
 * Created by USER on 3/18/2018.
 */
class SendMessageActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_message_activity)
        edtSendMessage.setText(intent.getStringExtra(Intent.EXTRA_TEXT))
    }
}