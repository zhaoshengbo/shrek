/**
 *
 */
package com.uidesigner.itf;

/**
 * Sherk.
 *
 * 执行策略.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 下午9:01:48
 */
public interface IExecuteStrategy {

	public void run() throws Exception;

	public int getExeMilliSeconds();

}
