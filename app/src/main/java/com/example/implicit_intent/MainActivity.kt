package com.example.implicit_intent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var phoneCall: Button
    private lateinit var sendMessage: Button
    private lateinit var openBrowser: Button

    @SuppressLint("QueryPermissionsNeeded")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit()

        phoneCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:01016125421")
            startActivity(callIntent)

            /*if (callIntent.resolveActivity(packageManager) != null ){
                startActivity(callIntent)
            }else{
                Toast.makeText(this,"No Activity found to handle this Action ",Toast.LENGTH_LONG).show()
            }*/
        }

        sendMessage.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_SENDTO)
            sendIntent.data = Uri.parse("mailto:")
            sendIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("bondokelgohary@gmail.com"))
            startActivity(sendIntent)

            /*  if (sendIntent.resolveActivity(packageManager) != null ){
                  startActivity(sendIntent)
              }else{
                  Toast.makeText(this,"No Activity found to handle this Action ",Toast.LENGTH_LONG).show()
              }*/

        }

        openBrowser.setOnClickListener {
            val browsingIntent = Intent(Intent.ACTION_VIEW)
            browsingIntent.data = Uri.parse("https://www.google.com")
            browsingIntent.setPackage("com.android.chrome")
            startActivity(browsingIntent)

            /* if (browsingIntent.resolveActivity(packageManager) != null ){
                 startActivity(browsingIntent)
             }else{
                 Toast.makeText(this,"No Activity found to handle this Action ",Toast.LENGTH_LONG).show()
             }*/
        }

    }

    private fun lateinit() {
        phoneCall = findViewById(R.id.call_btn)
        sendMessage = findViewById(R.id.send_message)
        openBrowser = findViewById(R.id.open_browser)

    }
}