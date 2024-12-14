package com.codedsalis.ecom.category;

import com.codedsalis.ecom.category.dto.CreateCategory;
import com.codedsalis.ecom.common.exception.ServerUnavailableException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(CreateCategory data) {
        var category = Category.builder()
                .name(data.getName())
                .build();

        try {
            return categoryRepository.save(category);
        } catch (DataAccessException ex) {
            log.debug(ex);
            throw new ServerUnavailableException("Something went wrong, please try again",
                    HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    public Page<Category> fetchAll(Pageable pageable) {
        return this.categoryRepository.findAll(pageable);
    }

    public Category findOne(UUID id) throws EntityNotFoundException {
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public void deleteOne(UUID id) throws EntityNotFoundException {
        var category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        try {
            this.categoryRepository.delete(category);
        } catch (DataAccessException ex) {
            log.error(ex);
            throw new ServerUnavailableException("Something went wrong, please try again");
        }
    }
}
