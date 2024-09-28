package com.echainika.app.utils;

import com.echainika.app.model.CandidateValidationResult;
import com.echainika.app.model.Error;
import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.model.enums.MaritalStatus;
import lombok.experimental.UtilityClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@UtilityClass
public final class ExcelUtils {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "Sheet1";

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static CandidateValidationResult parseExcelFile(InputStream inputStream) {
        try {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<CandidateRequest> candidateList = new ArrayList<>();
            List<Error> errorList = new ArrayList<>();
            Iterator<Cell> topCells = null;
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // take column names and skip header
                if (rowNumber == 0) {
                    topCells = currentRow.iterator();
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = currentRow.iterator();

                CandidateRequest.CandidateRequestBuilder candidateBuilder = CandidateRequest.builder();
                List<Error> rowErrors = new ArrayList<>();

                while (cells.hasNext()) {
                    String currentCell = cells.next().getStringCellValue();
                    String columnCell = topCells.next().getStringCellValue();

                    switch (columnCell) {
                        case ValidationUtil.REGISTRATION_NUMBER:
                            if (ValidationUtil.COLUMN_VALIDATORS.get(columnCell).validate(rowNumber, currentCell, rowErrors))
                                candidateBuilder.registrationNumber(currentCell);
                            break;
                        case ValidationUtil.NAME:
                            if (ValidationUtil.COLUMN_VALIDATORS.get(columnCell).validate(rowNumber, currentCell, rowErrors))
                                candidateBuilder.name(currentCell);
                            break;
                        case ValidationUtil.MARITAL_STATUS:
                            if (ValidationUtil.COLUMN_VALIDATORS.get(columnCell).validate(rowNumber, currentCell, rowErrors))
                                candidateBuilder.maritalStatus(MaritalStatus.valueOf(columnCell.toUpperCase()));
                            break;
                        case ValidationUtil.DATE_OF_BIRTH:
                            if (ValidationUtil.COLUMN_VALIDATORS.get(columnCell).validate(rowNumber, currentCell, rowErrors))
                                candidateBuilder.dateOfBirth(LocalDate.parse(currentCell, DateTimeFormatter.ISO_LOCAL_DATE));
                            break;
                        case ValidationUtil.TIME_OF_BIRTH:
                            if (ValidationUtil.COLUMN_VALIDATORS.get(columnCell).validate(rowNumber, currentCell, rowErrors))
                                candidateBuilder.timeOfBirth(LocalTime.parse(currentCell, DateTimeFormatter.ISO_LOCAL_TIME));
                            break;
                        default:
                            break;
                    }
                }
                if (rowErrors.isEmpty()) {
                    candidateList.add(candidateBuilder.build());
                }
                errorList.addAll(rowErrors);
            }

            return CandidateValidationResult.builder().candidates(candidateList).errors(errorList).build();
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse Excel file" + e.getMessage());
        }
    }
}
