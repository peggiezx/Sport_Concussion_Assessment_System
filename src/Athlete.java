
import java.util.ArrayList;
import java.util.List;

public class Athlete {
    List<SymptomData> symptomList;
    public Athlete() {
        symptomList = new ArrayList<SymptomData>();
    }

    public void addData(SymptomData input) {
        if (symptomList.size() >= 5) {
            symptomList.remove(0);
        }
            symptomList.add(input);

    }

    public int getDataSize() {
        return symptomList.size();
    }

    public SymptomData getData(int index) {
        return symptomList.get(index);
    }

    public String getOverallRating() {
        int size = symptomList.size();
        if (size == 0 || size == 1) return "No Overall Rating Available";
        SymptomData cur = symptomList.get(size - 1);
        SymptomData pre = symptomList.get(size - 2);
        return compare(cur, pre);
    }

    public String getOverallRating(SymptomData cur, SymptomData pre) {
        return compare(cur, pre);
    }

    public String compare(SymptomData cur, SymptomData pre) {
        int totalSymDiff = Math.abs(cur.getTotalNum() - pre.getTotalNum());
        int severityScoreDiff = Math.abs(cur.getSeverityScore() - pre.getSeverityScore());
        if (totalSymDiff < 3 && severityScoreDiff < 10) return "No Difference";
        else if (totalSymDiff < 3 && severityScoreDiff >= 10) return "Unsure";
        else if (totalSymDiff >=3 || severityScoreDiff >= 15) return "Very Different";
        else return "Unsure";
    }

}
