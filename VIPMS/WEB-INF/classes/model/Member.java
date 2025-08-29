package model;
import java.util.Date;
import java.math.BigDecimal;

public class Member {
    private int id;
    private String name;
    private String simpleName;
    private String phone;
    private Date birthday;
    private BigDecimal balance;
    private int rewardTimes;
    private BigDecimal totalReward;
    private BigDecimal availableReward;
    private boolean status;

    public Member() {
    }

    public Member(int id, String name, String simpleName, String phone, Date birthday, BigDecimal balance, 
                  int rewardTimes, BigDecimal totalReward, BigDecimal availableReward, boolean status) {
        this.id = id;
        this.name = name;
        this.simpleName = simpleName;
        this.phone = phone;
        this.birthday = birthday;
        this.balance = balance;
        this.rewardTimes = rewardTimes;
        this.totalReward = totalReward;
        this.availableReward = availableReward;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTotalReward() {
        return totalReward;
    }

    public void setTotalReward(BigDecimal totalReward) {
        this.totalReward = totalReward;
    }

    public BigDecimal getAvailableReward() {
        return availableReward;
    }

    public void setAvailableReward(BigDecimal availableReward) {
        this.availableReward = availableReward;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRewardTimes() {
        return rewardTimes;
    }

    public void setRewardTimes(int rewardTimes) {
        this.rewardTimes = rewardTimes;
    }
}