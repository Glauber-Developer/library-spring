package glauber.ex1_biblioteca.app.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import glauber.ex1_biblioteca.Domain.Book;

@RestController
@RequestMapping("/biblioteca")
public class LibraryController {
    
    
        private List<Book> books;
        public LibraryController() {
            books = List.of(
                new Book(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954),
                new Book(2, "Dom Quixote", "Miguel de Cervantes", 1605),
                new Book(3, "Cem Anos de Solidão", "Gabriel García Márquez", 1967),
                new Book(4, "A Montanha Mágica", "Thomas Mann", 1924),
                new Book(5, "O Apanhador no Campo de Centeio", "J.D. Salinger", 1951)
            );
        }
    
        @GetMapping("/")
        public String mensagemBiblioteca() {
            return "Bem vindo a nossa biblioteca!";
        }
    
        @GetMapping("/books")
        public List<Book> getLivros() {
            return books;
        }
    
        @GetMapping("/books/{id}")
        public Book getLivro(@PathVariable int id) {
            return books.stream().filter(livro -> livro.getId() == id).findFirst().orElse(null);
        }
    
        @GetMapping("/books/livrosautor/{autor}")
        public List<Book> getLivrosPorAutor(@PathVariable String autor) {
            return books.stream().filter(livro -> livro.getAutor().equals(autor)).toList();
        }
    
        @GetMapping("/books/titulo/{titulo}")
        public List<Book> getLivrosPorTitulo(@PathVariable String titulo) {
            return books.stream().filter(l -> l.getTitulo().equals(titulo)).toList();
        }
    
        @GetMapping("/books/ano/{ano}")
        public Book getAno(@PathVariable int ano) {
            return books.stream().filter(livro -> livro.getAno() == ano).findFirst().orElse(null);
        }
}
