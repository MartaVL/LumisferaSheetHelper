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

        val carreras = resources.getStringArray(R.array.carreras)
        val adapterCarreras = ArrayAdapter(requireContext(), R.layout.dropdown_item, carreras)
        val autocompleteCarrera = binding.chooseCarrera
        autocompleteCarrera.setAdapter(adapterCarreras)

        autocompleteCarrera.setOnItemClickListener { _, _, position, _ ->
            var arquetipos: Array<out String>
            when(position) {
                1 -> {
                    arquetipos = resources.getStringArray(R.array.granuja)
                }
                2 -> {
                    arquetipos = resources.getStringArray(R.array.teurgo)
                }
                3 -> {
                    arquetipos = resources.getStringArray(R.array.estadista)
                }
                4 -> {
                    arquetipos = resources.getStringArray(R.array.mago)
                }
                else -> {
                    arquetipos  = resources.getStringArray(R.array.luchador)
                }
            }

            val adapterArquetipos = ArrayAdapter(requireContext(), R.layout.dropdown_item, arquetipos)
            val autocompleteArquetipo = binding.chooseArquetipo
            autocompleteArquetipo.setAdapter(adapterArquetipos)
        }

        val religiones = resources.getStringArray(R.array.religiones)
        val adapterReligiones = ArrayAdapter(requireContext(), R.layout.dropdown_item, religiones)
        val autocompleteReligion = binding.chooseReligion
        autocompleteReligion.setAdapter(adapterReligiones)

        autocompleteReligion.setOnItemClickListener { _, _, position, _ ->
            var doctrinas: Array<out String>
            when(position) {
                1 -> {
                    doctrinas = resources.getStringArray(R.array.panteonElfo)
                }
                2 -> {
                    doctrinas = resources.getStringArray(R.array.panteonEnano)
                }
                3 -> {
                    doctrinas = resources.getStringArray(R.array.panteonVaruktar)
                }
                4 -> {
                    doctrinas = resources.getStringArray(R.array.panteonYizidis)
                }
                5 -> {
                    doctrinas = resources.getStringArray(R.array.panteonArbithio)
                }
                6 -> {
                    doctrinas = resources.getStringArray(R.array.panteonVenabingio)
                }
                7 -> {
                    doctrinas = resources.getStringArray(R.array.panteonYigerfein)
                }
                8 -> {
                    doctrinas = resources.getStringArray(R.array.panteonAdhaiyi)
                }
                else -> {
                    doctrinas  = resources.getStringArray(R.array.demiurgo)
                }
            }

            val adapterDioses = ArrayAdapter(requireContext(), R.layout.dropdown_item, doctrinas)
            val autocompleteDios = binding.chooseDios
            autocompleteDios.setAdapter(adapterDioses)
        }

        return binding.root
    }
}