abstract class BaseService<T> {
    val item = mutableListOf<T>()

    open fun add(note: T) {}   //Создает новую заметку у текущего пользователя.
    //open fun createComment (noteId:Int, comment: T){}     // Добавляет новый комментарий к заметке.
    abstract  fun delete (id: Int):Boolean            //Удаляет заметку текущего пользователя.
    abstract  fun deleteComment (id: Int):Boolean     //Удаляет комментарий к заметке.
    abstract fun edit (note: T) :Boolean             //Редактирует заметку текущего пользователя.
    open fun editComment (comment: T) {}   //Редактирует указанный комментарий у заметки.
    open fun get (note: T) {}               //Возвращает список заметок, созданных пользователем.
    abstract fun getById (id: Int):Boolean        //Возвращает заметку по её id.


    open fun getComments (note: T) {}       //Возвращает список комментариев к заметке.
   // open fun getFriendsNotes (note: T) {}    //Возвращает список заметок друзей пользователя.
    abstract fun restoreComment (id: Int) : Boolean     //Восстанавливает удалённый комментарий.


}