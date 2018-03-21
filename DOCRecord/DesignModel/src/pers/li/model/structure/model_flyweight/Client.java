package pers.li.model.structure.model_flyweight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Client {

       private static FlyweightFactory factory ;

       public static void main(String[] args){

              List list1 = new ArrayList();

              factory = FlyweightFactory.getInstance();

              Menu list = factory.factory("尖椒土豆丝");

              list.setPersonMenu("ai92",list1);

              list = factory.factory("红烧肉");

              list.setPersonMenu("ai92",list1);

              list = factory.factory("地三鲜");

              list.setPersonMenu("ai92",list1);

              list = factory.factory("地三鲜");

              list.setPersonMenu("ai92",list1);

              list = factory.factory("红焖鲤鱼");

              list.setPersonMenu("ai92",list1);

              list = factory.factory("红烧肉");

              list.setPersonMenu("ai921",list1);

              list = factory.factory("红焖鲤鱼");

              list.setPersonMenu("ai921",list1);

              list = factory.factory("地三鲜");

              list.setPersonMenu("ai921",list1);

              System.out.println(factory.getNumber());

             

              List list2 = list.findPersonMenu("ai921",list1);

              Iterator it = list2.iterator();

              while(it.hasNext()) {

                     System.out.println(" "+it.next());

              }

       }

}