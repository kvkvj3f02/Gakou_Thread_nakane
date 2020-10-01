package business;
import java.util.List;

import bean.ThreadListProfile;
import database.GetThreadList;


public class GetThreadListBusiness{
    public static List<ThreadListProfile>getAllThread(){

        // DBから全てのスレッドを取得するビジネスロジックレイヤ
        List<ThreadListProfile> threadAllList = GetThreadList.getQueryList();
        return threadAllList;
    }
}