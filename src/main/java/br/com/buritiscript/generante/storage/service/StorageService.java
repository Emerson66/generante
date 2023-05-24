package br.com.buritiscript.generante.storage.service;

import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;

@Service
public interface StorageService {
    void init();
    void store(MultipartFile file);
    Stream<Path> loadAll();
    Resource loadAsResource(String fileName);
    void deleteAll();
    Path load(String fileName);
}
