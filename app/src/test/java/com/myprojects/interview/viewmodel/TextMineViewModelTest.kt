package com.myprojects.interview.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.myprojects.interview.repository.TextMineRepositoryImpl
import com.myprojects.interview.stubs.services.ServiceStubs
import getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TextMineViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `calling getLongFormFromAbbreviation and receiving exception should return empty list`() {
        val viewModel = TextMineViewModel(TextMineRepositoryImpl(ServiceStubs.errorService))
        runTest { viewModel.getLongFormFromAbbreviation("") }
        assert(viewModel.textMineLiveData.getOrAwaitValue().isEmpty())
    }

    @Test
    fun `calling getLongFormFromAbbreviation and receiving emptyArray should return empty list`() {
        val viewModel = TextMineViewModel(TextMineRepositoryImpl(ServiceStubs.emptyResponseService))
        runTest { viewModel.getLongFormFromAbbreviation("") }
        assert(viewModel.textMineLiveData.getOrAwaitValue().isEmpty())
    }

    @Test
    fun `calling getLongFormFromAbbreviation and receiving valid array should post results to live data`() {
        val viewModel = TextMineViewModel(TextMineRepositoryImpl(ServiceStubs.validResponseService))
        runTest { viewModel.getLongFormFromAbbreviation("") }
        assert(viewModel.textMineLiveData.getOrAwaitValue().isNotEmpty())
    }
}