import java.util.*;

public class StudentTracker {

    static int roll;
    static String phy;
    static String chem;
    static String maths;
    static String bio;
    static String cs;
    static String tocheck;
    static int input;

    static boolean ans;

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Info> table = new ArrayList<>();

    static HashSet<Integer> set = new HashSet<>();

    public static class Info{
        String name;
        int roll;
        int phy;
        int chem;
        int maths;
        int bio;
        int cs;

        public Info(String name, int roll, int phy, int chem, int maths, int bio, int cs){
            this.name = name;
            this.roll = roll;
            this.phy = phy;
            this.chem = chem; 
            this.maths = maths;
            this.bio = bio;
            this.cs = cs;
        }
    }

    public static String capitalize(String r){
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

    public static boolean validateMarks(String x) {
        for(int i = 0; i<x.length(); i++){
            char ch = x.charAt(i);
            if(!Character.isDigit(ch)){
                System.out.println("Invalid Input\n");
                return false;
            }
        }
        if(Integer.parseInt(x)>100 || Integer.parseInt(x)<0){
            System.out.println("Invalid Marks\n");
            return false;
        }
        return true;  
    }

    public static void add(){
        //name
        ans = false;
        while(ans == false){
            System.out.print("Enter Student's Name          : ");
            tocheck = sc.nextLine();
            if(tocheck.equals("")){
                System.out.println("Entering customer's name is compulsory\n");
                continue;
            }
            break;
        }

        //roll no
        while(true){
            try {
                ans = false;
                while(ans == false){
                    System.out.print("Enter Roll No.                : ");
                    roll = sc.nextInt();
                    if(Integer.toString(roll).length() != 4){
                        System.out.println("Invalid Input\n");
                        continue;
                    }if(set.contains(roll)){
                        System.out.println("Roll number already exist\n");
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
        
        sc.nextLine();

        //phy
        ans = false;
        while(ans == false){
            System.out.print("Enter Physics Marks           : ");
            phy = sc.nextLine();
            if (phy.equals("")) {
                phy = "0";
                ans = true;
                continue;
            }
            ans = validateMarks(phy);
        }

        //chem
        ans = false;
        while(ans == false){
            System.out.print("Enter Chemistry Marks         : ");
            chem = sc.nextLine();
            if (chem.equals("")) {
                chem = "0";
                ans = true;
                continue;
            }
            ans = validateMarks(chem);
        }

        //maths
        ans = false;
        while(ans == false){
            System.out.print("Enter Maths Marks             : ");
            maths = sc.nextLine();
            if (maths.equals("")) {
                maths = "0";
                ans = true;
                continue;
            }
            ans = validateMarks(maths);
        }

        //bio
        ans = false;
        while(ans == false){
            System.out.print("Enter Biology Marks           : ");
            bio = sc.nextLine();
            if (bio.equals("")) {
                bio = "0";
                ans = true;
                continue;
            }
            ans = validateMarks(bio);
        }

        //cs
        ans = false;
        while(ans == false){
            System.out.print("Enter Computer Science Marks  : ");
            cs = sc.nextLine();
            if (cs.equals("")) {
                cs = "0";
                ans = true;
                continue;
            }
            ans = validateMarks(cs);
        }

        set.add(roll);
        table.add(new Info(capitalize(tocheck), roll, Integer.parseInt(phy), Integer.parseInt(chem), Integer.parseInt(maths), Integer.parseInt(bio), Integer.parseInt(cs)));
        System.out.println("=================================================================");
        System.out.println("                    DATA ADDED SUCCESSFULLY!");
        System.out.println("=================================================================");
        // sc.nextLine();
    }

    public static void display(){
        System.out.println("=================================================================");
        System.out.println("                     DISPLAY DETAILS");
        System.out.println("=================================================================");
        ans = false;
        while (ans == false) {
            System.out.print("Enter student's roll number : ");
            input = sc.nextInt();
            if(Integer.toString(input).length() != 4){
                System.out.println("Invalid Input\n");
                continue;
            }
            if(!set.contains(input)){
                System.out.println("Roll number doesn't exist\n");
                break;
            }
            for(int i = 0; i<table.size(); i++){
                Info curr = table.get(i);
                if(curr.roll == input){

                    System.out.println("=================================================================");
                    System.out.println("STUDENT NAME             : "+curr.name);
                    System.out.println("PHYSICS MARKS            : "+curr.phy);
                    System.out.println("CHEMISTRY MARKS          : "+curr.chem);
                    System.out.println("MATHS MARKS              : "+curr.maths);
                    System.out.println("BIOLOGY MARKS            : "+curr.bio);
                    System.out.println("COMPUTER SCIENCE MARKS   : "+curr.cs);
                    System.out.println("=================================================================\n");
                    ans = true;
                }
                if(ans == true){
                    break;
                }
            }
        }
    }

    public static void highest(){
        ans = false;
        while (ans == false) {
            System.out.print("Enter student's roll number : ");
            input = sc.nextInt();
            if(Integer.toString(input).length() != 4){
                System.out.println("Invalid Input");
                continue;
            }
            if(!set.contains(input)){
                System.out.println("Roll number doesn't exist");
                break;
            }
            for(int i = 0; i<table.size(); i++){
                Info curr = table.get(i);
                if(curr.roll == input){
                    System.out.println("=================================================================");
                    System.out.println("                     HIGHEST MARKS");
                    System.out.println("=================================================================");
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(curr.phy);
                    l.add(curr.chem);
                    l.add(curr.maths);
                    l.add(curr.bio);
                    l.add(curr.cs);

                    Collections.sort(l);
                    
                    int mx = l.get(l.size()-1);
                    if(curr.phy == mx){
                        System.out.println("Highest marks are "+mx+" in Physics");
                    }if(curr.chem == mx){
                        System.out.println("Highest marks are "+mx+" in Chemistry");
                    }if(curr.maths == mx){
                        System.out.println("Highest marks are "+mx+" in Maths");
                    }if(curr.bio == mx){
                        System.out.println("Highest marks are "+mx+" in Biology");
                    }if(curr.cs == mx){
                        System.out.println("Highest marks are "+mx+" in Computer Science");
                    }
                    System.out.println("=================================================================");
                    ans = true;
                }
                if(ans == true){
                    break;
                }
            }
        }
    }

    public static void lowest(){
        ans = false;
        while (ans == false) {
            System.out.print("Enter student's roll number : ");
            input = sc.nextInt();
            if(Integer.toString(input).length() != 4){
                System.out.println("Invalid Input");
                continue;
            }
            if(!set.contains(input)){
                System.out.println("Roll number doesn't exist");
                break;
            }
            for(int i = 0; i<table.size(); i++){
                Info curr = table.get(i);
                if(curr.roll == input){
                    System.out.println("=================================================================");
                    System.out.println("                     LOWEST MARKS");
                    System.out.println("=================================================================");
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(curr.phy);
                    l.add(curr.chem);
                    l.add(curr.maths);
                    l.add(curr.bio);
                    l.add(curr.cs);

                    Collections.sort(l);
                    
                    int min = l.get(0);
                    if(curr.phy == min){
                        System.out.println("Lowest marks are "+min+" in Physics");
                    }if(curr.chem == min){
                        System.out.println("Lowest marks are "+min+" in Chemistry");
                    }if(curr.maths == min){
                        System.out.println("Lowest marks are "+min+" in Maths");
                    }if(curr.bio == min){
                        System.out.println("Lowest marks are "+min+" in Biology");
                    }if(curr.cs == min){
                        System.out.println("Lowest marks are "+min+" in Computer Science");
                    }
                    System.out.println("=================================================================");
                    ans = true;
                }
                if(ans == true){
                    break;
                }
            }
        }
    }

    public static void average(){
        ans = false;
        while (ans == false) {
            System.out.print("Enter student's roll number : ");
            input = sc.nextInt();
            if(Integer.toString(input).length() != 4){
                System.out.println("Invalid Input");
                continue;
            }
            if(!set.contains(input)){
                System.out.println("Roll number doesn't exist");
                break;
            }
            for(int i = 0; i<table.size(); i++){
                Info curr = table.get(i);
                if(curr.roll == input){
                    
                    int sum = curr.phy + curr.chem + curr.maths + curr.bio + curr.cs;
                    System.out.println("=================================================================");
                    System.out.println("                     AVERAGE MARKS : " + (float)sum/5);
                    System.out.println("=================================================================");
                    ans = true;
                }
                if(ans == true){
                    break;
                }
            }
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("                              MENU");
        System.out.println("=================================================================");
        System.out.println("Enter 'A' to 'Add details of a student'");
        System.out.println("Enter 'B' to 'Display details'");
        System.out.println("Enter 'C' to 'Check the highest marks'");
        System.out.println("Enter 'D' to 'Check the lowest marks'");
        System.out.println("Enter 'E' to 'Calculate average marks'");
        System.out.println("Enter 'F' to 'Close the Programme'");
        System.out.println("=================================================================");
    }
    public static void main(String args[]){
        //Subjects are Physics, Chemistry, Maths, Biology, Computer Science
        table.add(new Info("Aman", 1011, 87, 90, 22, 56, 87));
        table.add(new Info("Rishab", 1012, 67, 12, 25, 97, 97));
        table.add(new Info("Suman", 1016, 89, 91, 79, 81, 32));

        set.add(1011);
        set.add(1012);
        set.add(1016);
        
        while (true) {

            menu();
            System.out.print("Enter your choice : ");
            tocheck = sc.nextLine();

            if(tocheck.equalsIgnoreCase("a")){
                add();
            }else if(tocheck.equalsIgnoreCase("b")){
                display();
                sc.nextLine();
            }else if(tocheck.equalsIgnoreCase("c")){
                highest();
                sc.nextLine();
            }else if(tocheck.equalsIgnoreCase("d")){
                lowest();
                sc.nextLine();
            }else if(tocheck.equalsIgnoreCase("e")){
                average();
                sc.nextLine();
            }else if(tocheck.equalsIgnoreCase("f")){
                break;
            }else{
                System.out.println("Invalid Input");
            }
        }
    }
}