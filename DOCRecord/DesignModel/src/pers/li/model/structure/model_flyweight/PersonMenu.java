package pers.li.model.structure.model_flyweight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 具体享元角色
 */
class PersonMenu implements Menu {

    private String dish;

    //在构造方法中给内蕴状态附值

    public PersonMenu(String dish) {

        this.dish = dish;

    }

    public synchronized void setPersonMenu(String person, List list) {
        list.add(person);
        list.add(dish);
    }

    public List findPersonMenu(String person, List list) {
        List dishList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()){
            if (person.equals(String.valueOf( it.next())))
                dishList.add(it.next());
        }
        return dishList;
    }

}