package lumisfera.sheet.helper.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import lumisfera.sheet.helper.R
import lumisfera.sheet.helper.databinding.ActivityCreateSheetBinding
import lumisfera.sheet.helper.databinding.EquipSheetFragmentBinding

class CreateSheetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateSheetBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = ""

        val t = supportFragmentManager.beginTransaction()
        t.replace(R.id.linearLayout, GeneralSheetFragment()).commit()

        binding.apply {
            toggle = ActionBarDrawerToggle(this@CreateSheetActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.manual -> {
                       supportFragmentManager.beginTransaction().replace(R.id.linearLayout, GeneralSheetFragment()).commit()
                    }
                    R.id.wizard -> {
                        Toast.makeText(this@CreateSheetActivity, "create player with wizard is disabled", Toast.LENGTH_SHORT).show()
                    }
                    R.id.template -> {
                        Toast.makeText(this@CreateSheetActivity, "create player with template is disabled", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        when(item.itemId) {
            R.id.back -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.combat -> {
                val t = supportFragmentManager.beginTransaction()
                t.replace(R.id.linearLayout, CombatSheetFragment()).commit()
            }
            R.id.general -> {
                val t = supportFragmentManager.beginTransaction()
                t.replace(R.id.linearLayout, GeneralSheetFragment()).commit()
            }
            R.id.magic -> {
                val t = supportFragmentManager.beginTransaction()
                t.replace(R.id.linearLayout, MagicSheetFragment()).commit()
            }
            R.id.equip -> {
                val t = supportFragmentManager.beginTransaction()
                t.replace(R.id.linearLayout, EquipSheetFragment()).commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}