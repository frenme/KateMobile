package bonch.dev.katemobile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class Profile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.profile_fragment, container, false)!!
        val friends: TextView = view.findViewById(R.id.friends)
        val stories: TextView = view.findViewById(R.id.stories)

        friends.setOnClickListener {
            Toast.makeText(context, "AAAAA", Toast.LENGTH_LONG).show()
        }

        stories.setOnClickListener {
            Toast.makeText(context, "BBBBBBB", Toast.LENGTH_LONG).show()
        }


        return view
    }
}