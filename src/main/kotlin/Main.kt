fun main() {
    val menuManager = MenuManager()
    val archives = mutableListOf<Archive>()

    fun createArchive() {
        val name = menuManager.getInput("Имя архива")
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }


    fun chooseNote(archiveIndex: Int) {
        val archive = archives[archiveIndex]

        fun menu() {
            println("0 - Возврат в меню выбора архива")
            println("1 - Создать заметку")
            if (archive.sizeArchive() > 0) {
                for (i in 0 until archive.sizeArchive()) {
                    println("${i + 2} - Просмотр заметки ${archive.getNote(i).title}")
                }
            }
        }

        while (true) {
            println()

            println("Содержимое архива ${archive.name}")
            val iMenu = menuManager.showMenu(::menu)

            when (iMenu) {
                0 -> return
                1 -> {
                    println()

                    println("Создание заметки")
                    val nameNote = menuManager.getInput("Имя")
                    val textNote = menuManager.getInput("Содержимое")
                    val note = Note(nameNote, textNote)
                    archive.addNote(note)
                    println("Заметка '$nameNote' добавлена.")
                }
                in 2..archive.sizeArchive() + 1 -> {
                    val note = archive.getNote(iMenu - 2)
                    println("# Заметка ${note.title}:")
                    println("${note.content}")
                    println()
                    menuManager.anyKey()
                }
                else -> {
                    menuManager.printMenuError()
                }
            }
        }
    }

    fun chooseArchive() {
        fun menu() {
            println("0 - Выход")
            println("1 - Создать архив")
            if (archives.isNotEmpty()) {
                for (i in archives.indices) {
                    println("${i + 2} - Просмотр архива ${archives[i].name}")
                }
            }
        }

        while (true) {
            val iMenu = menuManager.showMenu(::menu)

            when (iMenu) {
                0 -> return
                1 -> {
                    println()

                    println("Создание архива")
                    createArchive()
                }
                in 2..archives.size + 1 -> {
                    chooseNote(iMenu - 2)
                }
                else -> {
                    menuManager.printMenuError()
                }
            }
        }
    }

    chooseArchive()
}
