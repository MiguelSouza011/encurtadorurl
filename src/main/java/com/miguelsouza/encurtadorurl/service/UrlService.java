package com.miguelsouza.encurtadorurl.service;

import com.miguelsouza.encurtadorurl.model.Url;
import com.miguelsouza.encurtadorurl.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService (UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    private  String gerarCod (String originalUrl){
        originalUrl = originalUrl.replace("https://", "");
        originalUrl = originalUrl.replace("www.", "");
        String[] partes = originalUrl.split("\\.");

        if (originalUrl.length() > 8){
            return originalUrl.substring(0 , 8);
        }
        return originalUrl;
    }

    public Url criarUrl(String urlOriginal) {
        String codigoCurto = gerarCod(urlOriginal);
        Url url = new Url();
        url.setOriginalUrl(urlOriginal);
        url.setShortCode(codigoCurto);
        return urlRepository.save(url);
    }

    public List<Url> listarUrls() {
        return urlRepository.findAll();
    }

    public Url buscarPorId(Long id) {
        return urlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("URL não encontrada"));
    }

    public void deletarUrl(Long id) {
        urlRepository.deleteById(id);
    }
}
