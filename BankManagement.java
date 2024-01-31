import java.util.*;

public class BankManagement {

    static boolean ans;
    static String tocheck;
    static long inputadhar;
    static long inputphn;
    static long inputacnt;
    static ArrayList<Info> table;
    
    static Scanner sc = new Scanner(System.in);

    public static class Info {
        String name;
        String mName;
        String acntType;
        String gender;
        long phone;
        long adhaar;
        float amt;
        long acntNumber;

        public Info(String name, String mName, String acntType, String gender, long phone, long  adhaar, long acntNumber) {
            this.name = name;
            this.mName = mName;
            this.acntType = acntType;
            this.gender = gender;
            this.phone = phone;
            this.adhaar = adhaar;
            this.amt = (float) 0;
            this.acntNumber = acntNumber;
        }
    }

    public static String capitalize(String r){
        if(r.equals("")){
            return r;
        }
        String n = "";
        String l[] = r.split(" ");
        for(int i = 0; i<l.length; i++){
            n = n + l[i].substring(0, 1).toUpperCase() + l[i].substring(1).toLowerCase();
            if(i != l.length-1){
                n += " ";
            }
        }
        return n;
    }

    public static long acntNumberEntry(){
        while(true){
            try {
                ans = false;
                while(ans == false){
                    System.out.print("Enter Account No. : ");
                    inputacnt = sc.nextLong();
                    if(Long.toString(inputacnt).length() != 14){
                        System.out.println("Invalid Input\n");
                        continue;
                    }
                    ans = true;
                }
                break;
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid Input\n");
                sc.nextLine();
            }
        }
        return inputacnt;
    }
  
    public static void createNew() {
        sc.nextLine();
        System.out.println("=================================================================");
        System.out.println("                    CREATE NEW ACCOUNT");
        System.out.println("=================================================================\n");

        // name
        ans = false;
        while(ans == false){
            System.out.print("Enter Customer's Name               : ");
            tocheck = sc.nextLine();
            if(tocheck.equals("")){
                System.out.println("Entering customer's name is compulsory!\n");
                continue;
            }
            break;
        }
        String addname = capitalize(tocheck);

        // mothers name
        ans = false;
        while(ans == false){
            System.out.print("Enter Mother's Name                 : ");
            tocheck = sc.nextLine();
            if(tocheck.equals("")){
                System.out.println("Entering mother's name is compulsory\n");
                continue;
            }
            break;
        }
        String addmName = capitalize(tocheck);

        // acnt type
        System.out.println("=================================================================");
        System.out.println("A. Savings Account");
        System.out.println("B. Current Account");
        System.out.println("C. Fixed Deposit Account");
        System.out.println("D. Money Account");
        System.out.println("=================================================================");
        System.out.println();
        System.out.print("Enter type of account you want to create : ");
        tocheck = sc.nextLine();

        String addacntType = "";
        if (tocheck.equalsIgnoreCase("a")) {
            addacntType = "Savings Account";
        } else if (tocheck.equalsIgnoreCase("b")) {
            addacntType = "Current Account";
        } else if (tocheck.equalsIgnoreCase("c")) {
            addacntType = "Fixed Deposit Account";
        } else if (tocheck.equalsIgnoreCase("d")) {
            addacntType = "Money Account";
        }

        // gender
        ans = false;
        while(ans == false){
            System.out.print("Enter gender                             : ");
            tocheck = sc.nextLine();
            if(tocheck.equals("")){
                System.out.println("Entering gender is compulsory\n");
                continue;
            }if(tocheck.equalsIgnoreCase("male") || tocheck.equalsIgnoreCase("female") || tocheck.equalsIgnoreCase("other")){
                break;
            }
            System.out.println("Invalid Input\n");
        }
        String addgender = capitalize(tocheck);
        
        // phone no
        while(true){
            try {
                ans = false;
                while(ans == false){
                    System.out.print("Enter Mobile No.                         : ");
                    inputphn = sc.nextLong();
                    if(Long.toString(inputphn).length() != 10){
                        System.out.println("Invalid Input\n");
                        continue;
                    }
                    ans = true;
                }
                break;
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid Input\n");
                sc.nextLine();
            }
        }

        // adhaar
        while(true){
            try {
                ans = false;
                while(ans == false){
                    System.out.print("Enter Adhaar Card No.                    : ");
                    inputadhar = sc.nextLong();
                    if(Long.toString(inputadhar).length() != 12){
                        System.out.println("Invalid Input\n");
                        continue;
                    }
                    ans = true;
                }
                break;
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid Input\n");
                sc.nextLine();
            }
        }

        //generating account number
        long addacntNumber;
        if (table.isEmpty()) {
            addacntNumber = 1074901152172L;
        } else {
            Info last = table.get(table.size() - 1);
            long old = last.acntNumber;
            addacntNumber = old+1;
        }

        table.add(new Info(addname, addmName, addacntType, addgender, inputphn, inputadhar, addacntNumber));
        System.out.println("=================================================================");
        System.out.println("                   ACCOUNT CREATED SUCCESSFULLY!");
        System.out.println("               YOUR ACCOUNT NO. IS -> " + addacntNumber);
        System.out.println("=================================================================");
    }

