package com.ets.testcase.service;

import com.ets.testcase.entity.FileEntity;
import com.ets.testcase.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    private final FileRepository repository;

    @Autowired
    public FileService(FileRepository repository) {
        this.repository = repository;
    }

    public void save(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        repository.save(fileEntity);
    }

    public Optional<FileEntity> getFile(Long id) {
        return repository.findById(id);
    }

    public List<FileEntity> getAllFiles() {
        return repository.findAll();
    }

    public void deleteFile(Long id){
        repository.deleteById(id);
    }

}
