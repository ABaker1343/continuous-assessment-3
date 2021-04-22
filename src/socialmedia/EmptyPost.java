package socialmedia;

public class EmptyPost extends Post{
    EmptyPost(int id){
        super(null ,"The original content was removed from the system and is no longer available.");
        setID(id);
    }

    protected void setID(int id) {
        postID = id;
    }

    @Override
    public String show(){
        return content;
    }
}
