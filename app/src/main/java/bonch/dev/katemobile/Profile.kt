package bonch.dev.katemobile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Profile : Fragment() {

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
            inflater.inflate(R.layout.profile_fragment, container, false)!!

        initProfileMenu(view)
        setListeners()
        return view
    }


    private fun initProfileMenu(view: View) {
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


    private fun setListeners() {
        userName.setOnClickListener {
            (activity as MainActivity).replaceFragment1()
        }

        friendsBtn.setOnClickListener {
            //todo
        }
        wallBtn.setOnClickListener {
            //todo
        }
        groupsBtn.setOnClickListener {
            (activity as MainActivity).replaceFragment2()
        }
        photosBtn.setOnClickListener {
            //todo
        }
        audioBtn.setOnClickListener {
            //todo
        }
        videoBtn.setOnClickListener {
            (activity as MainActivity).replaceFragment3()
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
            //todo
        }
    }
}