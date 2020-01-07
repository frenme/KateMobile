package bonch.dev.katemobile.model

import bonch.dev.katemobile.pojo.Message

class ShowDialogModel : IShowDialogModel {

    //here get data from DataBase or Net
    override fun loadMessages(): ArrayList<Message> {
        val list: ArrayList<Message> = arrayListOf()

        for (i in 1..25) {
            if (i % 2 == 0) {
                list.add(
                    Message(
                        "Привет, как дела?",
                        "21:23",
                        true
                    )
                )
            } else {
                list.add(
                    Message(
                        "Привет, как дела?",
                        "21:23",
                        false
                    )
                )
            }
        }

        return list
    }







}