package com.amit.core.designpattern.g.prototype.ex2;

public interface Animal extends Cloneable {
	public Animal clone();
}

/*

-- ProtoType design pattern is used for creating new object (Instances)
	by cloning(coping) other objects and this way we can improve
	the performance.
	This pattern uses java cloning to copy the object.
-- This pattern is used when creation of object is costly or complex.
	for example, a object is to be created after a costly database
	operation. we can cache the object, returns its clone or next request.
	Once we get the cloned object we can modify according to our need.

*/
