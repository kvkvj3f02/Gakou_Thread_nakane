package business;
import java.util.List;

import bean.ResProfile;
import database.ResListQuery;

public class GetResListBusiness{
    public static List<ResProfile> insertBusinessLayer(ResProfile resProfile,String th_id){

    // th_id をもとに全てのresを取得する

    // ビジネスロジックレイヤ
    List<ResProfile> resList = ResListQuery.getQueryList(th_id);
    return resList;
    }
}
