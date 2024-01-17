package CETMS.Model;

public class GradeModel {
    private int gradeId;
    private String testDate;
    private String testType;
    private String studentId;
    private String teacherId;
    private float listeningGrade;
    private float readingGrade;
    private float writingGrade;
    private float sumGrade;

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public float getListeningGrade() {
        return listeningGrade;
    }

    public void setListeningGrade(float listeningGrade) {
        this.listeningGrade = listeningGrade;
    }

    public float getReadingGrade() {
        return readingGrade;
    }

    public void setReadingGrade(float readingGrade) {
        this.readingGrade = readingGrade;
    }

    public float getWritingGrade() {
        return writingGrade;
    }

    public void setWritingGrade(float writingGrade) {
        this.writingGrade = writingGrade;
    }

    public float getSumGrade() {
        return sumGrade;
    }

    public void setSumGrade(float sumGrade) {
        this.sumGrade = sumGrade;
    }
}
