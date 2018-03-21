package pers.li.model.action.model_command;

/**
 * Invoker是调用者（司令员），Receiver是被调用者（士兵），MyCommand是命令，实现了Command接口，持有接收对象
 */
public class Test {
  
    public static void main(String[] args) {
        //定义接收人
        Receiver receiver = new Receiver();  
        //传递命令
        Command cmd = new MyCommand(receiver);
        //发布命令
        Invoker invoker = new Invoker(cmd);
        invoker.action();  
    }  
} 