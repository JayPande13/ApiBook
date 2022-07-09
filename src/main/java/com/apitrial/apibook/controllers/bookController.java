package com.apitrial.apibook.controllers;


import java.util.List;
import java.util.Optional;

import com.apitrial.apibook.Services.bookService;
import com.apitrial.apibook.entities.book;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class bookController {
    
    @Autowired
    private bookService Bookservice;

    @PostMapping("/books")
    public ResponseEntity<book> addBook(@RequestBody book Book){
        book b =null; 
        try{
       b = this.Bookservice.addBook(Book);
        System.out.println(b);
        return ResponseEntity.status(HttpStatus.CREATED).body(b);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
        
    }
    

    //getmapping -  getting response also.

   @GetMapping("/books")
    public ResponseEntity <List<book>> getBooks() {

       List<book> list = Bookservice.getAllbooks();
       if(list.size()<=0){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<book> getBookbyId(@PathVariable("id") int id){
        book b = Bookservice.getBookbyId(id);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }



// deletemapping using reponse function.

    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookid")int bookid){

        try{
            this.Bookservice.deleteBook(bookid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // or you can use:ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        
    }




    // Did not understand.

    // update mapping using responseentity and status report
    @PutMapping("/books/{id}")
    public ResponseEntity<book> updateBookbyId(@RequestBody book Book, @PathVariable("id") int id){
        
        
        try{
          this.Bookservice.updateById(Book,id);
            return ResponseEntity.ok().body(Book);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
         
      
    }
    
}
