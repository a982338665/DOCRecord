package pers.li.model.six_design_principle.principle_yilaidaozhi;

/**
 * create by lishengbo on 2018-03-21 11:38
 * 依赖倒转原则（Dependence Inversion Principle）：
 *
 * 面向接口编程
 */
public class DIPPrincipls {


    /**
     *
     * 例如：
     *
     *  类mother
     *      -方法：讲故事talk（book b） 参数为类book
     *  类book--故事会
     *
     *  测试：mother.talk(book)
     ******************************************
     *
     *  类newspaper--报纸
     *
     *  若要讲报纸，则需要更改talk（book b）为 talk（类newspaper n）
     *
     *  此时mother和book的耦合度太高，且需要不断的修改mother，故引入接口读物Reader
     *
     ******************************************
     * 面向接口编程：
     *
     * 接口Reader
     *
     * 类book实现Reader
     *
     * 类newspaper实现Reader
     *
     * 类mother中talk（book b）更改为talk（Reader b）
     *
     * 测试：
     *  mother.talk(new book)
     *  mother.talk(new newspaper)
     *
     *
     *
     */




}
