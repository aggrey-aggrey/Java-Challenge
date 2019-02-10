package com.mymaisha;

public interface IgeneralList {
	ToDoListItem getHead();

	boolean addItem(ToDoListItem item);

	boolean removeItem(ToDoListItem item);

	void traverse(ToDoListItem head);

}
