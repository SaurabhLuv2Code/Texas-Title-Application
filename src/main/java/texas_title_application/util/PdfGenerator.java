package texas_title_application.util;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.interactive.form.*;
import org.springframework.stereotype.Component;
import texas_title_application.model.FormRequest;

import java.io.*;

@Component
public class PdfGenerator {

    private static final String FORM_TEMPLATE = "src/main/resources/130-U.pdf";

    public byte[] fillForm(FormRequest request) {
        try {
            // Load the PDF file from the classpath
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("130-U.pdf");

            if (inputStream == null) {
                throw new RuntimeException("PDF template not found! Check if the file exists in src/main/resources.");
            }

            System.out.println("PDF template loaded successfully.");

            // Check if the file is empty or corrupted
            if (inputStream.available() == 0) {
                throw new RuntimeException("PDF template is empty or corrupted.");
            }

            // Load the document using InputStream
            try (PDDocument document = PDDocument.load(inputStream)) {
                // Remove security before making changes
                document.setAllSecurityToBeRemoved(true);

                PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

                if (acroForm == null) {
                    throw new RuntimeException("No AcroForm found in the PDF template.");
                }
                // Loop through all fields in the AcroForm
//                for (PDField field : acroForm.getFields()) {
//                    System.out.println("Field Name: " + field.getFullyQualifiedName());
//                    System.out.println("Field Type: " + field.getClass().getSimpleName());
//                }

                // Map fields using correct field names
                setFieldValue(acroForm, "1 Vehicle Identification Number", request.getVin());
                setFieldValue(acroForm, "2 Year", request.getYear().toString());
                setFieldValue(acroForm, "3 Make", request.getMake());
                setFieldValue(acroForm, "4 Body Style", request.getBodyStyle());
                setFieldValue(acroForm, "5 Model", request.getModel());
                setFieldValue(acroForm, "6 Major Color", request.getMajorColor());
//                setFieldValue(acroForm, "7 Minor Color", request.getMinorColor());
                setFieldValue(acroForm, "8 Texas License Plate No", request.getTexasLicensePlateNo());
                setFieldValue(acroForm, "9 Odometer Reading no tenths", request.getOdometerReading().toString());
                setFieldValue(acroForm, "11 Empty Weight", request.getEmptyWeight());
                setFieldValue(acroForm, "12 Carrying Capacity if any", request.getCarryingCapacity());
                setFieldValue(acroForm, "14 Applicant Photo ID Number or FEINEIN", request.getPhotoIdNumber());
                setFieldValue(acroForm, "16 Applicant First Name or Entity Name Middle Name Last Name Suffix if any", request.getApplicantName());
                setFieldValue(acroForm, "18 Applicant Mailing Address City State Zip", request.getAddress());
                setFieldValue(acroForm, "20 Previous Owner Name or Entity Name City State", request.getPreviousOwnerName());
                setFieldValue(acroForm, "34 First Lienholder Name if any Mailing Address City State Zip", request.getLienholderAddress());
                setFieldValue(acroForm, "Seller  Name", request.getSellerName());
                setFieldValue(acroForm, "Date", request.getDateOfSale());

                // Save filled form to byte array
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                document.save(outputStream);
                return outputStream.toByteArray();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }

    // Helper method to handle null checks
    private void setFieldValue(PDAcroForm acroForm, String fieldName, String value) throws IOException {
        PDField field = acroForm.getField(fieldName);
        if (field != null) {
            field.setValue(value);
        } else {
            System.out.println("Field not found: " + fieldName);
        }
    }
}
