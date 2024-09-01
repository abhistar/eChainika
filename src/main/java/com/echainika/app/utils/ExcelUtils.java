package com.echainika.app.utils;

import com.echainika.app.model.CandidateAndErrors;
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

    public static CandidateAndErrors parseExcelFile(InputStream inputStream) {
        try {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<CandidateRequest> candidateList = new ArrayList<>();
            List<Error> errorList = new ArrayList<>();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = currentRow.iterator();

                CandidateRequest candidate = CandidateRequest.builder().build();
                List<Error> rowErrors = new ArrayList<>();

                int cellIndex = 0;
                while (cells.hasNext()) {
                    Cell currentCell = cells.next();
                    String errorMessage;

                    switch (cellIndex) {
                        case 0: // Registration Number
                            errorMessage = validateRegistrationNumber(currentCell.getStringCellValue());
                            if (errorMessage != null) {
                                rowErrors.add(Error.builder().error(errorMessage).rowNumber(rowNumber).build());
                            } else {
                                candidate.setRegistrationNumber(currentCell.getStringCellValue());
                            }
                            break;
                        case 1: // Name
                            errorMessage = validateName(currentCell.getStringCellValue());
                            if (errorMessage != null) {
                                rowErrors.add(Error.builder().error(errorMessage).rowNumber(rowNumber).build());
                            } else {
                                candidate.setName(currentCell.getStringCellValue());
                            }
                            break;
                        case 3: // Marital Status
                            errorMessage = validateMaritalStatus(currentCell.getStringCellValue());
                            if (errorMessage != null) {
                                rowErrors.add(Error.builder().error(errorMessage).rowNumber(rowNumber).build());
                            } else {
                                candidate.setMaritalStatus(MaritalStatus.valueOf(currentCell.getStringCellValue().toUpperCase()));
                            }
                        default:
                            break;
                    }

                    cellIndex++;
                }
                if (rowErrors.isEmpty()) {
                    candidateList.add(candidate);
                }
                errorList.addAll(rowErrors);
            }

            return CandidateAndErrors.builder().candidates(candidateList).errors(errorList).build();
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse Excel file" + e.getMessage());
        }
    }


    public static String validateRegistrationNumber(String stringCellValue) {
        if (stringCellValue != null) return null;

        return "Registration number is not present";
    }

    public static String validateName(String stringCellValue) {
        if (stringCellValue != null) return null;

        return "Name is not present";
    }

    private static String validateMaritalStatus(String stringCellValue) {
        try {
            MaritalStatus.valueOf(stringCellValue.toUpperCase());
            return null;
        } catch (NullPointerException ne) {
            return "Marital Status not present";
        } catch (IllegalArgumentException ie) {
            return "Marital status does not match with any values";
        }
    }
}
