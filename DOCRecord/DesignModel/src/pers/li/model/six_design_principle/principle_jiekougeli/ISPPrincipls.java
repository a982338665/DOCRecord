package pers.li.model.six_design_principle.principle_jiekougeli;

/**
 * create by lishengbo on 2018-03-21 11:52
 * 接口隔离原则（Interface Segregation Principle）
 * 使用多个隔离的接口，比使用单个接口要好
 */
public class ISPPrincipls {

    /**
     *
     *例如：
     * 接口I --方法A B C D
     * 实现类 M 仅需要方法 AB
     * 实现类 N 仅需要方法 CD
     *
     * 此时为避免用接口臃肿，应该拆分接口I，避免实现类MN对不用的方法进行多余的实现
     *
     *
     */
}
