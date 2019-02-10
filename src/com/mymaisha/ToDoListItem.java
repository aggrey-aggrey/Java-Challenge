package com.mymaisha;

public abstract class ToDoListItem {
	protected ToDoListItem next = null;
	protected ToDoListItem previous = null;

	protected Object value;

	public ToDoListItem(Object value) {
		this.value = value;
	}

	abstract int compareTo(ToDoListItem item);

	abstract ToDoListItem nextItem();

	abstract ToDoListItem previousItem();

	abstract ToDoListItem setNextItem(ToDoListItem item);

	abstract ToDoListItem setPreviousItem(ToDoListItem item);

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
