package com.apitrial.apibook.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name = "books")
public class book {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid")
    private int id;
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;
    public book(int id, String title,Author author) {
        this.id = id;

        this.title = title;

        this.author = author;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public book() {
    }
    @Override
    public String toString() {
        return "book [author=" + author + ", id=" + id + ", title=" + title + "]";
    }


   
    
    

    
}
