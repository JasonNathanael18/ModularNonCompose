package com.example.feature_repolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.repolist.R
import com.example.repolist.databinding.FragmentFeatureRepolistBinding
import com.example.router.FeatureScreenProfileRouteContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RepolistFragment : Fragment() {

    private lateinit var binding: FragmentFeatureRepolistBinding

    @Inject
    lateinit var featureProfileRouteContractImpl: FeatureScreenProfileRouteContract

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

    }

}