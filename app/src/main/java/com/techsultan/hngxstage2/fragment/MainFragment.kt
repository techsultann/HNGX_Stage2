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
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.techsultan.hngxstage2.R
import com.techsultan.hngxstage2.ResumeApplication
import com.techsultan.hngxstage2.databinding.FragmentMainBinding
import com.techsultan.hngxstage2.model.Resume
import com.techsultan.hngxstage2.viewmodel.ResumeViewModel
import com.techsultan.hngxstage2.viewmodel.ResumeViewModelFactory


class MainFragment : Fragment(), MenuProvider {

    private var _binding: FragmentMainBinding? =  null
    private val binding get() = _binding!!
    private val resumeViewModel: ResumeViewModel by viewModels {
        ResumeViewModelFactory((requireActivity().application as ResumeApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       resumeViewModel.getResumeDetails().observe(viewLifecycleOwner) { resume ->
           if (resume != null) {
               updateUi(resume)
           } else {

               return@observe
           }

       }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


    private fun updateUi(resume: Resume) {

        val name = binding.nameTv
        val slack = binding.slackTv
        val twitter = binding.twitterTv
        val linkedin = binding.locationTv
        val github = binding.tvGithub
        val instagram = binding.tvInstagram

        name.text = resume.name
        slack.text = resume.slack
        twitter.text = resume.twitter
        linkedin.text = resume.linkedin
        github.text = resume.github
        instagram.text = resume.instagram

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.editMenu -> {
                findNavController().navigate(R.id.action_main_dest_to_edit_dest)
            }
        }
        return true
    }

}