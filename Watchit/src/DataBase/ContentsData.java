package DataBase;

import ContentControl.Content;
import java.util.ArrayList;
import java.util.List;

public class ContentsData {
    List<Content> contents;
    public ContentsData() {
        this.contents = new ArrayList<>();
        contents.addAll(DataBase.getInstance().moviesData.getDataAsList());
        //contents.addAll(DataBase.getInstance().seriesData.getDataAsList());
    }
    /**
     * function that used to get the Content by its name
     * @param name name of Content you want to get it
     * @return Content
     */
    public Content getDataByName(String name){
        for (Content content : contents) {
            //if(content.getName().equals(name))
            return content;
        }
        return null;
    }

    /**
     * function that used to get the Contents that contains searchText
     * @param searchText is the substring of contents you search
     * @return Content[]
     */
    public Content[] getDataThatContains(String searchText){
        List<Content> Searched = new ArrayList<Content>();
        for (Content content : contents) {
            //if(content.getName().contains(searchText))
            Searched.add(content);
        }
        return Searched.toArray(new Content[0]);
    }

    /**
     * function that return all contents in application
     * @return Content[]
     */
    public Content[] getData() {
        return contents.toArray(new Content[0]);
    }

    /**
     * function that return all contents in application as List
     * @return List<Content>
     */
    public List<Content> getDataAsList() {
        return contents;
    }

    /**
     * function that add new content to application
     * @param content the content that will be added
     */
    public void addData(Content content){
        contents.add(content);
    }

    /**
     * function that remove content from application
     * @param content name of content that will be removed
     */
    public void removeData(String content){
        contents.remove(getDataByName(content));
    }


}
