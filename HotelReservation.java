import java.util.*;

public class HotelReservation {

    static boolean ans;

    static String tocheck;

    static String roomchoice;

    static int number;

    static int no;

    static long inputphn;

    static long rsvno;

    static Scanner sc = new Scanner(System.in);

    static HashSet<Long> set = new HashSet<>();

    static ArrayList<Boolean> std = new ArrayList<>(Collections.nCopies(25, false));//4500
    static ArrayList<Boolean> deluxe = new ArrayList<>(Collections.nCopies(15, false));//6000
    static ArrayList<Boolean> suite = new ArrayList<>(Collections.nCopies(10, false));//9000

    static ArrayList<Integer> room = new ArrayList<>(Collections.nCopies(3, 0));
    static ArrayList<Integer> roomNumbers = new ArrayList<>();

    static ArrayList<Info> table;

    public static class Info{
        String name;
        long phone;
        ArrayList<Integer> roomNumbers;
        ArrayList<Integer> room;
        long reservationNumber;

        public Info(String name, long phone, ArrayList<Integer> roomNumbers, ArrayList<Integer> room, long reservationNumber){
            this.name = name;
            this.phone = phone;
            this.roomNumbers = roomNumbers;
            this.room = room;
            this.reservationNumber = reservationNumber;
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

    public static long reservationNumberEtry(){
        while(true){
            try {
                ans = false;
                while(ans == false){
                    System.out.print("Enter Reservation No. : ");
                    rsvno = sc.nextLong();
                    if(Long.toString(rsvno).length() != 7){
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
        return rsvno;
    }

    public static void book(){
        System.out.println("=================================================================");
        System.out.println("                    BOOK A RESERVATION");
        System.out.println("=================================================================\n");

        sc.nextLine();

        //name
        ans = false;
        while(ans == false){
            System.out.print("Enter Name                 : ");
            tocheck = sc.nextLine();
            if(tocheck.equals("")){
                System.out.println("Entering Customer's Name is compulsory\n");
                continue;
            }
            break;
        }
        String addname = capitalize(tocheck);

        // phone no
        while(true){
            try {
                ans = false;
                while(ans == false){
                    System.out.print("Enter Mobile No.           : ");
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

        displayroom();

        //no of room
        //standard
        sc.nextLine();
        if(Collections.frequency(std, false) != 0){
            System.out.print("Do you want to book Standard Room? : ");
            roomchoice = sc.nextLine();
            if(roomchoice.equalsIgnoreCase("y") || roomchoice.equalsIgnoreCase("yes")){
                System.out.println("=================================================================");
                System.out.println(Collections.frequency(std, false) + " Standard Rooms availble at 4500 per night");
                System.out.println("=================================================================");
                while (true) { 
                    System.out.print("How many rooms you want to book?  : ");
                    no = sc.nextInt();
                    if(no>Collections.frequency(std, false)){
                        System.out.println("Not Enough Rooms");
                        continue;
                    }
                    break;
                }
                room.set(0, no);
                int i = 0;
                for(int j = 0; j<std.size(); j++){
                    if(std.get(j) == false && i<no){
                        if(j<10){
                            number = 100+j+1;
                        }else if(j>=10 && j<20){
                            number = 200+(j-10)+1;
                        }else{
                            number = 300+(j-20)+1;
                        }
                        roomNumbers.add(number);
                        std.set(j, true);
                        i++;
                    } 
                }
                sc.nextLine();
            }
        }

        //deluxe
        if(Collections.frequency(deluxe, false) != 0){
            System.out.print("Do you want to book Deluxe Room?  : ");
            roomchoice = sc.nextLine();
            if(roomchoice.equalsIgnoreCase("y") || roomchoice.equalsIgnoreCase("yes")){
                System.out.println("=================================================================");
                System.out.println(Collections.frequency(deluxe, false) + " Deluxe Rooms availble at 6000 per night");
                System.out.println("=================================================================");
                while (true) { 
                    System.out.print("How many rooms you want to book?  : ");
                    no = sc.nextInt();
                    if(no>Collections.frequency(deluxe, false)){
                        System.out.println("Not Enough Rooms\n");
                        continue;
                    }
                    break;
                }
                room.set(1, no);
                int i = 0;
                for(int j = 0; j<deluxe.size(); j++){
                    if(deluxe.get(j) == false && i<no){
                        if(j>4){
                            number = 400+(j-5)+1;
                        }else{
                            number = 300+(j+5)+1;
                        }
                        roomNumbers.add(number);
                        deluxe.set(j, true);
                        i++;
                    }
                }
                sc.nextLine();
            }
        }

        //suite
        if(Collections.frequency(suite, false) != 0){
            System.out.print("Do you want to book Suite Room?   : ");
            roomchoice = sc.nextLine();
            if(roomchoice.equalsIgnoreCase("y") || roomchoice.equalsIgnoreCase("yes")){                    
                System.out.println("=================================================================");
                System.out.println(Collections.frequency(suite, false) + " Suite Rooms availble at 9000 per night");
                System.out.println("=================================================================");
                while (true) { 
                    System.out.print("How many rooms you want to book?  : ");
                    no = sc.nextInt();
                    if(no>Collections.frequency(suite, false)){                            
                        System.out.println("Not Enough Rooms\n");
                        continue;
                    }
                    break;
                }
                room.set(2, no);
                int i = 0;
                for(int j = 0; j<suite.size(); j++){
                    if(suite.get(j) == false && i<no){
                        number = 500+j+1;
                        roomNumbers.add(number);
                        suite.set(j, true);
                        i++;
                    }
                }
                sc.nextLine();
            }
        }
        
        long reservationNumber;
        if (table.isEmpty()) {
            reservationNumber = 1074890;
        } else {
            Info last = table.get(table.size() - 1);
            long old = last.reservationNumber;
            reservationNumber = old+1;
        }

        table.add(new Info(addname, inputphn, roomNumbers, room, reservationNumber));
        set.add(reservationNumber);
        int amt = room.get(0)*4500 + room.get(1)*6000 + room.get(2)*9000;
        System.out.println("=================================================================");
        System.out.println("              RESERVATION CONFIRMED SUCCESSFULLY!");
        System.out.println("             YOUR RESERVATION NO. IS -> " + reservationNumber);
        System.out.println("           TOTAL AMOUNT(including 18% GST) -> "+ (amt + amt*0.18));
        System.out.println("=================================================================");
    }

    public static void bookEntry(String n, long phn, ArrayList<Integer> rn, ArrayList<Integer> r, long rsv){
        set.add(rsv);
        table.add(new Info(capitalize(n), phn, rn, r, rsv));
        for(int i = 0; i<rn.size(); i++){
            int currRoom = rn.get(i);
            int first = (currRoom-currRoom%100)/100;
            int last = currRoom%100;
            if(first == 1){
                std.set(last-1, true);
            }else if(first == 2){
                std.set(last+9, true);
            }else if(first == 3){
                if(last<=5){
                    std.set(last+19, true);
                }else{
                    deluxe.set(last-6, true);
                }
            }else if(first == 4){
                deluxe.set(last+4, true);
            }else if(first == 5){
                suite.set(last-1, true);
            }
        }
    }

    public static void displayroom(){
        System.out.println();
        System.out.println("=================================================================");
        if(Collections.frequency(std, false) != 0){
            System.out.println(Collections.frequency(std, false) + " Standard Rooms availble at 4500 per night");
        }else{
            System.out.println("Standard Room not available");
        }if(Collections.frequency(deluxe, false) != 0){
            System.out.println(Collections.frequency(deluxe, false) + " Deluxe Rooms availble at 6000 per night");
        }else{
            System.out.println("Deluxe Room not available");
        }if(Collections.frequency(suite, false) != 0){
            System.out.println(Collections.frequency(suite, false) + " Suite Rooms availble at 9000 per night");
        }else{
            System.out.println("Suite Room not available");
        }
        System.out.println("=================================================================");
        System.out.println();
    }

    public static void displaydetails(){
        long input = reservationNumberEtry();
        if(!set.contains(input)){
            System.out.println("No reservation exist for reservation no. : "+input + "\n");
        }else{
            for (int i = 0; i < table.size(); i++) {
                Info curr = table.get(i);
                if (curr.reservationNumber == input) {
                    System.out.println("=================================================================");
                    System.out.println("CUSTOMER NAME           :  " + curr.name);
                    System.out.println("PHONE NO.               :  " + curr.phone);
                    if(curr.room.get(0) != 0){
                        System.out.println("NO. OF STANDARD ROOMS   :  " + curr.room.get(0));
                    }if(curr.room.get(1) != 0){
                        System.out.println("NO. OF DELUXE ROOMS     :  " + curr.room.get(1));
                    }if(curr.room.get(2) != 0){
                        System.out.println("NO. OF SUITE ROOMS      :  " + curr.room.get(2));
                    }
                    System.out.println("ROOM NOS. BOOKED ARE    : "+ curr.roomNumbers);
                    int amt = curr.room.get(0)*4500 + curr.room.get(1)*6000 + curr.room.get(2)*9000;
                    System.out.println("=================================================================");
                    System.out.println("          TOTAL AMOUNT(Including 18% GST)  : "+ (amt + amt*0.18));
                    System.out.println("=================================================================\n");
                    break;
                }
            }
        }
    }

    public static void cancel(){
        long input = reservationNumberEtry();
        if(!set.contains(input)){
            System.out.println("No Reservation exist for Reservation No. : "+input + "\n");
        }else{
            for(int i = 0; i<table.size(); i++){
                Info curr = table.get(i);
                if(curr.reservationNumber == input){
                    for(int j = 0; j<curr.roomNumbers.size(); j++){
                        int rn = curr.roomNumbers.get(j);
                        int first = (rn-rn%100)/100;
                        int last = rn%100;
                        if(first == 1){
                            std.set(last-1, false);
                        }else if(first == 2){
                            std.set(last+9, false);
                        }else if(first == 3){
                            if(last<=5){
                                std.set(last+19, false);
                            }else{
                                deluxe.set(last-6, false);
                            }
                        }else if(first == 4){
                            deluxe.set(last+4, false);
                        }else if(first == 5){
                            suite.set(last-1, false);
                        }
                    }
                    int amt =  curr.room.get(0)*4500 + curr.room.get(1)*6000 + curr.room.get(2)*9000;
                    set.remove(curr.reservationNumber);
                    table.remove(curr);
                    System.out.println("=================================================================");
                    System.out.println("     RESERVATION CANCELLED FOR RESERVATION NUMBER : "+input);
                    System.out.println("               REFUNDABLE AMOUNT : " + (amt + amt*0.18)*0.6);
                    System.out.println("=================================================================\n");
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
        System.out.println("Enter 'A' to 'Book a reservation'");
        System.out.println("Enter 'B' to 'Display available rooms'");
        System.out.println("Enter 'C' to 'Display reservation details'");
        System.out.println("Enter 'D' to 'Cancel a reservation'");
        System.out.println("Enter 'E' to 'Close the Programme'");
        System.out.println("=================================================================");
    }

    public static void main(String[] args) {

        table = new ArrayList<>();

        bookEntry("ISHIKA", 9990921923L, new ArrayList<>(Arrays.asList(101,306,307,501,502,503)), new ArrayList<>(Arrays.asList(1,2,3)), 1074890L);
    
        set.add(1074890L);

        while (true) { 

            menu();
            System.out.print("Enter your choice : ");
            tocheck = sc.next();

            if(tocheck.equalsIgnoreCase("a")){
                book();
            }else if(tocheck.equalsIgnoreCase("b")){
                displayroom();
            }else if(tocheck.equalsIgnoreCase("c")){
                displaydetails();
            }else if(tocheck.equalsIgnoreCase("d")){
                cancel();
            }else if(tocheck.equalsIgnoreCase("e")){
                break;
            }else{
                System.out.println("Invalid Input\n");
            }
        }
    }
}