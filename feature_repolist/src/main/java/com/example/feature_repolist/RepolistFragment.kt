package com.example.feature_repolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.repolist.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepolistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feature_repolist, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //println("the passed data to fragment a is ${FeatureAFragmentArgs.fromBundle(requireArguments()).argAValue}")
//        buttonOpenFeatureScreenB.setOnClickListener {
//            featureScreenBRouteContract.show("as", findNavController())
//        }

    }

}