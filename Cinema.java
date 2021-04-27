import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner yo = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = yo.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = yo.nextInt();

        String[][] cinema = new String[rows][seats];
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                cinema[i][j] = "S";
            }
        }

        int exit = 1;
        int ticketCounter = 0;
        int income = 0;
        while (true) {
            menu();
            int choice = yo.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Cinema:");
                    System.out.print(" " + " ");
                    for (int i = 1; i < seats + 1; i++) {
                        System.out.printf("%d ", i);
                    }
                    System.out.println();
                    for (int i = 0; i < cinema.length; i++) {
                        System.out.print(i + 1 + " ");
                        for (int j = 0; j < cinema[i].length; j++) {
                            System.out.printf("%s ", cinema[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("Enter a row number:");
                        int ticketX = yo.nextInt();
                        System.out.println("Enter a seat number in that row: ");
                        int ticketY = yo.nextInt();
                        boolean check1 = ticketX > rows || ticketX < 0;
                        boolean check2 = ticketY > rows || ticketY < 0;
                        if (check1 || check2) {
                            System.out.println("Wrong input!\n");
                        } else if (cinema[ticketX - 1][ticketY - 1].equals("B")) {
                            System.out.println("That ticket has already been purchased!\n");
                        } else {
                            cinema[ticketX - 1][ticketY - 1] = "B";
                            ticketCounter += 1;
                            income += Integer.parseInt(ticketPrice(rows, seats, ticketX));
                            System.out.printf("Ticket price: $%s\n", ticketPrice(rows, seats, ticketX));
                            break;
                        }
                    }
                    break;
                case 3:
                    float percent = (float) 100 / (rows * seats) * ticketCounter;
                    System.out.printf("Number of purchased tickets: %d\n", ticketCounter);
                    System.out.printf("Percentage: %.2f", percent);
                    System.out.println("%");
                    System.out.printf("Current income: $%d\n", income);
                    System.out.printf("Total income: $%d\n", totalIncome(rows, seats));
                    break;
                case 0:
                    exit = 0;
                    break;
                default:
                    System.out.println("Wrong input");
            }
            if (exit == 0) {
                break;
            }
        }

    }
    public static void menu() {
        System.out.print("\n1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit\n");
    }
    public static String ticketPrice(int x, int y, int check) {
        if (x * y <= 60) {
            return "10";
        } else {
            if (check <= x / 2) {
                return "10";
            } else {
                return "8";
            }
        }
    }
    public static int totalIncome(int rows, int seats) {
        if (rows * seats <= 60) {
            return rows * seats * 10;
        } else {
            if (rows % 2 == 0) {
                return rows / 2 * seats * 18;
            } else {
                return rows / 2 * seats * 10 + (rows / 2 + 1) * seats * 8;
            }
        }
    }
}


