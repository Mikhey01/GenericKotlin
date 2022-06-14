data class Note(
    var id: Int,
    val ownerId: Int,
    val date: Int,
    val text: String,
    var isDelete: Boolean = false,
    var comments: MutableList<Comment> =  mutableListOf()
)