package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;

@Component
public class BootStrapData implements CommandLineRunner{

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository pubRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.pubRepository = pubRepository;
    }

    private final AuthorRepository authorRepository; 
    private final BookRepository bookRepository; 
    private final PublisherRepository pubRepository; 
    

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        Author eric  = new Author("Eric" , "Evans"); 
        Book eric_book = new Book("Design Driver Design", "2002032"); 
        Publisher publisher = new Publisher();
        publisher.setPubName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        pubRepository.save(publisher);
        
        eric.getBooks().add(eric_book); 
        eric_book.getAuthors().add(eric);
        eric_book.getPublishers().add(publisher);

        authorRepository.save(eric); 
        bookRepository.save(eric_book);
        

        

        Author rod = new Author("Rod", "Johnson"); 
        Book noEJB = new Book("J2EE Development", "2030200"); 

        rod.getBooks().add(noEJB); 
        noEJB.getAuthors().add(rod); 
        noEJB.getPublishers().add(publisher); 

        authorRepository.save(rod);
        bookRepository.save(noEJB); 
        pubRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + pubRepository.count());



    }
    
}
