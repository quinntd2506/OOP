import javax.swing.JOptionPane;

public class month {
    public static void main(String[] args) {
        // Get month input from user
        String monthInput = JOptionPane.showInputDialog(null, "Enter a month (full name, abbreviation, or number):",
                "Month Input", JOptionPane.PLAIN_MESSAGE);

        // Get year input from user
        String yearInput = JOptionPane.showInputDialog(null, "Enter a year (non-negative number):", "Year Input",
                JOptionPane.PLAIN_MESSAGE);

        // Check month input
        int month = parseMonthInput(monthInput);
        if (month == -1) {
            JOptionPane.showMessageDialog(null, "Invalid month input. Please try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check year input
        int year = parseYearInput(yearInput);
        if (year == -1) {
            JOptionPane.showMessageDialog(null, "Invalid year input. Please try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        System.out.println(dayOfMOnth(year, month));
        
    }
    public static int dayOfMOnth(int year, int month){
        if(checkLeapYear(year) == false){
            if( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month ==12 )
            {
                return 31;
            }
            else if( month == 2) return 28;
            else return 30;
        }
        else {
            if( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month ==12 )
            {
                return 31;
            }
            else if( month == 2) return 29;
            else return 30;
        }
    }
    static boolean checkLeapYear(int year){
        if( year% 4 == 0 ){
            if( year%100 == 0 && year%400!= 0 )
            return false;
            else return true;
        }
        else{
            return false;
        }
    }

    // Method to parse and validate month input
    static int parseMonthInput(String input) {
        input = input.toLowerCase();
        switch (input) {
            case "january":
            case "jan":
            case "jan.":
            case "1":
                return 1;
            case "february":
            case "feb":
            case "feb.":
            case "2":
                return 2;
            case "march":
            case "mar":
            case "mar.":
            case "3":
                return 3;
            case "april":
            case "apr":
            case "apr.":
            case "4":
                return 4;
            case "may":
            case "5":
                return 5;
            case "june":
            case "jun":
            case "jun.":
            case "6":
                return 6;
            case "july":
            case "jul":
            case "jul.":
            case "7":
                return 7;
            case "august":
            case "aug":
            case "aug.":
            case "8":
                return 8;
            case "september":
            case "sep":
            case "sep.":
            case "9":
                return 9;
            case "october":
            case "oct":
            case "oct.":
            case "10":
                return 10;
            case "november":
            case "nov":
            case "nov.":
            case "11":
                return 11;
            case "december":
            case "dec":
            case "dec.":
            case "12":
                return 12;
            default:
                return -1; // Invalid input
        }
    }

    // Method to parse and validate year input
    static int parseYearInput(String input) {
        try {
            int year = Integer.parseInt(input);
            if (year >= 0) {
                return year;
            } else {
                return -1; // Invalid input
            }
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }
}
