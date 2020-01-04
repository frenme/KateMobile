package bonch.dev.katemobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FullProfile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.full_profile_fragment, container, false)

//        val x = view.findViewById<LinearLayout>(R.id.wallFullProfile)
//        x.setOnClickListener{
//
//        }

        return view
    }

}