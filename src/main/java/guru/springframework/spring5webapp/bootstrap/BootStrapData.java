package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository; 
    private final BookRepository bookRepository; 


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }



    

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        Author eric  = new Author("Eric" , "Evans"); 
        Book eric_book = new Book("Design Driver Design", "2002032"); 
        
        eric.getBooks().add(eric_book); 
        eric_book.getAuthors().add(eric);

        authorRepository.save(eric); 
        bookRepository.save(eric_book); 

        Author rod = new Author("Rod", "Johnson"); 
        Book noEJB = new Book("J2EE Development", "2030200"); 

        rod.getBooks().add(noEJB); 
        noEJB.getAuthors().add(rod); 

        authorRepository.save(rod);
        bookRepository.save(noEJB); 

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
    
}
