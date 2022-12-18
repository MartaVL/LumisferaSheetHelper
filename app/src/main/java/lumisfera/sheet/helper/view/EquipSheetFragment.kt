package lumisfera.sheet.helper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import lumisfera.sheet.helper.databinding.EquipSheetFragmentBinding

class EquipSheetFragment() : Fragment() {

    private var _binding: EquipSheetFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EquipSheetFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}