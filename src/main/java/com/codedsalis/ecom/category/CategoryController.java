package com.codedsalis.ecom.category;

import com.codedsalis.ecom.category.dto.CreateCategory;
import com.codedsalis.ecom.common.BaseController;
import com.codedsalis.ecom.common.EcomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/categories")
@Tag(name = "Categories")
public class CategoryController extends BaseController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    public ResponseEntity<EcomResponse<Category>> create(@Valid @RequestBody CreateCategory request) {
        var response = this.categoryService.create(request);
        return success(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<EcomResponse<Page<Category>>> fetchAll(Pageable pageable) {
        Page<Category> categories = this.categoryService.fetchAll(pageable);
        return success(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EcomResponse<Category>> fetchOne(@Valid @PathVariable UUID id) {
        var category = this.categoryService.findOne(id);
        return success(category);
    }

    @DeleteMapping("/{id}")
    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    public ResponseEntity<Void> deleteOne(@Valid @PathVariable UUID id) {
        this.categoryService.deleteOne(id);
        return noContent();
    }
}
