package fcmb.com.good.service;


import org.dom4j.DocumentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UploadService {

    ResponseEntity<?> uploadFile(MultipartFile file) throws IOException;

    StreamingResponseBody downloadStudent(HttpServletResponse response) throws  IOException;



}
