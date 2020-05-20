package sample;

import java.net.*;
import java.io.*;
import java.util.*;


public class ServerRunnable extends Thread{

    private Socket socket;

    public ServerRunnable(Socket socket){
        this.socket = socket;
    }
    public void run(){

        Request request=new Request();
        Request r;
        try{
            ObjectOutputStream outStream =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inStream=
                    new ObjectInputStream(socket.getInputStream());

            while((r=(Request)inStream.readObject())!=null){
                if(r.getOperationType().equals("LIST_CARDS")){
                    ArrayList<Card> cards1 = request.returnCards();
                    Request data = new Request("LIST_CARDS", cards1);
                    outStream.writeObject(data);
                }
                else if(r.getOperationType().equals("LIST_ADMINS")){
                    ArrayList<admin> admins = request.returnAdmins();
                    Request data1 = new Request("LIST_ADMINS",admins,null);
                    outStream.writeObject(data1);
                }
                else  if(r.getOperationType().equals("NEW_CARDS")){
                    Request newR;
                    newR=(Request)inStream.readObject();
                    newR.saveCards(newR.getCard(),newR.getIndex());
                }
                else  if(r.getOperationType().equals("WHOLE_CARDS")){
                    Request newR;
                    newR=(Request)inStream.readObject();
                    newR.saveNewCards(newR.getCard());
                }
                else  if(r.getOperationType().equals("DELETE_CARD")){
                    Request newR;
                    newR=(Request)inStream.readObject();
                    System.out.println(newR.getId());
                    newR.deleteCard(newR.getId());
                }
            }
            outStream.close();
            socket.close();
        }catch (Exception e) {

        }



    }

}
