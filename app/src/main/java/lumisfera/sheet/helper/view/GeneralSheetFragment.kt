package lumisfera.sheet.helper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import lumisfera.sheet.helper.R
import lumisfera.sheet.helper.databinding.GeneralSheetFragmentBinding

class GeneralSheetFragment() : Fragment() {

    private var _binding: GeneralSheetFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GeneralSheetFragmentBinding.inflate(inflater, container, false)

        val races = resources.getStringArray(R.array.races)
        val adapterRaces = ArrayAdapter(requireContext(), R.layout.dropdown_item, races)
        val autocompleteRaces = binding.chooseRace
        autocompleteRaces.setAdapter(adapterRaces)

        val actitudes = resources.getStringArray(R.array.actitudes)
        val adapterActitudes = ArrayAdapter(requireContext(), R.layout.dropdown_item, actitudes)
        val autocompleteActitud = binding.chooseActitude
        autocompleteActitud.setAdapter(adapterActitudes)

        val nexos = resources.getStringArray(R.array.nexos)
        val adapterNexo = ArrayAdapter(requireContext(), R.layout.dropdown_item, nexos)
        val autocompleteNexo = binding.chooseNexo
        autocompleteNexo.setAdapter(adapterNexo)

        val arquetipos = resources.getStringArray(R.array.arquetipos)
        val adapterArquetipos = ArrayAdapter(requireContext(), R.layout.dropdown_item, arquetipos)
        val autocompleteArquetipo = binding.chooseArquetipo
        autocompleteArquetipo.setAdapter(adapterArquetipos)

        val carreras = resources.getStringArray(R.array.carreras)
        val adapterCarreras = ArrayAdapter(requireContext(), R.layout.dropdown_item, carreras)
        val autocompleteCarrera = binding.chooseCarrera
        autocompleteCarrera.setAdapter(adapterCarreras)

        val religiones = resources.getStringArray(R.array.religiones)
        val adapterReligiones = ArrayAdapter(requireContext(), R.layout.dropdown_item, religiones)
        val autocompleteReligion = binding.chooseReligion
        autocompleteReligion.setAdapter(adapterReligiones)

        /*val dioses = resources.getStringArray(R.array.empty)
        val adapterDioses = ArrayAdapter(requireContext(), R.layout.dropdown_item, dioses)
        val autocompleteDios = binding.chooseDios
        autocompleteDios.setAdapter(adapterDioses)*/

        return binding.root
    }
}