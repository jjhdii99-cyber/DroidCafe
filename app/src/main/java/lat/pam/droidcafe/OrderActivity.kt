package lat.pam.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Inisialisasi Spinner Kota
        val spinner: Spinner = findViewById(R.id.label_spinner)
        spinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this,
            R.array.city_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    // Aksi ketika item kota pada Spinner dipilih
    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        val spinnerLabel = parent.getItemAtPosition(position).toString()
        displayToast(spinnerLabel)
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Do nothing
    }

    // Aksi ketika opsi RadioButton diklik
    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.id) {
            R.id.sameday -> if (checked) {
                displayToast(getString(R.string.same_day_messenger_service))
            }
            R.id.nextday -> if (checked) {
                displayToast(getString(R.string.next_day_ground_delivery))
            }
            R.id.pickup -> if (checked) {
                displayToast(getString(R.string.pick_up))
            }
            else -> {}
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }
}