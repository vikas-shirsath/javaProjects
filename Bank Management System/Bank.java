import java.util.*;

public class Bank {
        Scanner sc = new Scanner(System.in);
        private long accNo;
        private String accName;
        private long balance;
        public void addAcc() {
            System.out.println("Enter the Account Number : ");
            accNo = sc.nextLong();
            System.out.println("Enter the Account Name : ");
            accName = sc.next();
            System.out.println("Enter Amount to open Account : ");
            balance = sc.nextLong();
        }

        public int choices(){
            System.out.println("Enter 1 to add acc.");
            System.out.println("Enter 2 to Deposit");
            System.out.println("Enter 3 to withdraw.");
            System.out.println("Enter 4 to remove acc.");
            System.out.println("Enter 5 to display");
            System.out.println("Enter 6 to exit.");
            return sc.nextInt();
        }

        public boolean DepositMoney(long accNo1, String accName1){
            if (accNo == accNo1 && accName1.equals(accName)){
                System.out.println("Enter amount to deposit");
                long amount = sc.nextLong();
                balance = balance + amount;
                System.out.println("Your Balance is " + balance);
                return true;
            } else {
//                System.out.println("Your credentials are wrong ");
                return false;
            }
        }

        public boolean displayAcc(String accName1){
            if (accName1.equals(accName)){
                System.out.println("Acc. no. : "+ accNo);
                System.out.println("Acc. Name : "+ accName);
                System.out.println("Acc. Balance : "+ balance);
            } else {
//                System.out.println("Your credentials are wrong ");
                return false;
            }
            return true;
        }

        public boolean withdrawMoney(String accName1, long accNo1){
            if (accNo == accNo1 && accName1.equals(accName)){
                System.out.println("Enter amount to withdraw");
                long amount = sc.nextLong();
                balance = balance - amount;
                System.out.println("Your Balance is " + balance);
            } else {
//                System.out.println("Your credintials are wrong ");
                return false;
            }
            return true;
        }

    public boolean removeAcc(long accNo1, String accName1){
        //            System.out.println("Your credintials are wrong ");
        return accNo == accNo1 && accName1.equals(accName);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank[] B = new Bank[20];
        int i = 0;
        for(int j=0; j<20; j++){
            B[j] = new Bank();
        }
        while(true){
            int choice = B[i].choices();
            switch(choice) {
                 case 1:
                    B[i].addAcc();
                    i++;
                    break;
                case 2:
                    System.out.println("Enter acc. no. : ");
                    long accNo1 = sc.nextLong();
                    System.out.println("Enter acc. name : ");
                    String accName1 = sc.next();
                    for (int j = 0; j <= i; j++) {
                        boolean x = B[j].DepositMoney(accNo1, accName1);
                        if(x){
                            break;
                        }
                    }
                    System.out.println("Your credintials are wrong ");
                    break;
                case 3:
                    System.out.println("Enter acc. name : ");
                    accName1 = sc.next();
                    System.out.println("Enter acc. no. : ");
                    accNo1 = sc.nextLong();
                    for (int j = 0; j <= i; j++) {
                        boolean x = B[j].withdrawMoney(accName1, accNo1);
                        if(x){
                            break;
                        }
                    }
                    System.out.println("Your credintials are wrong ");
                    break;
                case 4:
                    System.out.println("Enter acc. name : ");
                    accName1 = sc.next();
                    System.out.println("Enter acc. no. : ");
                    accNo1 = sc.nextLong();
                    for (int j = 0; j <= i; j++) {
                        boolean x = B[j].removeAcc(accNo1, accName1);
                        if(x){
                            B[j] = null;
                        }
                        if(B[j] == null) {
                            System.out.println("Account is deleted");
                            break;
                        }
                    }
                    System.out.println("Your credintials are wrong ");
                    break;
                case 5:
                    System.out.println("Enter acc. name : ");
                    accName1 = sc.next();
                    for (int j = 0; j <= i; j++) {
                        boolean x = B[j].displayAcc(accName1);
                        if(x){
                            break;
                        }
                    }
                    System.out.println("Your credintials are wrong ");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}