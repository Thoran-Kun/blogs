package com.salvatore.blogs.services;

import com.salvatore.blogs.entities.Autore;
import com.salvatore.blogs.exceptions.NotFoundException;
import com.salvatore.blogs.payloads.NewAutorePayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AutoriService {

    private List<Autore> autoriDB = new ArrayList<>();

    public List<Autore> findAll(){
        return this.autoriDB;
    }

    public Autore saveAutore(NewAutorePayload payload) {
        Autore newAutore = new Autore(payload.getNome(), payload.getCognome(), payload.getEmail(), payload.getDataDiNascita());
        this.autoriDB.add(newAutore);
        log.info("l'autore " + newAutore.getNome() + " con id: " + newAutore.getId() + " è stato creato correttamente");
        return newAutore;
    }

    public Autore findById(long autoreId){
        Autore found = null;
        for(Autore autore : this.autoriDB){
            if(autore.getId() == autoreId) found = autore;
        }
        if(found == null) throw new NotFoundException(autoreId);
        return found;
    }

    public Autore findByIdAndUpdate(long autoreId, NewAutorePayload payload) {
        Autore found = null;
        for(Autore autore : this.autoriDB){
            if(autore.getId() == autoreId){
                found = autore;
                autore.setNome(payload.getNome());
                autore.setCognome(payload.getCognome());
                autore.setEmail(payload.getEmail());
                autore.setDataDiNascita(payload.getDataDiNascita());
            }
        }
        if(found == null) throw new NotFoundException(autoreId);
        return found;
    }


    public void findByAndDelete(long autoreId) {
        Autore found = null;
        for(Autore autore : this.autoriDB){
            if(autore.getId() == autoreId) found = autore;
        }
        if(found == null) throw new NotFoundException(autoreId);
    }
}
