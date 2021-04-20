package socialmedia;

public class Account {
    int accountID;
    String handle;
    String description;
    int postCount;
    int endorseCount;
    static int nextID = 0;

    /**
     * issue the next available ID
     */
    static int issueNextID(){
        return nextID++;
    }


    /**
     * Constructor
     */
    public Account(String handle, String description){
        setID(issueNextID());
        setHandle(handle);
        setDescription(description);
    }
    public Account(String handle){
        this(handle, "");
    }

    public void updateHandle(String handle){
        setHandle(handle);
    }

    public void updateDescription(String description){
        setDescription(description);
    }

    public String showAccount(){
        return "" +
        "ID: " + accountID + "\n" +
        "Handle: "+ handle + "\n" + 
        "Description: " + description + "\n" +
        "Post count: " + postCount + "\n" +
        "Endorse count: " + endorseCount + "\n";
    }

    //getters and setters

    public int getID(){
        return accountID;
    }
    private void setID(int id){
        this.accountID = id;
    }

    public String getHandle(){
        return handle;
    }
    private void setHandle(String handle){
        this.handle = handle;
    }

    public String getDescription(){
        return description;
    }
    private void setDescription(String description){
        this.description = description;
    }
}
