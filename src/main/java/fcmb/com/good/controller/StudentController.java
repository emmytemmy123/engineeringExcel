package fcmb.com.good.controller;

import java.io.IOException;

import com.lowagie.text.DocumentException;
import fcmb.com.good.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

	private final UploadService uploadService;
//itext

	@PostMapping("/upload/data")
	@ApiOperation(value = "Upload profile picture of the dealer", response = String.class,
			produces = "application/json", consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity uploadFile(
			@RequestPart(value = "file", required = true) MultipartFile file) throws IOException {
		return uploadService.uploadFile(file);
	}

	@GetMapping("/download")
	StreamingResponseBody downloadStudent(
			HttpServletResponse response) throws IOException {
		return uploadService.downloadStudent(response);
	}






}