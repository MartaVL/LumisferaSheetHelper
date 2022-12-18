package lumisfera.sheet.helper.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lumisfera.sheet.helper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.newSheet.setOnClickListener {
            val intent = Intent(this, CreateSheetActivity::class.java)
            startActivity(intent)
        }
    }
}