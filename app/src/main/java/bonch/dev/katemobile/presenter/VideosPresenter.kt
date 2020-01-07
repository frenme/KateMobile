package bonch.dev.katemobile.presenter

import android.content.Context
import android.widget.LinearLayout
import android.widget.Toast
import bonch.dev.katemobile.MainActivity.Companion.isInternet
import bonch.dev.katemobile.model.IVideosModel
import bonch.dev.katemobile.model.VideosModel
import bonch.dev.katemobile.pojo.Video
import bonch.dev.katemobile.view.IVideosView
import com.google.android.material.snackbar.Snackbar

class VideosPresenter(val context: Context, val iVideosView: IVideosView) : IVideosPresenter {

    private var iVideosModel: IVideosModel? = null

    override fun loadVideos() {
        if (isInternet(context)) {
            val list: ArrayList<Video> = iVideosModel!!.loadVideos()
            setVideoRecyclerView(list)
        } else {
            Toast.makeText(context, "Check your Internet connection", Toast.LENGTH_LONG).show()
        }
    }


    override fun setVideoRecyclerView(list: ArrayList<Video>) {
        iVideosView.initRecyclerVideos(list)
    }


    override fun onItemViewClick(parentLayout: LinearLayout, itemPosition: Int, sectionTitle: String) {
        Snackbar.make(
            parentLayout, String.format(
                "Clicked on position #%s of Section %s",
                itemPosition,
                sectionTitle
            ), Snackbar.LENGTH_LONG
        ).show()
    }


    init {
        if (iVideosModel == null) {
            iVideosModel = VideosModel()
        }
    }

}