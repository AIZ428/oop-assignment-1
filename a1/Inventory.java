package org.uob.a1;

public class Inventory {

    final int MAX_ITEMS = 10;
    private String[] items;
    private int itemCount;

    public Inventory(){
        items = new String[MAX_ITEMS];
        itemCount = 0;
    }
    
    public void addItem(String item){
        // first checks if theres space in inventory before adding item
        if(itemCount <= MAX_ITEMS){
            items[itemCount] = item;
            itemCount++;
        } else {
            System.out.println("No more space in Inventory, failed to add " + item);
        }

    }
    // to check if the item is in the inventory
    public int hasItem(String item) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                return i;
            }
        }
        return -1;
    }

    public void removeItem(String item){
        int index = hasItem(item); // to get the index of the item to be removed
        if (index >= 0 && index < 10){
            for (int i = index; i < itemCount; i++){
                items[i] = items[i+1];
            }
        }
        items[itemCount - 1] = null; // to remove the last item
        itemCount--; // minus the item count

    }
    
    public String displayInventory(){
        StringBuilder inventoryString = new StringBuilder("");

        for (int i = 0; i < itemCount; i++) {
            inventoryString.append(items[i]);
            inventoryString.append(" "); // seperating each by a space
        }
        return inventoryString.toString();
    }
    

}
