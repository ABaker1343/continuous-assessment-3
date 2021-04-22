package socialmedia;

import java.util.ArrayList;

public class Original extends Post{
    ArrayList<Comment> comments;
    ArrayList<Endorsement> endorsements;

    Original(Account poster, String message){
        super(poster, message);
        comments = new ArrayList<Comment>();
        endorsements = new ArrayList<Endorsement>();
    }

    @Override
    public void addComment(Comment comment){
        comments.add(comment);
    }

    @Override
    public void addEndorsements(Endorsement endorsement){
        endorsements.add(endorsement);
    }

    @Override
    public void deleteEndorsements(){
        endorsements.removeAll(endorsements);
    }

    @Override
    public String show(){
        String outString;

        outString = "ID: " + postID + "\n" +
        "Account: " + accountHandle + "\n" +
        "No. Endorsements: " + endorsements.size() + " | No. Comments: " + comments.size() + "\n" +
        content;

        return outString;
    }

    @Override
    public int getNumEndorsements(){
        return endorsements.size();
    }

    @Override
    public String showWithChildren(int indent){
        String returnString = show() + "\n";

        for (Comment c : comments){

            for (int i = 0; i< indent; i++){
                returnString += " ";
            }
            returnString += "|\n";
            for (int i = 0; i< indent; i++){
                returnString += " ";
            }
            returnString += "|";

            returnString += c.showWithChildren(++indent);
        }

        return returnString;
    }

    @Override
    public ArrayList<Comment> getComments() {
        // TODO Auto-generated method stub
        return comments;
    }
}
