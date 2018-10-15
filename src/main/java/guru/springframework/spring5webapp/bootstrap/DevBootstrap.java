package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap
    implements ApplicationListener<ContextRefreshedEvent>
{
    private final AuthorRepository    authorRepsitory;
    private final BookRepository      bookRepository;
    private final PublisherRepository publisherRepository;

    public DevBootstrap(final AuthorRepository authorRepsitory, final BookRepository bookRepository, final PublisherRepository publisherRepository)
    {
        this.authorRepsitory = authorRepsitory;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event)
    {
        initData();
    }

    private void initData()
    {
        final Publisher harperCollins = new Publisher("Harper Collins", "Coblestonestreet 6", 12345, "Phoenix", "Arizona");
        publisherRepository.save(harperCollins);

        // Eric:
        final Author eric = new Author("Eric", "Evans");
        final Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepsitory.save(eric);
        bookRepository.save(ddd);

        final Publisher worx = new Publisher("Worx", "Bakerstreet 12", 54321, "New London", "Florida");
        publisherRepository.save(worx);

        // Rod:
        final Author rod = new Author("Rod", "Johnson");
        final Book noEJB = new Book("J2EE Development without EJB", "2344", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepsitory.save(rod);
        bookRepository.save(noEJB);
    }
}