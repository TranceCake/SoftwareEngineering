package Tree;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Enumeration;

/**
 * Created by Tanja on 22-2-2015.
 */
public class Run {
    private DefaultMutableTreeNode root;

    public static void main (String args[]){
        Run tree = new Run();

        tree.breadthFirstPrint();
        System.out.println(" ");
        tree.PreOrderPrint();
        System.out.println(" ");
        tree.PostOrderPrint();
        System.out.println(" ");
    }

    public Run(){
        DefaultMutableTreeNode person,employee,customer,us_customer;

        us_customer = new DefaultMutableTreeNode("US_Customer");
        us_customer.add(new DefaultMutableTreeNode("Local_Customers"));
        us_customer.add(new DefaultMutableTreeNode("Regional_Customers"));

        employee = new DefaultMutableTreeNode("Employee");
        employee.add(new DefaultMutableTreeNode("Sales_Rep"));
        employee.add(new DefaultMutableTreeNode("Engineer"));

        customer = new DefaultMutableTreeNode("Customer");
        customer.add(us_customer);
        customer.add(new DefaultMutableTreeNode("Non_US_Customer"));

        person = new DefaultMutableTreeNode("Person");
        person.add(employee);
        person.add(customer);

        root = person;

    }

    public void breadthFirstPrint() {
        Enumeration<DefaultMutableTreeNode> breadth = root.breadthFirstEnumeration();
        System.out.println("Breadth first enumeration:");
        while(breadth.hasMoreElements())
        {
            System.out.print(breadth.nextElement() + " , " );
        }
    }

    public void PreOrderPrint() {
        Enumeration<DefaultMutableTreeNode> preOrder = root.preorderEnumeration();
        System.out.println("Pre-order enumeration:");
        while(preOrder.hasMoreElements())
        {
            System.out.print(preOrder.nextElement()+ " , " );
        }
    }

    public void PostOrderPrint() {
        Enumeration<DefaultMutableTreeNode> postOrder = root.postorderEnumeration();
        System.out.println("Post-Order enumeration:");
        while(postOrder.hasMoreElements())
        {
            System.out.print(postOrder.nextElement()+ " , " );
        }
    }
}
