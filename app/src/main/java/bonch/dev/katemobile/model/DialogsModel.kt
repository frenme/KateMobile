package bonch.dev.katemobile.model

import bonch.dev.katemobile.pojo.Dialog

class DialogsModel : IDialogsModel {

    //here get data from DataBase or Net
    override fun loadDialogs(): ArrayList<Dialog> {
        val list: ArrayList<Dialog> = arrayListOf()

        for (i in 0..12) {
            list.add(
                Dialog(
                    "Егор Щукин",
                    "Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела? Привет, как дела?",
                    "01 Jan"
                )
            )
        }

        return list
    }

}