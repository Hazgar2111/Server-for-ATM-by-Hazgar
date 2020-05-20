package sample;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DBManager  extends Thread{
    private Connection connection;

    //@Override
    //public void run(){
    //    open();
    //}

    public void connect() {
        try {

            String urlDb="";
            try{
                ObjectInputStream inputStream=
                        new ObjectInputStream(new FileInputStream("save.txt"));
                urlDb=(String)inputStream.readObject();
                inputStream.close();

            }catch (FileNotFoundException e){

            }catch (Exception e) {
                e.printStackTrace();
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    urlDb, "root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Card> getAllCards(){
        ArrayList<Card> cardsList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Cards_ATM");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String number= resultSet.getString("number1");
                String pin= resultSet.getString("pin");
                String nameHolder= resultSet.getString("nameHolder");
                String surnameHolder= resultSet.getString("surnameHolder");
                String validity= resultSet.getString("validity");
                long balance= resultSet.getLong("balance");
                cardsList.add(new Card(id,number, pin, nameHolder, surnameHolder,validity,balance));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return cardsList;
    }
    public ArrayList<admin> getAdmins(){
        ArrayList<admin> adminList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM adminlogin");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String login= resultSet.getString("login");
                String password= resultSet.getString("password");
                int id = resultSet.getInt("id");

                adminList.add(new admin(login,password,id));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return adminList;
    }

    public void newBalance(Card card,int index){
        ArrayList<Card> cardsList1=getAllCards();
        Card card1=cardsList1.get(index);
        int id1=card1.getId();

        try{
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Cards_ATM SET balance=? where id=?");

            statement.setInt(2, id1);
            statement.setLong(1, card.getBalance());
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteCard(int id)
    {

        try{
            PreparedStatement statement;
            statement = connection.prepareStatement(""+
                    "DELETE FROM Cards_ATM WHERE id=?");
            System.out.println(id);
            statement.setInt(1,id);
            int rows =statement.executeUpdate();
            statement.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addCard(Card card) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Cards_ATM (id, number1, pin, nameHolder, surnameHolder,validity,balance) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, card.getNumber1());
            statement.setString(2, card.getPin());
            statement.setString(3, card.getNameHolder());
            statement.setString(4, card.getSurnameHolder());
            statement.setString(5, card.getValidity());
            statement.setLong(6, card.getBalance());

            int rows = statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    }
