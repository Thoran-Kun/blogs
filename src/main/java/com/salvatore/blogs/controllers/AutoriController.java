package com.salvatore.blogs.controllers;

import com.salvatore.blogs.entities.Autore;
import com.salvatore.blogs.payloads.NewAutorePayload;
import com.salvatore.blogs.services.AutoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoriController {

    private final AutoriService autoriService;

    @Autowired
    public AutoriController(AutoriService autoriService) {
        this.autoriService = autoriService;
    }

    @GetMapping
    public List<Autore> findAll(){
        return this.autoriService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody NewAutorePayload payload){
        return this.autoriService.saveAutore(payload);
    }

    @GetMapping("/{autoreId}")
    public Autore getAutoreById(@PathVariable long autoreId){
        return this.autoriService.findById(autoreId);
    }

    @PutMapping("/{autoreId}")
    public Autore getAutoreByIdAndUpdate(@PathVariable long autoreId, @RequestBody NewAutorePayload payload){
        return this.autoriService.findByIdAndUpdate(autoreId, payload);
    }

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getAutoreIdAndDelete(@PathVariable long autoreId){
        this.autoriService.findByAndDelete(autoreId);
    }
}
