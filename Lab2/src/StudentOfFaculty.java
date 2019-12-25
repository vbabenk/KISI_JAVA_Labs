import java.util.Date;

public class StudentOfFaculty extends Student {
    @Override
    public void outputMessage() {
        Date now = new Date();
        System.out.println("Now " + now + " , do something pal!");
    }

    public static void main(String[] args) {
        Abiturient student = new StudentOfFaculty();
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            }
            student.outputMessage();
        }
    }

}
