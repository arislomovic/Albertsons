package com.myprojects.interview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.myprojects.interview.databinding.FormFragmentBinding
import com.myprojects.interview.viewmodel.TextMineViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class FormFragment : Fragment() {

    private val viewModel: TextMineViewModel by viewModel()
    private lateinit var binding: FormFragmentBinding
    private lateinit var listAdapter: ArrayAdapter<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View {
        binding = FormFragmentBinding.inflate(inflater, container, false)
        listAdapter = ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObservers()
        binding.resultList.adapter = listAdapter
        binding.submitButton.setOnClickListener {
            val shortForm = binding.shortFormEditText.text?.toString()
            if (!shortForm.isNullOrBlank()) {
                viewModel.getLongFormFromAbbreviation(shortForm)
            }
        }
    }

    private fun bindObservers() {
        viewModel.textMineLiveData.observe(viewLifecycleOwner, ::onLongFormListRetrieved)
    }

    private fun onLongFormListRetrieved(list: List<String>) {
        listAdapter.clear()
        listAdapter.addAll(list)
    }
}