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

    @NotBlank(message = "Minor Color is required")
    private String minorColor;

    @NotBlank(message = "Texas License Plate No is required")
    private String texasLicensePlateNo;

    @NotNull(message = "Odometer Reading is required")
    private Integer odometerReading;

    private String emptyWeight;

    private String carryingCapacity;

    @NotBlank(message = "Photo ID Number is required")
    private String applicantPhotoIdNumber;

    @NotBlank(message = "Applicant Name is required")
    private String applicantName;

    private String additionalApplicantName;

    @NotBlank(message = "Mailing Address is required")
    private String applicantMailingAddress;

    private String applicantCountyOfResidence;

    private String previousOwnerName;

    private String renewalRecipientName;

    private String renewalNoticeMailingAddress;

    private String applicantPhoneNumber;

    private String email;

    private String vehicleLocationAddress;

    private String certifiedTitleLienholderIdNumber;

    private String firstLienDate;

    private String firstLienholderName;

    private String titleRegistration;
    private String titleOnly;
    private String registrationPurposesOnly;
    private String vehicleDescription;
    private String addRemoveLien;
    private String otherReasonForCorrection;
    private String notActual;
    private String exceedsMechanicalLimits;
    private String exempt;
    private String business;
    private String government;

    private String trust;

    private String nonProfit;

    private String passportIssued;

    private String natoId;

    private String usMilitaryId;

    private String otherMilitaryStatus;

    private String usDeptStateId;

    private String usDeptHomelandSecurityId;

    private String permitNumber;

    private String gdnLessorNumber;

    private String tradeIn;

    private String exemptionClaimed;

    private String sellerName;

    private String date;

    private String date2;

    private String date3;

    private String dealerGdn;

    private String tradeInYearMakeVin;

    private String stateTaxesPaidTo;

    private String newResidentTax;

    private String evenTradeTax;

    private String giftTax;

    private String rebuiltSalvageFee;

    private String salesTaxExemptionReason;

    private String passport;
    private String individual;
    private String yesProvideEmail;
    private String yesAttachFormVTR216;
    private String yesAttachFormVTR267;
    private String additionalTradeIns;
    private String salesAndUseTax;

    private String lateTaxPaymentPenalty5;

    private String lateTaxPaymentPenalty10;

    private String residentPreviousState;

    private String emissionsFeeDiesel;

    private String fairMarketValueDeduction;

    private String rebateAmount;

    private String salesPriceMinusRebateAmount;

    private String tradeInAmount;

    private String taxableAmount;

    private String lateTaxPaymentPenaltyAmount;

    private String amountOfTaxesPaid;

    private String amountOfTaxAndPenaltyDue;

    private String motorVehicleRetailerPermit;

    private String stateOfIdDl;

    private String applicationFee;

    private String applyCorrectedTitle;

    private String vehicleInspected;

    private String vehicleUnrecovered;
}
