package bonch.dev.katemobile.presenter

import bonch.dev.katemobile.pojo.Group

interface IGroupsPresenter {
    fun loadGroups()
    fun setGroupRecyclerView(list: ArrayList<Group>)
}