package bonch.dev.katemobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dialogs: Fragment(){

    private lateinit var reviewsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.dialogs_fragment, container, false)!!

        initRecyclerDialogs(view)
        return view
    }



    private fun initRecyclerDialogs(view: View) {
        val list: ArrayList<DialogsModel> = arrayListOf()
        for (i in 0..12) {
            list.add(
                DialogsModel(
                    "Егор Щукин",
                    "Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела?",
                    "01 Jan"
                )
            )
        }

        reviewsRecyclerView = view.findViewById(R.id.dialogsRecycler)
        reviewsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        reviewsRecyclerView.adapter =
            DialogsAdapter(list, (activity as MainActivity), context!!)
    }


}