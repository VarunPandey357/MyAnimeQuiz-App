package com.smalltide.myanimequiz

object Constants {

    // TODO  Create a constant variables which we required in the result screen
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "Name the character and the anime it belongs to?",
            R.drawable.ani1_resize,
            "Tanjiro, Demon Slayer", "Ichigo, Bleach",
            "Aizen, Code Geass", "Zenitsu, Demon Slayer", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "This popular frame is from which anime?",
            R.drawable.ani2_resize,
            "Bleach", "SpyXFamily",
            "Naruto", "Baki", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "Who is this character?",
            R.drawable.ani3_resize,
            "Aoi Todo", "Lelouch Lamperouge",
            "Megumi Fushiguro", "Gojo Satoru", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "These characters belong to which anime?",
            R.drawable.ani4_resize,
            "Demon Slayer", "JoJo's Bizarre Adventure",
            "Rick and Morty", "One Punch Man", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What is the name of this Titan?",
            R.drawable.ani6_resize,
            "Armored Titan", "Colossal Titan",
            "Attack Titan", "War Hammer Titan", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "These two characters belong to which clan?",
            R.drawable.ani7_resize,
            "Uchiha Clan", "Uzumaki Clan",
            "Amagiri Clan", "Senju Clan", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What are the names of these characters?",
            R.drawable.ani8_resize,
            "Naruto and Orochimaru", "Yuno ans Yami",
            "Asta and Yami", "Asta and Langris", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "Name the character and the anime it belongs to?",
            R.drawable.ani9_resize,
            "Anya, SpyXFamily", "Asta, Black Clover",
            "Jiraiya, Bleach", "Yuno, Black Clover", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "who is this character?",
            R.drawable.ani10_resize,
            "Kurama", "Sukuna",
            "Goku", "Ayanokoji", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "Who is this character?",
            R.drawable.ani11_resize,
            "Yuji Itadori", "Megumi Fushiguro",
            "Fuegoleon Vermillion", "Biscuit Oliva", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}