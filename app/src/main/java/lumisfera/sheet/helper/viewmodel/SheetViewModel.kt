package lumisfera.sheet.helper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lumisfera.sheet.helper.model.Sheet

class SheetViewModel(): ViewModel() {

    val sheet = MutableLiveData<Sheet>()

    fun newSheet() {
        var newSheet = Sheet()
        newSheet.caracteristicas.resistencia = 2
        newSheet.caracteristicas.percepcion = 5

        newSheet.caracteristicas.materia = newSheet.caracteristicas.resistencia

        sheet.postValue(newSheet)
    }

    fun changeMateria(value: String, resistencia: Boolean) {
        val sheet = this.sheet.value
        val valueInt = value.toInt()

        if(sheet != null) {
            if (resistencia) {
                if(valueInt == sheet.caracteristicas.resistencia) {
                    return
                }
                sheet.caracteristicas.resistencia = valueInt
            } else {
                if(valueInt == sheet.caracteristicas.percepcion) {
                    return
                }
                sheet.caracteristicas.percepcion = valueInt
            }

            if(sheet.caracteristicas.percepcion < sheet.caracteristicas.resistencia) {
                sheet.caracteristicas.materia = sheet.caracteristicas.percepcion
            } else {
                sheet.caracteristicas.materia = sheet.caracteristicas.resistencia
            }

            this.sheet.postValue(sheet)
        }
    }

    fun changeVida(value: String, fuerza: Boolean) {
        val sheet = sheet.value
        val valueInt = value.toInt()

        if(sheet != null) {
            if (fuerza) {
                if(valueInt == sheet.caracteristicas.fuerza) {
                    return
                }
                sheet.caracteristicas.fuerza = valueInt
            } else {
                if(valueInt == sheet.caracteristicas.voluntad) {
                    return
                }
                sheet.caracteristicas.voluntad = valueInt
            }

            if(sheet.caracteristicas.fuerza < sheet.caracteristicas.voluntad) {
                sheet.caracteristicas.vida = sheet.caracteristicas.fuerza
            } else {
                sheet.caracteristicas.vida = sheet.caracteristicas.voluntad
            }

            this.sheet.postValue(sheet)
        }
    }

    fun changeAnima(value: String, destreza: Boolean) {
        val sheet = sheet.value
        val valueInt = value.toInt()

        if(sheet != null) {
            if (destreza) {
                if(valueInt == sheet.caracteristicas.destreza) {
                    return
                }
                sheet.caracteristicas.destreza = valueInt
            } else {
                if(valueInt == sheet.caracteristicas.consciencia) {
                    return
                }
                sheet.caracteristicas.consciencia = valueInt
            }

            if(sheet.caracteristicas.destreza < sheet.caracteristicas.consciencia) {
                sheet.caracteristicas.anima = sheet.caracteristicas.destreza
            } else {
                sheet.caracteristicas.anima = sheet.caracteristicas.consciencia
            }

            this.sheet.postValue(sheet)
        }
    }

    fun changeEnergia(value: String, agilidad: Boolean) {
        val sheet = sheet.value
        val valueInt = value.toInt()

        if(sheet != null) {
            if (agilidad) {
                if(valueInt == sheet.caracteristicas.agilidad) {
                    return
                }
                sheet.caracteristicas.agilidad = valueInt
            } else {
                if(valueInt == sheet.caracteristicas.inteligencia) {
                    return
                }
                sheet.caracteristicas.inteligencia = valueInt
            }

            if(sheet.caracteristicas.agilidad < sheet.caracteristicas.inteligencia) {
                sheet.caracteristicas.energia = sheet.caracteristicas.agilidad
            } else {
                sheet.caracteristicas.energia = sheet.caracteristicas.inteligencia
            }

            this.sheet.postValue(sheet)
        }
    }
}