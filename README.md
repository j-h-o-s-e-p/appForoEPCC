
# SOLID
**Single Responsibility Principle (SRP):**
- La clase CommentService tiene la única responsabilidad de manejar la lógica de negocio relacionada con los comentarios. No mezcla lógica de otras entidades o procesos.

**Open/Closed Principle (OCP):**
- Aunque el código no muestra directamente la extensibilidad, el hecho de que CommentService implemente ICommentService sugiere que se pueden agregar nuevas funcionalidades mediante la extensión de la clase o la creación de nuevas implementaciones de la interfaz sin modificar el código existente.

**Liskov Substitution Principle (LSP):**
- CommentService implementa ICommentService, lo que significa que cualquier instancia de ICommentService en el código puede ser sustituida por una instancia de CommentService sin alterar el comportamiento esperado.

**Interface Segregation Principle (ISP):**
- ICommentService define una interfaz específica para las operaciones relacionadas con comentarios. Este principio se cumple porque no se obliga a CommentService a implementar métodos que no necesita.

**Dependency Inversion Principle (DIP):**
- CommentService depende de abstracciones (UserService, PostService, AnswerService, CommentRepositoryImp) en lugar de implementaciones concretas. Esto se logra a través de la inyección de dependencias en el constructor, aunque idealmente, las dependencias deberían ser interfaces en lugar de clases concretas (UserService, PostService, AnswerService, CommentRepository).
```java
public class CommentService implements ICommentService {
    
    private IUserService userService;
    private IPostService postService;
    private IAnswerService answerService;
    private ICommentRepository commentRepository;

    public CommentService(IUserService userService, IPostService postService, IAnswerService answerService, ICommentRepository commentRepository) {
        this.userService = userService;
        this.postService = postService;
        this.answerService = answerService;
        this.commentRepository = commentRepository;
    }
}
```

# ESTILOS DE PROGRAMACION 
**COOKBOOK** 
- Este estilo se caracteriza por tener métodos que siguen una receta específica para realizar una tarea.
```java
    public Comment postComment(Long postId, Long userId, String content) {
        // Seguir receta para publicar un comentario
        try {
            Post post = postService.getPostById(postId);
            Entry entry = post.getEntry();
            ForoUser user = userService.getUserbyId(userId);

            Comment comment = new Comment();
            comment.setUser(user);
            comment.setEntry(entry);
            comment.setContent(content);

            return commentRepository.save(comment);
        } catch (Exception e) {
            throw new CreationException("No se pudo crear el comentario al post", e);
        }
    }
```
**PIPELINE**
- Este estilo enfatiza el procesamiento de datos a través de una secuencia de operaciones, donde la salida de una operación es la entrada de la siguiente.
```java
    public Comment answerComment(Long answerId, Long userId, String content) {
        // Procesar datos en una secuencia de pasos
        return saveComment(
            buildComment(
                findEntry(answerService.getAnswerById(answerId)),
                userService.getUserbyId(userId),
                content
            )
        );
    }

    private Entry findEntry(Post post) {
        return post.getEntry();
    }
```
