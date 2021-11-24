package com.github.tobato.fastdfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 测试驱动类
 * 
 * @author tobato
 *
 *
 * 关于EnableMBeanExport
 *
 * 对的，只需要一行注解 @Import(FdfsClientConfig.class)就可以拥有带有连接池的FastDFS Java客户端了。
 *
 * 如果不加 spring.jmx.enabled=false 和 @EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING) 启动项目时会报异常:
 *
 * org.springframework.jmx.export.UnableToRegisterMBeanException: Unable to register MBean [FdfsConnectionPool [maxTotal=50, blockWhenExhausted=true, maxWaitMillis=100, lifo=true, fairness=false, testOnCreate=false, testOnBorrow=false, testOnReturn=false, testWhileIdle=true, timeBetweenEvictionRunsMillis=60000, numTestsPerEvictionRun=-1, minEvictableIdleTimeMillis=180000, softMinEvictableIdleTimeMillis=-1, evictionPolicy=org.apache.commons.pool2.impl.DefaultEvictionPolicy@1a05ff8e, closeLock=java.lang.Object@251e2f4a, closed=false, evictionLock=java.lang.Object@1abea1ed, evictor=org.apache.commons.pool2.impl.BaseGenericObjectPool$Evictor@6f5288c5, evictionIterator=null, factoryClassLoader=java.lang.ref.WeakReference@5a9ef32e, oname=org.apache.commons.pool2:type=GenericKeyedObjectPool,name=pool, creationStackTrace=java.lang.Exception
 * 	at org.apache.commons.pool2.impl.BaseGenericObjectPool.<init>(BaseGenericObjectPool.java:142)
 * 	at org.apache.commons.pool2.impl.GenericKeyedObjectPool.<init>(GenericKeyedObjectPool.java:105)
 * 	at com.github.tobato.fastdfs.conn.FdfsConnectionPool.<init>(FdfsConnectionPool.java:33)
 * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
 * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
 * 	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
 * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
 * 	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:142)
 * 推荐使用 : @EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
 *
 * 注意：@EnableMBeanExport解决问题JMX重复注册问题,不要再配置 spring.jmx.enabled=false，以免影响SpringBoot默认的JMX监控

 *
 *
 */
@SpringBootApplication
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastdfsTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(FastdfsTestApplication.class, args);
    }

}
