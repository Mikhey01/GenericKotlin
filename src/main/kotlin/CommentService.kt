object CommentService {

    fun createComment(noteId: Int, comment: Comment): Comment {
        for (note in NoteService.item) {
            if (noteId == note.id) {
                if (note.comments.isEmpty()) {
                    comment.id = 1
                } else {
                    comment.id = note.comments.last().id + 1
                }
                note.comments += comment
                return note.comments.last()
            }

        }
        throw PostNotFoundException("Заметка для комментария не найдена")
    }
}