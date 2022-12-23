package lumisfera.sheet.helper.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import lumisfera.sheet.helper.R
import lumisfera.sheet.helper.databinding.ActivityCreateSheetBinding
import lumisfera.sheet.helper.databinding.EquipSheetFragmentBinding
import lumisfera.sheet.helper.viewmodel.SheetViewModel

class CreateSheetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateSheetBinding
    private lateinit var toggle: ActionBarDrawerToggle

    private val sheetViewModel: SheetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = ""

        val t = supportFragmentManager.beginTransaction()
        t.replace(R.id.linearLayout, GeneralSheetFragment(true)).commit()

        binding.apply {
            toggle = ActionBarDrawerToggle(this@CreateSheetActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.manual -> {
                       supportFragmentManager.beginTransaction().replace(R.id.linearLayout, GeneralSheetFragment(true)).commit()
                    }
                    R.id.wizard -> {
                        Toast.makeText(this@CreateSheetActivity, "create player with wizard is disabled", Toast.LENGTH_SHORT).show()
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
            }
            R.id.general -> {
                val t = supportFragmentManager.beginTransaction()
                t.replace(R.id.linearLayout, GeneralSheetFragment(true)).commit()
            }
            R.id.magic -> {
            }
            R.id.equip -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
}