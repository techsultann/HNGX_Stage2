package com.techsultan.hngxstage2.fragment

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.techsultan.hngxstage2.R
import com.techsultan.hngxstage2.ResumeApplication
import com.techsultan.hngxstage2.databinding.FragmentEditBinding
import com.techsultan.hngxstage2.model.Resume
import com.techsultan.hngxstage2.viewmodel.ResumeViewModel
import com.techsultan.hngxstage2.viewmodel.ResumeViewModelFactory


class EditFragment : Fragment() {

    private var _binding : FragmentEditBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ResumeViewModel by viewModels {
        ResumeViewModelFactory((requireActivity().application as ResumeApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getResumeDetails().observe(viewLifecycleOwner){

            getResumeDetails()
        }

        binding.floatingActionButton.setOnClickListener {
            updateResume()
        }


    }



    private fun getResumeDetails() {
        binding.etName.setText(R.string.name)
        binding.etSlack.setText(R.string.slack_username)
        binding.etGithub.setText(R.string.github)
        binding.etLinkedin.setText(R.string.social_handle)
        binding.etTwitter.setText(R.string.social_handle)
        binding.etInstagram.setText(R.string.social_handle)
    }

    private fun updateResume() {

        val name = binding.etName.text.toString()
        val slack = binding.etSlack.text.toString()
        val linkedin = binding.etLinkedin.text.toString()
        val twitter = binding.etTwitter.text.toString()
        val github = binding.etGithub.text.toString()
        val instagram = binding.etInstagram.text.toString()

            val resume = Resume(id, name, slack, twitter, linkedin, instagram, github)
            viewModel.addResume(resume)
            findNavController().navigate(R.id.action_edit_dest_to_main_dest)



    }


}