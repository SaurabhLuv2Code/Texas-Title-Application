package texas_title_application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import texas_title_application.model.FormRequest;
import texas_title_application.util.PdfGenerator;

@Service
@RequiredArgsConstructor
public class FormService {

    private final PdfGenerator pdfGenerator;

    public byte[] generatePdf(FormRequest request) {
        return pdfGenerator.fillForm(request);
    }
}