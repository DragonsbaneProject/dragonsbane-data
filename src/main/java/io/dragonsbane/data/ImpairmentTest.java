package io.dragonsbane.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.onemfive.data.DID;
import io.onemfive.data.JSONSerializable;
import io.onemfive.data.util.JSONParser;

public class ImpairmentTest implements JSONSerializable {

    private DID did;
    private String name;
    private Boolean baseline = false;
    private Long timeStarted;
    private Long timeEnded;
    private Double bloodAlcoholContent;

    private List<Long> successes = new ArrayList<>();
    private List<Long> misses = new ArrayList<>();
    private List<Long> inappropriates = new ArrayList<>();
    private List<Long> negatives = new ArrayList<>();

    List<Integer> cardsUsed = new ArrayList<>();

    public ImpairmentTest(DID did, String name) {
        this.did = did;
        this.name = name;
    }

    public String getId() {
        return did.getAlias()+":"+timeStarted;
    }

    public DID getDid() {
        return did;
    }

    public void setDid(DID did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getBaseline() {
        return baseline;
    }

    public void setBaseline(Boolean baseline) {
        this.baseline = baseline;
    }

    public Long getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(Long timeStarted) {
        this.timeStarted = timeStarted;
    }

    public Long getTimeEnded() {
        return timeEnded;
    }

    public void setTimeEnded(Long timeEnded) {
        this.timeEnded = timeEnded;
    }

    public Double getBloodAlcoholContent() {
        return bloodAlcoholContent;
    }

    public void setBloodAlcoholContent(Double bloodAlcoholContent) {
        this.bloodAlcoholContent = bloodAlcoholContent;
    }

    public void addSuccess(long responseTime) {
        successes.add(responseTime);
    }

    public List<Long> getSuccesses() {
        return successes;
    }

    public long getMinResponseTimeSuccessMs() {
        long min = 24 * 60 * 60 * 1000L;
        for(long s : successes) {
            if(s < min) min = s;
        }
        if(min ==24 * 60 * 60 * 1000L)
            return 0;
        return min;
    }

    public long getMaxResponseTimeSuccessMs() {
        long max = 0L;
        for(long s : successes) {
            if(s > max) max = s;
        }
        return max;
    }

    public long getAvgResponseTimeSuccessMs() {
        long sum = 0L;
        for(long s : successes){
            sum += s;
        }
        if(sum > 0)
            return sum / successes.size();
        else
            return 0;
    }

    public void addMiss(long responseTime) {
        misses.add(responseTime);
    }

    public List<Long> getMisses() {
        return misses;
    }

    public long getMinResponseTimeMissMs() {
        long min = 24 * 60 * 60 * 1000L;
        for(long s : misses) {
            if(s < min) min = s;
        }
        if(min ==24 * 60 * 60 * 1000L)
            return 0;
        return min;
    }

    public long getMaxResponseTimeMissMs() {
        long max = 0L;
        for(long s : misses) {
            if(s > max) max = s;
        }
        return max;
    }

    public long getAvgResponseTimeMissMs() {
        long sum = 0L;
        for(long s : misses){
            sum += s;
        }
        if(sum > 0)
            return sum / misses.size();
        else
            return 0;
    }

    public void addInappropriate(long responseTime) {
        inappropriates.add(responseTime);
    }

    public List<Long> getInappropriates() {
        return inappropriates;
    }

    public long getMinResponseTimeInappropriateMs() {
        long min = 24 * 60 * 60 * 1000L;
        for(long s : inappropriates) {
            if(s < min) min = s;
        }
        if(min ==24 * 60 * 60 * 1000L)
            return 0;
        return min;
    }

    public long getMaxResponseTimeInappropriateMs() {
        long max = 0L;
        for(long s : inappropriates) {
            if(s > max) max = s;
        }
        return max;
    }

    public long getAvgResponseTimeInappropriateMs() {
        long sum = 0L;
        for(long s : inappropriates){
            sum += s;
        }
        if(sum > 0)
            return sum / inappropriates.size();
        else
            return 0;
    }

    public void addNegative(long responseTime) {
        negatives.add(responseTime);
    }

    public List<Long> getNegatives() {
        return negatives;
    }

    public long getMinResponseTimeNegativeMs() {
        long min = 24 * 60 * 60 * 1000L;
        for(long s : negatives) {
            if(s < min) min = s;
        }
        if(min ==24 * 60 * 60 * 1000L)
            return 0;
        return min;
    }

    public long getMaxResponseTimeNegativeMs() {
        long max = 0L;
        for(long s : negatives) {
            if(s > max) max = s;
        }
        return max;
    }

    public long getAvgResponseTimeNegativeMs() {
        long sum = 0L;
        for(long s : negatives){
            sum += s;
        }
        if(sum > 0)
            return sum / negatives.size();
        else
            return 0;
    }

    public List<Integer> getCardsUsed() {
        return cardsUsed;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> m = new HashMap<>();

        if(did!=null && did.getIdentityHash()!=null) m.put("tester",did.getIdentityHash());
        if(name!=null) m.put("name",name);
        m.put("baseline",baseline ? "1":"0");
        if(timeStarted!=null) m.put("timeStarted",timeStarted+"");
        if(timeEnded!=null) m.put("timeEnded",timeEnded+"");
        if(bloodAlcoholContent!=null) m.put("bloodAlcoholContent",bloodAlcoholContent+"");
        if(successes!=null && successes.size()>0) m.put("successes",JSONParser.toString(successes));
        if(misses!=null && misses.size()>0) m.put("misses",JSONParser.toString(misses));
        if(inappropriates!=null && inappropriates.size()>0) m.put("inappropriates",JSONParser.toString(inappropriates));
        if(negatives!=null && negatives.size()>0) m.put("negatives",JSONParser.toString(negatives));
        if(cardsUsed!=null && cardsUsed.size()>0) m.put("cardsUsed",JSONParser.toString(cardsUsed));

        return m;
    }

    @Override
    public void fromMap(Map<String, Object> m) {
        if(m.get("tester")!=null){
            if(did==null) did = new DID();
            did.setIdentityHash((String)m.get("tester"));
        }
        if(m.get("name")!=null) name = (String)m.get("name");
        if(m.get("baseline")!=null) baseline = m.get("baseline").equals("1");
        if(m.get("timeStarted")!=null) timeStarted = Long.parseLong((String)m.get("timeStarted"));
        if(m.get("timeEnded")!=null) timeStarted = Long.parseLong((String)m.get("timeEnded"));
        if(m.get("bloodAlcoholContent")!=null) bloodAlcoholContent = Double.parseDouble((String)m.get("bloodAlcoholContent"));
        if(m.get("successes")!=null) successes = (List<Long>)JSONParser.parse((String)m.get("successes"));
        if(m.get("misses")!=null) misses = (List<Long>)JSONParser.parse((String)m.get("misses"));
        if(m.get("inappropriates")!=null) inappropriates = (List<Long>)JSONParser.parse((String)m.get("inappropriates"));
        if(m.get("negatives")!=null) negatives = (List<Long>)JSONParser.parse((String)m.get("negatives"));
        if(m.get("cardsUsed")!=null) cardsUsed = (List<Integer>)JSONParser.parse((String)m.get("cardsUsed"));
    }
}

