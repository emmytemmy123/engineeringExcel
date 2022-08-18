package fcmb.com.good.service.impl;

import fcmb.com.good.exports.UserExporter;
import fcmb.com.good.model.Engine;
import fcmb.com.good.repo.EngineRepository;
import fcmb.com.good.service.UploadService;
import fcmb.com.good.utills.EngineCol;
import fcmb.com.good.utills.Utils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class UploadServiceImpl  implements UploadService {

    @NonNull
    private EngineRepository engineRepository;

    @Value("${FILE_UPLOAD_LOCATION}")
    private String uploadLocation;



    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file) throws IOException {
        File uploadedFile=saveFile(file);
        String result=   readExcel(uploadedFile);
        return ResponseEntity.ok(result);
    }

    @Override
    public StreamingResponseBody downloadStudent(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment; filename=customers.xls");
        response.setHeader("Cache-Control",
                "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        List<Engine>  engineList = engineRepository.findAll();
        ByteArrayInputStream out  = UserExporter.generateReport(engineList);
        return Utils.getStreamingResponseBody(out);
    }




    private String readExcel(File file) throws IOException {

        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = Utils.getWorkbook(inputStream, file.getAbsolutePath());
        Sheet firstSheet = workbook.getSheetAt(0);
        Map<String, Integer> map = Utils.getColumnName(firstSheet);
        Iterator<Row> iterator = firstSheet.iterator();
        iterator.next();
        while (iterator.hasNext()) {
             Row row = iterator.next();

             String id= Utils.getData(row, EngineCol.ID,map)+"";
             String psn= Utils.getData(row, EngineCol.PSN,map)+"";
             String names= Utils.getData(row, EngineCol.NAMES,map)+"";
             String lga= Utils.getData(row, EngineCol.LGA,map)+"";
             String sex= Utils.getData(row, EngineCol.SEX,map)+"";
             String dob= Utils.getData(row, EngineCol.DOB,map)+"";
             String dofa= Utils.getData(row, EngineCol.DOFA,map)+"";
             String doc= Utils.getData(row, EngineCol.DOC,map)+"";
             String gl= Utils.getData(row, EngineCol.GL,map)+"";
             String dopa= Utils.getData(row, EngineCol.DOPA,map)+"";
             String position= Utils.getData(row, EngineCol.POSITION,map)+"";
             String cadre= Utils.getData(row, EngineCol.CADRE,map)+"";
             String mda= Utils.getData(row, EngineCol.MDA,map)+"";
             String hq= Utils.getData(row, EngineCol.HQ,map)+"";
             String pl= Utils.getData(row, EngineCol.PL,map)+"";
             String pn= Utils.getData(row, EngineCol.PN,map)+"";

             Engine eng = new Engine();

            eng.setPsn(psn);
            eng.setNames(names);
            eng.setLga(lga);
            eng.setSex(sex);
            eng.setDob(LocalDate.parse((dob)));
            eng.setDofa(LocalDate.parse(dofa));
            eng.setDoc(LocalDate.parse(doc));
            eng.setGl(gl);
            eng.setDopa(LocalDate.parse(dopa));
            eng.setPosition(position);
            eng.setCadre(cadre);
            eng.setMda(mda);
            eng.setHq(hq);
            eng.setPl(pl);
            eng.setPn(pn);

            engineRepository.save(eng);
        }
        return "Record successfully saved to database";
    }


    private File saveFile(MultipartFile file) {
        File testFile = null;
        try {
            String originalName = file.getOriginalFilename().replaceAll("[\\\\/><\\|\\s\"'{}()\\[\\]]+", "_");
            String files = getStoreLocationPath() + File.separator + Utils.getNewFileName(getStoreLocationPath(), originalName);
            testFile = new File(files);
            FileUtils.writeByteArrayToFile(testFile, file.getBytes());
            return testFile;


        } catch (IOException e) {
            e.printStackTrace();
            return testFile;

        }

    }


    private String getStoreLocationPath() {
        return Utils.baseDir(uploadLocation).getPath();
    }
}
