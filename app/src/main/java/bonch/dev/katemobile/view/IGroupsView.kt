package bonch.dev.katemobile.view

import android.view.View
import bonch.dev.katemobile.pojo.Group

interface IGroupsView {
    fun initViews(view: View)
    fun initRecyclerGroups(list: ArrayList<Group>)
}