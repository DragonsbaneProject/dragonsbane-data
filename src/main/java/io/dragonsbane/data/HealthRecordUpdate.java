package io.dragonsbane.data;

import io.onemfive.data.DID;
import io.onemfive.data.JSONSerializable;

import java.util.HashMap;
import java.util.Map;

public class HealthRecordUpdate implements JSONSerializable {

    private Integer conversationID;
    private Integer id;
    private DID fromDID;
    private DID toDID;
    private Long timeSent;
    private Long timeReceived;

    public HealthRecordUpdate() {
    }

    public HealthRecordUpdate(DID from, DID to) {
        this.fromDID = from;
        this.toDID = to;
    }

    public Integer getConversationID() {
        return conversationID;
    }

    public void setConversationID(Integer conversationID) {
        this.conversationID = conversationID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DID getFromDID() {
        return fromDID;
    }

    public void setFromDID(DID fromDID) {
        this.fromDID = fromDID;
    }

    public DID getToDID() {
        return toDID;
    }

    public void setToDID(DID toDID) {
        this.toDID = toDID;
    }

    public Long getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Long timeSent) {
        this.timeSent = timeSent;
    }

    public Long getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(Long timeReceived) {
        this.timeReceived = timeReceived;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String,Object> m = new HashMap<>();
        if(id!=null) m.put("id",id+"");
        if(conversationID!=null) m.put("conversationID",conversationID+"");
        if(fromDID!=null) m.put("fromDID",fromDID.toMap());
        if(toDID!=null) m.put("toDID",toDID.toMap());
        return m;
    }

    @Override
    public void fromMap(Map<String, Object> m) {
        if(m.get("id")!=null) id = Integer.parseInt((String)m.get("id"));
        if(m.get("conversationID")!=null) conversationID = Integer.parseInt((String)m.get("conversationID"));
        if(m.get("fromDID")!=null) {
            fromDID = new DID();
            fromDID.fromMap((Map<String,Object>)m.get("fromDID"));
        }
        if(m.get("toDID")!=null) {
            toDID = new DID();
            toDID.fromMap((Map<String,Object>)m.get("toDID"));
        }
    }
}
