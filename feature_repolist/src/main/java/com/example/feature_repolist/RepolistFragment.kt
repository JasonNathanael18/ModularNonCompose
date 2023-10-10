package com.example.feature_repolist

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.entity.RepoItemEntity
import com.example.repolist.R
import com.example.repolist.databinding.FragmentFeatureRepolistBinding
import com.example.router.FeatureScreenProfileRouteContract
import com.example.uicomponent.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RepolistFragment : BaseFragment(R.layout.fragment_feature_repolist),
    RepoListAdapter.OnItemClickListener {

    private lateinit var binding: FragmentFeatureRepolistBinding

    @Inject
    lateinit var adapter: RepoListAdapter

    @Inject
    lateinit var featureProfileRouteContractImpl: FeatureScreenProfileRouteContract

    private val viewModel: RepoListViewModel by viewModels()

    override fun initComponent() {
        super.initComponent()
        binding = FragmentFeatureRepolistBinding.bind(requireView())

        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvRepoList.apply {
            setLayoutManager(layoutManager)
            setAdapter(adapter)
            initialHideList()
        }

        println("the passed data to fragment a is ${RepolistFragmentArgs.fromBundle(requireArguments()).argRepoListValue}")
    }

    override fun initEventListener() {
        super.initEventListener()
        adapter.setOnItemClickListener(this)
    }

    override fun initObserver() {
        super.initObserver()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when {
                        it.isLoading -> {
                            binding.rvRepoList.showWait()
                        }

                        it is RepoListUiState.HasRepoList -> {
                            adapter.addData(it.repoList)
                            binding.rvRepoList.apply {
                                hideWait()
                                showData()
                            }
                        }

                        it is RepoListUiState.RepoListEmpty -> {
                            if (it.error.isNotEmpty()) {
                                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                            } else {
                                binding.rvRepoList.apply {
                                    hideWait()
                                    showEmpty("No Data Found")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onItemClick(view: View, item: RepoItemEntity) {
        //featureProfileRouteContractImpl.show("as", findNavController())
    }
}