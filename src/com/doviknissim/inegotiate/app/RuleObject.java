package com.doviknissim.inegotiate.app;

import com.google.gdata.util.common.base.StringUtil;

public class RuleObject implements Comparable<RuleObject> {
    private String action;
    private long contactId;
    private String contactName;
    private String dueDate;
    private String picturePath;
    private long productId;
    private String productName;
    private long ruleId;
    private long ruleRangeLower;
    private long ruleRangeUpper;
    private String ruleType;
    private long targetPrice;

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPicturePath() {
        return this.picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public long getRuleId() {
        return this.ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleType() {
        return this.ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getContactId() {
        return this.contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getRuleRangeLower() {
        return this.ruleRangeLower;
    }

    public void setRuleRangeLower(long ruleRangeLower) {
        this.ruleRangeLower = ruleRangeLower;
    }

    public long getRuleRangeUpper() {
        return this.ruleRangeUpper;
    }

    public void setRuleRangeUpper(long ruleRangeUpper) {
        this.ruleRangeUpper = ruleRangeUpper;
    }

    public long getTargetPrice() {
        return this.targetPrice;
    }

    public void setTargetPrice(long targetPrice) {
        this.targetPrice = targetPrice;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public RuleObject(long ruleId, String ruleType, long productId, long contactId, long ruleRangeLower, long ruleRangeUpper, long targetPrice, String dueDate, String action) {
        this.ruleId = -1;
        this.ruleType = StringUtil.EMPTY_STRING;
        this.productId = -1;
        this.productName = StringUtil.EMPTY_STRING;
        this.contactName = StringUtil.EMPTY_STRING;
        this.contactId = -1;
        this.ruleRangeLower = -1;
        this.ruleRangeUpper = -1;
        this.targetPrice = -1;
        this.dueDate = StringUtil.EMPTY_STRING;
        this.picturePath = StringUtil.EMPTY_STRING;
        this.action = StringUtil.EMPTY_STRING;
        this.ruleId = ruleId;
        this.ruleType = ruleType;
        this.productId = productId;
        this.contactId = contactId;
        this.ruleRangeLower = ruleRangeLower;
        this.ruleRangeUpper = ruleRangeUpper;
        this.targetPrice = targetPrice;
        this.dueDate = dueDate;
        this.action = action;
    }

    public int compareTo(RuleObject o) {
        if (this != null && o != null && this.ruleType.equals(o.ruleType) && getProductId() == o.getProductId() && getContactId() == o.getContactId() && getRuleRangeLower() == o.getRuleRangeLower() && getRuleRangeUpper() == o.getRuleRangeUpper()) {
            return 1;
        }
        return 0;
    }
}
