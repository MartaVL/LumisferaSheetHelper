package lumisfera.sheet.helper.view

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import lumisfera.sheet.helper.R
import lumisfera.sheet.helper.databinding.GeneralSheetFragmentBinding
import lumisfera.sheet.helper.viewmodel.SheetViewModel

class GeneralSheetFragment(private val new: Boolean) : Fragment() {

    private var _binding: GeneralSheetFragmentBinding? = null
    private val binding get() = _binding!!

    private val sheetViewModel: SheetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GeneralSheetFragmentBinding.inflate(inflater, container, false)
        if(new) {
            sheetViewModel.newSheet()
        }

        sheetViewModel.sheet.observe(viewLifecycleOwner, Observer {
            binding.editName.text = Editable.Factory.getInstance().newEditable(it.nombre)
            binding.editLevel.text = Editable.Factory.getInstance().newEditable(it.nivel.toString())

            /* Caracteristicas */

            /* Materia */
            binding.materiaValue.text = it.caracteristicas.materia.toString()
            binding.editResistencia.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.resistencia.toString())
            binding.editPercepcion.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.percepcion.toString())

            /* Vida */
            binding.vidaValue.text = it.caracteristicas.vida.toString()
            binding.editFuerza.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.fuerza.toString())
            binding.editVoluntad.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.voluntad.toString())

            /* Anima */
            binding.animaValue.text = it.caracteristicas.anima.toString()
            binding.editDestreza.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.destreza.toString())
            binding.editConsciencia.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.consciencia.toString())

            /* Energia */
            binding.energiaValue.text = it.caracteristicas.energia.toString()
            binding.editAgilidad.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.agilidad.toString())
            binding.editInteligencia.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.inteligencia.toString())

            /* Eter */
            binding.editEterGanados.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.eterGanados.toString())
            binding.editEterGastados.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.eterGastados.toString())

            /* Puntos de poder */
            binding.editPuntosPoder.text = Editable.Factory.getInstance().newEditable(it.caracteristicas.puntosPoderGanados.toString())
            binding.puntosPoderValue.text = it.caracteristicas.puntosPoderRestantes.toString()
        })

        /* Automatización valores caracteristicas */

        /* Materia */
        binding.editResistencia.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.isNotEmpty()) {
                    binding.editResistencia.removeTextChangedListener(this)
                    sheetViewModel.changeMateria(s.toString(), true)
                    val pos = binding.editResistencia.length()
                    binding.editResistencia.setSelection(pos)
                    binding.editResistencia.addTextChangedListener(this)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        binding.editPercepcion.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.isNotEmpty()) {
                    binding.editPercepcion.removeTextChangedListener(this)
                    sheetViewModel.changeMateria(s.toString(), false)
                    val pos = binding.editPercepcion.length()
                    binding.editPercepcion.setSelection(pos)
                    binding.editPercepcion.addTextChangedListener(this)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
        /* Fin Materia */

        /* Vida */
        binding.editFuerza.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.isNotEmpty()) {
                    binding.editFuerza.removeTextChangedListener(this)
                    sheetViewModel.changeVida(s.toString(), true)
                    val pos = binding.editFuerza.length()
                    binding.editFuerza.setSelection(pos)
                    binding.editFuerza.addTextChangedListener(this)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        binding.editVoluntad.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.isNotEmpty()) {
                    binding.editVoluntad.removeTextChangedListener(this)
                    sheetViewModel.changeVida(s.toString(), false)
                    val pos = binding.editVoluntad.length()
                    binding.editVoluntad.setSelection(pos)
                    binding.editVoluntad.addTextChangedListener(this)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
        /* Vida */

        /* Anima */
        binding.editDestreza.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.isNotEmpty()) {
                    binding.editDestreza.removeTextChangedListener(this)
                    sheetViewModel.changeAnima(s.toString(), true)
                    val pos = binding.editDestreza.length()
                    binding.editDestreza.setSelection(pos)
                    binding.editDestreza.addTextChangedListener(this)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        binding.editConsciencia.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.isNotEmpty()) {
                    binding.editConsciencia.removeTextChangedListener(this)
                    sheetViewModel.changeAnima(s.toString(), false)
                    val pos = binding.editConsciencia.length()
                    binding.editConsciencia.setSelection(pos)
                    binding.editConsciencia.addTextChangedListener(this)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
        /* Fin Anima */

        /* Energia */
        binding.editAgilidad.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.isNotEmpty()) {
                    binding.editAgilidad.removeTextChangedListener(this)
                    sheetViewModel.changeEnergia(s.toString(), true)
                    val pos = binding.editAgilidad.length()
                    binding.editAgilidad.setSelection(pos)
                    binding.editAgilidad.addTextChangedListener(this)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        binding.editInteligencia.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.isNotEmpty()) {
                    binding.editInteligencia.removeTextChangedListener(this)
                    sheetViewModel.changeEnergia(s.toString(), false)
                    val pos = binding.editInteligencia.length()
                    binding.editInteligencia.setSelection(pos)
                    binding.editInteligencia.addTextChangedListener(this)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
        /* Fin Energia */

        /* Fin automatización caracteristicas */

        return binding.root
    }


    /* Rellena los dropdown menus
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

    Fin dropdown menus */
}