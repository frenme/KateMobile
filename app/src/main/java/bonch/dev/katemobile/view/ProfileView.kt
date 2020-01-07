package bonch.dev.katemobile.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import bonch.dev.katemobile.Constants.Companion.FULL_PROFILE
import bonch.dev.katemobile.Constants.Companion.GROUPS
import bonch.dev.katemobile.Constants.Companion.VIDEOS
import bonch.dev.katemobile.R
import bonch.dev.katemobile.presenter.IProfilePresenter
import bonch.dev.katemobile.presenter.ProfilePresenter

class ProfileView : Fragment(), IProfileView {

    private var iProfilePresenter: IProfilePresenter? = null
    private lateinit var userName: TextView
    private lateinit var friendsBtn: TextView
    private lateinit var wallBtn: TextView
    private lateinit var groupsBtn: TextView
    private lateinit var photosBtn: TextView
    private lateinit var audioBtn: TextView
    private lateinit var videoBtn: TextView
    private lateinit var bookmarksBtn: TextView
    private lateinit var repliesBtn: TextView
    private lateinit var storiesBtn: TextView
    private lateinit var fullProfileBtn: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.profile_fragment, container, false)

        if (iProfilePresenter == null) {
            iProfilePresenter = ProfilePresenter(this)
        }

        initProfileMenu(view)
        setListeners()
        return view
    }


    override fun setListeners() {
        //notify presenter if click item
        userName.setOnClickListener {
            iProfilePresenter!!.clickProfileMenu(FULL_PROFILE)
        }

        friendsBtn.setOnClickListener {
            //todo
        }
        wallBtn.setOnClickListener {
            //todo
        }
        groupsBtn.setOnClickListener {
            iProfilePresenter!!.clickProfileMenu(GROUPS)
        }
        photosBtn.setOnClickListener {
            //todo
        }
        audioBtn.setOnClickListener {
            //todo
        }
        videoBtn.setOnClickListener {
            iProfilePresenter!!.clickProfileMenu(VIDEOS)
        }
        bookmarksBtn.setOnClickListener {
            //todo
        }
        repliesBtn.setOnClickListener {
            //todo
        }
        storiesBtn.setOnClickListener {
            //todo
        }
        fullProfileBtn.setOnClickListener {
            iProfilePresenter!!.clickProfileMenu(FULL_PROFILE)
        }
    }


    override fun initProfileMenu(view: View) {
        userName = view.findViewById(R.id.userName)
        friendsBtn = view.findViewById(R.id.friends)
        wallBtn = view.findViewById(R.id.wall)
        groupsBtn = view.findViewById(R.id.groups)
        photosBtn = view.findViewById(R.id.photos)
        audioBtn = view.findViewById(R.id.audio)
        videoBtn = view.findViewById(R.id.video)
        bookmarksBtn = view.findViewById(R.id.bookmarks)
        repliesBtn = view.findViewById(R.id.replies)
        storiesBtn = view.findViewById(R.id.stories)
        fullProfileBtn = view.findViewById(R.id.fullProfile)
    }
}