package fcmb.com.good.exports;

import fcmb.com.good.model.Engine;
import fcmb.com.good.utills.Utils;
import org.apache.poi.ss.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class UserExporter {

    public static ByteArrayInputStream generateReport(List<Engine> list) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String extension = "user.xls";
        Workbook wb = Utils.getWorkbook(extension);
        Sheet sheet = wb.createSheet();
        createBody(sheet, list);
        wb.write(out);
        return new ByteArrayInputStream(out.toByteArray());
    }


    private static void writeReport(Engine rs, Row row) {
        Utils.createContent(row, null, rs.getId(), 0);
        Utils.createContent(row, null, rs.getPsn(), 1);
        Utils.createContent(row, null, rs.getNames(), 2);
        Utils.createContent(row, null, rs.getLga(), 3);
        Utils.createContent(row, null, rs.getSex(), 4);
        Utils.createContent(row, null, rs.getDob(), 5);
        Utils.createContent(row, null, rs.getDofa(), 6);
        Utils.createContent(row, null, rs.getDoc(), 7);
        Utils.createContent(row, null, rs.getGl(), 8);
        Utils.createContent(row, null, rs.getDopa(), 9);
        Utils.createContent(row, null, rs.getPosition(), 10);
        Utils.createContent(row, null, rs.getCadre(), 11);
        Utils.createContent(row, null, rs.getMda(), 12);
        Utils.createContent(row, null, rs.getHq(), 13);
        Utils.createContent(row, null, rs.getPl(), 14);
        Utils.createContent(row, null, rs.getPn(), 15);

    }

    public static void createHeader(Row row, CellStyle style) {
        Utils.createContent(row, style, "ID", 0);
        Utils.createContent(row, style, "Psn", 1);
        Utils.createContent(row, style, "Names", 2);
        Utils.createContent(row, style, "Lga", 3);
        Utils.createContent(row, style, "Sex", 4);
        Utils.createContent(row, style, "Dob", 5);
        Utils.createContent(row, style, "Dofa", 6);
        Utils.createContent(row, style, "Doc", 7);
        Utils.createContent(row, style, "Gl", 8);
        Utils.createContent(row, style, "Dopa", 9);
        Utils.createContent(row, style, "Position", 10);
        Utils.createContent(row, style, "Cadre", 11);
        Utils.createContent(row, style, "Mda", 12);
        Utils.createContent(row, style, "Hq", 13);
        Utils.createContent(row, style, "Pl", 14);
        Utils.createContent(row, style, "Pn", 15);

    }

    public static void createBody(Sheet sheet, List<Engine> list) {
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        cellStyle.setFont(font);
        Row rw = sheet.createRow(0);
        createHeader(rw, cellStyle);
        int rowcount = 1;
        for (Engine rs : list) {
            Row row = sheet.createRow(rowcount++);
            writeReport(rs, row);
        }

    }
}
