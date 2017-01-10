package com.amazonaws.auth.policy.actions;

import com.amazonaws.auth.policy.Action;

public enum SNSActions implements Action {
    AddPermission("sns:AddPermission"),
    DeleteTopic("sns:DeleteTopic"),
    GetTopicAttributes("sns:GetTopicAttributes"),
    ListSubscriptionsByTopic("sns:ListSubscriptionsByTopic"),
    Publish("sns:Publish"),
    RemovePermission("sns:RemovePermission"),
    SetTopicAttributes("sns:SetTopicAttributes"),
    Subscribe("sns:Subscribe");
    
    private final String action;

    private SNSActions(String str) {
        this.action = str;
    }

    public String getActionName() {
        return this.action;
    }
}
