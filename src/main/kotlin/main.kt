fun main() {
    //val noteService = NoteService()
    NoteService.add( Note(0,1,2,"Доброе утро"))
    NoteService.add( Note(0,1,2,"Добрый день"))
    NoteService.add( Note(0,1,2,"Добрый вечер"))
    NoteService.add( Note(0,1,2,"Добрый "))

    try {
        CommentService.createComment(2, Comment(1,2,3,"...Добрейшее утречко"))
        CommentService.createComment(2, Comment(2,1,4,"...Добрый, добрый"))
        CommentService.createComment(2, Comment(3,5,6,"...И вам не хворать"))
    }
    catch (e: PostNotFoundException) {
        println(e.message)
    }

    NoteService.delete(4)
    NoteService.deleteComment(1)
    NoteService.restoreComment(1)
   // NoteService.edit(Note(4,1,2,"Доброй ночи"))
    NoteService.editComment((Comment(1,5,6,"...И вам не хворать")))
    NoteService.get()
    NoteService.getComments()
}