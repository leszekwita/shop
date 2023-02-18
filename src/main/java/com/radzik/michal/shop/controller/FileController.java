package com.radzik.michal.shop.controller;

import com.radzik.michal.shop.flyweight.domain.FileType;
import com.radzik.michal.shop.flyweight.generic.GenericFactory;
import com.radzik.michal.shop.flyweight.generic.strategy.generator.GeneratorStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {


    private final  GenericFactory<FileType, GeneratorStrategy> genericFactory;

    @GetMapping("/{fileType}")
    public void getGeneratedFile(@PathVariable FileType fileType) {
        final byte[] byType = genericFactory.getByType(fileType).generateFile();
    }


}
