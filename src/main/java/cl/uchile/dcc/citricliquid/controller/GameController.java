package cl.uchile.dcc.citricliquid.controller;

import cl.uchile.dcc.citricliquid.controller.states.State;
import cl.uchile.dcc.citricliquid.exceptions.InvalidStateOperationException;
import cl.uchile.dcc.citricliquid.
import java.util.List;
import java.util.Scanner;

public class GameController {
    private final GameCharacter player = new GameCharacter("Player");
    private final List<GameCharacter> enemies =
            List.of(new GameCharacter("Enemy 1"), new GameCharacter("Enemy 2"), new GameCharacter("Enemy 3"));
    private State state = new IdleState(this);
    private GameCharacter selectedCharacter;
    private InputHandler inputHandler = new InputHandler(this);
    private InputManager inputManager = new InputManager();

    public GameController() {
        inputManager.addInputPromptListener(inputHandler);
    }

    public static void main(String[] args) throws InvalidStateOperationException {
        GameController gameController = new GameController();
        gameController.startBattle();
    }

    /**
     * Creates a new playable character.
     */
    public GameCharacter createPlayableCharacter(String name) {
        return new GameCharacter(name);
    }

    public void startBattle() throws InvalidStateOperationException {
        state.toAttackingState();
        inputManager.promptForInput();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void promptCharacterSelection() {
        System.out.println("Select a character to attack");
        for (int i = 0; i < enemies.size(); i++) {
            System.out.println(i + ") " + enemies.get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        selectedCharacter = enemies.get(scanner.nextInt());
        inputManager.processInput();
    }

    public void doAttack() throws InvalidStateOperationException {
        System.out.println(player.getName() + " attacks " + selectedCharacter.getName());
    }

    public void onSelectedCharacterChanged(GameCharacter selectedCharacter) {
        System.out.println(player.getName() + "attacks " + selectedCharacter.getName());
    }

    public void runContextAction() {
        try {
            state.runAction();
        } catch (InvalidStateOperationException e) {
            System.err.println("Invalid operation in current state");
        }
    }
}
