package com.echainika.app.utils;

import com.echainika.app.model.CandidatesResult;
import com.echainika.app.model.Error;
import com.echainika.app.model.dto.request.CandidateRequest;
import lombok.experimental.UtilityClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@UtilityClass
public final class ExcelUtils {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "Sheet1";

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static CandidatesResult parseExcelFile(InputStream inputStream) {
        try {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<CandidateRequest> candidateList = new ArrayList<>();
            List<Error> errorList = new ArrayList<>();
            List<String> topCells = null;
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                List<String> currentRow = IntStream.range(0, row.getLastCellNum()).mapToObj(i -> row.getCell(i).getStringCellValue()).toList();

                // take column names and skip header
                if (rowNumber == 0) {
                    topCells = currentRow;
                    rowNumber++;
                    continue;
                }

                CandidateRequest candidateRequest = CandidateRequest.builder().build();
                List<Error> rowErrors = new ArrayList<>();

                for (int i = 0; i < currentRow.size(); i++) {
                    String currentCell = currentRow.get(i);
                    String columnName = topCells.get(i);

                    FieldUtil.COLUMN_STRATEGY_MAP.get(columnName).set(rowNumber, currentCell, rowErrors, candidateRequest);
                }
                if (rowErrors.isEmpty()) {
                    candidateList.add(candidateRequest);
                }
                errorList.addAll(rowErrors);
            }

            return CandidatesResult.builder().candidates(candidateList).errors(errorList).build();
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse Excel file" + e.getMessage());
        }
    }
}
