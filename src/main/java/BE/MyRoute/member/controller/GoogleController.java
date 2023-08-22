package BE.MyRoute.member.controller;

import BE.MyRoute.member.service.GoogleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/google")
public class GoogleController {

    private final GoogleService googleService;

    @GetMapping("/callback")
    public void GoogleCallback(@RequestParam String code, @PathVariable String registrationId) {
        googleService.GoogleCallback(code, registrationId);
    }
}
