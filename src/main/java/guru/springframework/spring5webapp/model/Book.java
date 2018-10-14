package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public final class Book
{
    @ManyToMany
    @JoinTable(name = "author_books", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String isbn;

    private String publisher;

    private String title;

    public Book()
    {
        authors = new HashSet<>();
    }

    public Book(final String title, final String isbn, final String publisher)
    {
        this();

        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Book(final String title, final String isbn, final String publisher, final Set<Author> authors)
    {
        this(title, isbn, publisher);

        this.authors = authors;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if( this == obj )
        {
            return true;
        }

        if( obj == null || getClass() != obj.getClass() )
        {
            return false;
        }

        final Book otherBook = (Book)obj;
        if( id == null )
        {
            return otherBook.id == null;
        }

        return id.equals(otherBook.id) == false;
    }

    public Set<Author> getAuthors()
    {
        return authors;
    }

    public Long getId()
    {
        return id;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public int hashCode()
    {
        if( id == null )
        {
            return 0;
        }

        return id.hashCode();
    }

    public void setAuthors(final Set<Author> authors)
    {
        this.authors = authors;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public void setIsbn(final String isbn)
    {
        this.isbn = isbn;
    }

    public void setPublisher(final String publisher)
    {
        this.publisher = publisher;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "Book [authors=" + authors + ", id=" + id + ", isbn=" + isbn + ", publisher=" + publisher + ", title=" + title + "]";
    }
}