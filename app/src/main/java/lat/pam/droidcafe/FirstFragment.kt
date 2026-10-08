package lat.pam.droidcafe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import lat.pam.droidcafe.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Klik gambar donat
        binding.donut.setOnClickListener {
            displayToast(getString(R.string.donut_order_message))
        }

        // Klik gambar es krim
        binding.iceCream.setOnClickListener {
            displayToast(getString(R.string.ice_cream_order_message))
        }

        // Klik gambar froyo
        binding.froyo.setOnClickListener {
            displayToast(getString(R.string.froyo_order_message))
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}