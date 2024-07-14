package com.tulingxueyuan.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Data
public class SwAlarmDTO {

    /*
    * "scopeId": 1,
        "scope": "SERVICE",
        "name": "serviceB",
        "id0": "23",
        "id1": "",
        "ruleName": "service_resp_time_rule",
        "alarmMessage": "alarmMessage yyy",
        "startTime": 1560524171000,
        "tags": [{
            "key": "level",
            "value": "CRITICAL"*/
    private int scopeId;
    private String scope;
    private String name;
    private String id0;
    private String id1;
    private String ruleName;
    private String alarmMessage;
    private List<Tag> tags;
    private long startTime;
    private transient int period;
    private transient boolean onlyAsCondition;

    @Data
    public static class Tag{
        private String key;
        private String value;
    }
}
