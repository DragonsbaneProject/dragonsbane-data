package io.dragonsbane.data;

import io.onemfive.data.JSONSerializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasterHealthRecord implements JSONSerializable {

    private volatile List<HealthRecordUpdate> healthRecordUpdates = new ArrayList<>();

    private Integer id;
    private Long timeCreated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public void add(HealthRecordUpdate m) {
        if(healthRecordUpdates == null) healthRecordUpdates = new ArrayList<>();
        healthRecordUpdates.add(m);
    }

    public List<HealthRecordUpdate> getHealthRecordUpdates() {
        if(healthRecordUpdates == null) healthRecordUpdates = new ArrayList<>();
        return healthRecordUpdates;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String,Object> m = new HashMap<>();
        if(id != null) m.put("id",id+"");
        if(timeCreated != null) m.put("timeCreated", timeCreated);
        if(healthRecordUpdates !=null && healthRecordUpdates.size() > 0) {
            List<Map<String,Object>> ms = new ArrayList<>();
            m.put("healthRecordUpdates",ms);
            for(HealthRecordUpdate msg : healthRecordUpdates) {
                ms.add(msg.toMap());
            }
        }
        return m;
    }

    @Override
    public void fromMap(Map<String, Object> m) {
        if(m.get("id")!=null) id = Integer.parseInt((String)m.get("id"));
        if(m.get("timeCreated")!=null) timeCreated = Long.parseLong((String)m.get("timeCreated"));
        if(m.get("healthRecordUpdates")!=null) {
            healthRecordUpdates = new ArrayList<>();
            List<Map<String,Object>> ms = (List<Map<String,Object>>)m.get("healthRecordUpdates");
            HealthRecordUpdate msg;
            for(Map<String,Object> s : ms) {
                msg = new HealthRecordUpdate();
                msg.fromMap(s);
                healthRecordUpdates.add(msg);
            }
        }
    }
}
