package bonch.dev.katemobile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.katemobile.MainActivity
import bonch.dev.katemobile.R
import bonch.dev.katemobile.adapters.DialogsAdapter
import bonch.dev.katemobile.pojo.Dialog
import bonch.dev.katemobile.presenter.DialogsPresenter
import bonch.dev.katemobile.presenter.IDialogsPresenter

class DialogsView : Fragment(), IDialogsView {

    private lateinit var reviewsRecyclerView: RecyclerView
    private var iDialogsPresenter: IDialogsPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.dialogs_fragment, container, false)

        if (iDialogsPresenter == null) {
            iDialogsPresenter = DialogsPresenter(context!!, this, (activity as MainActivity))
        }

        //init recycler and load list of dialogs
        initRecyclerDialogs(view)
        iDialogsPresenter!!.loadDialogs()


        return view
    }


    override fun initRecyclerDialogs(list: ArrayList<Dialog>) {
        reviewsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        reviewsRecyclerView.adapter = DialogsAdapter(list, iDialogsPresenter!!, context!!)
    }


    override fun initRecyclerDialogs(view: View) {
        reviewsRecyclerView = view.findViewById(R.id.dialogsRecycler)
    }


}