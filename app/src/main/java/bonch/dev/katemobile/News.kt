package bonch.dev.katemobile


import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class News : Fragment() {

    private val API_KEY = "2538d74de2a040b28dfb0b3f7bc5947c"
    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var searchEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.news_fragment, container, false)

        initViews(view)
        setListener()
        //set default query news recycler
        if (isInternet(context!!)) {
            sendRequest("USA")
        } else {
            Toast.makeText(
                context, "Check your Internet connection", Toast.LENGTH_LONG
            ).show()
        }

        return view
    }


    private fun sendRequest(query: String) {
        var response: Response<NewsModel>
        val service = RetrofitFactory.makeRetrofitService()
        var list: List<ArticlesModel>

        CoroutineScope(Dispatchers.IO).launch {
            //send request and get data object
            response = service.getData(query, API_KEY)
            try {
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        //get list data and init recycler
                        list = response.body()!!.articles
                        initRecyclerNews(list)
                    } else {
                        Toast.makeText(context, "${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (err: HttpException) {
                Log.e("Retrofit", "${err.printStackTrace()}")
            }
        }
    }


    private fun initRecyclerNews(list: List<ArticlesModel>) {
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
                    sendRequest(textQuery)
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