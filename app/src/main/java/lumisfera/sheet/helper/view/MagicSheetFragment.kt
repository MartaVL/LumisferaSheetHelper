package lumisfera.sheet.helper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import lumisfera.sheet.helper.databinding.MagicSheetFragmentBinding

class MagicSheetFragment() : Fragment() {

    private var _binding: MagicSheetFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MagicSheetFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}