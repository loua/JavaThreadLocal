/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laloia.threadlocalexample;

/**
 *
 * @author lou
 */
public class ThreadLocalManager {

    public static final ThreadLocal<ThreadContext> threadLocalContext =
            new ThreadLocal<ThreadContext>();
}
