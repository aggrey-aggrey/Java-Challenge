package com.mymaisha;

public class MenListItem extends ToDoListItem {

	public MenListItem(Object value) {
		super(value);

	}

	@Override
	ToDoListItem setNextItem(ToDoListItem item) {
		return this.next = item;

	}

	@Override
	ToDoListItem nextItem() {
		return this.next;
	}

	@Override
	ToDoListItem previousItem() {
		return this.previous;
	}

	@Override
	ToDoListItem setPreviousItem(ToDoListItem item) {
		return this.previous = item;
	}

	@Override
	int compareTo(ToDoListItem item) {

		if (item != null) {
			return ((String) super.getValue()).compareTo((String) item.getValue());
		} else {

			return -1;
		}
	}

}
