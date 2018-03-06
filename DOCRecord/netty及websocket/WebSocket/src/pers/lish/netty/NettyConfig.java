package pers.lish.netty;


import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 存储整个工程的全局配置
 * create by lishengbo on 2018-03-06 15:58
 */
public class NettyConfig {

    /**
     * 负责存储客户端进来的channel
     * 存储每一个客户端接入进来的channel对象
     */
    public static ChannelGroup group=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);





}
