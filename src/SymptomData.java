import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SymptomData {
    public int[] answers;
    public int answer;

    public SymptomData() {
        answers = new int[22];
        answer = -1;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("******** Evaluation Form ********");
        System.out.println();
        System.out.println("How do you feel? Score yourself on the following symptoms listed below, based on how you feel now.");
        System.out.println();
        System.out.println("Please Enter a Score from [0] to [6].");
        System.out.println("Note: None [0], Mild[1-2], Moderate[3-4], Severe[5-6]");
        String[] questions = new String[22];
        questions[0] = "Headache";
        questions[1] = "Pressure in head";
        questions[2] = "Neck pain";
        questions[3] = "Nausea or vomiting";
        questions[4] = "Dizziness";
        questions[5] = "Blurred vision";
        questions[6] = "Balance problems";
        questions[7] = "Sensitivity to light";
        questions[8] = "Sensitivity to noise";
        questions[9] = "Feeling slowed down";
        questions[10] = "Feeling like 'in a fog'";
        questions[11] = "'Don't feel right'";
        questions[12] = "Difficulty concentrating";
        questions[13] = "Difficulty remembering";
        questions[14] = "Fatigue or low energy";
        questions[15] = "Confusion";
        questions[16] = "Drowsiness";
        questions[17] = "Trouble failing asleep";
        questions[18] = "More emotional";
        questions[19] = "Irritability";
        questions[20] = "Sadness";
        questions[21] = "Nervous or anxious";


        int i = 0;
        while (i < 22) {
            System.out.println("Q" + (i + 1) + ": " + questions[i] + ": ");
            try {
                String answerStr = scanner.nextLine();
                answer = Integer.parseInt(answerStr);
                if (answer >= 0 && answer <= 6) {
                    answers[i] = answer;
                    i++;
                } else {
                    System.out.println("Error: Please Enter a Score from [0] to [6]");
                    System.out.println("Note: None [0], Mild[1-2], Moderate[3-4], Severe[5-6]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please Enter a Score from [0] to [6]");
                System.out.println("Note: None [0], Mild[1-2], Moderate[3-4], Severe[5-6]");

            }
        }

        System.out.println("******** Thank you for the input! ********");
    }


    public int getTotalNum() {
        int total = 0;
        for (int i = 0; i < 22; i++) {
            if (answers[i] > 0) {
                total++;
            }
        }
        return total;
    }

    public int getSeverityScore() {
        int total = 0;
        for (int i = 0; i < 22; i++) {
            total += answers[i];
        }
        return total;
    }


//    public static void main(String[] args) {
//        SymptomData form = new SymptomData();
//        form.inputData();
//        System.out.println(form.symptomArr.size());
//
//        System.out.println(form.symptomArr.get(0));
//
//    }
}
