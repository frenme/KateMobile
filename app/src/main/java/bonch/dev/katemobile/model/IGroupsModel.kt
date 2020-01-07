package bonch.dev.katemobile.model

import bonch.dev.katemobile.pojo.Group


interface IGroupsModel {
    fun loadGroups(): ArrayList<Group>
}