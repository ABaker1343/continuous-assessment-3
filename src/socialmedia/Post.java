package socialmedia;

import java.util.ArrayList;
import java.io.Serializable;

public class Post implements Serializable{
    protected int postID;
    protected int posterID;
    protected String accountHandle;
    protected String content;
    static int nextID;

    /**
     * 
     * @return the next available ID number
     */
    static int getNextID(){
        return nextID ++;
    }

    /**
     * constructor
     */
    Post(Account poster, String content){
        setID();
        if (poster != null) setPosterID(poster.getID());
        if (poster != null) setAccountHandle(poster.getHandle());
        setContent(content);
    }

    /**
     * adds a comment to a post or comment
     */
    public void addComment(Comment comment){

    }
    /**
     * Adds and endorsement to the post
     * @param endorsement
     */
    public void addEndorsements(Endorsement endorsement){

    }
    /**
     * removes an endorsement from the post
     */
    public void deleteEndorsements(){

    }
    /**
     * returns an ArrayList of endorsement posts for this post
     * @return ArrayList of endorsement posts for this post
     */
    public ArrayList<Endorsement> getEndorsements(){
        return null;
    }

    /**
     * returns the amount of endorsements on this post
     * @return the amount of endorsements on this post
     */
    public int getNumEndorsements(){
        return -1;
    }

    /**
     * returns a string representing the post
     * @param indent
     * @return String representing the post
     */
    public String show(int indent){
        return "";
    }

    /**
     * returns a string representing the post and its children
     * @param indent
     * @return String representing the post and its children
     */
    public String showWithChildren(int indent){
        return show(indent);
    }

    /**
     * returns ArrayList of comments on this post
     * @return ArrayList of comments on this post
     */
    public ArrayList<Comment> getComments(){
        return null;
    }

    //getters and setters

    protected void setID(){
        this.postID = getNextID();
    }
    public int getID(){
        return postID;
    }

    protected void setPosterID(int id){
        this.posterID = id;
    }
    public int getPosterID() {
        return posterID;
    }

    protected void setAccountHandle(String handle){
        this.accountHandle = handle;
    }    
    public String getAccountHandle() {
        return accountHandle;
    }

    protected void setContent(String content){
        this.content = content;
    }   
    public String getContent() {
        return content;
    }


}
