package com.apitrial.apibook.Repository;

import com.apitrial.apibook.entities.book;

import org.springframework.data.repository.CrudRepository;

public interface bookrepo extends CrudRepository<book,Integer> {

    public book findById(int id);

   
    
    
}
