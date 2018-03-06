package pers.lish.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 程序的入口负责启动应用
 * create by lishengbo on 2018-03-06 17:11
 */
public class Main {


    public static void main(String[] args) {

        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workGroup=new NioEventLoopGroup();
        try {
            ServerBootstrap b=new ServerBootstrap();
            b.group(bossGroup,workGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new MyWebSocketChannelHandle());
            System.out.println("服务端开启等待客户端连接=====");
            Channel channel = b.bind(8888).sync().channel();
            channel.closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //退出程序
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }





    }






}
