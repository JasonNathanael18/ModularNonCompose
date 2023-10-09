package com.example.feature_repolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.repolist.R
import com.example.repolist.databinding.FragmentFeatureRepolistBinding
import com.example.router.FeatureScreenProfileRouteContract
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RepolistFragment : Fragment() {

    private lateinit var binding: FragmentFeatureRepolistBinding

    @Inject
    lateinit var featureProfileRouteContractImpl: FeatureScreenProfileRouteContract

    private val viewModel: RepoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feature_repolist, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFeatureRepolistBinding.bind(requireView())
        println("the passed data to fragment a is ${RepolistFragmentArgs.fromBundle(requireArguments()).argRepoListValue}")
        binding.buttonOpenFeatureScreenB.setOnClickListener {
            featureProfileRouteContractImpl.show("as", findNavController())
        }
        //        buttonOpenFeatureScreenB.setOnClickListener {
//            featureScreenBRouteContract.show("as", findNavController())
//        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when {
                        it.isLoading -> {
                            Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                        }

                        it is RepoListUiState.HasRepoList -> {
                            Toast.makeText(requireContext(), "Ada isi ${it.repoList.first().repoName}", Toast.LENGTH_SHORT).show()
                        }

                        it is RepoListUiState.RepoListEmpty -> {
                            if (it.error.isNotEmpty()) {
                                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(requireContext(), "Kosong", Toast.LENGTH_SHORT)
                                    .show()

                            }
                        }
                    }
                }
            }
        }

    }

}