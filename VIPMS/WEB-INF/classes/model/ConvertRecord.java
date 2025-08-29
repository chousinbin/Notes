package model;
import java.math.BigDecimal;

public class ConvertRecord {
    private int memberId;
    private String memberName;
    private String memberSimpleName;
    private String memberPhone;
    private String giftName;
    private int giftValue;
    private int convertNumber;
    private BigDecimal rewardUsed;
    private String convertDate;

    public ConvertRecord(int memberId, String memberName, String memberSimpleName, String memberPhone, String giftName,
                         int giftValue, int convertNumber, BigDecimal rewardUsed, String convertDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberSimpleName = memberSimpleName;
        this.memberPhone = memberPhone;
        this.giftName = giftName;
        this.giftValue = giftValue;
        this.convertNumber = convertNumber;
        this.rewardUsed = rewardUsed;
        this.convertDate = convertDate;
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

    public String getMemberSimpleName() {
        return memberSimpleName;
    }

    public void setMemberSimpleName(String memberSimpleName) {
        this.memberSimpleName = memberSimpleName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public int getGiftValue() {
        return giftValue;
    }

    public void setGiftValue(int giftValue) {
        this.giftValue = giftValue;
    }

    public int getConvertNumber() {
        return convertNumber;
    }

    public void setConvertNumber(int convertNumber) {
        this.convertNumber = convertNumber;
    }

    public BigDecimal getRewardUsed() {
        return rewardUsed;
    }

    public void setRewardUsed(BigDecimal rewardUsed) {
        this.rewardUsed = rewardUsed;
    }

    public String getConvertDate() {
        return convertDate;
    }

    public void setConvertDate(String convertDate) {
        this.convertDate = convertDate;
    }
}