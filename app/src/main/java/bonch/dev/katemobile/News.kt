package bonch.dev.katemobile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class News: Fragment(){

    private lateinit var reviewsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.news_fragment, container, false)!!
        initRecyclerNews(view)
        return view
    }


    private fun initRecyclerNews(view: View) {
        val list: ArrayList<NewsModel> = arrayListOf()
        for (i in 0..12) {
            list.add(
                NewsModel(
                    "Егор Щукин",
                    "Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела?",
                    "01 Jan"
                )
            )
        }

        reviewsRecyclerView = view.findViewById(R.id.newsRecycler)
        reviewsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        reviewsRecyclerView.adapter =
            NewsAdapter(list,  context!!)
    }
}