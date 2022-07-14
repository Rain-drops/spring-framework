package org.springframework.testsgj.aop;

import org.junit.jupiter.api.Test;
import org.springframework.testsgj.aop.bean.MyInterface;
import org.springframework.testsgj.aop.bean.ProxyFactory;
import org.springframework.testsgj.aop.bean.TargetObject;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;


public class ProxyTest {
	public static void main(String[] args) {
		TargetObject target = new TargetObject();
		// ProxyFactory 实现了 InvocationHandler接口，其中的 getInstance()方法 利用 Proxy类
		// 生成了 target目标对象 的代理对象，并返回；且 ProxyFactory 持有对 target 的引用，可以在
		// invoke() 中完成对 target 相应方法的调用，以及目标方法前置后置的增强处理
		ProxyFactory proxyFactory = new ProxyFactory();
		// 这个 mi 就是 JDK 的 Proxy类 动态生成的代理类 $Proxy0 的实例，该实例中的方法都持有对
		// invoke()方法 的回调，所以当调用其方法时，就能够执行 invoke() 中的增强处理
		MyInterface mi = (MyInterface) proxyFactory.getInstance(target);
		// 这样可以看到 mi 的 Class 到底是什么
		System.out.println(mi.getClass());
		// 这里实际上调用的就是 $Proxy0代理类 中对 play()方法 的实现，结合下面的代码可以看到
		// play()方法 通过 super.h.invoke() 完成了对 InvocationHandler对象(proxyFactory)中
		// invoke()方法 的回调，所以我们才能够通过 invoke()方法 实现对 target对象 方法的
		// 前置后置增强处理
		mi.play();
		// 总的来说，就是在 invoke()方法 中完成 target目标方法 的调用，及前置后置增强，
		// JDK 动态生成的代理类中对 invoke()方法 进行了回调
	}

	/**
	 * 将 ProxyGenerator 生成的动态代理类的输出到文件中，利用反编译工具 luyten 等就可
	 * 以看到生成的代理类的源码咯，下面给出了其反编译好的代码实现
	 */
	@Test
	public void generatorSrc(){
		byte[] bytesFile = ProxyGenerator.generateProxyClass("$Proxy0", TargetObject.class.getInterfaces());
		FileOutputStream fos = null;
		try{
			String path = System.getProperty("user.dir") + "\\$Proxy0.class";
			File file = new File(path);
			fos = new FileOutputStream(file);
			fos.write(bytesFile);
			fos.flush();
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
final class $Proxy0 extends Proxy implements MyInterface {
	private static Method m1;
	private static Method m2;
	private static Method m3;
	private static Method m0;

	public $Proxy0(InvocationHandler var1){
		super(var1);
	}

	public final boolean equals(Object var1){
		try {
			return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
		} catch (RuntimeException | Error var3) {
			throw var3;
		} catch (Throwable var4) {
			throw new UndeclaredThrowableException(var4);
		}
	}

	public final String toString(){
		try {
			return (String)super.h.invoke(this, m2, (Object[])null);
		} catch (RuntimeException | Error var2) {
			throw var2;
		} catch (Throwable var3) {
			throw new UndeclaredThrowableException(var3);
		}
	}

	public final void play(){
		try {
			// 这个 h 其实就是我们调用 Proxy.newProxyInstance()方法 时传进去的 ProxyFactory对象(它实现了InvocationHandler接口)，
			// 该对象的 invoke()方法 中实现了对目标对象的目标方法的增强。
			// 看到这里，利用动态代理实现方法增强的实现原理就全部理清咯
			super.h.invoke(this, m3, (Object[])null);
		} catch (RuntimeException | Error var2) {
			throw var2;
		} catch (Throwable var3) {
			throw new UndeclaredThrowableException(var3);
		}
	}

	public final int hashCode(){
		try {
			return (Integer)super.h.invoke(this, m0, (Object[])null);
		} catch (RuntimeException | Error var2) {
			throw var2;
		} catch (Throwable var3) {
			throw new UndeclaredThrowableException(var3);
		}
	}

	static {
		try {
			m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
			m2 = Class.forName("java.lang.Object").getMethod("toString");
			// 实例化 MyInterface 的 play()方法
			m3 = Class.forName("org.springframework.testsgj.aop.bean.MyInterface").getMethod("play");
			m0 = Class.forName("java.lang.Object").getMethod("hashCode");
		} catch (NoSuchMethodException var2) {
			throw new NoSuchMethodError(var2.getMessage());
		} catch (ClassNotFoundException var3) {
			throw new NoClassDefFoundError(var3.getMessage());
		}
	}
}
