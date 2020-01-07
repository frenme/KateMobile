package bonch.dev.katemobile.presenter

import bonch.dev.katemobile.Constants.Companion.FULL_PROFILE
import bonch.dev.katemobile.Constants.Companion.GROUPS
import bonch.dev.katemobile.Constants.Companion.VIDEOS
import bonch.dev.katemobile.MainActivity
import bonch.dev.katemobile.view.ProfileView

class ProfilePresenter(val profileView: ProfileView) : IProfilePresenter {

    override fun clickProfileMenu(idMenuItem: Int) {
        when (idMenuItem) {
            FULL_PROFILE -> {
                (profileView.activity as MainActivity).replaceFragment(FULL_PROFILE)
            }
            GROUPS -> {
                (profileView.activity as MainActivity).replaceFragment(GROUPS)
            }
            VIDEOS -> {
                (profileView.activity as MainActivity).replaceFragment(VIDEOS)
            }
        }
    }
}