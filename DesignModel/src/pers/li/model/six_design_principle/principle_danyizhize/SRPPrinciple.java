package pers.li.model.six_design_principle.principle_danyizhize;

/**
 * create by lishengbo on 2018-03-21 11:20
 * 单一职责原则：Single responsibility principle
 *
 */
public class SRPPrinciple {

    /**
     * 例如：
     *
     * 陆生动物A：呼吸空气
     *
     * 水生动物B：水
     *******************************************
     * 方法一：
     *
     * 新建陆生动物类A -- 创建方法breath_空气
     * 新建水生动物类B -- 创建方法breath_水
     *
     * 没有违反单一职责原则，但是花销大
     *******************************************
     * 方法二：
     *
     * 创建动物类Animal：
     *      创建breathe方法：
     *          --判断若为水生：水
     *          --判断若为路生：空气
     * 违背单一职责原则，隐患大
     *******************************************
     * 方法三：
     *
     * 创建动物类Animal：
     *      创建呼吸空气的方法breath1
     *      创建呼吸谁的方法breathe2
     *
     * 方法级别上未违背单一职责原则
     *
     *
     *
     *
     */






}
