package com.mymaisha;

public class MyLinkedList implements IgeneralList {

	private ToDoListItem head = null;

	public MyLinkedList(ToDoListItem head) {
		this.head = head;
	}

	@Override
	public ToDoListItem getHead() {
		return this.head;
	}

	@Override
	public boolean addItem(ToDoListItem newItem) {
		if (this.head == null) {
			// The list was empty so this item becomes the head of the list
			this.head = newItem;
			return true;
		}
		ToDoListItem currentItem = this.head;
		while (currentItem != null) {
			int comparison = (currentItem.compareTo(newItem));
			if (comparison < 0) {
				// newItem is greater, move to next item if possible
				if (currentItem.nextItem() != null) {
					currentItem = currentItem.nextItem();
				} else {
					// there is no next, so insert at end of list
					currentItem.setNextItem(newItem).setPreviousItem(currentItem);
					return true;
				}
			} else if (comparison > 0) {
				// newItem is less, insert before
				if (currentItem.previousItem() != null) {
					currentItem.previousItem().setNextItem(newItem).setPreviousItem(currentItem.previousItem());
					newItem.setNextItem(currentItem).setPreviousItem(newItem);
				} else {
					// the node with a previous is the head of the list
					newItem.setNextItem(this.head).setPreviousItem(newItem);
					this.head = newItem;
				}
				return true;
			} else {
				// equal
				System.out.println(newItem.getValue() + " is already present, not added.");
				return false;
			}
		}

		return false;
	}

	@Override
	public boolean removeItem(ToDoListItem item) {
		if (item != null) {
			System.out.println("Deleting item " + item.getValue());
		}

		ToDoListItem currentItem = this.head;
		while (currentItem != null) {
			int comparison = currentItem.compareTo(item);
			if (comparison == 0) {
				// found the item to delete
				if (currentItem == this.head) {
					this.head = currentItem.nextItem();
				} else {
					currentItem.previousItem().setNextItem(currentItem.nextItem());
					if (currentItem.nextItem() != null) {
						currentItem.nextItem().setPreviousItem(currentItem.previousItem());
					}
				}
				return true;
			} else if (comparison < 0) {
				currentItem = currentItem.nextItem();
			} else { // comparison > 0
				// We are at an item greater than the one to be deleted
				// so the item is not in the list
				return false;
			}
		}

		// We have reached the end of the list
		// Without finding the item to delete
		return false;
	}

	@Override
	public void traverse(ToDoListItem head) {
		if (head == null) {
			System.out.println("The list is empty");
		} else {
			while (head != null) {
				System.out.println(head.getValue());
				head = head.nextItem();
			}
		}
	}

}
