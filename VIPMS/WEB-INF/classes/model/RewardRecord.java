package model;
import java.math.BigDecimal;
import java.util.Date;

public class RewardRecord {
    private int recordId;
    private int memberId;
    private String memberName;
    private String memberPhone;
    private String recordType;
    private BigDecimal recordAmount;
    private String recordDate;

    public RewardRecord() {
    }

    public RewardRecord(int recordId, int memberId, String memberName, String memberPhone, String recordType, 
                        BigDecimal recordAmount, String recordDate) {
        this.recordId = recordId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.recordType = recordType;
        this.recordAmount = recordAmount;
        this.recordDate = recordDate;
    }

    public BigDecimal getRecordAmount() {
        return recordAmount;
    }

    public void setRecordAmount(BigDecimal recordAmount) {
        this.recordAmount = recordAmount;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
}

