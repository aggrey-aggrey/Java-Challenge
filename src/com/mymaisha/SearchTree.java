package com.mymaisha;

public class SearchTree implements IgeneralList {

	private ToDoListItem head = null;

	public SearchTree(ToDoListItem root) {
		this.head = root;
	}

	@Override
	public ToDoListItem getHead() {
		return this.head;
	}

	@Override
	public boolean addItem(ToDoListItem newItem) {
		if (this.head == null) {
			// the tree was empty, so our item becomes the head of the tree
			this.head = newItem;
			return true;
		}

		// otherwise, start comparing from the head of the tree
		ToDoListItem currentItem = this.head;
		while (currentItem != null) {
			int comparison = (currentItem.compareTo(newItem));
			if (comparison < 0) {
				// newItem is greater, move right if possible
				if (currentItem.nextItem() != null) {
					currentItem = currentItem.nextItem();
				} else {
					// there's no node to the right, so add at this point
					currentItem.setNextItem(newItem);
					return true;
				}
			} else if (comparison > 0) {
				// newItem is less, move left if possible
				if (currentItem.previousItem() != null) {
					currentItem = currentItem.previousItem();
				} else {
					// there's no node to the left, so add at this point
					currentItem.setPreviousItem(newItem);
					return true;
				}
			} else {
				// equal, so don't add
				System.out.println(newItem.getValue() + " is already present");
				return false;
			}
		}
		// we can't actually get here, but Java complains if there's no return
		return false;
	}

	@Override
	public boolean removeItem(ToDoListItem item) {
		if (item != null) {
			System.out.println("Deleting item " + item.getValue());
		}
		ToDoListItem currentItem = this.head;
		ToDoListItem parentItem = currentItem;

		while (currentItem != null) {
			int comparison = (currentItem.compareTo(item));
			if (comparison < 0) {
				parentItem = currentItem;
				currentItem = currentItem.nextItem();
			} else if (comparison > 0) {
				parentItem = currentItem;
				currentItem = currentItem.previousItem();
			} else {
				// equal: we've found the item so remove it
				performRemoval(currentItem, parentItem);
				return true;
			}
		}
		return false;
	}

	private void performRemoval(ToDoListItem item, ToDoListItem parent) {
		// remove item from the tree
		if (item.nextItem() == null) {
			// no right tree, so make parent point to left tree (which may be null)
			if (parent.nextItem() == item) {
				// item is right child of its parent
				parent.setNextItem(item.previousItem());
			} else if (parent.previousItem() == item) {
				// item is left child of its parent
				parent.setPreviousItem(item.previousItem());
			} else {
				// parent must be item, which means we were looking at the root of the tree
				this.head = item.previousItem();
			}
		} else if (item.previousItem() == null) {
			// no left tree, so make parent point to right tree (which may be null)
			if (parent.nextItem() == item) {
				// item is right child of its parent
				parent.setNextItem(item.nextItem());
			} else if (parent.previousItem() == item) {
				// item is left child of its parent
				parent.setPreviousItem(item.nextItem());
			} else {
				// again, we are deleting the root
				this.head = item.nextItem();
			}
		} else {
			// neither left nor right are null, deletion is now a lot trickier!
			// From the right sub-tree, find the smallest value (i.e., the leftmost).
			ToDoListItem current = item.nextItem();
			ToDoListItem leftmostParent = item;
			while (current.previousItem() != null) {
				leftmostParent = current;
				current = current.previousItem();
			}
			// Now put the smallest value into our node to be deleted
			item.setValue(current.getValue());
			// and delete the smallest
			if (leftmostParent == item) {
				// there was no leftmost node, so 'current' points to the smallest
				// node (the one that must now be deleted).
				item.setNextItem(current.nextItem());
			} else {
				// set the smallest node's parent to point to
				// the smallest node's right child (which may be null).
				leftmostParent.setPreviousItem(current.nextItem());
			}
		}
	}

	@Override
	public void traverse(ToDoListItem root) {
		// recursive method
		if (root != null) {
			traverse(root.previousItem());
			System.out.println(root.getValue());
			traverse(root.nextItem());
		}

	}

}
