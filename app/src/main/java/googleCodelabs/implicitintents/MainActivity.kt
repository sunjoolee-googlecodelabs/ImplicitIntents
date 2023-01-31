package googleCodelabs.implicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var mWebsiteEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWebsiteEditText = findViewById(R.id.website_edittext)
    }

    fun openWebsite(view: View) {
        val url = mWebsiteEditText.text.toString()
        val webpage : Uri = Uri.parse(url)
        val intent : Intent = Intent(Intent.ACTION_VIEW, webpage)

        if(intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            Log.d("Implicit Intents", "Can't handle this request")
        }
    }
}