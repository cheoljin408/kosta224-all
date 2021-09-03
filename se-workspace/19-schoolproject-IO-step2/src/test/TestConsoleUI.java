package test;

import java.io.IOException;

import view.ConsoleUI;

public class TestConsoleUI {
	public static void main(String[] args) {
		ConsoleUI ui = new ConsoleUI();
		try {
			ui.execute();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
