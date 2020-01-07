package bonch.dev.katemobile.view


import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.katemobile.MainActivity.Companion.isInternet
import bonch.dev.katemobile.R
import bonch.dev.katemobile.adapters.NewsAdapter
import bonch.dev.katemobile.pojo.Articles
import bonch.dev.katemobile.presenter.INewsPresenter
import bonch.dev.katemobile.presenter.NewsPresenter

class NewsView : Fragment(), INewsView {

    private val DEFAULT_QUERY = "USA"
    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var searchEditText: EditText
    private var iNewsPresenter: INewsPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.news_fragment, container, false)

        if(iNewsPresenter == null){
            iNewsPresenter = NewsPresenter(context!!, this)
        }

        //set default news recycler
        iNewsPresenter!!.loadNews(DEFAULT_QUERY)

        initViews(view)
        setListener()

        return view
    }


    override fun initRecyclerNews(list: List<Articles>) {
        newsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newsRecyclerView.adapter =
            NewsAdapter(list, context!!)
    }


    private fun setListener() {
        //listener tap on key "Enter"
        searchEditText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val textQuery = searchEditText.text.toString().trim().toLowerCase()

                if (isInternet(context!!)) {
                    iNewsPresenter!!.loadNews(textQuery)
                } else {
                    Toast.makeText(
                        context, "Check your Internet connection", Toast.LENGTH_LONG
                    ).show()
                }

                val imm = v.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)
                return@OnEditorActionListener true
            }
            false
        })
    }


    private fun initViews(view: View) {
        newsRecyclerView = view.findViewById(R.id.newsRecycler)
        searchEditText = view.findViewById(R.id.searchEditText)
    }
}