package texas_title_application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FormRequest {

    @NotBlank(message = "VIN is required and should be 17 characters")
    @Size(min = 17, max = 17, message = "VIN must be 17 characters")
    private String vin;

    @NotNull(message = "Year is required")
    private Integer year;

    @NotBlank(message = "Make is required")
    private String make;

    @NotBlank(message = "Body Style is required")
    private String bodyStyle;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Major Color is required")
    private String majorColor;

    @NotNull(message = "Odometer Reading is required")
    private Integer odometerReading;

    @NotBlank(message = "Texas License Plate No is required")
    private String texasLicensePlateNo;

    @NotBlank(message = "Applicant Name is required")
    private String applicantName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Photo ID Type is required")
    private String photoIdType;

    @NotBlank(message = "Photo ID Number is required")
    private String photoIdNumber;

    @NotBlank(message = "Application Type is required")
    private String applicationType;

    @NotBlank(message = "Date of Sale is required")
    private String dateOfSale;

    @NotNull(message = "Sale Price is required")
    private Double salePrice;

    @NotBlank(message = "Seller Name is required")
    private String sellerName;

    @NotBlank(message = "Lienholder Name is required")
    private String lienholderName;

    @NotBlank(message = "Lienholder Address is required")
    private String lienholderAddress;

    private String previousOwnerName;

    private String carryingCapacity;

    private String emptyWeight;
}
