package org.uob.a1;

import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {

        // init some components like map, score
        Map grid = new Map(10, 10); // named it grid for simplicity/avoid confusion for myself
        Score score = new Score(0); 
        
        // creating rooms with their unique features/puzzles/items etc
        Room room1 = new Room(
                "Entrance Hall", 
                "\nA grand, dusty hall with high ceilings and ancient walls. " +
                "\nOne wall displays an inscription in an ancient language" +
                "\nand the floor is covered in golden sand." +
                "\nPerhaps 'look inscription' or 'look golden sand' might reveal something useful.", 
                'E', 
                new Position(2, 1)
            );
            room1.setFeatures(new String[]{"inscription", "golden sand"});
            room1.setFeatureDesc(new String[]{"\nThe inscription seems to contain ancient languages, luckily, you find a translation scroll right next to it and pick it up.", "\nYou walk on the sand, quickly realizing it's a quick sand trap." + "\nYou lose 10 HP and -1 score."});
            room1.setRequiredItems(new String[]{"Translation Scroll", null});
            room1.setItemFound("Translation Scroll");
            room1.setIsTrap(new boolean[]{false, true});
            room1.setPuzzle("What is the ancient language trying to convey?");
            room1.setAfterWin("\nUsed [Translation Scroll] to decipher the inscription. \nIt reads: 'Just the beginning, novice, please move east to the Hall of Mirrors...");
    
        
            Room room2 = new Room(
                "Hall of Mirrors", 
                "\nA large hall meant to confuse and frighten any explorer attempting to unlock the temple's power. " +
                "\nOne mirror stands out with strong shimmering symbols." + 
                "\nYou might want to 'look shimmering mirror' for a closer inspection.", 
                'M', 
                new Position(3, 1)
            );
            room2.setFeatures(new String[]{"shimmering mirror", null});
            room2.setFeatureDesc(new String[]{"\nAs you get closer, the mirror breaks into multiple shards with magical reflections, you pick one up.", null});
            room2.setRequiredItems(new String[]{"Mirror Shard", null});
            room2.setItemFound("Mirror Shard");
            room2.setIsTrap(new boolean[]{false, false});
            room2.setPuzzle("What does the ceiling mirror reveal? Your mirror shard might come in handy here...");
            room2.setAfterWin("\nYou found a hidden symbol in the mirror. It seemed to reflect some sort of library to the east...");
    
            Room room3 = new Room(
                "Library of Whispers", 
                "\nYou walk into a small room with books that seem to be whispering when you pass by. " +
                "\nTwo books seem to be standing out, they whisper louder than the rest." +
                "\nOne book is an ancient tome, and the other is a bloody book" +
                "\nTry to 'look ancient tome' or 'look bloody book' to read them.", 
                'L', 
                new Position(4, 1)
            );
            room3.setFeatures(new String[]{"ancient tome", "bloody book"});
            room3.setFeatureDesc(new String[]{"\nYou pick up and open the ancient tome.", "\nUpon opening the book, a cobra comes out to bite you. You lose 10 HP and -1 score."});
            room3.setRequiredItems(new String[]{"Translation Scroll", null});
            room3.setItemFound("Ancient tome");
            room3.setIsTrap(new boolean[]{false, true});
            room3.setPuzzle("What secrets does the ancient tome hold?");
            room3.setAfterWin("\nThe text seemed to warn you that everything is an illusion. \nA gate opens from one of the libraries, proceed to the next room.");
    
            Room room4 = new Room(
                "Illusionary Garden", 
                "\nYou walk into a lush garden with flowers humanity has never seen before. " + 
                "\nThere are different colors of doors around you." +
                "\nSome flowers and vines seem interesting, perhaps one of them can get you out of this endless loop." + 
                "\nUse 'look flower' or 'look vine' to analyze them deeper.", 
                'G', 
                new Position(4, 2)
            );
            room4.setFeatures(new String[]{"flower", "vine"});
            room4.setFeatureDesc(new String[]{"\nYou pick up the flower, but the colors seem to change quickly, almost like it's an illusion!", "\nIt's a trap! The vines entangle you and almost choke you. You lose 10 HP and -1 score."});
            room4.setRequiredItems(new String[]{"Mirror shard", null});
            room4.setItemFound("Flower");
            room4.setIsTrap(new boolean[]{false, true});
            room4.setPuzzle("Identify the color of the flower.");
            room4.setAfterWin("You use your mirror shard to accurately reflect the color of the flower, which was 'Blurple'. You may want to use the blurple door to the south.");
    
            Room room5 = new Room(
                "Statue Museum", 
                "\nAncient statues of humans and beasts, scholars and warriors. " +
                "\nOne statue seems to have 2 hidden compartments." + 
                "\nTry to use 'look compartment 2' or 'look compartment 1' to look deeper", 
                'S', 
                new Position(4, 3)
            );
            room5.setFeatures(new String[]{"compartment 1", "compartment 2"});
            room5.setFeatureDesc(new String[]{"\nYou found a Rusty Key in the hidden compartment. You also notice symbols on some statues.", "\nIt's a trap! The statue falls on you. You lose 10 HP and -1 score."});
            room5.setRequiredItems(new String[]{"Ancient tome", null});
            room5.setItemFound("Rusty Key");
            room5.setIsTrap(new boolean[]{false, true});
            room5.setPuzzle("Decipher the symbols on the statues.");
            room5.setAfterWin("\nYou used the ancient tome to decipher the symbols, the arrow points west...");
    
            Room room6 = new Room(
                "Chamber of Flames", 
                "\nTemperatures reach over 50 degrees here, intense flames dance around the room, making it hard to see the path forward. " +
                "\nTry to 'look flame pattern' for more information.", 
                'F', 
                new Position(3, 3)
            );
            room6.setFeatures(new String[]{"flame pattern", null});
            room6.setFeatureDesc(new String[]{"\nYou found a pattern of blue flames, they seem not to burn. It might help you navigate.", null});
            room6.setRequiredItems(new String[]{"Blue flames", null});
            room6.setItemFound("Blue flames");
            room6.setIsTrap(new boolean[]{false, true});
            room6.setPuzzle("Navigate through the flames.");
            room6.setAfterWin("\nYou navigated through the flames safely by following the blue flames. Proceed to the next room.");
    
            Room room7 = new Room(
                "Frozen Cave", 
                "\nA quiet and cold icy cave. The low temperatures here make it difficult to stay in it for long. " +
                "\nYou notice some snow and ice crystals on the floor." +
                "\nTry to use 'look ice crystal' or 'look snow' to take a deeper look.", 
                'C', 
                new Position(3, 4)
            );
            room7.setFeatures(new String[]{"snow", "ice crystal"});
            room7.setFeatureDesc(new String[]{"\nYou dig through the snow and find a lantern.", "\nThe ice crystals stab you. You lose 10 HP."});
            room7.setRequiredItems(new String[]{"Blue flames", null});
            room7.setItemFound("Lantern");
            room7.setIsTrap(new boolean[]{false, true});
            room7.setPuzzle("Melt the ice cave walls.");
            room7.setAfterWin("You melted the ice with the blue flames. A tight passage shows up west.");
    
            Room room8 = new Room(
                "Echo Vault", 
                "\nYou crawl into a vault." + 
                "\nEvery sound bounces off the walls and creates a loud echo, getting louder each time it bounces. " +
                "\nTry to 'look echo chamber' for more information.", 
                'V', 
                new Position(2, 4)
            );
            room8.setFeatures(new String[]{"echo chamber", null});
            room8.setFeatureDesc(new String[]{"You found an Echo Stone. Listen to the voices...", "It's a trap! The echo disorients you. You lose 10 HP."});
            room8.setRequiredItems(new String[]{"Echo Stone", null});
            room8.setItemFound("Echo Stone");
            room8.setIsTrap(new boolean[]{false, true});
            room8.setPuzzle("Listen to the voices to ascend.");
            room8.setAfterWin("The voices make the floor collapse south of you.");
    
            Room room9 = new Room(
                "Hall of Shadows", 
                "\nThis room is shrouded in darkness, with shadows that seem to move and shift as you walk. " +
                "\nYou see a square and circular shadow" +
                "\nTry to 'look square shadow' or 'look circular shadow' for more information.", 
                'D', 
                new Position(2, 5)
            );
            room9.setFeatures(new String[]{"square shadow", "circular shadow"});
            room9.setFeatureDesc(new String[]{"The square shadow quickly shifts around you", "It's a trap! The shadows engulf you. You lose 10 HP."});
            room9.setRequiredItems(new String[]{"Lantern", null});
            room9.setItemFound(null);
            room9.setIsTrap(new boolean[]{false, true});
            room9.setPuzzle("Illuminate the shadows.");
            room9.setAfterWin("\nYou illuminated the shadows and found a hidden basement door.");
    
            Room room10 = new Room(
                "Sphinx Room", 
                "\nA grand sphinx statue sits at the far end of the room. Its eyes seem to follow you, and a deep voice echoes from within. " +
                "\nTry to 'look sphinx' for more information.", 
                'X', 
                new Position(2, 6)
            );
            room10.setFeatures(new String[]{"sphinx", null});
            room10.setFeatureDesc(new String[]{"You climb the sphinx, it tells you that the source of life is from a plant.", "It's a trap! The riddle confuses you. You lose 10 HP."});
            room10.setRequiredItems(new String[]{"Flower", null});
            room10.setItemFound(null);
            room10.setIsTrap(new boolean[]{false, true});
            room10.setPuzzle("Answer the Sphinx's riddle.");
            room10.setAfterWin("\nThe sphinx warns you that you're extremely close, the temple starts to shake. Move west");
    
            Room room11 = new Room(
                "Guardian’s Vault", 
                "\nThis vault is heavily fortified with a magical barrier. " +
                "\nA guardian seems to be asleep too" + 
                "\nMaybe use 'look guardian' or 'look magical barrier'", 
                'V', 
                new Position(1, 6)
            );
            room11.setFeatures(new String[]{"magical barrier", "guardian"});
            room11.setFeatureDesc(new String[]{"\nYou come closer to the magical barrier, and it magically opens up a keyhole and tells you to try if you dare." + "\nIt also gives you a magical ball", "The guardian smashes you towards the wall. You lose 10 HP."});
            room11.setRequiredItems(new String[]{"Rusty key", null});
            room11.setItemFound("Magical Ball");
            room11.setIsTrap(new boolean[]{false, true});
            room11.setPuzzle("Unlock the magical barrier.");
            room11.setAfterWin("\nYou use the rusty key to unlock the magical barrier, the temple's floor starts to tremble, you have 15 seconds to escape south.");
    
            Room room12 = new Room(
                "Artifact Room", 
                "\nYou crawl with effort into the room. " +
                "\nYou see a pedestal holding a radiant artifact that glows with ancient energy. " +
                "\nThe room is filled with an ominous aura and is very shaky, and you sense that this is the final challenge." +
                "\nYou are given two tough choices: either attempt to unlock the artifact's power or leave it untouched and escape the collapsing temple." + 
                "\nUse 'look artifact' or 'look escape door'", 
                'A', 
                new Position(1, 7)
            );
            room12.setFeatures(new String[]{"artifact", "escape door"});
            room12.setFeatureDesc(new String[]{"The temple's structure starts to fall, it feels like an earthquake. You get closer to the artifact and attempt to pull the artifact.", "You attempt to escape, but you're too deep into it. You lose HP."});
            room12.setRequiredItems(new String[]{"Magical Ball", null});
            room12.setItemFound("Mystras Artifact");
            room12.setIsTrap(new boolean[]{false, true});
            room12.setPuzzle("You fail to pull the artifact, the temple shakes more violently, you find a slot to place a ball on the pedestal.");
            room12.setAfterWin("\nYou acquired Mystra’s Artifact, completing your quest." + "\nThe temple starts collapsing, you quickly find your exit and are finally rewarded with a million dollar Artifact." +  "Congrats!==");
    
        
        Room[] rooms = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11, room12};
        

        // welcome statements to the game
        System.out.println("Welcome to the The Forgotten Temple of Mystra!\n" +
        "\nYou have discovered the long-lost Temple of Mystra, hidden within a remote and ancient forest you've visited." + "\nThis temple was built centuries ago to protect a powerful artifact, its full of traps, puzzles and ancient lore." +  "\nTo reach the final powerful artifact, you must transverse through 12 mysterious rooms." + "\nThe artifact is worth millions and has various magical powers.");
        
        
        Scanner scanner = new Scanner(System.in);
        boolean alwaysOn = true; 

        String help = "\nGame commands:\n" +
                "\"move <direction>\" - (<direction> can be \"north\", \"south\", \"east\", \"west\"). The player moves to a new room based on the direction.\n" +
                "\"look\" - Displays a description of the room the player is in.\n" +
                "\"look <feature>\" - Displays a more detailed description of a feature of a room.\n" +
                "\"look <item>\" - Displays a description of an item.\n" +
                "\"inventory\" - Displays a list of all items the player has obtained.\n" +
                "\"score\" - Displays the user’s current score.\n" +
                "\"map\" - Displays a text-based map of the current explored game world.\n" +
                "\"help\" - Displays a help message.\n" +
                "\"position\" - Displays the player's current position.\n" +
                "\"hp\" - Displays the player's current HP.\n" +
                "\"remove\" - Removes an item from the player's inventory after prompting you to specify item.\n" +
                "\"quit\" - Quits the game.\n";

        System.out.println(help);

        Position currentPosition = new Position(2, 1); // player starting position (at entrance hall)
        int currentRoomIndex = 0; // starts in room1
        Room currentRoom = rooms[currentRoomIndex];

        // PLACING ROOMS ON THE MAP
        for (Room room : rooms) {
            grid.placeRoom(room.getPosition(), room.getSymbol());
        }


        // init the inventory + creating strings containing a brief desc of each item for when the user uses "look <item>" command.
        Inventory inventory = new Inventory(); 
        String translationScrollDesc = "A scroll that translates ancient languages.";
        String mirrorShardDesc = "A shard from a magical mirror.";
        String ancientTomeDesc = "An ancient book filled with mysterious texts.";
        String flowerDesc = "A flower with ever-changing colors.";
        String rustyKeyDesc = "A key that looks old and rusty.";
        String blueFlamesDesc = "A magical flame that doesn't burn.";
        String lanternDesc = "A lantern that emits a bright light.";
        String echoStoneDesc = "A stone that echoes with voices.";
        String magicalBallDesc = "A magical ball that unlocks barriers.";
        String mystrasArtifactDesc = "A powerful artifact that glows with ancient energy.";
        

        

        System.out.println("You are currently at the " + room1.getName() + ". " + room1.getDescription()); // part of welcome message to orient player

        while (alwaysOn) {

            // check if player is dead before looping again
            if (score.getHP() <= 0) {
                System.out.println("The temple's curse has finally taken your life. Game over...");
                alwaysOn = false;
                break;
            }

            System.out.print("\nEnter a command: ");
            String command = scanner.nextLine().trim();

            // handles the look command, mainly for the items and the specific features in the room + also handles some puzzle logic 
            // Basically for cmds that start with look + something look <item/feature>
            if (command.toLowerCase().startsWith("look ")) {
                String feature = command.substring(5).toLowerCase().trim(); 
                String itemD = command.substring(5).toLowerCase().trim();
                boolean foundFeature = false;

                if (itemD.contains(itemD)) {
                    if (itemD.equals("translation scroll")) {
                        System.out.println(translationScrollDesc);
                    } else if (itemD.equals("mirror shard")) {
                        System.out.println(mirrorShardDesc);
                    } else if (itemD.equals("ancient tome")) {
                        System.out.println(ancientTomeDesc);
                    } else if (itemD.equals("flower")) {
                        System.out.println(flowerDesc);
                    } else if (itemD.equals("rusty key")) {
                        System.out.println(rustyKeyDesc);
                    } else if (itemD.equals("blue flames")) {
                        System.out.println(blueFlamesDesc);
                    } else if (itemD.equals("lantern")) {
                        System.out.println(lanternDesc);
                    } else if (itemD.equals("echo stone")) {
                        System.out.println(echoStoneDesc);
                    } else if (itemD.equals("magical ball")) {
                        System.out.println(magicalBallDesc);
                    } else if (itemD.equals("mystras artifact")) {
                        System.out.println(mystrasArtifactDesc);
                    }
                }

                
                // handles puzzle logic, score system, and inventory management/using items for the puzzles
                for (int i = 0; i < currentRoom.getFeatures().length; i++) {
                    
                    if (feature.equals(currentRoom.getFeatures()[i].toLowerCase())) { 
                        foundFeature = true;
                        System.out.println(currentRoom.getFeatureDesc(i));
                        if (currentRoom.isTrap(i)) {
                            score.loseHP(10);
                            score.loseScore(1);
                            score.displayScore();
                        } else {
                            if (currentRoom.isPuzzleSolved()) {
                                System.out.println("This puzzle has already been solved. Move on!");
                                break;
                            }
                            System.out.println(currentRoom.getPuzzle());
                            boolean correctItem = false;
                            while (correctItem == false) { 
                                if (currentRoom.isPuzzleSolved() == true) {
                                    System.out.println("You realize you've already solved this puzzle. Move on!");
                                    correctItem = true; // break out of while loop to avoid infinite solving
                                    break; 
                                } else{
                                   
                                    if (currentRoom.getFoundItem() != null && inventory.hasItem(currentRoom.getFoundItem()) == -1) {
                                        inventory.addItem(currentRoom.getFoundItem()); // add the item to inventory only if it was found in the room
                                    
                                    }
                                 
                                System.out.println("\nCurrent inventory : [" + inventory.displayInventory()+"]"); // display inventory to help him know what item to use
                                System.out.print("Enter the item to use: ");
                                String itemPrompt = scanner.nextLine().toLowerCase().trim();
                                // check if the item is in the inventory and if the item is the correct item to solve the puzzle, if it is, adds score and displays afterWin msg
                                if (inventory.hasItem(currentRoom.getRequiredItem(i).toLowerCase()) != -1 && itemPrompt.equals(currentRoom.getRequiredItem(i).toLowerCase()) && currentRoom.isPuzzleSolved() == false) {
                                    currentRoom.solvePuzzle();
                                    score.solvePuzzle();
                                    System.out.println(currentRoom.getAfterWin());
                                    // if the player is in the final room, display the final score and break out of the game loop as he finished the game
                                    if (currentRoom == rooms[11]){
                                        System.out.println("Final Score: " + score.getScore() + "\nHP: " + score.getHP() + "\nRooms Visited: " + score.getRoomsVisited() + "\nPuzzles Solved: " + score.getPuzzlesSolved());
                                        alwaysOn = false;
                                        break;
                                    }
                    
                                    correctItem = true;
                                } else{
                                    System.out.println("Wrong item used, or item not available in your inventory. You lose 3 HP.");
                                    score.loseHP(3);
                                    score.displayScore();
                                }
                            }
                            }
                        }
                        break;
                    }
                }
            

    
            } else if (command.toLowerCase().startsWith("remove ")) {
                String itemToRemove = command.substring(7).trim();
                if (inventory.hasItem(itemToRemove) != -1) {
                    inventory.removeItem(itemToRemove);
                    System.out.println("You threw away the " + itemToRemove + ".");
                } else {
                    System.out.println("Item not found in inventory.");
                }
             } else { // else (if the command is not a look + <item/feature> command), handle the rest of the commands
            switch (command.toLowerCase()) {
                case "move north":
                if (currentRoom.isPuzzleSolved() == false) {
                    System.out.println("You attempt to escape the room without solving the puzzle. The temple pushes you back into the room violently. You lose 12 HP and 5 score.");
                    score.loseHP(12);
                    score.loseScore(5);
                    score.displayScore();
                } else {
                    Position newPosition = new Position(currentPosition.getX(), currentPosition.getY() - 1);
                    // handles some of the currentRoom logic and checks if the user is indeed trying to move to a valid room or outside the rooms, in which case it punishes him 
                    if (currentRoomIndex < rooms.length - 1 && newPosition.getX() == rooms[currentRoomIndex + 1].getPosition().getX() && newPosition.getY() == rooms[currentRoomIndex + 1].getPosition().getY()) {
                        currentRoomIndex++;
                        currentRoom = rooms[currentRoomIndex];
                        currentPosition = newPosition;
                        score.visitRoom();
                        System.out.println("You moved north.");
                    } else {
                        System.out.println("You tried moving outside the temple, remember whoever enters the temple stays in. You must navigate to the next room, using map/position commands.");
                        System.out.println("\nThe temple punishes you for attempting to escape, -10 HP, -1 score.");
                        score.loseHP(10);
                        score.loseScore(1);
                        score.displayScore();
                    }
                }
                break;
            case "move south":
            if (currentRoom.isPuzzleSolved() == false) {
                System.out.println("You attempt to escape the room without solving the puzzle. The temple pushes you back into the room violently. You lose 12 HP and 5 score.");
                score.loseHP(12);
                score.loseScore(5);
                score.displayScore();
                } else {
                    Position newPosition = new Position(currentPosition.getX(), currentPosition.getY() + 1);
                         if (currentRoomIndex < rooms.length - 1 && newPosition.getX() == rooms[currentRoomIndex + 1].getPosition().getX() && newPosition.getY() == rooms[currentRoomIndex + 1].getPosition().getY()) {
                        currentRoomIndex++;
                        currentRoom = rooms[currentRoomIndex];
                        currentPosition = newPosition;
                        score.visitRoom();
                        System.out.println("You moved south.");
                    } else {
                        System.out.println("You tried moving outside the temple, remember whoever enters the temple stays in. You must navigate to the next room, using map/position commands.");
                        System.out.println("\nThe temple punishes you for attempting to escape, -10 HP, -1 score.");
                        score.loseHP(10);
                        score.loseScore(1);
                        score.displayScore();
                    }
                }
                break;
            case "move east":
            if (currentRoom.isPuzzleSolved() == false) {
                System.out.println("You attempt to escape the room without solving the puzzle. The temple pushes you back into the room violently. You lose 12 HP and 5 score.");
                score.loseHP(12);
                score.loseScore(5);
                score.displayScore();
                } else {
                    Position newPosition = new Position(currentPosition.getX() + 1, currentPosition.getY());
                    if (currentRoomIndex < rooms.length - 1 && newPosition.getX() == rooms[currentRoomIndex + 1].getPosition().getX() && newPosition.getY() == rooms[currentRoomIndex + 1].getPosition().getY()) {
                        currentRoomIndex++;
                        currentRoom = rooms[currentRoomIndex];
                        currentPosition = newPosition;
                        score.visitRoom();
                        System.out.println("You moved east");
                    } else {
                        System.out.println("You tried moving outside the temple, remember whoever enters the temple stays in. You must navigate to the next room, using map/position commands.");
                        System.out.println("\nThe temple punishes you for attempting to escape, -10 HP, -1 score.");
                        score.loseHP(10);
                        score.loseScore(1);
                        score.displayScore();
                    }
                }
                break;
            case "move west":
            if (currentRoom.isPuzzleSolved() == false) {
                System.out.println("You attempt to escape the room without solving the puzzle. The temple pushes you back into the room violently. You lose 12 HP and 5 score.");
                score.loseHP(12);
                score.loseScore(5);
                score.displayScore();
            } else {
                Position newPosition = new Position(currentPosition.getX() - 1, currentPosition.getY());
                if (currentRoomIndex < rooms.length - 1 && newPosition.getX() == rooms[currentRoomIndex + 1].getPosition().getX() && newPosition.getY() == rooms[currentRoomIndex + 1].getPosition().getY()) {
                    currentRoomIndex++;
                    currentRoom = rooms[currentRoomIndex];
                    currentPosition = newPosition;
                    score.visitRoom();
                    System.out.println("You moved west.");
                } else {
                    System.out.println("You tried moving outside the temple, remember whoever enters the temple stays in. You must navigate to the next room, using map/position commands.");
                    System.out.println("\nThe temple punishes you for attempting to escape, -10 HP, -1 score.");
                    score.loseHP(10);
                    score.loseScore(1);
                    score.displayScore();
                }
            }
                break;
                case "look": // look without any other feature/item cmd after it, simply displays the room name and desc
                    for (Room room : rooms) {
                        if (room.getPosition().getX() == currentPosition.getX() && room.getPosition().getY() == currentPosition.getY()) {
                            System.out.println("\nYou are now at the " + room.getName() + "." + "\n" + room.getDescription());
                            break;
                        }
                    }    
                break;

                case "map":
                    System.out.println(grid.display());
                    break;
                case "help":
                    System.out.println(help);
                    break;
                case "inventory":
                    System.out.println("Current inventory : [" + inventory.displayInventory()+"]");
                    break;    
                case "score":
                    System.out.println("Your score is: " + score.getScore());
                    break;    
                case "position": // helps in navigation with the map command
                    System.out.println("Your current position is: " + currentPosition.getX() + "," + currentPosition.getY());
                    break;    
                case "hp":
                     System.out.println("Your current HP is: " + score.getHP());
                      break;    
                case "quit":
                    System.out.println("Quitting game...");
                    alwaysOn = false;
                    break;        

                
                }
            }


        }


    }
    
}