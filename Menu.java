enum Menu {
    SEARCH("SEARCH"),
    EDIT("EDIT"),
    PRINT("PRINT"),
    RESET("RESET"),
    ADDROW("ADDROW"),
    ADDCELL("ADDCELL"),
    SORT("SORT"),
    EXIT("EXIT");
               
    private final String name;

    private Menu(String name) {
        this.name = name;
    }
               
    public boolean equals(String choice) {
        return choice.equals(name);
    }
               
    public static boolean search(String input) {
        boolean found = false;
                    
        input = input.toUpperCase();
                    
        for (Menu item : values()) {
            if(item.toString().equals(input)) {
                found = true;
                break;
            }
        }
                    
        if(!found) {
            throw new IllegalArgumentException();
        }
                    
        return found;
    }
}