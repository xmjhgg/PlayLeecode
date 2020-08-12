package test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class Mytest {


    public static void main(String[] args) {
        ArrayList<String>  myList=new ArrayList<>();
        for (String a :myList){
            switch (a.length()){
                case 1:
                    System.out.println("hahah");break;
            }

        }
    }
}
