package bonch.dev.katemobile.model

import bonch.dev.katemobile.pojo.Group


class GroupsModel : IGroupsModel {

    //here get data from DataBase or Net
    override fun loadGroups(): ArrayList<Group> {
        val list: ArrayList<Group> = arrayListOf()

        for (i in 0..12) {
            list.add(
                Group("Some group")
            )
        }

        return list
    }

}