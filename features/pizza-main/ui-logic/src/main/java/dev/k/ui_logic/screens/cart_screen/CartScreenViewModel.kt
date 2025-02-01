package dev.k.ui_logic.screens.cart_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.k.ui_logic.usecase.GetCartUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class CartScreenViewModel @Inject internal constructor(
    getCartUseCase: Provider<GetCartUseCase>,
): ViewModel() {

    val state: StateFlow<CartScreenState> =
        getCartUseCase.get().invoke()
            .map { CartScreenState.Content(it) }
            .stateIn(viewModelScope, SharingStarted.Lazily, CartScreenState.Initial)
}