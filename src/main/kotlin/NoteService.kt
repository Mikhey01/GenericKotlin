object NoteService : BaseService<Note>() {

    override fun add(note: Note) {
        if (item.isEmpty()) {
            note.id = 1
        } else {
            note.id = item.last().id + 1
        }
        item += note
    }


    override fun delete(id: Int): Boolean {
        for ((index, note) in item.withIndex()) {
            if (index == id - 1) {
                val deleteNotes = note.copy(
                    isDelete = true
                )
                item[index] = deleteNotes
                return true
            }
        }
        return false
    }

    override fun deleteComment(id: Int): Boolean {
        for (note in item)
            for ((index, comment) in note.comments.withIndex())
                if (index == id - 1) {
                    val deleteComments = comment.copy(
                        isDelete = true
                    )
                    note.comments[index] = deleteComments
                    return true
                }
        return false
    }

    override fun restoreComment(id: Int): Boolean {
        for (note in item)
            for ((index, comment) in note.comments.withIndex())
                if (comment.id == id)
                    if (comment.isDelete) {
                        val restoreComments = comment.copy(
                            isDelete = false
                        )
                        note.comments[index] = restoreComments
                        return true
                    }
        return false
    }

    fun get() {
        for (note in item) {
            if (note.isDelete) {
                println("Заметка удалена $note.id")
            } else {
                println(note.text + " " + note.id)
            }
        }
    }

    override fun edit(note: Note): Boolean {
        for ((index, editNote) in item.withIndex()) {
            if (editNote.id == note.id) {
                item[index] = note.copy(
                    ownerId = note.ownerId,
                    date = note.date
                )
                return true
            }
        }
        return false
    }

    fun editComment(comment: Comment): Boolean {
        for (note in item)
            for ((index, editNote) in note.comments.withIndex()) {
                if (editNote.id == comment.id) {
                    note.comments[index] = comment.copy(
                        ownerId = comment.ownerId,
                        date = comment.date
                    )
                    return true
                }
            }
        return false
    }

    override fun getById(id: Int): Boolean {
        for (note in item) {
            if (note.id == id) {
                return true
            }
        }
        return false
    }

    fun getComments(){
        for (note in item)
    for (comment in note.comments) {
        if (comment.isDelete == true) {
            println("...Комметнатий к заметке удален ")
        } else {
            println(comment.text + " " + comment.id)

        }
    }
    }

    fun clear() {
        item.clear()
    }
}