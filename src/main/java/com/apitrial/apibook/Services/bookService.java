package com.apitrial.apibook.Services;


import java.util.List;


import com.apitrial.apibook.Repository.bookrepo;
import com.apitrial.apibook.entities.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class bookService {

    @Autowired
    private bookrepo Repobj;
    // private static List<book> list =new ArrayList<>();
    // static{

        
    //     list.add(new book(12,"You can study","YZA"));
    //     list.add(new book(13,"I will study","ATX"));
    //     list.add(new book(14,"I don' want to","ABC"));


    // }
    //adding the book
    
    public book addBook(book b){
        
        book result = Repobj.save(b);
        return result;
    }

    public List<book> getAllbooks(){
        List<book> l = (List<book>)this.Repobj.findAll();
        return l;
    }
    public book getBookbyId(int id){
        book Book = null;
        try{
        // Book =list.stream().filter(e->e.getId()==id).findFirst().get();
        Book = this.Repobj.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  Book;
    }

    public void deleteBook(int bid){

      Repobj.deleteById(bid);
    }



    public void updateById(book Book,int id){
        
        Book.setId(id);

        Repobj.save(Book);

        //Foreach method not working idk why.

    //  list =list.forEach(book-> {
    //         if(book.getId()==id){
    //             book.setAuthor(Book.getAuthor());
    //             book.setTitle(Book.getTitle());
    //         }
    //         return book;
    //     }).collect(Collectors.toList());



    //    list = list.stream().map(v-> 
    //     {
    //         if(v.getId()==id){
    //             v.setAuthor(Book.getAuthor());
    //             v.setTitle(Book.getTitle());
    //         }
        
    //         return v;
    //     }).collect(Collectors.toList());
    }
    
}
