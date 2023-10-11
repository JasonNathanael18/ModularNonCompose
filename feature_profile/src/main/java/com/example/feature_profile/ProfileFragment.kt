package com.example.feature_profile

import com.example.domain.utils.DataConvert
import com.example.entity.RepoItemEntity
import com.example.profile.R
import com.example.profile.databinding.FragmentFeatureProfileBinding
import com.example.uicomponent.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment(R.layout.fragment_feature_profile) {

    @Inject
    lateinit var dataConvert: DataConvert

    private lateinit var binding: FragmentFeatureProfileBinding

    private lateinit var repoData: RepoItemEntity

    override fun initComponent() {
        super.initComponent()
        binding = FragmentFeatureProfileBinding.bind(requireView())

        println("the passed data to fragment b is ${ProfileFragmentArgs.fromBundle(requireArguments()).argProfileValue}")

        val data = ProfileFragmentArgs.fromBundle(requireArguments()).argProfileValue

        repoData = dataConvert.toData(data)!!
        println("the passed data to fragment b is ${repoData.repoName}")
    }

}