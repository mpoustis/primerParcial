package edu.uade.primerparcial.logic

import androidx.lifecycle.ViewModel
import edu.uade.primerparcial.data.Pokemon
import edu.uade.primerparcial.data.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// El ViewModel esta en "logic" porque es el puente entre datos y pantalla
// Guarda el estado de la lista y expone un StateFlow para que la UI lo vea
// Solo provee los datos listos para mostrar

class PokemonViewModel(
    private val repository: PokemonRepository = PokemonRepository()
) : ViewModel() {
    private val _pokemons = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons: StateFlow<List<Pokemon>> = _pokemons.asStateFlow()

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        _pokemons.value = repository.getPokemons()
    }
}