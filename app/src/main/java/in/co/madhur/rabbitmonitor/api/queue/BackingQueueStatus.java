
package in.co.madhur.rabbitmonitor.api.queue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BackingQueueStatus {

    @Expose
    private Integer q1;
    @Expose
    private Integer q2;
    @Expose
    private List<String> delta = new ArrayList<String>();
    @Expose
    private Integer q3;
    @Expose
    private Integer q4;
    @Expose
    private Integer len;
    @SerializedName("pending_acks")
    @Expose
    private Integer pendingAcks;
    @SerializedName("target_ram_count")
    @Expose
    private String targetRamCount;
    @SerializedName("ram_msg_count")
    @Expose
    private Integer ramMsgCount;
    @SerializedName("ram_ack_count")
    @Expose
    private Integer ramAckCount;
    @SerializedName("next_seq_id")
    @Expose
    private Integer nextSeqId;
    @SerializedName("persistent_count")
    @Expose
    private Integer persistentCount;
    @SerializedName("avg_ingress_rate")
    @Expose
    private Double avgIngressRate;
    @SerializedName("avg_egress_rate")
    @Expose
    private Double avgEgressRate;
    @SerializedName("avg_ack_ingress_rate")
    @Expose
    private Double avgAckIngressRate;
    @SerializedName("avg_ack_egress_rate")
    @Expose
    private Double avgAckEgressRate;

    /**
     * 
     * @return
     *     The q1
     */
    public Integer getQ1() {
        return q1;
    }

    /**
     * 
     * @param q1
     *     The q1
     */
    public void setQ1(Integer q1) {
        this.q1 = q1;
    }

    /**
     * 
     * @return
     *     The q2
     */
    public Integer getQ2() {
        return q2;
    }

    /**
     * 
     * @param q2
     *     The q2
     */
    public void setQ2(Integer q2) {
        this.q2 = q2;
    }

    /**
     * 
     * @return
     *     The delta
     */
    public List<String> getDelta() {
        return delta;
    }

    /**
     * 
     * @param delta
     *     The delta
     */
    public void setDelta(List<String> delta) {
        this.delta = delta;
    }

    /**
     * 
     * @return
     *     The q3
     */
    public Integer getQ3() {
        return q3;
    }

    /**
     * 
     * @param q3
     *     The q3
     */
    public void setQ3(Integer q3) {
        this.q3 = q3;
    }

    /**
     * 
     * @return
     *     The q4
     */
    public Integer getQ4() {
        return q4;
    }

    /**
     * 
     * @param q4
     *     The q4
     */
    public void setQ4(Integer q4) {
        this.q4 = q4;
    }

    /**
     * 
     * @return
     *     The len
     */
    public Integer getLen() {
        return len;
    }

    /**
     * 
     * @param len
     *     The len
     */
    public void setLen(Integer len) {
        this.len = len;
    }

    /**
     * 
     * @return
     *     The pendingAcks
     */
    public Integer getPendingAcks() {
        return pendingAcks;
    }

    /**
     * 
     * @param pendingAcks
     *     The pending_acks
     */
    public void setPendingAcks(Integer pendingAcks) {
        this.pendingAcks = pendingAcks;
    }

    /**
     * 
     * @return
     *     The targetRamCount
     */
    public String getTargetRamCount() {
        return targetRamCount;
    }

    /**
     * 
     * @param targetRamCount
     *     The target_ram_count
     */
    public void setTargetRamCount(String targetRamCount) {
        this.targetRamCount = targetRamCount;
    }

    /**
     * 
     * @return
     *     The ramMsgCount
     */
    public Integer getRamMsgCount() {
        return ramMsgCount;
    }

    /**
     * 
     * @param ramMsgCount
     *     The ram_msg_count
     */
    public void setRamMsgCount(Integer ramMsgCount) {
        this.ramMsgCount = ramMsgCount;
    }

    /**
     * 
     * @return
     *     The ramAckCount
     */
    public Integer getRamAckCount() {
        return ramAckCount;
    }

    /**
     * 
     * @param ramAckCount
     *     The ram_ack_count
     */
    public void setRamAckCount(Integer ramAckCount) {
        this.ramAckCount = ramAckCount;
    }

    /**
     * 
     * @return
     *     The nextSeqId
     */
    public Integer getNextSeqId() {
        return nextSeqId;
    }

    /**
     * 
     * @param nextSeqId
     *     The next_seq_id
     */
    public void setNextSeqId(Integer nextSeqId) {
        this.nextSeqId = nextSeqId;
    }

    /**
     * 
     * @return
     *     The persistentCount
     */
    public Integer getPersistentCount() {
        return persistentCount;
    }

    /**
     * 
     * @param persistentCount
     *     The persistent_count
     */
    public void setPersistentCount(Integer persistentCount) {
        this.persistentCount = persistentCount;
    }

    /**
     * 
     * @return
     *     The avgIngressRate
     */
    public Double getAvgIngressRate() {
        return avgIngressRate;
    }

    /**
     * 
     * @param avgIngressRate
     *     The avg_ingress_rate
     */
    public void setAvgIngressRate(Double avgIngressRate) {
        this.avgIngressRate = avgIngressRate;
    }

    /**
     * 
     * @return
     *     The avgEgressRate
     */
    public Double getAvgEgressRate() {
        return avgEgressRate;
    }

    /**
     * 
     * @param avgEgressRate
     *     The avg_egress_rate
     */
    public void setAvgEgressRate(Double avgEgressRate) {
        this.avgEgressRate = avgEgressRate;
    }

    /**
     * 
     * @return
     *     The avgAckIngressRate
     */
    public Double getAvgAckIngressRate() {
        return avgAckIngressRate;
    }

    /**
     * 
     * @param avgAckIngressRate
     *     The avg_ack_ingress_rate
     */
    public void setAvgAckIngressRate(Double avgAckIngressRate) {
        this.avgAckIngressRate = avgAckIngressRate;
    }

    /**
     * 
     * @return
     *     The avgAckEgressRate
     */
    public Double getAvgAckEgressRate() {
        return avgAckEgressRate;
    }

    /**
     * 
     * @param avgAckEgressRate
     *     The avg_ack_egress_rate
     */
    public void setAvgAckEgressRate(Double avgAckEgressRate) {
        this.avgAckEgressRate = avgAckEgressRate;
    }

}
