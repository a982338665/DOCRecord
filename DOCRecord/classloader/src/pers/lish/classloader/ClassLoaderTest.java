package pers.lish.classloader;

import java.security.ProtectionDomain;

/**
 * create by lishengbo on 2017-12-21 10:38
 * 测试java热加载
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        new Thread(new MsgHandle()).start();
    }
}
