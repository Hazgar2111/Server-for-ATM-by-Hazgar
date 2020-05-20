package sample;

import java.io.*;
import java.util.ArrayList;

public class Request implements Serializable {
    private String operationType;
    private ArrayList<Card> cards;
    private static final long serialVersionUID=9180844317717290831L;
    private static DBManager manager = new DBManager();
    private int index;
    private Card card;
    private int id;
    private ArrayList<admin> admins;
    String s="";

    public Request(String operationType, ArrayList<admin> admins, String s) {
        this.operationType = operationType;
        this.s=s;
        this.admins = admins;
    }
    @Override
    public String toString() {
        return "Request{" +
                "operationType='" + operationType + '\'' +
                ", cards=" + cards +
                ", index=" + index +
                ", card=" + card +
                ", id=" + id +
                '}';
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Request(String operationType, Card card, int index) {
        this.operationType = operationType;
        this.card = card;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }



    public Request() {
    }

    public Request(String operationType, ArrayList<Card> cards) {
        this.operationType = operationType;
        this.cards = cards;
    }

    public String getOperationType() {
        return operationType;
    }




    //ПОЛУЧЕНИЕ КАРТ ИЗ БАЗЫ ДАННЫХ
    public static  ArrayList<Card> returnCards(){
        ArrayList<Card> cards;
        manager.connect();
        cards=manager.getAllCards();
        return cards;
    }

    public static  ArrayList<admin> returnAdmins(){
        ArrayList<admin> admins;
        manager.connect();
        admins=manager.getAdmins();
        return admins;
    }

    public static void saveCards(Card card,int index){
       manager.connect();
       manager.newBalance(card,index);
    }

    public int getId() {
        return id;
    }

    public static void saveNewCards(Card card){
        manager.connect();
        manager.addCard(card);
    }
    public static void deleteCard(int  id){
        manager.connect();
        manager.deleteCard(id);
    }

}

