package com.codedsalis.ecom.auth;

import com.codedsalis.ecom.common.BaseController;
import com.codedsalis.ecom.common.EcomResponse;
import com.codedsalis.ecom.user.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/auth")
@Tag(name = "Authentication")
public class AuthController extends BaseController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<EcomResponse<User>> register(
            @Valid @RequestBody RegistrationRequest request
    ) {
        var user = authService.register(request);
        return success(user, CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<EcomResponse<String>> login(@Valid LoginRequest request) {
        var response = authService.login(request);
        return success(response, OK);
    }
}