    public static void display() {
        System.out.println("=================================================================");
        System.out.println("                     DISPLAY DETAILS");
        System.out.println("=================================================================");
        long input = acntNumberEntry();
        boolean found = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr = table.get(i);
            if (curr.acntNumber == input) {
                found = true;
                System.out.println("=================================================================");
                System.out.println("CUSTOMER NAME    :  " + curr.name);
                System.out.println("ACCOUNT NO.      :  " + curr.acntNumber);
                System.out.println("MOTHER'S NAME    :  " + curr.mName);
                System.out.println("ACCOUNT TYPE     :  " + curr.acntType);
                System.out.println("GENDER           :  " + curr.gender);
                System.out.println("PHONE NO.        :  " + curr.phone);
                System.out.println("ADHAAR NO.       :  " + curr.adhaar);
                System.out.println("BALANCE          :  " + curr.amt);
                System.out.println("=================================================================\n");
                break;
            }
        }
        if (found == false) {
            System.out.println("No bank account exist for account no. : " + input + "\n");
        }
    }

    public static void chkBalance() {
        long input = acntNumberEntry();
        boolean found = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr = table.get(i);
            if (curr.acntNumber == input) {
                found = true;
                System.out.println("=================================================================");
                System.out.println("                  CURRENT BALANCE" + curr.amt);
                System.out.println("=================================================================\n");
                break;
            }
        }
        if (found == false) {
            System.out.println("No bank account exist for account no. : " + input + "\n");
        }
    }

    public static void deposit() {
        System.out.println("=================================================================");
        System.out.println("                            DEPOSIT");
        System.out.println("=================================================================\n");
        long input = acntNumberEntry();
        boolean found = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr = table.get(i);
            if (curr.acntNumber == input) {
                found = true;
                System.out.print("Enter amount : ");
                Float money = sc.nextFloat();
                System.out.println("=================================================================");
                System.out.println("             PREVIOUS BALANCE        :  " + curr.amt);
                curr.amt = curr.amt + money;
                System.out.println("             CURRENT BALANCE         :  " + curr.amt);
                System.out.println("=================================================================");
                break;
            }
        }
        if (found == false) {
            System.out.println("No bank account exist for account no. : " + input + "\n");
        }
    }

    public static void withdraw() {
        System.out.println("=================================================================");
        System.out.println("                           WITHDRAW");
        System.out.println("=================================================================\n");
        long input = acntNumberEntry();
        boolean found = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr = table.get(i);
            if (curr.acntNumber == input) {
                found = true;
                System.out.print("Enter amount : ");
                Float money = sc.nextFloat();
                if (money > curr.amt) {
                    System.out.println("Not enough balance!\n");
                } else {
                    System.out.println("=================================================================");
                    System.out.println("          PREVIOUS BALANCE        :  " + curr.amt);
                    curr.amt = curr.amt - money;
                    System.out.println("          CURRENT BALANCE         :  " + curr.amt);
                    System.out.println("=================================================================\n");
                }
                break;
            }
        }
        if (found == false) {
            System.out.println("No bank account exist for account no. : " + input + "\n");
        }
    }

    public static void transfer() {
        System.out.println("=================================================================");
        System.out.println("                           TRANSFER");
        System.out.println("=================================================================\n");
        while(true){
            try {
                ans = false;
                while(ans == false){
                    System.out.print("Enter Account No.(from) : ");
                    inputacnt = sc.nextLong();
                    if(Long.toString(inputacnt).length() != 14){
                        System.out.println("Invalid Input\n");
                        continue;
                    }
                    ans = true;
                }
                break;
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid Input\n");
                sc.nextLine();
            }
        }
        long fromAcnt = inputacnt;
        while(true){
            try {
                ans = false;
                while(ans == false){
                    System.out.print("Enter Account No.(to)   : ");
                    inputacnt = sc.nextLong();
                    if(Long.toString(inputacnt).length() != 14){
                        System.out.println("Invalid Input\n");
                        continue;
                    }
                    ans = true;
                }
                break;
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid Input\n");
                sc.nextLine();
            }
        }
        long toAcnt = inputacnt;

        boolean found1 = false;
        boolean found2 = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr1 = table.get(i);
            if (curr1.acntNumber == fromAcnt) {
                found1 = true;
                for (int j = 0; j < table.size(); j++) {
                    Info curr2 = table.get(j);
                    if (curr2.acntNumber == toAcnt) {
                        found2 = true;
                        System.out.println("BALANCE        :  " + curr1.amt);
                        System.out.print("Enter amount : ");
                        Float money = sc.nextFloat();
                        if (money > curr1.amt) {
                            System.out.println("Not enough balance!\n");
                        } else {
                            System.out.println("=================================================================");
                            System.out.println("              AMOUNT TRANSFERRED SUCCESSFULLY");
                            System.out.println("=================================================================\n");
                            
                            curr1.amt = curr1.amt - money;
                            curr2.amt = curr2.amt + money;
                        }
                    }
                }
            }
        }
        if (found1 == false && found2 == false) {
            System.out.println("No bank account exist for account no. : " + fromAcnt);
            System.out.println("No bank account exist for account no. : " + toAcnt);
        }else if(found1 == false){
            System.out.println("No bank account exist for account no. : " + fromAcnt +"\n");
        }else if(found2 == false){
            System.out.println("No bank account exist for account no. : " + toAcnt + "\n");
        }
    }
 
    public static void menu() {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("                              MENU");
        System.out.println("=================================================================");
        System.out.println("Enter 'A' to 'Create New Account'");
        System.out.println("Enter 'B' to ''Display Details'");
        System.out.println("Enter 'C' to 'Check Balance Left'");
        System.out.println("Enter 'D' to 'Deposit Money'");
        System.out.println("Enter 'E' to 'Withdraw Money'");
        System.out.println("Enter 'F' to 'Transafer Money'");
        System.out.println("Enter 'G' to 'Close The Programme'");
        System.out.println("=================================================================");
    }

    public static void main(String[] args) {

        table = new ArrayList<>();
        table.add(new Info("Ansh", "Rama", "Savings Account", "Male", 7099890380L, 123456789012L, 10748901152172L));
        table.add(new Info("Tanisha", "Rita", "Current Account", "Female", 7034654480L, 149586039480L,
                10748901152173L));
        table.add(new Info("Mira", "Tanya", "Money Account", "Female", 7908890380L, 123459162539L, 10748901152174L));

        while (true) { 
            menu();
            System.out.print("Enter your choice : ");
            tocheck = sc.next();

            if(tocheck.equalsIgnoreCase("a")){
                createNew();
            }else if(tocheck.equalsIgnoreCase("b")){
                display();
            }else if(tocheck.equalsIgnoreCase("c")){
                chkBalance();
            }else if(tocheck.equalsIgnoreCase("d")){
                deposit();
            }else if(tocheck.equalsIgnoreCase("e")){
                withdraw();
            }else if(tocheck.equalsIgnoreCase("f")){
                transfer();
            }else if(tocheck.equalsIgnoreCase("g")){
                break;
            }else{
                System.out.println("Invalid Input\n");
            }
        }
    }
}