package com.blastic.clases;

import java.util.ArrayList;

public interface AsyncDelegate<T> {
	public void asyncComplete(ArrayList<T> elements);
}
