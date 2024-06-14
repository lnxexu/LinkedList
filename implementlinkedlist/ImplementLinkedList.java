package implementlinkedlist;

import java.util.Scanner;

public class ImplementLinkedList{
    
    public static void Menu(){
        System.out.print("MENU"+"\n1. Insert node at beginning" + "\n2. Insert node at end" + "\n3. Insert node at middle" + "\n4. Delete node at beginning" + 
                             "\n5. Delete node at end" + "\n6. Delete node at middle" + "\n7. Display" + "\n8. Node Count" + "\n9. Exit" + "\nChoice: ");
    }
       
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        Scanner input = new Scanner(System.in);
        int data, pos;

        while(true){     
            Menu();
            switch(input.nextInt()){
                case 1:{
                    System.out.print("Enter Data: ");
                    data = input.nextInt();
                    list.addToHead(data);
                    list.display();
                    System.out.println("");
                    break;
                } 
                case 2:{
                    System.out.print("Enter Data: ");
                    data = input.nextInt();
                    list.addToTail(data);
                    list.display();
                    System.out.println("");
                    break;
                }
                case 3:{
                    System.out.print("Enter Data: ");
                    data = input.nextInt();
                    System.out.println();
                    System.out.print("Enter Position: ");
                    pos = input.nextInt();    
                    list.addToMiddle(data, pos);
                    list.display();
                    System.out.println("");
                    break;
                }
                case 4:{
                    list.deleteFromHead();
                    list.display();
                    System.out.println("");
                    break;
                }
                case 5:{
                    list.deleteFromTail();
                    list.display();
                    System.out.println("");
                    break;
                }
                case 6:{
                    System.out.print("Enter Position: ");
                    pos = input.nextInt();    
                    list.deleteFromMiddle(pos);
                    list.display();
                    System.out.println("");
                    break;
                }
                case 7:{
                    list.display();
                    System.out.println("");
                    break;
                }
                case 8:{
                    list.listCount();
                    System.out.println("");
                    break;
                }
                case 9:{
                    return;
                }
            } 
        } 
    }
}

