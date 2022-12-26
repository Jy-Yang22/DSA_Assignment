package assignment;

import java.util.Iterator;
import java.util.Scanner;


public class MemberMaintainance {

    public static SortedListInterface<Member>memberList = new SortedLinkedList<>();
    
    public static void main(String[] args) {
        MemberMaintainance mm = new MemberMaintainance();
        Scanner input = new Scanner(System.in);
        Member member1 = new Member("A0001","Ali","ali@gmail.com",18,'M',"0134467890","01010308016789");
        Member member2 = new Member("A0002","XiaoMeng","Meng123@gmail.com",20,'M',"0198861234","01010308016789");
        Member member3 = new Member("A0003","Mel","Mel123@gmail.com",20,'F',"0127901234","01011208010567");
      
        
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        
        int selection;
        do {
            System.out.print("Main Menu\n" + "1. Add member\n" + "2. Delete member\n" + "3. Search member\n" +"4. Modify member\n" + "5. Generate report\n" +"6. Exit\n"
                    + "Please select your option: ");
            selection = input.nextInt();
            input.nextLine();
            System.out.println();

            switch (selection) {
                case 1 -> mm.add();
                case 2 -> mm.delete();
                case 3 -> mm.search();
                case 4 -> mm.modify();
                
                case 5 -> mm.GenerateReport();
                    
                default -> System.out.println("Quit success!\n");
            }
        } while (selection > 0 && selection <= 5);
       
    }
    
    public void add(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id:");
        String addID = input.nextLine();
        System.out.println("Enter name:");
        String addName = input.nextLine();
        System.out.println("Enter email:");
        String addEmail = input.nextLine();
        System.out.println("Enter age:");
        int addAge = input.nextInt();
        input.nextLine();
        System.out.println("Enter gender(M/F):");
        char addGender = input.next().charAt(0);
        input.nextLine();
        System.out.println("Enter number telephone:");
        String addNoTel = input.nextLine();
        System.out.println("Enter number IC:");
        String addNoIC = input.nextLine();
        
        Member member = new Member(addID,addName,addEmail,addAge,addGender,addNoTel,addNoIC);
        memberList.add(member);
         
        System.out.println("Member successfully added to list.\n");
     
        
    }
    
    public void delete(){
        Iterator<Member> mem = memberList.getIterator();
        Scanner input = new Scanner(System.in);
        boolean dCheck = false;
        System.out.println("" + memberList.toString());
        System.out.println("Enter the member name you want to delete: ");
        String name = input.nextLine();
        while(mem.hasNext()){
            Member member = mem.next();
            if (name.compareTo(member.getName()) == 0){
                System.out.println("The member has removed succesfully: "+ memberList.delete(member));
                dCheck=true;
                
            }
        }
        if(!dCheck){
        System.out.println(name + " is not exist in the list\n");
        }
        
    }
    
    public void search(){
        Iterator<Member> mem = memberList.getIterator();
        Scanner input = new Scanner(System.in);
        boolean sCheck = false;
        System.out.println("Enter the member name you want to search: ");
        String name = input.nextLine();
        while(mem.hasNext()){
            Member member = mem.next();
            if(name.compareTo(member.getName()) == 0){
                System.out.println("Below are the search result");
                System.out.println ("Member{"+"id ="+member.getId()+" name="+ member.getName()+" email="+ member.getEmail()+" Age="+member.getAge()+" Gender="+ 
                        member.getGender()+" NoTel="+ member.getNoTel()+" NoIC="+ member.getNoIC()+'}');
                sCheck = true;
            }
        }
        if(!sCheck){
        System.out.println(name + " is not exist in the list\n");
        }
       
    }
    
    public void modify(){
        Iterator<Member> mem = memberList.getIterator();
        Scanner input = new Scanner(System.in);
        boolean mCheck = false;
        System.out.println("Enter the member name you want to edit: ");
        String name = input.nextLine();
        
        while(mem.hasNext()){
            Member member = mem.next();
            if (name.compareTo(member.getName()) == 0){
                String modID = member.getId();
                String modNoIC = member.getNoIC();
                String modName = member.getName();
                char modGender = member.getGender();
                
                System.out.println("Enter new email: ");
                String modEmail = input.nextLine();
                System.out.println("Enter new age: ");
                int modAge = input.nextInt();
                input.nextLine();
                System.out.println("Enter new number telephone: ");
                String modNoTel = input.nextLine();
                
                Member member1 = new Member(modID,modName,modEmail,modAge,modGender,modNoTel,modNoIC);
                memberList.modify(member, member1);
                
                System.out.println("Data succesfully edited!\n");
                mCheck = true;
                
            }
              
        }
        if(!mCheck){
        System.out.println(name + " is not exist in the list\n");
        }
    }
    
    public void GenerateReport(){
    
    System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("ID             Name                   Email                      Age           Gender           No Tel                No IC     ");
    System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("" + memberList.toString());
    System.out.println(memberList.getTotal()+" records found.\n");
     
    }
    
        
}
