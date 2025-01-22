package com.daniil.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * На этот класс не обращайте внимания, вместо библиотеки решил свою реализацию использовать
 * */

abstract class BaseViewModel<STATE : Any, SIDE_EFFECT : Any, EVENT : Any>(
    initialState: STATE,
) : ViewModel() {

    private val sideEffectsQueue: MutableList<SIDE_EFFECT> = mutableListOf()
    private var sideEffectsSubscribers: ((SIDE_EFFECT) -> Unit)? = null

    protected val state: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    val stateFlow: StateFlow<STATE>
        get() = state

    abstract fun dispatch(event: EVENT)

    protected suspend fun postSideEffect(effect: SIDE_EFFECT) {
        withContext(Dispatchers.Main.immediate) {
            sideEffectsSubscribers?.invoke(effect) ?: sideEffectsQueue.add(effect)
        }
    }

    protected suspend fun updateState(call: (STATE) -> STATE) {
        withContext(Dispatchers.Main.immediate) {
            val currentState = state.value
            state.emit(call(currentState))
        }
    }

    protected fun getState(): STATE {
        return state.value
    }

    @Composable
    fun collectAsState(): State<STATE> {
        return stateFlow.collectAsState()
    }

    @Composable
    fun collectSideEffect(onSideEffect: (SIDE_EFFECT) -> Unit) {
        val job = remember { mutableStateOf<Job?>(null) }
        val lifecycleOwner = LocalLifecycleOwner.current
        DisposableEffect(lifecycleOwner) {
            val observer = LifecycleEventObserver { _, event ->
                when (event) {
                    Lifecycle.Event.ON_START -> {
                        job.value = viewModelScope.launch(Dispatchers.Main.immediate) {
                            job.value?.cancelAndJoin()
                            sideEffectsSubscribers = onSideEffect
                            sideEffectsQueue.forEach { postSideEffect(it) }
                            sideEffectsQueue.clear()
                        }
                    }
                    Lifecycle.Event.ON_STOP -> {
                        viewModelScope.launch(Dispatchers.Main.immediate) {
                            sideEffectsSubscribers = null
                            job.value?.cancelAndJoin()
                        }
                    }
                    else -> {}
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)
            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
                viewModelScope.launch(Dispatchers.Main.immediate) {
                    sideEffectsSubscribers = null
                    job.value?.cancelAndJoin()
                }
            }
        }
    }
}