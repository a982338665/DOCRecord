package pers.li.model.structure.model_flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂角色，这可是关键所在
 */
public class FlyweightFactory {

    private Map menuList = new HashMap();

    private static FlyweightFactory factory = new FlyweightFactory();

    //这里还使用了单例模式，来使工厂对象只产生一个工厂实例
    private FlyweightFactory() {
    }

    public static FlyweightFactory getInstance() {
        return factory;
    }

    //这就是享元模式同工厂模式的不同所在！！
    public synchronized Menu factory(String dish) {

        //判断如果内蕴状态已经存在就不再重新生成，而是使用原来的，否则就重新生成
        if (menuList.containsKey(dish)) {
            return (Menu) menuList.get(dish);
        } else {
            Menu menu = new PersonMenu(dish);
            menuList.put(dish, menu);
            return menu;
        }
    }

    //来验证下是不是真的少产生了对象
    public int getNumber() {
        return menuList.size();
    }

}