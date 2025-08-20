// Very Important Double Checked Locking Concept
package com.amit.core.designpattern.a.singleton;

public class SingleTon05 {
	public static SingleTon05 st = null;
	
	private SingleTon05() {}
	
	public static SingleTon05 getInstance() {
		if(st == null) {
			synchronized (SingleTon05.class) {
				if(st==null) {
					st = new SingleTon05();
				}
			}
		}
		return st;
	}
}

/*

Thread safe Singleton using Double Checked Locking Idiom
--------------------------------------------------------
	Double checked locking idiom solves this problem by allowing you to eat your cake and have it as well, 
	it ensures synchronization is used only when instance of Singleton is created, when getInstance() method 
	is called first time and all other time, same instance is returned without any synchronization overhead. 
	
As the name suggests, it's double-checked, which means it checked two times 
	whether st (the singleton instance) is initialized or not, one without synchronization and 
	other with synchronization. 
	
	This double check ensures that locking is only used when an instance is null i.e. 
	when first time someone calls getInstance(), all subsequent call will see _instnace not null hence they 
	will not enter into synchronization block.

How Double Checked Locking Idiom Works
---------------------------------------
To illustrate the point, how this idiom prevents from two instances being created when two thread simultaneously 
calls the getInstance() method, let's see the theory. 

Suppose, thread T1 calls getInstance() very the first time and sees that st is null then it will go inside 
	synchronization block and that point of time it paused. 
	
Now, thread T2 calls getInstance() and it will also see st variable null, but it cannot go inside synchronization 
block because the lock is held by Thread T1, which is inside the synchronization block. 

Now, thread T1 wake up and creates a new instance of singleton and come out of synchronized block.  
After this when thread T2 goes inside synchronized block, it again checks whether st is null and this time 
check fails because st is no more null. 

So thread T2 come out of the synchronized block without creating another instance.  
Further calls to this method return from first check only.

*/
