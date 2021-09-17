import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public static void main(String[] args) {
        Athlete athlete = new Athlete();

        String userInput = "";
        Integer userInputInt = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Sport Concussion Assessment System!");

        while (userInput != "quit") {
            System.out.println();
            System.out.println("******** Please select one of the following options ********");
            System.out.println("1. Enter Symptoms - Enter [1]");
            System.out.println("2. Display Symptoms Summary - Enter [2]");
            System.out.println("3. Am I at Risk? - Enter [3]");
            System.out.println("4. Exit - Type [quit]");
            System.out.println("Your selection is: ");
            userInput = scanner.nextLine();

            try {
                userInputInt = Integer.parseInt(userInput);

                if (userInputInt == 1) {
                    // new symptoms input
                    SymptomData form = new SymptomData();
                    form.inputData();
                    athlete.addData(form);

                    // display summary
                } else if (userInputInt == 2) {
                    System.out.println("Please Choose a Game to View Symptom Summary");
                    System.out.println();
                    int summaryNum = athlete.getDataSize();
                    if (summaryNum == 0) {
                        System.out.println("You Have to Input Your Symptom Evaluation First. Please Enter[1] to Submit One.");
                    } else if (summaryNum == 1) {
                        System.out.println("Enter [1] to View Last Game Symptom Summary: ");
                        userInput = scanner.nextLine();
                    } else {
                        System.out.println("We Have the Most Recent "+summaryNum+" Evaluation Reports on Records. (Larger Number Represents More Recent Games.)");
                        for (int i = 0; i < summaryNum; i++) {
                            System.out.println("Please Enter ["+(i+1)+"] to View Summary for Game "+(i+1));
                        }
                        userInput = scanner.nextLine();
                    }
                    userInputInt = Integer.parseInt(userInput);
                    if (userInputInt >=1 && userInputInt <= summaryNum) {
                        SymptomData recent = athlete.getData(userInputInt - 1);
                        System.out.println("******** Evaluation Summary ********");
                        System.out.println("Total Number of Symptoms (Max Possible 22): "+ recent.getTotalNum());
                        System.out.println("Symptom Severity Score (Add All Scores in Table, Max Possible 22 x 6 = 132): "+recent.getSeverityScore());
                        if (userInputInt == 1) {
                            System.out.println("No Overall Rating Available.");
                        } else {
                            int curIdx = userInputInt - 1;
                            int preIdx = userInputInt - 2;
                            SymptomData cur = athlete.getData(curIdx);
                            SymptomData pre = athlete.getData(preIdx);
                            System.out.println("Overall Rating is: " + athlete.getOverallRating(cur, pre));
                        }

                    }
                    // risk evaluation
                } else if (userInputInt == 3) {
                    String text = athlete.getOverallRating();
                    if (text.equals("No Overall Rating Available")) {
                        System.out.println("We Don't Have Enough Data to Perform Risk Analysis. Please Enter[1] to Submit One.");
                    } else if (text.equals("No Difference")) {
                        System.out.println(ANSI_GREEN + text + ANSI_RESET);
                    } else if (text.equals("Unsure")) {
                        System.out.println(ANSI_YELLOW + text + ANSI_RESET);
                    }
                    else if (text.equals("Very Different")) {
                        System.out.println(ANSI_RED + text + ANSI_RESET);
                    }

                } else {
                    System.out.println("Error: Enter a Valid Input - [1], [2], [3] or [quit]");
                }
            } catch (NumberFormatException e) {
                if (userInput.compareTo("quit") == 0) {
                    break;
                } else {
                    System.out.println("Error: Enter a Valid Input - [1], [2], [3] or [quit]");
                }
            }

        }
        scanner.close();
        System.out.println();
        System.out.println("******** Successfully Quit. Thank You for Using SCAS! ********");


    }
}
