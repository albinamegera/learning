# learning
import java.util.Scanner;

public class ticTacToe5 {
    public static void main(String[] args) {
        Scanner yo = new Scanner(System.in);
        String[][] game = new String[3][3];

        System.out.println("---------");
        for (int i = 0; i < game.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < game[i].length; j++) {
                game[i][j] = " ";
                System.out.print(" " + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        boolean ver1 = false;
        boolean ver2 = false;
        boolean ver3 = false;

        boolean gor1 = false;
        boolean gor2 = false;
        boolean gor3 = false;

        boolean dg1 = false;
        boolean dg2 = false;

        boolean xWin = false;
        boolean oWin = false;
        int t = 0;
        while (true) {
            System.out.print("Enter the coordinates for X move: ");
            String inPutCoordinate = yo.nextLine();

            String xStr = String.valueOf(inPutCoordinate.charAt(0));
            String yStr = String.valueOf(inPutCoordinate.charAt(2));

            boolean check = false;
            int xCheck = xStr.equals("1") || xStr.equals("2") || xStr.equals("3") ? 1 : 0;
            int yCheck = yStr.equals("1") || yStr.equals("2") || yStr.equals("3") ? 1 : 0;
            if (xCheck == 1 && yCheck == 1) {
                check = true;
            }

            while (!check) {
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates: ");
                inPutCoordinate = yo.nextLine();
                xStr = String.valueOf(inPutCoordinate.charAt(0));
                yStr = String.valueOf(inPutCoordinate.charAt(2));
                xCheck = xStr.equals("1") || xStr.equals("2") || xStr.equals("3") ? 1 : 0;
                yCheck = yStr.equals("1") || yStr.equals("2") || yStr.equals("3") ? 1 : 0;

                if (xCheck == 1 && yCheck == 1) {
                    break;
                }
            }

            int x = Integer.valueOf(xStr) - 1;
            int y = Integer.valueOf(yStr) - 1;

            if (game[x][y].equals("X") || game[x][y].equals("O")) {
                while (true) {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.print("Enter the coordinates: ");
                    inPutCoordinate = yo.nextLine();

                    xStr = String.valueOf(inPutCoordinate.charAt(0));
                    yStr = String.valueOf(inPutCoordinate.charAt(2));

                    check = false;
                    xCheck = xStr.equals("1") || xStr.equals("2") || xStr.equals("3") ? 1 : 0;
                    yCheck = yStr.equals("1") || yStr.equals("2") || yStr.equals("3") ? 1 : 0;
                    if (xCheck == 1 && yCheck == 1) {
                        check = true;
                    }

                    while (!check) {
                        System.out.println("You should enter numbers!");
                        System.out.print("Enter the coordinates: ");
                        inPutCoordinate = yo.nextLine();

                        xStr = String.valueOf(inPutCoordinate.charAt(0));
                        yStr = String.valueOf(inPutCoordinate.charAt(2));
                        xCheck = xStr.equals("1") || xStr.equals("2") || xStr.equals("3") ? 1 : 0;
                        yCheck = yStr.equals("1") || yStr.equals("2") || yStr.equals("3") ? 1 : 0;

                        if (xCheck == 1 && yCheck == 1) {
                            break;
                        }
                    }
                    x = Integer.valueOf(xStr) - 1;
                    y = Integer.valueOf(yStr) - 1;

                    int lastCheck = game[x][y].equals("X") || game[x][y].equals("O") ? 1 : 0;

                    if (lastCheck == 0) {
                        game[x][y] = "X";
                        break;
                    }
                }
            } else {
                game[x][y] = "X";
            }
            System.out.println("---------");
            for (int i = 0; i < game.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < game[i].length; j++) {
                    System.out.print(game[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");

            ver1 = game[0][0].equals(game[1][0]) && game[1][0].equals(game[2][0]);
            ver2 = game[0][1].equals(game[1][1]) && game[1][1].equals(game[2][1]);
            ver3 = game[0][2].equals(game[1][2]) && game[1][2].equals(game[2][2]);

            gor1 = game[0][0].equals(game[0][1]) && game[0][1].equals(game[0][2]);
            gor2 = game[1][0].equals(game[1][1]) && game[1][1].equals(game[1][2]);
            gor3 = game[2][0].equals(game[2][1]) && game[2][1].equals(game[2][2]);

            dg1 = game[0][0].equals(game[1][1]) && game[1][1].equals(game[2][2]);
            dg2 = game[2][0].equals(game[1][1]) && game[1][1].equals(game[0][2]);


            if ((ver1 || gor1) && game[0][0].equals("X")){
                xWin = true;
            } else if ((ver3 || gor3) && game[2][2].equals("X")) {
                xWin = true;
            } else if ((ver2 || gor2 || dg1 || dg2) && game[1][1].equals("X")) {
                xWin = true;
            }

            if (xWin) {
                break;
            }

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! X MOVE END !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            t += 1; // move counter
            if (t == 5) {
                break;
            }

            System.out.print("Enter the coordinates for O move: ");
            inPutCoordinate = yo.nextLine();

            xStr = String.valueOf(inPutCoordinate.charAt(0));
            yStr = String.valueOf(inPutCoordinate.charAt(2));

            check = false;
            xCheck = xStr.equals("1") || xStr.equals("2") || xStr.equals("3") ? 1 : 0;
            yCheck = yStr.equals("1") || yStr.equals("2") || yStr.equals("3") ? 1 : 0;
            if (xCheck == 1 && yCheck == 1) {
                check = true;
            }

            while (!check) {
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates: ");
                inPutCoordinate = yo.nextLine();
                xStr = String.valueOf(inPutCoordinate.charAt(0));
                yStr = String.valueOf(inPutCoordinate.charAt(2));
                xCheck = xStr.equals("1") || xStr.equals("2") || xStr.equals("3") ? 1 : 0;
                yCheck = yStr.equals("1") || yStr.equals("2") || yStr.equals("3") ? 1 : 0;

                if (xCheck == 1 && yCheck == 1) {
                    break;
                }
            }

            x = Integer.valueOf(xStr) - 1;
            y = Integer.valueOf(yStr) - 1;

            if (game[x][y].equals("X") || game[x][y].equals("O")) {
                while (true) {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.print("Enter the coordinates: ");
                    inPutCoordinate = yo.nextLine();

                    xStr = String.valueOf(inPutCoordinate.charAt(0));
                    yStr = String.valueOf(inPutCoordinate.charAt(2));

                    check = false;
                    xCheck = xStr.equals("1") || xStr.equals("2") || xStr.equals("3") ? 1 : 0;
                    yCheck = yStr.equals("1") || yStr.equals("2") || yStr.equals("3") ? 1 : 0;
                    if (xCheck == 1 && yCheck == 1) {
                        check = true;
                    }

                    while (!check) {
                        System.out.println("You should enter numbers!");
                        System.out.print("Enter the coordinates: ");
                        inPutCoordinate = yo.nextLine();

                        xStr = String.valueOf(inPutCoordinate.charAt(0));
                        yStr = String.valueOf(inPutCoordinate.charAt(2));
                        xCheck = xStr.equals("1") || xStr.equals("2") || xStr.equals("3") ? 1 : 0;
                        yCheck = yStr.equals("1") || yStr.equals("2") || yStr.equals("3") ? 1 : 0;

                        if (xCheck == 1 && yCheck == 1) {
                            break;
                        }
                    }
                    x = Integer.valueOf(xStr) - 1;
                    y = Integer.valueOf(yStr) - 1;

                    int lastCheck = game[x][y].equals("X") || game[x][y].equals("O") ? 1 : 0;

                    if (lastCheck == 0) {
                        game[x][y] = "O";
                        break;
                    }
                }
            } else {
                game[x][y] = "O";
            }
            System.out.println("---------");
            for (int i = 0; i < game.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < game[i].length; j++) {
                    System.out.print(game[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");

            ver1 = game[0][0].equals(game[1][0]) && game[1][0].equals(game[2][0]);
            ver2 = game[0][1].equals(game[1][1]) && game[1][1].equals(game[2][1]);
            ver3 = game[0][2].equals(game[1][2]) && game[1][2].equals(game[2][2]);

            gor1 = game[0][0].equals(game[0][1]) && game[0][1].equals(game[0][2]);
            gor2 = game[1][0].equals(game[1][1]) && game[1][1].equals(game[1][2]);
            gor3 = game[2][0].equals(game[2][1]) && game[2][1].equals(game[2][2]);

            dg1 = game[0][0].equals(game[1][1]) && game[1][1].equals(game[2][2]);
            dg2 = game[2][0].equals(game[1][1]) && game[1][1].equals(game[0][2]);

            if ((ver1 || gor1) && game[0][0].equals("O")) {
                oWin = true;
            } else if ((ver3 || gor3) && game[2][2].equals("O")) {
                oWin = true;
            } else if ((ver2 || gor2 || dg1 || dg2) && game[1][1].equals("O")) {
                oWin = true;
            }

            if (oWin) {
                break;
            }
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! O MOVE END !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        }

        if (xWin) {
            System.out.println("X wins");
        } else if (oWin) {
            System.out.println("O wins");
        } else if (!xWin && !oWin) {
            System.out.println("Draw");
        }
    }
}
