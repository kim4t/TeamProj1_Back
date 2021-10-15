package bfs.TeamProj.controller;


import bfs.TeamProj.Service.AmazonS3BucketService;
import bfs.TeamProj.constant.Constant;
import bfs.TeamProj.security.util.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class S3BucketController {
    private AmazonS3BucketService amazonS3BucketService;

    S3BucketController(AmazonS3BucketService amazonS3BucketService) {
        this.amazonS3BucketService = amazonS3BucketService;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(HttpServletRequest request, @RequestPart(value = "file") MultipartFile file) {
        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        System.out.println(username);
        if(username == null) {
            return "please login";
        }
        return this.amazonS3BucketService.uploadFile(file, username);
    }

}
