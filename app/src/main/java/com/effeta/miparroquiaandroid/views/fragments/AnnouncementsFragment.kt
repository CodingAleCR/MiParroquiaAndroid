package com.effeta.miparroquiaandroid.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.effeta.miparroquiaandroid.R
import com.effeta.miparroquiaandroid.common.BaseFragment
import com.effeta.miparroquiaandroid.models.Announcement
import com.effeta.miparroquiaandroid.viewmodel.AnnouncementViewModel
import com.effeta.miparroquiaandroid.views.adapters.AnnouncementAdapter
import kotlinx.android.synthetic.main.fragment_announcements.*
import javax.inject.Inject

class AnnouncementsFragment : BaseFragment() {
    override val mLayout: Int = R.layout.fragment_announcements

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mAnnouncementViewModel: AnnouncementViewModel

    @Inject
    lateinit var mAnnouncementAdapter : AnnouncementAdapter

    override fun initializeViewModels() {
        mAnnouncementViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(AnnouncementViewModel::class.java)
    }

    override fun initializeUI() {
        mAnnouncementAdapter.mAnnouncementTypes = resources.getStringArray(R.array.announcement_types)
    }

    override fun observeLiveData(isNewActivity: Boolean) {
        getViewLifecycleOwner()?.let {
            mAnnouncementViewModel.isError.observe(it, Observer {
            Toast.makeText(this@AnnouncementsFragment.context, R.string.error_to_load_announcements, Toast.LENGTH_SHORT).show()
        })
        }
        getViewLifecycleOwner()?.let {
            mAnnouncementViewModel.getAnnouncements().observe(it, Observer {
            progress.visibility = View.GONE
            content.visibility = View.VISIBLE
            showAnnouncements(it)
        })
        }
    }

    private fun showAnnouncements(list: List<Announcement>?) {
        mAnnouncementAdapter.mList = list!!

        announcement_list.adapter = mAnnouncementAdapter
        announcement_list.layoutManager = LinearLayoutManager(this@AnnouncementsFragment.context)

        mAnnouncementAdapter.notifyDataSetChanged()
    }
}
