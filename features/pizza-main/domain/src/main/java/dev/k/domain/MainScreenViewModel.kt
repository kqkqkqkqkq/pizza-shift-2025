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
class MainScreenViewModel @Inject internal constructor(
    getCatalogUseCase: Provider<GetCatalogUseCase>,
): ViewModel() {

    val state: StateFlow<MainScreenState> =
        getCatalogUseCase.get().invoke()
            .map { MainScreenState.Content(it) }
            .stateIn(viewModelScope, SharingStarted.Lazily, MainScreenState.Initial)
}