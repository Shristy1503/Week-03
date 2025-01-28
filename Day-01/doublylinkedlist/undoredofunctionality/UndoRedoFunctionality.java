package doublylinkedlist.undoredofunctionality;

public class UndoRedoFunctionality {
    public static void main(String[] args) {
        UndoRedoLinkedList editor = new UndoRedoLinkedList(10); // Limit history to 10 states

        // Adding states
        editor.addState("Hey");
        editor.addState("Hey, there!");
        editor.addState("Hey, there! How");
        editor.addState("Hey, there! How are you?");

        // Display the current state
        editor.displayCurrentState();

        // Undo functionality
        editor.undo();
        editor.undo();

        // Redo functionality
        editor.redo();

        // Add a new state (overwrites redo history)
        editor.addState("Hey, there! How is it going?");

        // Display all states
        editor.displayAllStates();

        // Display the current state
        editor.displayCurrentState();
    }
}
