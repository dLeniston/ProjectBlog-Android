package com.example.dazza.functionalprototypev1;
import com.example.dazza.functionalprototypev1.NewEntry;
/**
 * Created by Dazza on 17/11/2017.
 */

public class QueryBuilder {
    public String getDBName(){
        return "DB NAME";
    }

    public String getApiKey(){
        return "API KEY HERE";
    }

    public String getBaseUrl(){
        return "https://api.mongolab.com/api/1/databases/"+getDBName()+"/collections/";
    }

    public String docApiKeyUrl(){
        return "?apiKey="+getApiKey();
    }

    public String docRequest(){
        return "blogs";
    }

    public String buildEntrySaveUrl(){
        return getBaseUrl()+docRequest()+docApiKeyUrl();
    }

    public String createEntry(NewEntry entry){
        return String.format("{\"title\": \"%s\",\"body\": \"%s\",\"created\": {\"$date\": \"%s\"}, \"image\": \"%s\", \"__v\" : 0}",
                entry.blogTitle, entry.blogContent, entry.date, entry.blogImage);
    }

}
