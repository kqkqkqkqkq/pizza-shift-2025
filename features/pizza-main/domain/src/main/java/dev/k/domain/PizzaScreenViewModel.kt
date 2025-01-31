package dev.k.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.k.domain.usecase.GetCatalogUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class PizzaScreenViewModel @Inject internal constructor(
    getCatalogUseCase: Provider<GetCatalogUseCase>,
): ViewModel() {

    val state: StateFlow<PizzaScreenState> =
        getCatalogUseCase.get().invoke()
            .map { PizzaScreenState.Content(it) }
            .stateIn(viewModelScope, SharingStarted.Lazily, PizzaScreenState.Initial)
}