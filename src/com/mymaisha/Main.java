package com.mymaisha;

public class Main {

	public static void main(String[] args) {

		SearchTree tree = new SearchTree(null);
		tree.traverse(tree.getHead());
		// Create a string data array to avoid typing loads of addItem instructions:
		String stringData = "5 7 3 9 8 2 1 0 4 6";
		// String stringData = "Houston Austin Dallas Tampa Orlando Miami Ohio
		// Cincinnati";

		String[] data = stringData.split(" ");
		for (String s : data) {
			tree.addItem(new MenListItem(s));
		}

		tree.traverse(tree.getHead());
		tree.removeItem(new MenListItem("3"));
		tree.traverse(tree.getHead());

		tree.removeItem(new MenListItem("5"));
		tree.traverse(tree.getHead());

		tree.removeItem(new MenListItem("0"));
		tree.removeItem(new MenListItem("4"));
		tree.removeItem(new MenListItem("2"));
		tree.traverse(tree.getHead());

		tree.removeItem(new MenListItem("9"));
		tree.traverse(tree.getHead());
		tree.removeItem(new MenListItem("8"));
		tree.traverse(tree.getHead());
		tree.removeItem(new MenListItem("6"));
		tree.traverse(tree.getHead());
		tree.removeItem(tree.getHead());
		tree.traverse(tree.getHead());
		tree.removeItem(tree.getHead());
		tree.traverse(tree.getHead());
	}

}
