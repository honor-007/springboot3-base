package com.honor.infrastructure.common.actor;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @Author honor
 * @Data 2024/7/3 10:02
 * @Version 1.0
 */
public class ActorInfoThreadHolder {
    /**
     * 保存用户对象的ThreadLocal
     */
    private static final TransmittableThreadLocal<Actor> ACTOR_THREAD_LOCAL = new TransmittableThreadLocal<>();

    /**
     * 添加当前登录用户方法
     */
    public static void addCurrentUser(Actor actor){
        ACTOR_THREAD_LOCAL.set(actor);
    }

    public static Actor getCurrentUser(){
        return ACTOR_THREAD_LOCAL.get();
    }


    /**
     * 防止内存泄漏
     */
    public static void remove(){
        ACTOR_THREAD_LOCAL.remove();
    }

}
