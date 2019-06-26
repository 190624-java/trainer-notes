package com.revature.exceptions;

public class TryWith {

	public void before() {
		TelevisionStreamingResource tv = new TelevisionStreamingResource();
		try {
			//do some stuff with the resource
		} finally {
			tv.close();
		}
	}
	
	public void tryWith() {
		try(TelevisionStreamingResource tv = new TelevisionStreamingResource()){
			//logic here
		}//don't need to close the resource.
	}
	
}

class TelevisionStreamingResource implements AutoCloseable{
	public void close() {}
}