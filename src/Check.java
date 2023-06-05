


import java.sql.Connection;
import java.sql.DriverManager;

public class Check
{
    Connection con;

    public Check()
    {
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver Loaded");
            con= DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");

            System.out.println("Connection got succsessfully");

        }catch(Exception e)
        {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Check();
    }

}