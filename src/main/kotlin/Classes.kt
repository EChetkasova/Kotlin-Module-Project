data class Archive(val name: String){
    val notes: MutableList<Note> = mutableListOf()

    fun addNote(note: Note){
        notes.add(note)
    }

    fun getNote(i: Int): Note {
        return notes[i]
    }

    fun sizeArchive(): Int {
        return notes.size
    }
}

data class Note(val title: String, val content: String)
