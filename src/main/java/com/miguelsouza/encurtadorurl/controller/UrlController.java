package com.miguelsouza.encurtadorurl.controller;

import com.miguelsouza.encurtadorurl.model.Url;
import com.miguelsouza.encurtadorurl.service.UrlService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/urls")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/criar")
    public Url criarUrl(@RequestBody String urlOriginal) {
        return urlService.criarUrl(urlOriginal);
    }

    @GetMapping
    public List<Url> listarUrls() {
        return urlService.listarUrls();
    }

    @GetMapping("/{id}")
    public Url buscarPorId(@PathVariable Long id) {
        return urlService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarUrl(@PathVariable Long id) {
        urlService.deletarUrl(id);
    }
}
