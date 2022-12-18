package lumisfera.sheet.helper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import lumisfera.sheet.helper.databinding.WizardFragmentBinding

class WizardFragment : Fragment() {
    private var _binding: WizardFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WizardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}